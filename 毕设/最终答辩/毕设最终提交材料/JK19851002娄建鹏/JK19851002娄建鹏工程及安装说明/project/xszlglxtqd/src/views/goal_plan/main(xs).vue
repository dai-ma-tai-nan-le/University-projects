<template>
	<el-main class="plan_main">
		<div class="tjwlmb">
			<el-carousel :interval="4000" type="card" height="200px">
				<el-carousel-item v-for="item in list" :key="item">
					<img class="wlmbt" :src="item" @click="tjwlmb" />
				</el-carousel-item>
			</el-carousel>
			<p>点击图片添加学未来目标</p>
		</div>
		<div class="jhlb">
			<!-- <el-card class="box-card" shadow="hover" v-for="index in xxjhList" :key="index"> -->
			<el-card class="box-card" shadow="hover" v-for="index in wlmbList" :key="index">
				<template #header>
					<div class="card-header">
						<span>{{ index.goalName }}</span>
						<span style="display: block;margin-left:  600px;margin-top: -20px;"
							v-if="(Math.round((new Date(index.endTime) - new Date(Date.now())) / (1000 * 60 * 60 * 24)) >= 0) && index.endTime != null">还剩
							{{ Math.round((new Date(index.endTime) - new Date(Date.now())) / (1000 * 60 * 60 * 24))
							}}天</span>
						<span style="display: block;margin-left:  600px;margin-top: -20px;" v-else
							v-if="index.endTime != null">已过
							{{ Math.round((new Date(Date.now()) - new Date(index.endTime)) / (1000 * 60 * 60 * 24))
							}}天</span>
						<span style="display: block;margin-top: 10px;">{{ index.goalDescribe }}</span>
						<div v-if="index.goalDescribe != ''">
							<span style="display: block;margin-left:300px;margin-top: -20px;"
								v-if="(Math.round((new Date(index.endTime) - new Date(Date.now())) / (1000 * 60 * 60 * 24)) >= 0) && index.endTime != null">已过
								{{ Math.round((new Date(Date.now()) - new Date(index.createTime)) / (1000 * 60 * 60 * 24))
								}}/
								{{ Math.round((new Date(index.endTime) - new Date(index.createTime)) / (1000 * 60 * 60 *
									24))
								}}天</span>
							<span style="display: block;margin-left: 600px;margin-top: -20px;"
								v-if="index.endTime != null">{{ index.endTime }}</span>
						</div>
						<div v-else-if="(Math.round((new Date(index.endTime) - new Date(Date.now())) / (1000 * 60 * 60 * 24))>=0)">
							<span style="display: block;margin-left:300px;margin-top: 0px;"
								v-if="(Math.round((new Date(index.endTime) - new Date(Date.now())) / (1000 * 60 * 60 * 24)) >= 0) && index.endTime != null">已过
								{{ Math.round((new Date(Date.now()) - new Date(index.createTime)) / (1000 * 60 * 60 * 24))
								}}/
								{{ Math.round((new Date(index.endTime) - new Date(index.createTime)) / (1000 * 60 * 60 *
									24))
								}}天</span>
							<span style="display: block;margin-left: 600px;margin-top: -20px;"
								v-if="index.endTime != null">{{ index.endTime }}</span>
						</div>
						<div v-else>
							<span style="display: block;margin-left: 600px;margin-top: 0px;"
								v-if="index.endTime != null">{{ index.endTime }}</span>
						</div>
						<div class="sangeann">
							<el-button class="start" @click="modplan(index)">编辑</el-button>
							<el-button class="start shanchu" @click="delplan(index)">删除</el-button>
						</div>
					</div>
				</template>
				<span style="margin-left: 400px;">建于：{{ index.createTime.split(" ")[0] }}</span>
			</el-card>
		</div>
		<!--对话框-->
		<el-dialog title="编辑未来目标" v-model="centerDialogVisible" width="30%" center>
			<el-form ref="form" :model="form" :rules="rules" label-width="80px">
				<el-form-item prop="goalname" label-width="120px" label="学习计划名称" style="margin-top: 0px;">
					<el-input v-model="form.goalname" style="width: 250px" placeholder="请输入未来目标名称"></el-input>
				</el-form-item>
				<el-form-item prop="description" label="目标描述：" label-width="120px">
					<el-input v-model="form.description" placeholder="如:心仪的大学" style="width: 250px" />
				</el-form-item>
				<div>
					<span style="color: #00838F;font-size: 14px;margin-left: 38px;">截止日期：</span>
					<el-date-picker v-model="form.value" type="date" placeholder="设定目标日期" :size="size"
						style="margin-left: 13px;width: 250px;" value-format="YYYY-MM-DD" />
				</div>
			</el-form>
			<div style="margin-top: 20px;">
				<span slot="footer" class="dialog-footer" style="margin-left: 120px;">
					<el-button @click="centerDialogVisible = false">取 消</el-button>
					<el-button type="primary" @click="submit()">确 定</el-button>
				</span>
			</div>
		</el-dialog>
	</el-main>
