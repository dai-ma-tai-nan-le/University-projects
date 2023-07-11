<template>
	<el-main class="notice_main">
		<div class="zuo">
			<el-menu default-active="you" style="padding-top: 10px;color: #000;">
				<el-menu-item index="1" @click="menu">
					<span>个人</span>
				</el-menu-item>
				<el-menu-item index="2" @click="menu">
					<span>班级</span>
				</el-menu-item>
				<el-menu-item index="3" @click="menu">
					<span>专业</span>
				</el-menu-item>
				<el-menu-item index="4" @click="menu">
					<span>学院</span>
				</el-menu-item>
				<el-menu-item index="5" @click="menu">
					<span>学校</span>
				</el-menu-item>
			</el-menu>
		</div>
		<!-- <div class="zuo1">
			<div data-v-2695ae86="" class="satisfied-component">
				<div data-v-91c4a4b4="" data-v-2695ae86="" class="so-questionnaire">
					<div data-v-91c4a4b4="" class="sq-main">
						<div data-v-91c4a4b4="" class="sq-hd">“登录/注册”流程满意度</div>
						<div data-v-91c4a4b4="" class="sq-bd">
							<ul data-v-91c4a4b4="" class="vertical">
								<li data-v-91c4a4b4="" class="others">
									<i data-v-91c4a4b4="" class="icon"></i>
									<span data-v-91c4a4b4="" class="text">非常不满意</span>
								</li>
								<li data-v-91c4a4b4="" class="others">
									<i data-v-91c4a4b4="" class="icon"></i>
									<span data-v-91c4a4b4="" class="text">不满意</span>
								</li>
								<li data-v-91c4a4b4="" class="others">
									<i data-v-91c4a4b4="" class="icon"></i>
									<span data-v-91c4a4b4="" class="text">一般</span>
								</li>
								<li data-v-91c4a4b4="" class="others">
									<i data-v-91c4a4b4="" class="icon"></i>
									<span data-v-91c4a4b4="" class="text">满意</span>
								</li>
								<li data-v-91c4a4b4="" class="others">
									<i data-v-91c4a4b4="" class="icon"></i>
									<span data-v-91c4a4b4="" class="text">非常满意</span>
								</li>
							</ul>
						</div> 
					</div>
				</div>
			</div>
		</div> -->
		<div class="you">
			<h1 v-if="reusername === username">个人</h1>
			<h1 v-else>{{ reusername }}</h1>
			<el-tabs v-model="activeName" class="demo-tabs" @tab-click="handleClick">
				<el-tab-pane label="全部" name="全部">
					<div v-if="JSON.parse(JSON.stringify(this.list)).length !== 0">
						<div class="jhlb" v-for="index in list" :key="index">
							<span class="time">{{ index.publishTime }}</span>
							<el-card class="box-card" shadow="hover">
								<template #header>
									<div class="card-header">
										<el-avatar style="overflow: hidden;">
											<img src="../../../public/tz/lb.jpg" />
										</el-avatar>
										<span style="margin-left: 60px;display: block;margin-top: -35px;">{{
											index.username }}</span>
										<span style="margin-left:300px;display: block;margin-top: -20px;">{{ index.type
										}}</span>
										<div class="sangeann">
											<el-button class="start shanchu" @click="xsdeltz(index)"
												v-if="index.reusername === username">删除</el-button>
											<el-button class="start" @click="qrsdtz(index)"
												v-if="index.received == 0">确认收到</el-button>
											<el-button class="start" v-else>已确认收到</el-button>
											<el-button class="start shanchu" @click="zdtz(index)"
												v-if="index.level == 1 || index.xslevel == 1">取消置顶</el-button>
											<el-button class="start shanchu" @click="zdtz1(index)" v-else>置顶</el-button>
										</div>
									</div>
								</template>
								<div class="minddle">
									<div class="minddle1">
										<div style="text-align: center;">
											<h3>{{ index.title }}</h3>
											<div>{{ index.content }}</div>
										</div>
									</div>
								</div>
							</el-card>
						</div>
					</div>
					<div v-else style="height: 370px;text-align: center;padding-top: 100px;">
						<img src="../../../public/tz/kkry.jpg" />
						<div>空空如也</div>
					</div>
				</el-tab-pane>
				<el-tab-pane label="提醒" name="提醒">
					<div v-if="JSON.parse(JSON.stringify(this.list)).length !== 0">
						<div class="jhlb" v-for="index in list" :key="index">
							<span class="time">{{ index.publishTime }}</span>
							<el-card class="box-card" shadow="hover">
								<template #header>
									<div class="card-header">
										<el-avatar style="overflow: hidden;">
											<img src="../../../public/tz/lb.jpg" />
										</el-avatar>
										<span style="margin-left: 60px;display: block;margin-top: -35px;">{{
											index.username }}</span>
										<div class="sangeann">
											<el-button class="start shanchu" @click="xsdeltz(index)"
												v-if="index.reusername === username">删除</el-button>
											<el-button class="start" @click="qrsdtz(index)"
												v-if="index.received == 0">确认收到</el-button>
											<el-button class="start" v-else>已确认收到</el-button>
											<el-button class="start shanchu" @click="zdtz(index)"
												v-if="index.level == 1 || index.xslevel == 1">取消置顶</el-button>
											<el-button class="start shanchu" @click="zdtz1(index)" v-else>置顶</el-button>
										</div>
									</div>
								</template>
								<div class="minddle">
									<div class="minddle1">
										<div style="text-align: center;">
											<h3>{{ index.title }}</h3>
											<div>{{ index.content }}</div>
										</div>
									</div>
								</div>
							</el-card>
						</div>
					</div>
					<div v-else style="height: 370px;text-align: center;padding-top: 100px;">
						<img src="../../../public/tz/kkry.jpg" />
						<div>空空如也</div>
					</div>
				</el-tab-pane>
				<el-tab-pane label="通知" name="通知">
					<div v-if="JSON.parse(JSON.stringify(this.list)).length !== 0">
						<div class="jhlb" v-for="index in list" :key="index">
							<span class="time">{{ index.publishTime }}</span>
							<el-card class="box-card" shadow="hover">
								<template #header>
									<div class="card-header">
										<el-avatar style="overflow: hidden;">
											<img src="../../../public/tz/lb.jpg" />
										</el-avatar>
										<span style="margin-left: 60px;display: block;margin-top: -35px;">{{
											index.username }}</span>
										<div class="sangeann">
											<el-button class="start shanchu" @click="xsdeltz(index)"
												v-if="index.reusername === username">删除</el-button>
											<el-button class="start" @click="qrsdtz(index)"
												v-if="index.received == 0">确认收到</el-button>
											<el-button class="start" v-else>已确认收到</el-button>
											<el-button class="start shanchu" @click="zdtz(index)"
												v-if="index.level == 1 || index.xslevel == 1">取消置顶</el-button>
											<el-button class="start shanchu" @click="zdtz1(index)" v-else>置顶</el-button>
										</div>
									</div>
								</template>
								<div class="minddle">
									<div class="minddle1">
										<div style="text-align: center;">
											<h3>{{ index.title }}</h3>
											<div>{{ index.content }}</div>
										</div>
									</div>
								</div>
							</el-card>
						</div>
					</div>
					<div v-else style="height: 370px;text-align: center;padding-top: 100px;">
						<img src="../../../public/tz/kkry.jpg" />
						<div>空空如也</div>
					</div>
				</el-tab-pane>
				<el-tab-pane label="公告" name="公告">
					<div v-if="JSON.parse(JSON.stringify(this.list)).length !== 0">
						<div class="jhlb" v-for="index in list" :key="index">
							<span class="time">{{ index.publishTime }}</span>
							<el-card class="box-card" shadow="hover">
								<template #header>
									<div class="card-header">
										<el-avatar style="overflow: hidden;">
											<img src="../../../public/tz/lb.jpg" />
										</el-avatar>
										<span style="margin-left: 60px;display: block;margin-top: -35px;">{{
											index.username }}</span>
										<div class="sangeann">
											<el-button class="start shanchu" @click="xsdeltz(index)"
												v-if="index.reusername === username">删除</el-button>
											<el-button class="start" @click="qrsdtz(index)"
												v-if="index.received == 0">确认收到</el-button>
											<el-button class="start" v-else>已确认收到</el-button>
											<el-button class="start shanchu" @click="zdtz(index)"
												v-if="index.level == 1 || index.xslevel == 1">取消置顶</el-button>
											<el-button class="start shanchu" @click="zdtz1(index)" v-else>置顶</el-button>
										</div>
									</div>
								</template>
								<div class="minddle">
									<div class="minddle1">
										<div style="text-align: center;">
											<h3>{{ index.title }}</h3>
											<div>{{ index.content }}</div>
										</div>
									</div>
								</div>
							</el-card>
						</div>
					</div>
					<div v-else style="height: 370px;text-align: center;padding-top: 100px;">
						<img src="../../../public/tz/kkry.jpg" />
						<div>空空如也</div>
					</div>
				</el-tab-pane>
				<!-- <el-tab-pane label="文件" name="fifth">文件</el-tab-pane>
				<el-tab-pane label="图片" name="six">图片</el-tab-pane>
				<el-tab-pane label="视频" name="seven">视频</el-tab-pane> -->
			</el-tabs>
		</div>
	</el-main>
