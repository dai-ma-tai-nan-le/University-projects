<template>
    <div class="question">
        <el-card class="card">
            <div class="zxskp" v-for="index in list" :key="index">
                <div>
                    <div style="font-size: 18px;width: 800px;font-weight: 600;">{{ index.roomName }}(加入码 {{ index.code }})
                    </div>
                    <div style="width: 800px;margin-top: 10px;">{{ index.roomIntroduce }}</div>
                    <el-button v-if="index.password != 'd41d8cd98f00b204e9800998ecf8427e'" class="xymm">需要密码</el-button>
                    <el-button class="jrrs">{{ index.joinNum }}人</el-button>
                    <el-button class="xdrs">限定{{ index.limitNum }}人</el-button>
                    <div style="color: dodgerblue;font-size: 20px;font-weight: 600;text-align: center;margin-left: 200px;">房主：{{ homeOwner }}</div>
                </div>
                <div>
                    <el-button type="primary" style="margin-left: 180px;margin-top: -80px;" @click="fanhui()">返回</el-button>
                    <div style="font-size: 20px;font-weight: 600;margin-left: 100px;">共{{length}}个问题</div>
                </div>
            </div>
        </el-card>
        <div class="wt">
            <div class="query">
                <el-form :inline="true" :model="form" class="demo-form-inline">
                    <el-form-item label="问题">
                        <el-input v-model="form.question" placeholder="请输入问题进行查询" style="width: 500px;"/>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="query()">查询</el-button>
                        <el-button type="primary" @click="shuaxin()">重置</el-button>
                    </el-form-item>
                </el-form>
            </div>
            <div v-if="JSON.parse(JSON.stringify(this.wtList)).length !== 0">
                <div class="jhlb" v-for="index in wtList" :key="index">
                    <el-card class="card1" shadow="hover">
                        <template #header>
							<div class="card-header">
								<el-avatar style="overflow: hidden;">
									<img v-if="index.avatar" :src="tuPianUrl + index.avatar" />
									<img v-else src="/img/error.png" />
								</el-avatar>
								<span style="margin-left: 60px;display: block;margin-top: -35px;">{{ index.username}}</span>
								<span style="margin-left:460px;display: block;margin-top: -20px;">问题</span>
								<div style="float: right;margin-top: 5px;">
                                    <el-button class="start shanchu" @click="fzdel(index)">删除</el-button>
								</div>
							</div>
						</template>
						<div class="minddle">
							<div class="minddle1">
								<div style="text-align: center;">
									<div>{{index.content }}</div>
								</div>
							</div>
						</div>
						<div class="minddles">
							<div v-if="index.hits.length !== 0" style="display: flex;">
								<svg t="1681215982915" class="icon" viewBox="0 0 1024 1024" version="1.1"
									xmlns="http://www.w3.org/2000/svg" p-id="2841" width="15" height="15">
									<path
										d="M64 483.04V872c0 37.216 30.144 67.36 67.36 67.36H192V416.32l-60.64-0.64A67.36 
													 67.36 0 0 0 64 483.04zM857.28 344.992l-267.808 1.696c12.576-44.256 18.944-83.584 18.944-118.208 
													 0-78.56-68.832-155.488-137.568-145.504-60.608 8.8-67.264 61.184-67.264 126.816v59.264c0 76.064-63.84 140.864-137.856 
													 148L256 416.96v522.4h527.552a102.72 102.72 0 0 0 100.928-83.584l73.728-388.96a102.72 102.72 0 0 0-100.928-121.824z"
										p-id="2842" data-spm-anchor-id="a313x.7781069.0.i3" class="selected" fill="#fc5533">
									</path>
								</svg>
								<span v-for="index1 in index.hits" :key="index1" style="display: flex;">
									{{ index1.username }}，
								</span>
							</div>
						</div>
						<div class="footer">
							<span class="time">发布于 {{ index.createTime }}</span>
							<div class="sangeann">
								<span @click="dianzhan(index)" v-if="index.likes === 0||index.likes === null">
									<svg t="1681215982915" class="icon" viewBox="0 0 1024 1024" version="1.1"
										xmlns="http://www.w3.org/2000/svg" p-id="2841"
										data-spm-anchor-id="a313x.7781069.0.i6" width="15" height="15">
										<path d="M64 483.04V872c0 37.216 30.144 67.36 67.36 67.36H192V416.32l-60.64-0.64A67.36 
												67.36 0 0 0 64 483.04zM857.28 344.992l-267.808 1.696c12.576-44.256 18.944-83.584 18.944-118.208
												 0-78.56-68.832-155.488-137.568-145.504-60.608 8.8-67.264 61.184-67.264 126.816v59.264c0 76.064-63.84 
												 140.864-137.856 148L256 416.96v522.4h527.552a102.72 102.72 0 0 0 100.928-83.584l73.728-388.96a102.72 
												 102.72 0 0 0-100.928-121.824z" p-id="2842" data-spm-anchor-id="a313x.7781069.0.i3" class="" fill="#2c2c2c">
										</path>
									</svg>点赞</span>
								<span @click="dianzhan1(index)" v-else>
									<svg t="1681215982915" class="icon" viewBox="0 0 1024 1024" version="1.1"
										xmlns="http://www.w3.org/2000/svg" p-id="2841" width="15" height="15">
										<path
											d="M64 483.04V872c0 37.216 30.144 67.36 67.36 67.36H192V416.32l-60.64-0.64A67.36 
													 67.36 0 0 0 64 483.04zM857.28 344.992l-267.808 1.696c12.576-44.256 18.944-83.584 18.944-118.208 
													 0-78.56-68.832-155.488-137.568-145.504-60.608 8.8-67.264 61.184-67.264 126.816v59.264c0 76.064-63.84 140.864-137.856 
													 148L256 416.96v522.4h527.552a102.72 102.72 0 0 0 100.928-83.584l73.728-388.96a102.72 102.72 0 0 0-100.928-121.824z"
											p-id="2842" data-spm-anchor-id="a313x.7781069.0.i3" class="selected"
											fill="#fc5533"></path>
									</svg>取消点赞</span>
                                <span style="margin-left: 520px;" @click="ckgd(index)">查看更多>></span>
							</div>
						</div>
                    </el-card>
                </div>
            </div>
            <div v-if="length==0" style="height: 387px;text-align: center;padding-top: 100px;">
				<img src="../../../public/tz/kkry.jpg" />
				<div>该自习室还没有成员提问。</div>
			</div>
            <div v-if="length==1" style="height: 263px;"></div>
            <div v-if="length==2" style="height: 58px;"></div>
        </div>
    </div>
