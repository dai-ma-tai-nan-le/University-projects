<template>
	<el-main class="notice_main">
		<h1>通知信息页面</h1>
		<el-card class="box-card">
			<el-form :inline="true" :model="form" class="demo-form-inline">
				<el-form-item label="发布用户名" prop="username">
					<el-input v-model="form.username" placeholder="请输入发布人用户名进行查询" @keyup.enter.native="query()"
						style="width: 210px;" />
				</el-form-item>
				<el-form-item label="类型" prop="type">
					<!-- <el-input v-model="form.goal_name" placeholder="请输入计划名称进行查询" @keyup.enter.native="query()" /> -->
					<el-select v-model="form.type" placeholder="请选择类型" @keyup.enter.native="query()">
						<el-option :key="1" :value="'提醒'" :label="'提醒'"></el-option>
						<el-option :key="2" :value="'通知'" :label="'通知'"></el-option>
						<el-option :key="3" :value="'公告'" :label="'公告'"></el-option>
						<!-- <el-option :key="4" :value="'文件'" :label="'文件'"></el-option>
						<el-option :key="5" :value="'图片'" :label="'图片'"></el-option>
						<el-option :key="6" :value="'视频'" :label="'视频'"></el-option> -->
					</el-select>
				</el-form-item>
				<el-form-item>
					<el-button type="primary" @click="query()">查询</el-button>
					<el-button type="primary" @click="shuaxin()">重置</el-button>
				</el-form-item>
				<el-form-item style="margin-left: 50px;">
					<el-button type="primary" @click="addtz()">发布</el-button>
					<el-button type="danger" @click="deltz()">删除</el-button>
					<!-- <el-button type="primary" @click="addtz()">置顶</el-button> -->
				</el-form-item>
			</el-form>

			<el-table border :data="list" @selection-change="selectionChange" style="width: 100%;" stripe>
				<el-table-column fixed type="selection" tooltip-effect="dark" width="55"></el-table-column>
				<el-table-column prop="title" label="主题" sortable width="150">
				</el-table-column>
				<el-table-column prop="type" label="类型" sortable width="120">
				</el-table-column>
				<el-table-column prop="username" label="发布人" sortable width="150">
				</el-table-column>
				<el-table-column prop="reusername" label="接收方" sortable width="150">
				</el-table-column>
				<el-table-column prop="publishTime" label="发布时间" sortable width="180">
				</el-table-column>
				<el-table-column prop="receivedNum" label="收到人数" sortable width="120">
				</el-table-column>
				<el-table-column prop="content" label="正文" width="250">
					请点击详情查看正文内容
				</el-table-column>
				<el-table-column prop="createTime" label="创建时间" sortable min-width="200">
				</el-table-column>
				<el-table-column prop="updateTime" label="更新时间" sortable min-width="200">
				</el-table-column>
				<el-table-column fixed="right" label="操作" width="260">
					<template #default="scope">
						<el-button type="primary" @click="xiangqing(scope.row)">详情</el-button>
						<el-button type="success" @click="zhuanfa(scope.row)">转发</el-button>
						<el-button type="success" @click="zhiding(scope.row)" v-if="scope.row.level==0">置顶</el-button>
						<el-button type="success" @click="zhiding1(scope.row)" v-else>取消置顶</el-button>
					</template>
				</el-table-column>
			</el-table>
			<!-- 分页器 -->
			<div class="demo-pagination-block">
				<el-pagination v-model:current-page="pageNum" v-model:page-size="pageSize" :page-sizes="[5, 10, 15, 20]"
					:small="small" :disabled="disabled" :background="background"
					layout="total, sizes, prev, pager, next, jumper" :total="count" @size-change="handleSizeChange"
					@current-change="handleCurrentChange" />
			</div>
			<!--对话框-->
			<el-dialog title="通知详情" v-model="centerDialogVisible1" width="50%" center>
				<el-form ref="form1" :model="form1" :rules="rules" label-width="80px">
					<el-form-item label="主题" prop="title">
						<el-input v-model="form1.title" placeholder="请输入通知主题" style="width: 1000px;" />
					</el-form-item>
					<el-form-item label="接收方" prop="reusername">
						<el-input v-model="form1.reusername" placeholder="请输入通知接收方" style="width: 1000px;" />
						<!-- <el-cascader :options="options" v-model="form1.reusername" :show-all-levels="false"
							style="width: 1000px;" /> -->
					</el-form-item>
					<el-form-item label="通知类型" prop="type">
						<el-input v-model="form1.type" placeholder="请输入通知类型" style="width: 1000px;" />
						<!-- <el-select v-model="form1.type" placeholder="请选择通知类型" style="width: 1000px;">
							<el-option :key="1" :value="'提醒'" :label="'提醒'"></el-option>
							<el-option :key="2" :value="'通知'" :label="'通知'"></el-option>
							<el-option :key="3" :value="'公告'" :label="'公告'"></el-option>
						</el-select> -->
					</el-form-item>
					<el-form-item label="正文" prop="textarea">
						<el-input v-model="form1.textarea" :rows="18" type="textarea" placeholder="请输入通知内容"
							style="width: 1000px;" />
					</el-form-item>
				</el-form>
			</el-dialog>
			<el-dialog title="转发通知" v-model="centerDialogVisible2" width="50%" center>
				<el-form ref="form1" :model="form1" :rules="rules" label-width="80px">
					<el-form-item label="接收方" prop="reusername">
						<el-cascader :options="options" v-model="form1.reusername" :show-all-levels="false" placeholder="请选择接收方"
							style="width: 1000px;" />
					</el-form-item>
				</el-form>
				<span slot="footer" class="dialog-footer" style="margin-left: 285px;">
					<el-button @click="centerDialogVisible2 = false">取 消</el-button>
					<el-button type="primary" @click="submit()">确 定</el-button>
				</span>
			</el-dialog>
		</el-card>
	</el-main>