</template>

<script>
let username = sessionStorage.getItem("username");
import { ElMessage, ElMessageBox } from 'element-plus'
export default {
	data() {
		return {
			activeName: '全部',
			username: username,
			reusername: username,
			list: [],
			type: '全部',
			level: 1,
			level1: 0,
			sd: 1,
		}
	},
	methods: {
		menu(index) {
			let data = JSON.parse(sessionStorage.getItem("user"))
			// console.log(index.index)
			if (index.index == 1) {
				this.reusername = username;
				// console.log(this.reusername)
				this.xianshi();
			} else if (index.index == 2) {
				this.reusername = data[0]["className"];
				// console.log(this.reusername)
				this.xianshi();
			} else if (index.index == 3) {
				this.reusername = data[0]["major"];
				// console.log(this.reusername)
				this.xianshi();
			} else if (index.index == 4) {
				this.reusername = data[0]["academy"];
				// console.log(this.reusername)
				this.xianshi();
			} else if (index.index == 5) {
				this.reusername = '学校';
				// console.log(this.reusername)
				this.xianshi();
			}
		}, handleClick(tab) {
			// console.log(tab.props.name);
			this.type = tab.props.name;
			this.xianshi();
		}, xianshi() {
			this.axios.post("/notice/tzList", {
				username: username,
				reusername: this.reusername,
				type: this.type
			})
				.then(res => res.data).then(res => {
					if (res.code == 200) {
						console.log(res.data)
						this.list = res.data;
						// this.endTime = res.data['endTime']
					} else {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '数据查询失败',
							type: 'error'
						});
					}
				})
		}, qrsdtz(index) {
			let index1 = JSON.parse(JSON.stringify(index));
			this.axios.post('/notice/qrsftz', {
				noticeId: index1.noticeId,
				username: username,
				reusername: index1.username,
				sd: this.sd
			})
				.then(res => res.data).then(res => {
					// console.log(res);
					if (res.code == 200) {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '确认收到成功',
							type: 'success'
						});
						this.xianshi();
					} else {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '确认收到失败',
							type: 'error'
						});
					}
				})
		}, zdtz(index) {
			let index1 = JSON.parse(JSON.stringify(index));
			if (index1.level == 0) {
				this.axios.post('/notice/xszhiding1', {
					noticeId: index1.noticeId,
					username: username,
					level1: this.level1
				})
					.then(res => res.data).then(res => {
						// console.log(res);
						if (res.code == 200) {
							this.$message({
								duration: 3000,
								offset: 50,
								message: '取消置顶成功',
								type: 'success'
							});
							this.xianshi();
						} else {
							this.$message({
								duration: 3000,
								offset: 50,
								message: '取消置顶失败',
								type: 'error'
							});
						}
					})
			} else {
				this.$message({
					duration: 3000,
					offset: 50,
					message: '取消置顶失败，这是教师或者管理员设置的置顶，你没有权限取消置顶。',
					type: 'error'
				});
			}
		}, zdtz1(index) {
			let index1 = JSON.parse(JSON.stringify(index));
			this.axios.post('/notice/xszhiding', {
				noticeId: index1.noticeId,
				username: username,
				level: this.level
			})
				.then(res => res.data).then(res => {
					// console.log(res);
					if (res.code == 200) {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '置顶成功',
							type: 'success'
						});
						this.xianshi();
					} else {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '置顶失败',
							type: 'error'
						});
					}
				})
		}, xsdeltz(index) {
			let index1 = JSON.parse(JSON.stringify(index));
			ElMessageBox.confirm(
				'是否确认删除该通知',
				'提示',
				{
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning',
				}
			)
				.then(() => {
					this.axios.post('/notice/xsdeltz', {
						noticeId: index1.noticeId,
					})
						.then(res => res.data).then(res => {
							// console.log(res);
							if (res.code == 200) {
								this.$message({
									duration: 3000,
									offset: 50,
									message: '通知删除成功',
									type: 'success'
								});
								this.xianshi();
							} else {
								this.$message({
									duration: 3000,
									offset: 50,
									message: '通知删除失败',
									type: 'error'
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
		}
	}, beforeMount() {
		this.xianshi();
	}
}
</script>

<style>
.notice_main {
	padding: 2rem 1rem;
	background-color: #eeeeee !important;
	width: 70%;
	height: 92vh;
	margin: 0 auto;
	padding: 0;
}

.zuo span {
	color: #000;
	padding-left: 60px;
}

.zuo {
	width: 200px;
	/* height: 92vh; */
	height: 305px;
	background-color: rgb(255, 255, 255);
	margin-left: 20px;
	position: fixed;
}

h1 {
	text-align: center;
	/* margin-bottom: 20px; */
	color: #00838F !important;
}

/* .zuo1 {
	width: 200px;
	height: 300px;
	background-color: rgb(255, 255, 255);
	margin-left: 20px;
	margin-top: 315px;
	position: fixed;
} */

.you {
	width: 820px;
	float: right;
	/* height: 100%; */
	margin-right: 20px;
	background-color: rgb(250, 250, 250);
	/* border: 2px solid #987f59; */
}

.jhlb {
	display: block;
	margin-left: 55px;
}

.time {
	display: block;
	margin-left: -55px;
	text-align: center;
}

.el-form-item__content {
	font-size: 20px;
}

.el-card {
	width: 700px;
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
	float: right;
	display: block;
	margin-top: 5px;
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

.el-tabs--top .el-tabs__item.is-top:nth-child(2) {
	padding-left: 120px;
}

.el-tabs__item {
	padding-left: 120px;
}

.el-tabs {
	width: 820px;
	/* position: fixed; */
}

.el-form-item__label {
	color: #00838F !important;
}</style>