<template>
	<el-main class="notice_view">
		<!-- <el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()"> -->
		<el-form ref="form" :model="form" :rules="rules" label-width="120px">
			<el-form-item label="主题" prop="title">
				<el-input v-model="form.title" placeholder="请输入通知主题" style="width: 1000px;" />
			</el-form-item>
			<el-form-item label="接收方" prop="reusername">
				<!-- <el-input v-model="form.username" placeholder="请输入用户名进行查询" @keyup.enter.native="query()" /> -->
				<el-cascader :options="options" v-model="form.reusername" :show-all-levels="false" placeholder="请选择接收方" style="width: 1000px;" />
			</el-form-item>
			<el-form-item label="通知类型" prop="type">
				<!-- <el-input v-model="form.goal_name" placeholder="请输入计划名称进行查询" @keyup.enter.native="query()" /> -->
				<el-select v-model="form.type" placeholder="请选择通知类型" style="width: 1000px;">
					<el-option :key="1" :value="'提醒'" :label="'提醒'"></el-option>
					<el-option :key="2" :value="'通知'" :label="'通知'"></el-option>
					<el-option :key="3" :value="'公告'" :label="'公告'"></el-option>
					<!-- <el-option :key="4" :value="'文件'" :label="'文件'"></el-option>
					<el-option :key="5" :value="'图片'" :label="'图片'"></el-option>
					<el-option :key="6" :value="'视频'" :label="'视频'"></el-option> -->
				</el-select>
			</el-form-item>
			<!-- <el-form-item>
				<el-upload v-model:file-list="fileList" class="upload-demo" :auto-upload="false"
					action="https://run.mocky.io/v3/9d059bf9-4660-45f2-925d-ce80ad6c4d15" multiple :limit="3"
					:on-exceed="handleExceed" :before-remove="beforeRemove">
					<el-button type="primary">点击可以上传文章，视频，图片，文件</el-button>
				</el-upload>
			</el-form-item> -->
			<el-form-item label="正文" prop="textarea">
				<el-input v-model="form.textarea" :rows="18" type="textarea" placeholder="请输入通知内容" style="width: 1000px;" />
			</el-form-item>
			<el-form-item style="margin-left: 400px;">
				<el-button type="primary" @click="submit()">发布</el-button>
				<el-button @click="cancel()">取消</el-button>
			</el-form-item>
		</el-form>
	</el-main>
</template>

<script>
import router from '../../router';
let username = sessionStorage.getItem("username")
import { ElMessageBox } from 'element-plus'
export default {
	data() {
		return {
			form: {
				title: '',
				reusername: '',
				type: '',
				textarea: ''
			},
			//级联选择器
			options: [
				{
					value: '个人',
					label: '个人',
					children: []
				},
				{
					value: '班级',
					label: '班级',
					children: []
				},
				{
					value: '专业',
					label: '专业',
					children: []
				}, {
					value: '学院',
					label: '学院',
					children: []
				}, {
					value: '学校',
					label: '学校',
					children: [{
						value: '学校',
						label: '学校',
					}]
				}
			],
			// 校验规则
			rules: {
				title: [{ required: true, message: '主题不能为空！', trigger: 'blur' }
				],
				reusername: [{ required: true, message: '接收方不能为空！', trigger: 'blur' }
				],
				type: [{ required: true, message: '类型不能为空！', trigger: 'blur' }
				],
				textarea: [{ required: true, message: '正文不能为空！', trigger: 'blur' }
				]
			}
		}
	}, methods: {
		cancel() {
			router.push("/notice/main").then(() => {
				setTimeout(router.go(0), 0);
			});
		}, handleExceed() {
			this.$message({
				message: '你只能上传三个文件/视频/图片/文章',
				type: 'warning',
				offset: 50
			});
		}, beforeRemove() {
			return ElMessageBox.confirm(
				`是否取消上传该文件/视频/图片/文章`
			).then(
				() => true,
				() => false
			)
		}, xianshi() {
			this.axios.get("/notice/username")
				.then(res => res.data).then(res => {
					if (res.code == 200) {
						// console.log(res.data)
						this.options[0].children = res.data;
						// console.log(this.options[0].children)
					} else {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '数据查询失败',
							type: 'error'
						});
					}
				}),
				this.axios.get("/notice/class1")
					.then(res => res.data).then(res => {
						if (res.code == 200) {
							// console.log(res.data)
							this.options[1].children = res.data;
							// console.log(this.options[1].children)
						} else {
							this.$message({
								duration: 3000,
								offset: 50,
								message: '数据查询失败',
								type: 'error'
							});
						}
					}),
				this.axios.get("/notice/major")
					.then(res => res.data).then(res => {
						if (res.code == 200) {
							// console.log(res.data)
							this.options[2].children = res.data;
							// console.log(this.options[2].children)
						} else {
							this.$message({
								duration: 3000,
								offset: 50,
								message: '数据查询失败',
								type: 'error'
							});
						}
					}),
				this.axios.get("/notice/academy")
					.then(res => res.data).then(res => {
						if (res.code == 200) {
							// console.log(res.data)
							this.options[3].children = res.data;
							// console.log(this.options[3].children)
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
			this.axios.post('/notice/addtz', {
				username: username,
				title: this.form.title,
				reusername: this.form.reusername[1],
				type: this.form.type,
				textarea: this.form.textarea
			})
				.then(res => res.data).then(res => {
					// console.log(res);
					if (res.code == 200) {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '通知发送成功',
							type: 'success'
						});
						router.push("/notice/main").then(() => {
							setTimeout(router.go(0), 0);
						});
					} else {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '通知发送失败',
							type: 'error'
						});
					}
				}
				)
		},
	}, beforeMount() {
		this.xianshi();
	}
}
</script>

<style>
.notice_view {
	padding: 2rem 1rem;
	background-color: #eeeeee !important;
	width: 90%;
	margin: 0 auto;
}

.ElMessage {
	margin-top: 50px;
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

.el-upload-list__item-name {
	height: 10px;
}

.el_form_btn_warp {
	margin-left: 50px;
	color: #ffffff;
	/* display: inline-flex; */
	float: left;
	padding-top: 20px;
}
</style>