</template>

<script>
let username = sessionStorage.getItem("username");
import { ElMessage, ElMessageBox } from 'element-plus';
import router from '../../router';
export default {
	data() {
		return {
			list:[],
            homeOwner:'',
            username:username,
            centerDialogVisible:false,
            form: {
                question: ''
            },
            form1:{
                textarea:''
            },
            group:'管理',
            dz: 1,
			qxdz: 0,
            length:0,
            wtList:[],
            tuPianUrl: "http://localhost:8080",
		}
	},
	methods: {
        xianshi() {
            this.axios.post("/studyRoom/selectRoomId4", {
                id: this.$route.query.studyRoomId,
            })
                .then(res => res.data).then(res => {
                    console.log(res.data);
                    if (res.code == 200) {
                        this.list = res.data;
                        this.homeOwner=res.data[0]['homeowner']
                    }
                    else {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: "数据查询失败",
                            type: "error"
                        });
                        router.push("/study_room/main1").then(() => {
                            setTimeout(router.go(0), 0);
                        });
                    }
                });
        },query(){
            this.axios.post("/studyRoom/selectWt1", {
                question: this.form.question,
                id: this.$route.query.studyRoomId,
                username: username,
            })
                .then(res => res.data).then(res => {
                    console.log(res.data);
                    if (res.code == 200) {
                        this.wtList = res.data;
                        this.length = this.wtList.length
                    }
                    else {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: "数据查询失败",
                            type: "error"
                        });
                    }
                });
        },shuaxin(){
            this.form.question='';
            this.axios.post("/studyRoom/selectWt1", {
                question: this.form.question,
                id: this.$route.query.studyRoomId,
                username: username,
            })
                .then(res => res.data).then(res => {
                    console.log(res.data);
                    if (res.code == 200) {
                        this.wtList = res.data;
                        this.length = this.wtList.length
                    }
                    else {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: "数据查询失败",
                            type: "error"
                        });
                    }
                });
        }, dianzhan(index) {
			let index1 = JSON.parse(JSON.stringify(index));
			this.axios.post('/communication/dianzhan', {
				username: username,
				communicationId: index1.wtId,
				dz: this.dz,
				type: '问题'
			})
				.then(res => res.data).then(res => {
					// console.log(res);
					if (res.code == 200) {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '点赞成功',
							type: 'success'
						});
						this.query();
					} else {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '点赞失败',
							type: 'error'
						});
					}
				}
				)
		}, dianzhan1(index) {
			let index1 = JSON.parse(JSON.stringify(index));
			this.axios.post('/communication/qxdz', {
				username: username,
                communicationId: index1.wtId,
				qxdz: this.qxdz,
				type: '问题'
			})
				.then(res => res.data).then(res => {
					// console.log(res);
					if (res.code == 200) {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '取消点赞成功',
							type: 'success'
						});
						this.query();
					} else {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '取消点赞失败',
							type: 'error'
						});
					}
				}
				)
		},ckgd(index){
            let index1 = JSON.parse(JSON.stringify(index));
            router.push( {path: "/study_room/discuss", query:{wtId:index1.wtId,homeOwner:this.homeOwner} }).then(() => {
				setTimeout(router.go(0), 0);
			});
        },fzdel(index){
            let index1 = JSON.parse(JSON.stringify(index));
            ElMessageBox.confirm(
                '是否确认删除该问题',
                '提示',
                {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning',
                }
            )
                .then(() => {
                    this.axios.post('/studyRoom/fzdelwt', {
                        id: index1.wtId,
                        username:index1.username,
                        people:username,
                        group:this.group,
                        roomName:this.list[0]['roomName']
                    })
                        .then(res => res.data).then(res => {
                            if (res.code === 200) {
                                this.$message({
                                    duration: 3000,
                                    offset: 50,
                                    message: "问题删除成功",
                                    type: "success"
                                });
                                this.query();
                            } else {
                                this.$message({
                                    duration: 3000,
                                    offset: 50,
                                    message: "问题删除失败",
                                    type: "error"
                                });
                            }
                        })
                })
                .catch(() => {
                    ElMessage({
                        type: 'info',
                        duration: 3000,
                        offset: 50,
                        message: '已取消删除',
                    })
                })
        }, fanhui() {
            router.push("/study_room/main").then(() => {
                setTimeout(router.go(0), 0);
            });
        }
	},beforeMount() {
        this.xianshi();
        this.query();
    }
}
</script>

