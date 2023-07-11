<template>
    <div class="xd">
        <h1>学生心得交流页面</h1>
        <el-card class="box-card">
            <el-form :inline="true" :model="form" class="demo-form-inline">
                <el-form-item label="分享人">
                    <el-input v-model="form.username" placeholder="请输入分享人进行查询" @keyup.enter.native="query()" />
                </el-form-item>
                <el-form-item label="被分享人">
                    <el-cascader :options="options" v-model="form.reusername" :show-all-levels="false" placeholder="请选择被分享人" v-if="userGroup==='管理员'"/>
                    <el-select v-model="form.reusername" filterable placeholder="请选择或输入你想给谁分享的用户名" allow-create v-else>
						<el-option v-for="item in options1" :key="item.value" :label="item.label" :value="item.value">
						</el-option>
					</el-select>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="query()">查询</el-button>
                    <el-button type="primary" @click="shuaxin()">重置</el-button>
                </el-form-item>
            </el-form>

            <el-table border :data="list" style="width: 100%" stripe>
                <!-- <el-table-column fixed type="selection" tooltip-effect="dark" width="55"></el-table-column> -->
                <el-table-column prop="planName" label="计划名称" sortable width="200">
                </el-table-column>
                <el-table-column prop="username" label="分享人" sortable min-width="200">
                </el-table-column>
                <el-table-column prop="reusername" label="被分享的人" sortable min-width="200">
                </el-table-column>
                <el-table-column prop="content" label="心得内容" sortable width="250">
                    请点击详情查看心得内容
                </el-table-column>
                <el-table-column sortable prop="createTime" label="创建时间" min-width="200">
                </el-table-column>
                <el-table-column sortable prop="updateTime" label="更新时间" min-width="200">
                </el-table-column>
                <!-- 操作 -->
                <!-- <el-table-column fixed="right" label="操作" width="156"> -->
                <el-table-column fixed="right" label="操作" width="86">
                    <template #default="scope">
                        <el-button type="primary" @click="xiangqing(scope.row)">详情</el-button>
                        <!-- <el-button type="danger" @click="delxd(scope.row)">删除</el-button> -->
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
            <!-- 对话框 -->
            <!-- <el-dialog title="心得详情" v-model="centerDialogVisible" width="50%" center style="height: 650px;">
                <el-form ref="form1" :model="form1" label-width="80px">
                    <el-form-item label="计划名称" prop="planName">
                        <el-input v-model="form1.planName" placeholder="请输入学习计划名称" />
                    </el-form-item>
                    <el-form-item label="分享人" prop="username">
                        <el-input v-model="form1.username" placeholder="请输入用户名" />
                    </el-form-item>
                    <el-form-item label="被分享人" prop="username">
                        <el-input v-model="form1.reusername" placeholder="请输入用户名" />
                    </el-form-item>
                    <el-form-item label="心得内容" prop="textarea">
                        <el-input v-model="form1.textarea" :rows="15" type="textarea" placeholder="请输入心得内容" />
                    </el-form-item>
                </el-form>
            </el-dialog> -->
        </el-card>
    </div>
</template>

