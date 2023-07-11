<template>
	<el-main class="tea_view">
		<h1>教师详情页面</h1>
		<!-- <el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()"> -->
		<el-form ref="form" :model="form" :rules="rules" label-width="120px">
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="头像" prop="avatar">
					<img v-if="seen" :src="tuPianUrl + form.avatar" style="width: 178px;height: 178px;" />
					<img v-else src="/img/error.png" style="width: 178px;height: 178px;" />
				</el-form-item>
			</el-col>
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户名:" prop="username" style="margin-left: -50px;">
					<el-input v-model="form.username" disabled></el-input>
				</el-form-item>
			</el-col>
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户组：" prop="user_group" style="margin-left: -40px;">
					<el-select v-model="form.user_group" placeholder="请选择" style="width: 300px;">
						<el-option :key="1" :value="'管理员'" :label="'管理员'"></el-option>
						<el-option :key="2" :value="'学生'" :label="'学生'"></el-option>
						<el-option :key="3" :value="'教师'" :label="'教师'"></el-option>
					</el-select>
				</el-form-item>
			</el-col>
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="教师编号:" prop="teaNumber" style="margin-left: -50px;">
					<el-input v-model="form.teaNumber" placeholder="请输入教师编号"></el-input>
				</el-form-item>
			</el-col>
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="教师姓名:" prop="teaName" style="margin-left: -40px;">
					<el-input v-model="form.teaName" placeholder="请输入教师姓名"></el-input>
				</el-form-item>
			</el-col>
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="账号状态:" label-width="120px" prop="status" style="margin-left: -50px;">
					<el-select v-model="form.status" placeholder="请选择" style="width: 320px;">
						<el-option :key="1" :value="'可用'" :label="'可用'"></el-option>
						<el-option :key="2" :value="'禁用'" :label="'禁用'"></el-option>
					</el-select>
				</el-form-item>
			</el-col>
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="审核状态:" label-width="120px" prop="examineState" style="margin-left: -40px;">
					<el-select v-model="form.examineState" placeholder="请选择" style="width: 300px;">
						<el-option :key="1" :value="'通过'" :label="'通过'"></el-option>
						<el-option :key="2" :value="'未通过'" :label="'未通过'"></el-option>
					</el-select>
				</el-form-item>
			</el-col>
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="手机号码:" prop="phone" style="margin-left: -50px;">
					<el-input type="phone" v-model="form.phone" placeholder="请输入手机号码"></el-input>
				</el-form-item>
			</el-col>
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="邮箱:" prop="email" style="margin-left: -40px;">
					<el-input type="email" v-model="form.email" placeholder="请输入邮箱"></el-input>
				</el-form-item>
			</el-col>
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="性别:" prop="gender">
					<el-select v-model="form.gender" placeholder="请选择" style="width: 200px;">
						<el-option :key="1" :value="'男'" :label="'男'"></el-option>
						<el-option :key="2" :value="'女'" :label="'女'"></el-option>
					</el-select>
				</el-form-item>
			</el-col>
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="所教课程:" prop="courses" style="margin-left: -50px;">
					<el-input v-model="form.courses" placeholder="请输入所教课程"></el-input>
				</el-form-item>
			</el-col>
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="所在院系" prop="faculties" style="margin-left: -40px;">
					<el-input v-model="form.faculties" placeholder="请输入所在院系"></el-input>
				</el-form-item>
			</el-col>
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp" style="margin-left: 400px;">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>
		</el-form>
	</el-main>
</template>