</template>

<script>
import router from "../../router";
let username = sessionStorage.getItem("username")
import { ElMessage, ElMessageBox } from 'element-plus'
export default {
	data() {
		//查重名
		let checkplanname = (rule, value, callback) => {
			this.axios.get('/goalPlan/findplanname?username=' + username + '&goalname=' + this.form.goalname)
				.then(res => {
					// console.log(res)
					if (res.data.code == 200) {
						callback();
					} else {
						callback(new Error('该目标名称已存在'));
					}
				})
		};
		return {
			list: [],
			pg1: require("../../../public/img/wlmb1.jpg"),
			pg2: require("../../../public/img/wlmb2.jpg"),
			pg3: require("../../../public/img/wlmb3.jpg"),
			pg4: require("../../../public/img/wlmb4.jpg"),
			wlmbList: [],
			// seen: true, //判断创建时间是否已过
			// hiddern: true,
			// endTime: '',
			centerDialogVisible: false,
			form: {
				goalname: "",
				description: "",
				value: ''
			},
			goalPlanId: '',
			// 校验规则
			rules: {
				goalname: [{ required: true, message: '昵称不能为空！', trigger: 'blur' },
				{ validator: checkplanname, trigger: 'blur' }
				]
			}
		}
	},
	methods: {
		getList() {
			this.list.push(this.pg1, this.pg2, this.pg3, this.pg4);
		}, tjwlmb() {
			router.push('/goal_plan/view1').then(() => {
				setTimeout(router.go(0), 0);
			});
		}, xianshi() {
			this.axios.post("/goalPlan/wlmbList", {
				username: username
			})
				.then(res => res.data).then(res => {
					if (res.code == 200) {
						// console.log(res.data)
						this.wlmbList = res.data;
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
		}, submit() {
			console.log(this.form.value)
			this.axios.post('/goalPlan/modplan', {
				goalPlanId: this.goalPlanId,
				goalname: this.form.goalname,
				description: this.form.description,
				value1: this.form.value
			})
				.then(res => res.data).then(res => {
					// console.log(res);
					console.log(this.form.value)
					if (res.code == 200) {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '目标修改成功',
							type: 'success'
						});
						this.centerDialogVisible = false;
						this.xianshi();
					} else {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '目标修改失败',
							type: 'error'
						});
						this.centerDialogVisible = false;
					}
				}
				)
		}, modplan(index) {
			let index1 = JSON.parse(JSON.stringify(index));
			this.form.goalname = index1.goalName;
			this.form.description = index1.goalDescribe;
			this.form.value = index1.endTime;
			this.goalPlanId = index1.goalPlanId;
			this.centerDialogVisible = true;
		}, delplan(index) {
			let index1 = JSON.parse(JSON.stringify(index));
			this.goalPlanId = index1.goalPlanId;
			ElMessageBox.confirm(
				'是否确认删除该计划',
				'注意',
				{
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning',
				}
			)
				.then(() => {
					this.axios.post('/goalPlan/delplan', {
						goalPlanId: this.goalPlanId,
					})
						.then(res => res.data).then(res => {
							// console.log(res);
							if (res.code == 200) {
								this.$message({
									duration: 3000,
									offset: 50,
									message: '目标删除成功',
									type: 'success'
								});
								this.xianshi();
							} else {
								this.$message({
									duration: 3000,
									offset: 50,
									message: '目标删除失败',
									type: 'error'
								});
							}
						}
						)
				})
				.catch(() => {
					ElMessage({
						type: 'info',
						message: '已取消删除',
					})
				})
		}
	}, beforeMount() {
		this.getList();
		this.xianshi();
	}
}
</script>

<style>
.plan_main {
	padding: 2rem 1rem;
	background-color: #eeeeee !important;
	width: 70%;
	margin: 0 auto;
	padding: 0;
}

.tjwlmb p {
	display: none;
	margin: auto;
	position: absolute;
	top: 208px;
	left: 509px;
	background-color: rgba(111, 109, 109, 0.5);
	width: 500px;
	height: 50px;
	text-align: center;
	padding-top: 3px;
	color: #fff;
	font-size: xx-large;
	z-index: 999;
}

.el-form-item__label {
	color: #00838F !important;
}

.tjwlmb:hover p {
	display: block;
}

.wlmbt {
	width: 500px;
	display: block;
	margin: auto;
	height: 200px;
	/* margin-top: -70px; */
}

.search_btn_wrap {
	margin-bottom: 20px;
	/* padding-left: 100px; */
}

.el-button--text {
	margin-right: 15px;
}

.el-input {
	width: 300px;
}

.dialog-footer button:first-child {
	margin-right: 10px;
}

.demo-date-picker {
	display: flex;
	width: 100%;
	padding: 0;
	flex-wrap: wrap;
}

.jhlb {
	display: flex;
	flex-wrap: wrap;
	justify-content: space-evenly;
	align-items: space-evenly;
}

.el-card {
	width: 1000px;
	margin-top: 20px;
	margin-bottom: 20px;
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
}</style>