<style>
.question{
    padding: 2rem 1rem;
    background-color: #eeeeee !important;
    width: 90%;
    margin: 0 auto;
    padding: 0;
}
.el-form-item__label {
    color: #00838F !important;
}
.el-dialog__title {
    color: #00838F !important;
}
.card {
    width: 1100px;
    margin: auto;
}

.zxskp {
    display: flex;
    align-items: center;
}

.xymm {
    margin-top: 10px;
    height: 20px;
    font-size: 10px;
    background-color: rgb(231, 208, 253);
    color: #7b0490;
}

.jrrs {
    height: 20px;
    margin-top: 10px;
    font-size: 10px;
    background-color: rgb(253, 214, 187);
    color: #ff7300;
}

.xdrs {
    height: 20px;
    margin-top: 10px;
    font-size: 10px;
    background-color: rgb(255, 220, 195);
    color: #ff7300;
}
.wt{
    width: 1100px;
    margin: auto;
    background-color: #ffffff;
}
.query {
    padding-top: 20px;
    padding-left: 20px;
    border-bottom: solid 2px #eee;
}
.jhlb {
	display: block;
	margin-left: 50px;
}

.el-form-item__content {
	font-size: 20px;
}

.card1 {
	width: 1000px;
	margin-top: 20px;
	margin-bottom: 20px;
}

.myxx {
	text-align: center;
	margin-top: 10px;
	width: 100%;
	height: 100px;
	padding-top: 50px;
	font-size: 30px;
	background-color: #fff;
}

.start {
	margin-top: -60px;
	margin-left: 20px;
	border-radius: 30%;
	font-weight: 700;
	/* 字变斜 */
	font-style: oblique;
	color: #027cff;
	background-color: rgb(193, 231, 255);
}

.start:hover {
	margin-top: -60px;
	margin-left: 20px;
	border-radius: 30%;
	font-weight: 700;
	/* 字变斜 */
	font-style: oblique;
	color: #027cff;
	background-color: rgb(193, 231, 255);
}

.shanchu {
	font-weight: 700;
	color: #fb0000;
	background-color: rgb(247, 179, 179);
}

.shanchu:hover {
	font-weight: 700;
	color: #fb0000;
	background-color: rgb(247, 179, 179);
}

.sangeann {
	float: left;
	display: block;
	margin-left: 20px;
}

.sangeann span {
	margin-left: 30px;
	cursor: pointer;
}

.minddle {
	width: 100%;
	border-radius: 20px 20px;
	color: #000000;
	background-color: rgb(193, 231, 255);
}

.minddle1 {
	margin-left: 20px;
	margin-right: 20px;
	padding-top: 7px;
	padding-bottom: 7px;
}

.minddles {
	width: 100%;
	margin-top: 10px;
	border-radius: 20px 20px;
	color: #000000;
	background-color: rgb(203, 203, 203);
}

.minddles span {
	margin-left: 10px;
	padding-bottom: 5px;
	padding-top: 5px;
}

.minddles svg {
	padding-top: 5px;
	padding-bottom: 5px;
	margin-left: 10px;
}

.footer {
	margin-top: 20px;
	display: flex;
}
</style>