<script>
// let username = sessionStorage.getItem("username");
let userGroup = sessionStorage.getItem("userGroup");
let data = JSON.parse(sessionStorage.getItem("user"));
import router from '../../router';
// import { ElMessage, ElMessageBox } from 'element-plus'
export default {
    data() {
        return {
            form: {
                username: '',
                reusername: '',
            },
            list: [],
            count: '',
            pageNum: 1,
            pageSize: 5,
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
            form1: {
                planName: '',
                reusername: '',
                username: '',
                textarea: '',
            },
            options1:[],
            userGroup:userGroup,
        }
    },
    methods: {
        handleSizeChange(val) {
            console.log(`每页 ${val} 条`);
            this.pageNum = 1;
            this.pageSize = val;
            this.query();
        }, handleCurrentChange(val) {
            console.log(`当前页: ${val}`);
            this.pageNum = val;
            this.query();
        }, query() {
            if (userGroup==="管理员") {
                this.axios.post('/communication/xdjlList1', {
                    pageNum: this.pageNum,
                    pageSize: this.pageSize,
                    param: {
                        username: this.form.username,
                        reusername: this.form.reusername[1],
                        userGroup:userGroup,
					    academy:data[0]['faculties']
                    }
                }).then(res => res.data).then(res => {
                    console.log(res.data)   
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
            }else{
                this.options1 = [
				    {
					    value: data[0]['faculties'], label: data[0]['faculties']
				    }, {
					    value: '学校', label: '学校'
				    }
			    ]
                this.axios.post('/communication/xdjlList1', {
                    pageNum: this.pageNum,
                    pageSize: this.pageSize,
                    param: {
                        username: this.form.username,
                        reusername: this.form.reusername,
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
            }
        }, shuaxin() {
            this.form.username = ''
            this.form.reusername = ''
            this.axios.post('/communication/xdjlList1', {
                pageNum: this.pageNum,
                pageSize: this.pageSize,
                param: {
                    username: this.form.username,
                    reusername: this.form.reusername,
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
        }, xiangqing(row) {
            let row1 = JSON.parse(JSON.stringify(row));
            router.push( {path: "/experience/views", query:{communicationId:row1.communicationId} }).then(() => {
				setTimeout(router.go(0), 0);
			});
        }, 
        // delxd(row) {
        //     let row1 = JSON.parse(JSON.stringify(row));
        //     ElMessageBox.confirm(
        //     '是否确认删除该心得交流',
        //     '注意',
        //     {
        //         confirmButtonText: '确定',
        //         cancelButtonText: '取消',
        //         type: 'warning',
        //     }
        // )
        //     .then(() => {
        //     this.axios.post('/experience/jsdelxd', {
        //         experienceId: row1.experienceId,
        //         username:username,
        //         reusername:row1.username,
        //         createTime:row1.createTime,
        //         planName:row1.planName
        //     })
        //         .then(res => res.data).then(res => {
        //             // console.log(res);
        //             if (res.code == 200) {
        //                 this.$message({
        //                     duration: 3000,
        //                     offset: 50,
        //                     message: '删除成功',
        //                     type: 'success'
        //                 });
        //                 this.xianshi();
        //             } else {
        //                 this.$message({
        //                     duration: 3000,
        //                     offset: 50,
        //                     message: '删除失败',
        //                     type: 'error'
        //                 });
        //             }
        //         }
        //         )
        //     })
        //     .catch(() => {
        //         ElMessage({
        //             type: 'info',
        //             message: '已取消删除',
        //         })
        //     })
        // }, 
        xianshi() {
			this.axios.get("/notice/username")
				.then(res => res.data).then(res => {
					if (res.code == 200) {
						this.options[0].children = res.data;
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
							this.options[1].children = res.data;
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
							this.options[2].children = res.data;
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
							this.options[3].children = res.data;
						} else {
							this.$message({
								duration: 3000,
								offset: 50,
								message: '数据查询失败',
								type: 'error'
							});
						}
					})
		}
    }, beforeMount() {
        this.query();
        this.xianshi();
    }
}
</script>

<style>
.xd {
    padding: 2rem 1rem;
    background-color: #eeeeee !important;
    width: 90%;
    margin: 0 auto;
}

.el-dialog__title {
    color: #00838F !important;
}

.el-pagination {
    margin-left: 230px;
    margin-top: 20px;
}

.el-form-item__label {
    color: #00838F !important;
}

.el_form_item_warp {
    float: left;
    width: 354px;
}

h1 {
    text-align: center;
    margin-left: -100px;
    margin-top: -20px;
    margin-bottom: 20px;
    color: #00838F !important;
    font-weight: bold;
}
</style>