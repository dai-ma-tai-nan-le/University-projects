<template>
	<div class="login">
		<article class="sign_in">
			<el-row>
				<el-col>
					<el-form :model="form" :rules="rules" ref="form" label-width="60px" class="form">
						<h1>学生自律管理系统</h1>
						<el-form-item label="账号" prop="account">
							<el-input type="text" v-model="form.account" placeholder="用户名">
							</el-input>
						</el-form-item>
						<el-form-item label="密码" prop="password" @keyup.enter.native="sign_in()">
							<el-input type="password" v-model="form.password" placeholder="6 到 16 个字符" autocomplete="off">
							</el-input>
						</el-form-item>
						<div class="btns">
							<el-button type="primary" @click="sign_in()">登录</el-button>
							<el-button class="el-button el-button--primary" @click="register()">注册</el-button>
						</div>
						<div class="btns1">
							<router-link to="./forgot">
								<p>忘记密码?</p>
							</router-link>
						</div>
					</el-form>
				</el-col>
			</el-row>
		</article>
	</div>
</template>

<script>
import router from '../router';
export default {
	data() {
		return {
			form: {
				account: "",
				password: ""
			},
			rules: {//校验
				account: [{
					required: true, message: '请输入账号', trigger: 'blur'
				},
				{ min: 5, max: 16, message: '长度在 5 到 16 个字符', trigger: 'blur' }
				],
				password: [{ required: true, message: '请输入密码', trigger: 'blur' },
				{ min: 6, max: 16, message: '长度在 6 到 16 个字符', trigger: 'blur' }
				]
			},
		}
	},
	methods: {
		register() {
			this.$router.push('/register');
		},
		sign_in() {
			var f = this.form;
			var form = {
				password: f.password
			};
			var account = f.account + '';
			// // 账号类型判断
			// if (account.indexOf('@') !== -1) {
			// 	form.username = account;
			// } else if (/1[0-9]{10}/.test(account)) {
			// 	form.username = account;
			// } else {
			// 	form.username = account;
			// }
			//判断账号和密码是否符合
			if (!this.form.account && !this.form.password) {
				return this.$message.warning("请输入正确账号和密码")
			} else if (!this.form.account) {
				return this.$message.warning("请输入正确账号")
			} else if (!this.form.password) {
				return this.$message.warning("请输入正确密码")
			}
			form.username = account;
			// var _this = this;
			// // form = JSON.stringify(form);
			// console.log(form);

			//提交表单数据
			this.$refs.form.validate((valid) => {
				if (valid) {
					// 查询用户
					this.axios.post('/user/login', this.form).then(res => res.data).then(res => {
						// res.data.code===200  res.result && res.result.obj
						console.log(res)
						if (res.code === 200) {
							//存储token信息
							sessionStorage.setItem("token", res.token);
							sessionStorage.setItem("username", res.data[0]["username"]);
							sessionStorage.setItem("userGroup", res.data[0]["userGroup"]);
							sessionStorage.setItem("user", JSON.stringify(res.data));
							if (res.data[0]["userGroup"] === "管理员" || res.data[0]["userGroup"] === "教师") {
								router.push("/study_plan/main").then(() => {
									setTimeout(router.go(0), 0);
								});
							} else {
								router.push("/study_plan/main1").then(() => {
									setTimeout(router.go(0), 0);
								});
							}
						} else if (res.code === 401) {
							return this.$message.warning("用户名错误/没有该用户")
						} else if (res.code === 402) {
							return this.$message.warning("密码错误")
						} else if (res.code === 408) {
							return this.$message({
								duration: 3000,
								message: '该账号已被禁用，请找你的老师或管理员解禁',
								type: 'warning'
							});
						} else if (res.code === 409) {
							return this.$message.warning("该账号还没有通过管理员的审核")
						}
					});
				} else {
					return this.$message.warning("登录失败");
				}
			});
		}
	},
}
</script>

<style>
/* 大的背景样式 */
.sign_in {
	box-sizing: border-box;
	height: 100vh;
	padding: .5rem;
	width: 100%;
	background: url(../../public/img/bz.jpg) no-repeat;
	background-size: 100% 100%;
	color: #fff;
}

.el-form-item__error {
	color: rgb(255, 255, 255);
}

/* 登录居中 */
.sign_in h1 {
	text-align: center;
	margin-bottom: 10px;
	margin-left: 50px;
}

/* 登录框的位置 */
.sign_in .btns {
	text-align: center;
	margin-left: 3rem;
}

/* 忘记密码的位置 */
.sign_in .btns1 {
	text-align: center;
	width: 80px;
	margin-left: 8.5rem;
	margin-top: .5rem;
}

/* 忘记密码的颜色 */
.sign_in .btns1 p {
	color: #fff;
}

/* 登录框的大小 */
.sign_in .btns .el-button {
	width: 40%;
}

/* 账号密码的颜色 */
.el-form-item__label {
	color: #fff !important;
}

/* 小框的大小样式 */
.sign_in .form {
	box-sizing: border-box;
	padding: 1rem 3rem;
	margin: auto;
	margin-top: 17rem;
	width: 100%;
	max-width: 25rem;
	box-shadow: 0 0 0 1px hsla(240, 0%, 100%, .3) inset,
		0 .5em 1em rgba(50, 50, 50, 0.6);
	text-shadow: 0 1px 1px hsla(240, 0%, 100%, .5);
	overflow: hidden;
	/* background-color: rgba(255, 255, 255, .5); */
	border-radius: 0.5rem;
}

.sign_in .form:after {
	content: '';
	position: absolute;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	background-color: rgba(255, 255, 255, 0.8);
	z-index: -1;

	background-image: url(../../public/img/bz.jpg);
	background-position: center top;
	background-size: cover;
	background-attachment: fixed;
	-webkit-filter: blur(20px);
	-moz-filter: blur(20px);
	-ms-filter: blur(20px);
	-o-filter: blur(20px);
	filter: blur(20px);
}
</style>
