<template>
	<el-main class="tea_main">
        <h1>教师信息页面</h1>
		<el-card class="box-card">
			<div :model="form" style="display: flex;">
				<el-form-item label="用户名" style="width: 300px;">
					<el-input v-model.trim="form.username" placeholder="请输入你要查询的用户名" @keyup.enter.native="querytea()" />
				</el-form-item>
				<el-form-item label="教师姓名" style="width: 300px;margin-left: 20px;">
					<el-input v-model.trim="form.tea_name" placeholder="请输入你要查询的教师姓名" @keyup.enter.native="querytea()" />
				</el-form-item>
				<el-form-item>
					<el-button style="margin-left: 20px;" type="primary" @click="querytea()">查询</el-button>
					<el-button @click="shuaxin()">重置</el-button>
				</el-form-item>
				<el-form-item style="margin-left: 50px;">
					<el-button type="primary" @click="addtea()">添加</el-button>
					<el-button type="danger" @click="deltea()">删除</el-button>
				</el-form-item>
			</div>

			<el-table border :data="list" style="width: 100%;" stripe @selection-change="handleSelectionChange">
				<el-table-column fixed type="selection" tooltip-effect="dark" width="55"></el-table-column>
				<el-table-column prop="username" label="用户名" sortable width="120">
				</el-table-column>
				<el-table-column prop="userGroup" label="用户组" sortable min-width="120">
				</el-table-column>
                <el-table-column prop="teaNumber" label="教师编号" sortable min-width="120">
				</el-table-column>
                <el-table-column prop="teaName" label="教师姓名" sortable min-width="120">
				</el-table-column>
                <el-table-column prop="examineState" label="审核状态" sortable min-width="150">
				</el-table-column>
                <el-table-column prop="courses" label="所教课程" sortable min-width="150">
				</el-table-column>
                <el-table-column prop="faculties" label="所在院系" sortable min-width="150">
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
            <el-dialog title="添加教师" v-model="centerDialogVisible" width="30%" center>
                <el-form ref="form1" :model="form1" :rules="rules" label-width="80px">
                    <el-form-item prop="username" label="用户名">
                        <el-input v-model="form1.username" style="width: 80%"></el-input>
                    </el-form-item>
                    <el-form-item prop="password" label="密码">
                        <el-input v-model="form1.password" style="width: 80%"></el-input>
                    </el-form-item>
                    <el-form-item prop="userGroup" label="用户组">
                        <el-input v-model="form1.userGroup" disabled style="width: 80%"></el-input>
                    </el-form-item>
                    <el-form-item prop="gender" label="性别">
                        <el-select v-model="form1.gender" placeholder="请选择" style="width: 80%;">
                            <el-option :key="1" :value="'男'" :label="'男'"></el-option>
                            <el-option :key="2" :value="'女'" :label="'女'"></el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item prop="tea_number" label="教师编号">
                        <el-input v-model="form1.tea_number" placeholder="请输入数字" style="width: 80%"></el-input>
                    </el-form-item>
                    <el-form-item prop="tea_name" label="教师姓名">
                        <el-input v-model="form1.tea_name" style="width: 80%"></el-input>
                    </el-form-item>
                    <el-form-item prop="courses" label="所教课程">
                        <el-input v-model="form1.courses" style="width: 80%"></el-input>
                    </el-form-item>
                    <el-form-item prop="faculties" label="所在院系">
                        <el-input v-model="form1.faculties" style="width: 80%"></el-input>
                    </el-form-item>
                </el-form>
                <span slot="footer" class="dialog-footer" style="margin-left: 120px;">
                    <el-button @click="centerDialogVisible = false">取 消</el-button>
                    <el-button type="primary" @click="submit()">确 定</el-button>
                </span>
            </el-dialog>
		</el-card>
	</el-main>
</template>