</template>

<script>
import router from '../../router';
let username = sessionStorage.getItem("username")
export default {
	data() {
		return {
			form: {
				username: '',
				type: '',
			},
			list: [],
			count: '',
			pageNum: 1,
			pageSize: 5,
			form1: {
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
			centerDialogVisible1: false,
			centerDialogVisible2: false,
		}
	},
	methods: {
		addtz() {
			router.push("/notice/view").then(() => {
				setTimeout(router.go(0), 0);
			});
		}, handleSizeChange(val) {
			console.log(`每页 ${val} 条`);
			this.pageNum = 1;
			this.pageSize = val;
			this.query();
		}, handleCurrentChange(val) {
			console.log(`当前页: ${val}`);
			this.pageNum = val;
			this.query();
		}, query() {
			this.axios.post('/notice/tzList1', {
				pageNum: this.pageNum,
				pageSize: this.pageSize,
				param: {
					username: this.form.username,
					type: this.form.type
				}
			}).then(res => res.data).then(res => {
				// console.log(res.data)
				if (res.code == 200) {
					this.list = res.data;
					this.count = res.total;
				} else {
					return this.$message({
						duration: 3000,
						offset: 50,
						message: '数据获取失败',
						type: 'error'
					});
				}
			})
		}, shuaxin() {
			this.form.username = ''
			this.form.type = ''
			this.axios.post('/notice/tzList1', {
				pageNum: this.pageNum,
				pageSize: this.pageSize,
				param: {
					username: this.form.username,
					type: this.form.type
				}
			}).then(res => res.data).then(res => {
				// console.log(res.data)
				if (res.code == 200) {
					this.list = res.data;
					this.count = res.total;
				} else {
					return this.$message({
						duration: 3000,
						offset: 50,
						message: '数据获取失败',
						type: 'error'
					});
				}
			})
		}, deltz() {
			if (this.selectedRows.length === 0) {
				this.$message({
					duration: 3000,
					offset: 50,
					message: '请选择要删除的数据',
					type: 'warning'
				});
				return;
			} else {
				//  selectedRows=JSON.parse(this.selectedRows)
				this.axios.post('/notice/deltz', {
					selectedRows: this.selectedRows
				}).then(res => res.data).then(res => {
					// console.log(this.selectedRows)
					// console.log(this.selectedRows[0].username)
					if (res.code == 200) {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '删除数据成功',
							type: 'success'
						});
						this.query();
					} else {
						return this.$message({
							duration: 3000,
							offset: 50,
							message: '删除数据失败',
							type: 'error'
						});
					}
				})
			}
		}, selectionChange(val) { //监听选中行的变化
			this.selectedRows = val;
		}, zhuanfa(row) {
			this.centerDialogVisible2 = true;
			let row1=JSON.parse(JSON.stringify(row))
			// console.log(row1);
			this.form1.title=row1.title;
			this.form1.type=row1.type;
			this.form1.textarea=row1.content;
			this.$nextTick(() => {
                this.$refs.form1.resetFields(); //刷新
            })
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
		},submit(){
			this.axios.post('/notice/addtz', {
				username: username,
				title: this.form1.title,
				reusername: this.form1.reusername[1],
				type: this.form1.type,
				textarea: this.form1.textarea
			})
				.then(res => res.data).then(res => {
					// console.log(res);
					if (res.code == 200) {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '通知转发成功',
							type: 'success'
						});
						this.query();
					} else {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '通知转发失败',
							type: 'error'
						});
					}
				}
				)
		},xiangqing(row){
			this.centerDialogVisible1 = true;
			let row1=JSON.parse(JSON.stringify(row))
			// console.log(row1);
			this.form1.title=row1.title;
			this.form1.reusername=row1.reusername;
			this.form1.type=row1.type;
			this.form1.textarea=row1.content;
		},zhiding(row){
			let row1=JSON.parse(JSON.stringify(row))
			this.axios.post('/notice/zhiding', {
				noticeId:row1.noticeId
			})
				.then(res => res.data).then(res => {
					// console.log(res);
					if (res.code == 200) {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '通知置顶成功',
							type: 'success'
						});
						this.query();
					} else {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '通知置顶失败',
							type: 'error'
						});
					}
				}
				)
		},zhiding1(row){
			let row1=JSON.parse(JSON.stringify(row))
			this.axios.post('/notice/zhiding1', {
				noticeId:row1.noticeId
			})
				.then(res => res.data).then(res => {
					// console.log(res);
					if (res.code == 200) {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '通知取消置顶成功',
							type: 'success'
						});
						this.query();
					} else {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '通知取消置顶失败',
							type: 'error'
						});
					}
				}
				)
		}
	}, beforeMount() {
		this.query();
		this.xianshi();
	}
}
</script>

<style>
.notice_main {
	padding: 2rem 1rem;
	background-color: #eeeeee !important;
	width: 90%;
	margin: 0 auto;
}
.el-dialog__title{
	color: #00838F !important;
}
h1 {
	text-align: center;
	margin-left: -100px;
	margin-top: -20px;
	margin-bottom: 20px;
	color: #00838F !important;
	font-weight: bold;
}

.el-form-item__label {
	color: #00838F !important;
}

.el_form_search_wrap .el-input {
	width: 150px;
}

.el-table .el-table-column__label {
	color: #987f59;
}

.search_btn_1 {
	display: flex;
}

.search_btn_wrap_1 {
	display: flex;
	float: left;
	margin-left: -100px;
}

.el-pagination {
	margin-left: 230px;
	margin-top: 20px;
}</style>