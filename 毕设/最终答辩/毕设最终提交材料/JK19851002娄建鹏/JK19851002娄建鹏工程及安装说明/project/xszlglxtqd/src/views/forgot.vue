<template>
	<div class="forgot">
		<article class="sign_in forgot_wrap">
			<el-row>
				<el-col>
					<el-form :model="form" :rules="rules" ref="form" label-width="80px" class="form">
						<h1>忘记密码</h1>
						<el-form-item label="用户名" prop="username">
							<el-input v-model="form.username" placeholder="用户名"></el-input>
						</el-form-item>
						<!-- <el-form-item label="找回方式" prop="mode">
                            <el-select v-model="form.mode" style="width: 230px;">
                                <el-option :key="1" :value="'邮箱'" :label="'邮箱'"></el-option>
                            </el-select>
                        </el-form-item> -->
						<!-- <el-form-item v-show="form.mode === '邮箱'" label="邮箱" prop="email"> -->
						<el-form-item label="邮箱" prop="email">
							<el-input v-model="form.email" placeholder="邮箱">
							</el-input>
						</el-form-item>
						<el-form-item label="验证码" prop="code">
							<el-input v-model="form.code" placeholder="验证码" style="width: 99px;">
							</el-input>
							<el-button @click="send()" :disabled="!form.username || !form.email" slot="append">{{ content }}</el-button>
						</el-form-item>
						<el-form-item label="新密码" prop="password">
							<el-input v-model="form.password" placeholder="新密码" show-password>
							</el-input>
						</el-form-item>
						<el-form-item label="确认密码" prop="confirm_password">
							<el-input v-model="form.confirm_password" placeholder="确认密码" show-password>
							</el-input>
						</el-form-item>
						<div class="btns">
							<el-button type="primary" @click="submit()">提交</el-button>
							<router-link class="el-button el-button--primary" to="./login">取消</router-link>
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
		//检查两次密码是否一致
		let checkpassword = (rule, value, callback) => {
			if (this.form.password === this.form.confirm_password) {
				callback();
			} else {
				callback(new Error('两次密码不一致，请重新输入'));
			}
		};
		//检查是否有该用户名
		let checkDuplicate = (rule, value, callback) => {
			this.axios.get('/user/findUsername?username=' + this.form.username)
				.then(res => {
					// console.log(res)
					if (res.data.code == 200) {
						callback();
					} else {
						callback(new Error('没有该用户'));
					}
				})
		};
		//检查是否邮箱是否是该用户的
		let checkemail = (rule, value, callback) => {
			this.axios.get('/user/findemail?username=' + this.form.username + '&email=' + this.form.email)
				.then(res => {
					// console.log(res)
					if (res.data.code == 200) {
						callback();
					} else {
						callback(new Error('此邮箱不是该用户的邮箱'));
					}
				})
		};
		return {
			form: {
				username: "",
				email: "",
				confirm_password: '',
				password: "",
				code: ""
			},
			content: '发送验证码',  // 按钮里显示的内容
			totalTime: 30,    //记录具体倒计时时间
			canClick: true,//添加canClick
			rules: {//校验
				username: [{
					required: true, message: '请输入用户名', trigger: 'blur'
				},
				{ min: 5, max: 16, message: '长度在 5 到 16 个字符', trigger: 'blur' },
				{ validator: checkDuplicate, trigger: 'blur' }
				],
				password: [{ required: true, message: '请输入密码', trigger: 'blur' },
				{ min: 6, max: 16, message: '长度在 6 到 16 个字符', trigger: 'blur' }
				],
				confirm_password: [{ required: true, message: '请输入再次密码', trigger: 'blur' },
				{ min: 6, max: 16, message: '长度在 6 到 16 个字符', trigger: 'blur' },
				{ validator: checkpassword, trigger: 'blur' }
				],
				email: [{ required: true, message: "请输入邮箱", trigger: "blur" },
				{ pattern: /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/, message: "请输入正确的邮箱", trigger: "blur" },
				{ validator: checkemail, trigger: 'blur' }
				],
				code: [{ required: true, message: "请输入验证码", trigger: "blur" },
				],
			}
		}
	},
	methods: {
		send() {
			if (!this.canClick) return  //改动的是这两行代码
			this.canClick = false
			this.content = this.totalTime + 's后重新发送'
			let clock = window.setInterval(() => {
				this.totalTime--
				this.content = this.totalTime + 's后重新发送'
				if (this.totalTime < 0) {
					window.clearInterval(clock)
					this.content = '重新发验证码'
					this.totalTime = 30
					this.canClick = true  //这里重新开启
				}
			}, 1000);
			this.axios.post('/user/send', {
				username: this.form.username,
				email: this.form.email
			})
				.then(res => res.data).then(res => {
					// console.log(res);
					if (res.code == 200) {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '验证码发送成功',
							type: 'success'
						});
					} else {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '验证码发送失败',
							type: 'error'
						});
					}
				}
				)
		},submit(){
			this.axios.post('/user/forgot',this.form)
				.then(res => res.data).then(res => {
					// console.log(res);
					if (res.code == 200) {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '密码修改成功',
							type: 'success'
						});
					router.push("/login");
					} else if (res.code==403) {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '验证码输入错误',
							type: 'error'
						});
					}else if (res.code==404) {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '验证码已过期，请重新发送',
							type: 'error'
						});
					}
					else {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '密码修改失败',
							type: 'error'
						});
					}
				}
				)
		}

	}
}
</script>

<style>
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
	color: rgb(255, 255, 255) !important;
}
.el-form-item__label {
	color: #fff;
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

.sign_in .btns .el-button {
	width: 40%;
}

.sign_in .form {
	box-sizing: border-box;
	padding: 1rem 3rem;
	margin: auto;
	margin-top: 15rem;
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