<script>
import router from '../../router';
export default {
	data() {
		//检查是否重名
		let checkDuplicate = (rule, value, callback) => {
			this.axios.get('/teacher/findByUsername?username=' + this.form1.username)
				.then(res => {
					// console.log(res)
					if (res.data.code == 200) {
						callback();
					} else {
						callback(new Error('名称已存在'));
					}
				})
		};
        //检查是否重教师编号
		let checkteanumber = (rule, value, callback) => {
			this.axios.get('/teacher/findByteanumber?tea_number=' + this.form1.tea_number)
				.then(res => {
					// console.log(res)
					if (res.data.code == 200) {
						callback();
					} else {
						callback(new Error('教师编号已存在'));
					}
				})
		};
		return {
			form: {
				username: '',
                tea_name:''
			},
			form1: {
				username: '',
				password: '',
				status: '',
				userGroup: '教师',
                gender:'',
				tea_name: '',
				tea_number: '',
                courses:'',
                faculties:'',
			},
			rules: {//校验
				username: [{ required: true, message: '请输入用户名', trigger: 'blur' },
				{ min: 5, max: 16, message: '长度在 5 到 16 个字符', trigger: 'blur' },
				{ validator: checkDuplicate, trigger: 'blur' }
				],
				password: [{ required: true, message: '请输入密码', trigger: 'blur' },
				{ min: 6, max: 16, message: '长度在 6 到 16 个字符', trigger: 'blur' }
				],
                tea_name: [{ required: true, message: '请输入教师姓名', trigger: 'blur' },
				],
                tea_number: [{ required: true, message: '请输入教师编号', trigger: 'blur' },
                { pattern:  /^[0-9]+$/, message: '请输入数字', trigger: 'blur' },
                { validator: checkteanumber, trigger: 'blur' }
				],
                gender: [{ required: true, message: '请输入性别---男/女', trigger: 'blur' }
				],
			},
			list: [],
			count: '',
			pageNum: 1,
			pageSize: 5,
			seen: true,
			centerDialogVisible: false,
			selectedRows: [], //保存选中行的数据
		}
	},
	methods: {
		xiangqing(row) {
            // console.log(row.username)
            router.push({path:"/teacher/view",query:{username: row.username}}).then(() => {
                    setTimeout(router.go(0), 0);
                });
        },handleSizeChange(val) {
            console.log(`每页 ${val} 条`);
            this.pageNum = 1;
            this.pageSize = val;
            this.querytea();
        },handleCurrentChange(val) {
            console.log(`当前页: ${val}`);
            this.pageNum = val;
            this.querytea();
        }, querytea() {
            this.axios.post('/teacher/tealist', {
                pageNum: this.pageNum,
                pageSize: this.pageSize,
                param: {
                    username: this.form.username,
                    tea_name:this.form.tea_name
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
            this.form.tea_name=''
            this.axios.post('/teacher/tealist', {
                pageNum: this.pageNum,
                pageSize: this.pageSize,
                param: {
                    username: this.form.username,
                    tea_name:this.form.tea_name
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
        }, addtea() {
            this.centerDialogVisible = true;
            this.$nextTick(() => {
                this.$refs.form1.resetFields();
            })
        }, submit() {
            this.$refs.form1.validate((valid) => {
                if (valid) {
                    this.axios.post('/teacher/addtea', this.form1)
                        .then(res => res.data).then(res => {
                            // console.log(res);
                            if (res.code == 200) {
                                this.$message({
                                    duration: 3000,
                                    offset: 50,
                                    message: '数据添加成功',
                                    type: 'success'
                                });
                                this.centerDialogVisible = false;
                                this.querytea();
                            } else {
                                this.$message({
                                    duration: 3000,
                                    offset: 50,
                                    message: '数据添加失败',
                                    type: 'error'
                                });
                                this.centerDialogVisible = false;
                            }
                        }
                        )
                } else {
                    console.log('Error!!')
                    return false;
                }
            });
        }, handleSelectionChange(val) { //监听选中行的变化
            this.selectedRows = val;
        }, deltea() {
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
                this.axios.post('/teacher/deltea', {
                    selectedRows: this.selectedRows
                }).then(res => res.data).then(res => {
                    console.log(this.selectedRows)
                    // console.log(this.selectedRows[0].username)
                    if (res.code == 200) {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '删除数据成功',
                            type: 'success'
                        });
                        this.querytea();
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
        },
    },
    beforeMount() {
        this.querytea()
    }
}
</script>

<style>
.tea_main {
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
.el-pagination {
	margin-left: 230px;
	margin-top: 20px;
}

.el-form-item__label {
	color: #00838F !important;
}

.el_form_search_wrap .el-input {
	width: 200px;
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
}</style>