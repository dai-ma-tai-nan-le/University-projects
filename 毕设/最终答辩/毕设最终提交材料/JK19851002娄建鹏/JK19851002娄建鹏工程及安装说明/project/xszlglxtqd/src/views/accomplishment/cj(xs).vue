<template>
    <div class="cj">
        <h1>我的成就</h1>
        <div v-if="length==0" class="mcj">还没有成就，完成计划计时，解锁成就吧！</div>
        <div v-else class="cjkp">
            <div v-for="index in list" :key="index" style="margin-bottom: 5px;">
                <el-card>
                    <div style="display: flex;align-items: center;">
                        <div><img :src="index.cj" style="height: 50px;margin-left: 100px;"/></div>
                        <div style="width: 700px;">
                            <span style="display: block;text-align: center;font-size: 40px;font-weight: 600;">{{ index.name }}</span>
                            <span style="display: block;text-align: center;font-size: 20px;">{{ index.condition }}</span>
                        </div>
                    </div>
                </el-card>
            </div>
            <div v-if="length==1" style="margin-top: 460px;text-align: center;font-weight: 600;">完成更多计时，解锁更多成就</div>
            <div v-if="length==2" style="margin-top: 335px;text-align: center;font-weight: 600;">完成更多计时，解锁更多成就</div>
            <div v-if="length==3" style="margin-top: 208px;text-align: center;font-weight: 600;">完成更多计时，解锁更多成就</div>
            <div v-if="length==4" style="margin-top: 82px;text-align: center;font-weight: 600;">完成更多计时，解锁更多成就</div>
            <div v-if="length>4" style="text-align: center;font-weight: 600;">完成更多计时，解锁更多成就</div>
        </div>
    </div>
</template>

<script>
let username = sessionStorage.getItem("username")
export default {
    data() {
        return {
            list:[],
            length:0,
        }
    },
    methods: {
        xianshi(){
            this.axios.post('/accomplishment/cjList', {
				username: username
			}).then(res => res.data).then(res => {
				// console.log(res.data)
				if (res.code == 200) {
					this.list = res.data;
					this.length = this.list.length;
				} else {
					return this.$message({
						duration: 3000,
						offset: 50,
						message: '数据获取失败',
						type: 'error'
					});
				}
			})
        }
    },beforeMount(){
        this.xianshi();
    }
}
</script>

<style>
.cj {
    padding: 2rem 1rem;
    background-color: #eeeeee !important;
    width: 70%;
    margin: 0 auto;
    padding-bottom: 0;
}

h1 {
    text-align: center;
    color: #00838F !important;
    font-weight: bold;
    margin-bottom: 20px;
}
.mcj{
    margin: auto;
    width: 1000px;
    height: 321px;
    text-align: center;
    color:#000000;
    font-weight: bold;
    background-color: #fff;
    padding-top: 280px;
}
.cjkp{
    margin: auto;
    width: 1000px;
    background-color: #fff;
    /* margin-bottom: 20px; */
}
</style>