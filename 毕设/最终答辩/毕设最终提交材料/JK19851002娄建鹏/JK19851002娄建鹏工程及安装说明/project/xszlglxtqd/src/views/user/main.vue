<template>
    <div class="user_main">
        <h1>管理员信息页面</h1>
        <el-card class="box-card">
            <div :model="form" style="display: flex;">
                <el-form-item label="用户名" style="width: 300px;">
                    <el-input v-model.trim="form.username" placeholder="请输入你要查询的用户名" @keyup.enter.native="querygly()" />
                </el-form-item>
                <el-form-item>
                    <el-button style="margin-left: 20px;" type="primary" @click="querygly()">查询</el-button>
                    <el-button @click="shuaxin()">重置</el-button>
                </el-form-item>
                <el-form-item style="margin-left: 50px;">
                    <el-button type="primary" @click="addgly()">添加</el-button>
                    <el-button type="danger" @click="delgly()">删除</el-button>
                </el-form-item>
            </div>

            <el-table border :data="list" style="width: 100%;" stripe @selection-change="handleSelectionChange">
                <el-table-column fixed type="selection" tooltip-effect="dark" width="55"></el-table-column>
                <!-- <el-table-column prop="userId" label="ID" sortable width="80">
                </el-table-column> -->
                <!-- <el-table-column label="头像" prop="avatar" min-width="110">
                    <el-avatar :src="avater" style="width: 80px;height: 80px;">
                        <img v-if="seen" :src="tuPianUrl + avater" />
                        <img v-else src="/img/error.png" />
                    </el-avatar>
                </el-table-column> -->
                <el-table-column prop="username" label="用户名" sortable width="120">
                </el-table-column>
                <el-table-column prop="userGroup" label="用户组" sortable min-width="120">
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
                <!-- 操作 -->
                <el-table-column fixed="right" label="操作" width="90" style="height: 80px;">
                    <template #default="scope">
                        <el-button class="el-button el-button--small is-plain el-button--primary" @click="xiangqing(scope.row)"
                        size="small">详情</el-button>
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
            <el-dialog title="添加管理员" v-model="centerDialogVisible" width="30%" center>
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
                    <el-form-item prop="phone" label="手机号">
                        <el-input v-model="form1.phone" style="width: 80%"></el-input>
                    </el-form-item>
                    <el-form-item prop="email" label="邮件">
                        <el-input v-model="form1.email" style="width: 80%"></el-input>
                    </el-form-item>
                </el-form>
                <span slot="footer" class="dialog-footer" style="margin-left: 120px;">
                    <el-button @click="centerDialogVisible = false">取 消</el-button>
                    <el-button type="primary" @click="submit()">确 定</el-button>
                </span>
            </el-dialog>
        </el-card>
    </div>
</template>

<script>
import router from '../../router';
//图片网址
// const tuPianUrl = 'http://localhost:8080'
export default {
    data() {
        //检查是否重名
        let checkDuplicate = (rule, value, callback) => {
            this.axios.get('/user/findByUsername?username=' + this.form1.username)
                .then(res => {
                    // console.log(res)
                    if (res.data.code == 200) {
                        callback();
                    } else {
                        callback(new Error('名称已存在'));
                    }
                })
        };
        return {
            form: {
                username: '',
            },
            form1: {
                username: '',
                password: '',
                status:'',
                userGroup: '管理员',
                phone: '',
                email: '',
            },
            rules: {//校验
                username: [{ required: true, message: '请输入用户名', trigger: 'blur' },
                { min: 5, max: 16, message: '长度在 5 到 16 个字符', trigger: 'blur' },
                { validator: checkDuplicate, trigger: 'blur' }
                ],
                password: [{ required: true, message: '请输入密码', trigger: 'blur' },
                { min: 6, max: 16, message: '长度在 6 到 16 个字符', trigger: 'blur' }
                ],
                phone: [{ pattern: /^1[2|3|4|5|6|7|8][0-9]\d{8}$/, message: '请输入正确的手机号', trigger: 'blur' },
                ],
                email: [{ pattern: /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/, message: '请输入正确的邮箱', trigger: 'blur' },
                ],
            },
            list: [],
            count: '',
            pageNum: 1,
            pageSize: 5,
            // avater: '',
            seen: true,
            centerDialogVisible: false,
            selectedRows: [], //保存选中行的数据
        }
    },
    methods: {
        xiangqing(row) {
            // console.log(row.username)
            router.push({path:"/user/view",query:{username: row.username}}).then(() => {
                    setTimeout(router.go(0), 0);
                });
        },
        handleSizeChange(val) {
            console.log(`每页 ${val} 条`);
            this.pageNum = 1;
            this.pageSize = val;
            this.querygly();
        },
        handleCurrentChange(val) {
            console.log(`当前页: ${val}`);
            this.pageNum = val;
            this.querygly();
        }, querygly() {
            this.axios.post('/user/glylist', {
                pageNum: this.pageNum,
                pageSize: this.pageSize,
                param: {
                    username: this.form.username
                }
            }).then(res => res.data).then(res => {
                // console.log(res.data)
                if (res.code == 200) {
                    this.list = res.data;
                    this.count = res.total;
                    // router.go()
                    // this.avater = res.data[0]['avatar'];
                    // for (let i = 0; i < res.total; i++) {
                    //     this.avater = res.data[0]['avatar'];
                    //     console.log(res.data[i]['avatar'])
                    //     if (this.avater == null) {
                    //         // alert(1)
                    //         this.seen = false
                    //     }
                    // }
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
            this.axios.post('/user/glylist', {
                pageNum: this.pageNum,
                pageSize: this.pageSize,
                param: {
                    username: this.form.username
                }
            }).then(res => res.data).then(res => {
                // console.log(res)
                if (res.code == 200) {
                    this.list = res.data;
                    this.count = res.total;
                    this.avater = res.data[0]['avatar'];
                    console.log(this.avater)
                    if (this.avater.length == 0) {
                        // alert(1)
                        this.seen = false
                    }
                } else {
                    return this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '数据获取失败',
                            type: 'error'
                        });
                }
            })
        }, addgly() {
            this.centerDialogVisible = true;
            this.$nextTick(() => {
                this.$refs.form1.resetFields();
            })
        }, submit() {
            this.$refs.form1.validate((valid) => {
                if (valid) {
                    this.axios.post('/user/addgly', this.form1)
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
                                this.querygly();
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
        }, delgly() {
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
                this.axios.post('/user/delgly', {
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
                        this.querygly();
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
        this.querygly()
    }
}
</script>

<style>
.user_main {
    padding: 2rem 1rem;
    background-color: #eeeeee !important;
    width: 95%;
    margin: 0 auto;
}
.el-pagination {
    margin-left: 250px;
    margin-top: 20px;
}
.el-dialog__title{
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
.el-form-item__label {
    color: #00838F !important;
}

.el-table .el-table-column__label {
    color: #987f59;
}

.search_btn_1 {
    display: flex;
}

.search_btn_wrap {
    display: flex;
    float: left;
}
</style>