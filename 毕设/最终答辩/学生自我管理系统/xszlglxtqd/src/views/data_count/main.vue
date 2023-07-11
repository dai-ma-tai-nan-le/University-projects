<template>
	<el-main class="stu_main">
		<h1>学生数据统计页面</h1>
		<el-card class="box-card">
			<div :model="form" style="display: flex;">
				<el-form-item label="用户名" style="width: 300px;">
					<el-input v-model.trim="form.username" placeholder="请输入你要查询的用户名" @keyup.enter.native="querystu()" />
				</el-form-item>
				<el-form-item label="学生姓名" style="width: 300px;margin-left: 20px;">
					<el-input v-model.trim="form.stu_name" placeholder="请输入你要查询的学生姓名" @keyup.enter.native="querystu()" />
				</el-form-item>
				<el-form-item>
					<el-button style="margin-left: 20px;" type="primary" @click="querystu()">查询</el-button>
					<el-button @click="shuaxin()">重置</el-button>
				</el-form-item>
			</div>

			<el-table border :data="list" style="width: 100%;" stripe @selection-change="handleSelectionChange">
				<el-table-column fixed type="selection" tooltip-effect="dark" width="55"></el-table-column>
				<el-table-column prop="username" label="用户名" sortable width="120">
				</el-table-column>
				<el-table-column prop="userGroup" label="用户组" sortable min-width="120">
				</el-table-column>
				<el-table-column prop="stuNumber" label="学号" sortable min-width="120">
				</el-table-column>
				<el-table-column prop="stuName" label="学生姓名" sortable min-width="120">
				</el-table-column>
				<el-table-column prop="academy" label="学院" sortable min-width="150">
				</el-table-column>
				<el-table-column prop="major" label="专业" sortable min-width="150">
				</el-table-column>
				<el-table-column prop="className" label="班级名称" sortable min-width="150">
				</el-table-column>
				<el-table-column prop="teaNumber" label="教师编号" sortable min-width="150">
				</el-table-column>
				<el-table-column prop="gender" label="性别" sortable min-width="120">
				</el-table-column>
				<el-table-column prop="phone" label="手机号码" sortable min-width="150">
				</el-table-column>
				<el-table-column prop="email" label="邮箱" sortable min-width="180">
				</el-table-column>
				<el-table-column prop="status" label="账号状态" sortable min-width="150">
				</el-table-column>
				<el-table-column prop="loginTime" label="上次登录时间" sortable min-width="200">
				</el-table-column>
				<el-table-column sortable prop="createTime" label="创建时间" min-width="200">
				</el-table-column>
				<el-table-column prop="updateTime" label="更新时间" sortable min-width="200">
				</el-table-column>
				<!-- 操作 -->
				<el-table-column fixed="right" label="操作" width="90" style="height: 80px;">
					<template #default="scope">
						<el-button class="el-button el-button--small is-plain el-button--primary"
							@click="xiangqing(scope.row)" size="small">详情</el-button>
					</template>
				</el-table-column>
			</el-table>
			<!-- 分页器 -->
			<div>
				<el-pagination v-model:current-page="pageNum" v-model:page-size="pageSize" :page-sizes="[5, 10, 15, 20]"
					layout="total, sizes, prev, pager, next, jumper" :total="count" @size-change="handleSizeChange"
					@current-change="handleCurrentChange" />
			</div>
			<!--对话框-->
			<el-dialog title="选项" v-model="centerDialogVisible" width="50%" center>
            <div class="jr" @click="seensjtj()">查看该学生的数据统计</div>
            <div class="jr" @click="seencj()">查看该学生解锁的成就</div>
            <div class="jr" @click="centerDialogVisible = false">取消</div>
        </el-dialog>
		</el-card>
	</el-main>
</template>

<script>
import router from '../../router';
let userGroup = sessionStorage.getItem("userGroup");
let data = JSON.parse(sessionStorage.getItem("user"));
export default {
	data() {
		return {
			form: {
				username: '',
				stu_name: ''
			},
			username:'',
			list: [],
			count: '',
			pageNum: 1,
			pageSize: 5,
			centerDialogVisible:false,
		}
	},
	methods: {
		xiangqing(row) {
			this.centerDialogVisible=true;
			this.username=row.username;
		}, handleSizeChange(val) {
			console.log(`每页 ${val} 条`);
			this.pageNum = 1;
			this.pageSize = val;
			this.querystu();
		}, handleCurrentChange(val) {
			console.log(`当前页: ${val}`);
			this.pageNum = val;
			this.querystu();
		}, querystu() {
			this.axios.post('/student/stulist', {
				pageNum: this.pageNum,
				pageSize: this.pageSize,
				param: {
					username: this.form.username,
					stu_name: this.form.stu_name,
					userGroup:userGroup,
					academy:data[0]['faculties']
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
			this.form.stu_name = ''
			this.axios.post('/student/stulist', {
				pageNum: this.pageNum,
				pageSize: this.pageSize,
				param: {
					username: this.form.username,
					stu_name: this.form.stu_name,
					userGroup:userGroup,
					academy:data[0]['faculties']
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
		},seensjtj(){
			this.centerDialogVisible = false;
			router.push({ path: "/data_count/view", query: { username: this.username } }).then(() => {
                setTimeout(router.go(0), 0);
            });
		},seencj(){
			this.centerDialogVisible = false;
			router.push({ path: "/accomplishment/cj", query: { username: this.username } }).then(() => {
                setTimeout(router.go(0), 0);
            });
		}
	},
	beforeMount() {
		this.querystu()
	}
}
</script>

<style>
.stu_main {
	padding: 2rem 1rem;
	background-color: #eeeeee !important;
	width: 90%;
	margin: 0 auto;
}
.el-form-item__label {
	color: #00838F !important;
}
h1{
    text-align: center;
    margin-left: -100px;
    margin-top: -20px;
    margin-bottom: 20px;
    color: #00838F !important;
    font-weight:bold;
}
.el_form_search_wrap .el-input {
	width: 200px;
}

.el-table .el-table-column__label {
	color: #987f59;
}

.el-pagination {
	margin-left: 230px;
	margin-top: 20px;
}

.search_btn_1 {
	display: flex;
}

.search_btn_wrap_1 {
	display: flex;
	float: left;
	margin-left: -100px;
}
.jr {
    text-align: center;
    font-size: 20px;
    font-weight: 800;
    margin-top: 10px;
    padding-top: 20px;
    width: 100%;
    height: 40px;
    cursor: pointer;
    background-color: #78dbf9;
}
</style>