<script>
import router from '../../router';
export default {
	data() {
		return {
			form: {
				username: "",
				password: "",
				avatar: "",
				phone: "",
				email: "",
				user_group: "教师",
				status: "",
				courses: '',
				examineState: '',
				faculties: '',
				gender: '',
				teaName: '',
				teaNumber: '',
			},
			rules: {
				teaName: [{ required: true, message: "请输入教师姓名", trigger: "blur" },
				],
				teaNumber: [{ required: true, message: "请输入教师编号", trigger: "blur" },
				{ pattern:  /^[0-9]+$/, message: '请输入数字', trigger: 'blur' },
				],
				phone: [{ pattern: /^1[2|3|4|5|6|7|8][0-9]\d{8}$/, message: "请输入正确的手机号", trigger: "blur" },
				],
				email: [{ pattern: /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/, message: "请输入正确的邮箱", trigger: "blur" },
				],
			},
			seen: true,
			tuPianUrl: 'http://localhost:8080'
		};
	},
	methods: {
		cancel() {
			router.push("/teacher/main");
			// window.location.reload()
		}, xianshi() {
			this.axios.post("/teacher/selectmessage", {
				username: this.$route.query.username
			}).then(res => res.data).then(res => {
				if (res.code == 200) {
					// console.log(res.data);
					this.form.username = res.data[0]["username"];
					this.form.password = res.data[0]["password"];
					this.form.avatar = res.data[0]["avatar"];
					this.form.phone = res.data[0]["phone"];
					this.form.email = res.data[0]["email"];
					this.form.user_group = res.data[0]["userGroup"];
					this.form.loginTime = res.data[0]["loginTime"];
					this.form.status = res.data[0]["status"];
					this.form.courses = res.data[0]["courses"];
					this.form.examineState = res.data[0]["examineState"];
					this.form.faculties = res.data[0]["faculties"];
					this.form.gender = res.data[0]["gender"];
					this.form.teaName = res.data[0]["teaName"];
					this.form.teaNumber = res.data[0]["teaNumber"];
					if (this.form.avatar == "") {
						this.seen = false
					}
				}
				else {
					return this.$message({
						duration: 3000,
						offset: 50,
						message: "查询数据失败",
						type: "error"
					});
				}
			});
		}, submit() {
			this.$refs.form.validate((valid) => {
				if (valid) {
					this.axios.post('/teacher/modtea', this.form)
						.then(res => res.data).then(res => {
							// console.log(this.form);
							if (res.code == 200) {
								this.$message({
									duration: 3000,
									offset: 50,
									message: '数据修改成功',
									type: 'success'
								});
							} else {
								this.$message({
									duration: 3000,
									offset: 50,
									message: '数据修改失败',
									type: 'error'
								});
							}
						}
						)
				} else {
					console.log('Error!!')
					return false;
				}
			});
		}
	},
	beforeMount() {
		this.xianshi();
	},
}
</script>

<style>
.tea_view {
	padding: 2rem 1rem;
	background-color: #eeeeee !important;
	width: 90%;
	margin: 0 auto;
}
h1{
    text-align: center;
    margin-left: -100px;
    margin-top: -20px;
    margin-bottom: 20px;
    color: #00838F !important;
    font-weight:bold;
}
.el-select svg {
	margin-left: -180px;
}

.el-select .el-input__suffix {
	width: 10px;
}

.el-form-item__label {
	color: #00838F !important;
}

.el_form_item_warp {
	/* display: inline-flex; */
	float: left;
	font-size: 14px;
	padding-left: 10px;
	padding-top: 15px;
	width: 400px;
	line-height: 40px;
	/* display: inline-block; */
	margin: 0 auto;
}

.avatar-uploader .el-upload {
	border: 1px dashed #d9d9d9;
	border-radius: 6px;
	cursor: pointer;
	position: relative;
	overflow: hidden;
	width: 180px;
	height: 182px;
}

/* 头像框鼠标放上去 */
.avatar-uploader .el-upload:hover {
	border-color: #409EFF;
}

/* 头像框内图标大小 */
.el-icon {
	font-size: 28px;
	color: #8c939d;
	width: 178px;
	height: 178px;
	line-height: 178px;
	text-align: center;
}

/* 头像框大小 */
.avatar {
	width: 178px;
	height: 178px;
	display: block;
}

.avatar-uploader {
	width: 230px;
	height: 200px;
}

.el_form_btn_warp {
	margin-left: 50px;
	color: #ffffff;
	/* display: inline-flex; */
	float: left;
	padding-top: 20px;
}
</style>