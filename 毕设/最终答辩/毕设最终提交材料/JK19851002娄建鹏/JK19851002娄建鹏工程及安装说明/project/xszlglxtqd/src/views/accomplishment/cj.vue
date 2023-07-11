<template>
    <div class="cj">
        <h1>{{username}}获得的成就</h1>
        <el-button type="primary" style="margin-left: 1140px;margin-top: -100px;" @click="fhui()">返回</el-button>
        <div v-if="length==0" class="mcj">该用户还没有解锁成就。</div>
        <div v-else class="cjkp">
            <div v-for="index in list" :key="index" style="margin-bottom: 5px;">
                <el-card>
                    <div style="display: flex;align-items: center;">
                        <div><img :src="index.cj" style="height: 50px;margin-left: 200px;"/></div>
                        <div style="width: 700px;">
                            <span style="display: block;text-align: center;font-size: 40px;font-weight: 600;">{{ index.name }}</span>
                            <span style="display: block;text-align: center;font-size: 20px;">{{ index.condition }}</span>
                        </div>
                    </div>
                </el-card>
            </div>
            <div v-if="length==1" style="margin-top: 445px;text-align: center;font-weight: 600;color: #fff;">.</div>
            <div v-if="length==2" style="margin-top: 320px;text-align: center;font-weight: 600;color: #fff;">.</div>
            <div v-if="length==3" style="margin-top: 193px;text-align: center;font-weight: 600;color: #fff;">.</div>
            <div v-if="length==4" style="margin-top: 67px;text-align: center;font-weight: 600;color: #fff;">.</div>
            <div v-if="length>4" style="text-align: center;font-weight: 600;color: #fff;">.</div>
        </div>
    </div>
</template>

<script>
let username = sessionStorage.getItem("username");
import router from '../../router';
export default {
    data() {
        return {
            list:[],
            length:0,
            username:this.$route.query.username,
        }
    },
    methods: {
        xianshi(){
            this.axios.post('/accomplishment/cjList', {
				username: this.username
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
        },fhui(){
            router.push("/data_count/main").then(() => {
                setTimeout(router.go(0), 0);
            });
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
    width: 90%;
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
    width: 1200px;
    height: 307px;
    text-align: center;
    color:#000000;
    font-weight: bold;
    background-color: #fff;
    padding-top: 280px;
}
.cjkp{
    margin: auto;
    width: 1200px;
    background-color: #fff;
    /* margin-bottom: 20px; */
}
</style>