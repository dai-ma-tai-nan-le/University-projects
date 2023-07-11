<template>
    <div class="info" id="user_info">
        <el-row class="card">
            <el-col>
                <h1>个人信息</h1>
            </el-col>
            <el-col>
                <el-form ref="form" :rules="rules" :model="form" label-width="100px" class="zj">
                    <el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
                        <el-form-item label="头像" prop="avatar">
                            <el-upload class="avatar-uploader" drag accept="image/gif, image/jpeg, image/png, image/jpg"
                            action="http://localhost:8080/upload/avatar" :show-file-list="false" @click="touxiang">
                                <img v-if="seen" :src="tuPianUrl + form.avatar" style="width: 178px;height: 178px;margin-left: -10px;margin-top: -39px;" />
                                <img v-else src="/img/error.png" style="width: 178px;height: 178px;margin-left: -10px;margin-top: -39px;" />
                            </el-upload>
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
                        <el-form-item label="用户名:" prop="username">
                            {{ form.username }}
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
                        <el-form-item label="手机号码:" prop="phone" style="margin-left: -50px;">
                            <el-input type="phone" v-model="form.phone" placeholder="请输入手机号码"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
                        <el-form-item label="用户组:" prop="user_group">
                            {{form.user_group }}
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
                        <el-form-item label="邮箱:" prop="email" style="margin-left: -50px;">
                            <el-input type="email" v-model="form.email" placeholder="请输入邮箱"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
                        <el-form-item label="账号状态:" label-width="120px" prop="status" style="margin-left: -20px;">
                            {{ form.status }}
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp" v-if="js">
                        <el-form-item label="性别:" prop="gender" style="margin-left: -50px;">
                            <el-select v-model="form.gender" placeholder="请选择">
                                <el-option :key="1" :value="'男'" :label="'男'"></el-option>
                                <el-option :key="2" :value="'女'" :label="'女'"></el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp" v-if="js">
                        <el-form-item label="教师姓名:" prop="teaName">
                            {{form.teaName}}
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp" v-if="js" >
                        <el-form-item label="所教课程:" prop="courses" style="margin-left: -50px;">
                            <el-input v-model="form.courses" placeholder="请输入所教课程" ></el-input>
                        </el-form-item>
                    </el-col>
                    <!-- <el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp" v-if="js">
                        <el-form-item label="审核状态:" label-width="120px" prop="examineState" style="margin-left: -40px;">
                            {{ form.examineState }}
                        </el-form-item>
                    </el-col> -->
                    <el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp" v-if="js">
                        <el-form-item label="创建时间:" label-width="120px" prop="createTime">
                            {{ form.createTime }}
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp" v-else>
                        <el-form-item label="创建时间:" label-width="120px" prop="createTime" style="margin-left: -70px;">
                            {{ form.createTime }}
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp" v-if="js">
                        <el-form-item label="教师编号:" prop="teaNumber" style="width: 180px;">
                            {{form.teaNumber}}
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp" v-if="js">
                        <el-form-item label="所在院系:" prop="faculties" style="margin-left: -50px;">
                            <el-input v-model="form.faculties" placeholder="请输入所在院系"></el-input>
                        </el-form-item>
                    </el-col>
                    <div class="el_form_btn_warp" v-if="js">
                        <el-form-item>
                            <el-button type="primary" @click="submit()">提交</el-button>
                            <el-button @click="cancel()">取消</el-button>
                        </el-form-item>
                    </div>
                    <div class="el_form_btn_warp" v-else style="margin-left: -10px;">
                        <el-form-item>
                            <el-button type="primary" @click="submit()">提交</el-button>
                            <el-button @click="cancel()">取消</el-button>
                        </el-form-item>
                    </div>
                </el-form>
            </el-col>
        </el-row>
    </div>
</template>

<script>
import router from '../../router';
let userGroup = sessionStorage.getItem("userGroup")
let username = sessionStorage.getItem("username")
// console.log(userGroup)
export default {
    data() {
        return {
            form: {
                username: "",
                password: "",
                avatar: "",
                phone: "",
                email: "",
                user_group: "",
                status: "",
                courses: '',
                examineState: '',
                faculties: '',
                gender: '',
                teaName: '',
                teaNumber: '',
                createTime:''
            },
            rules: {
                phone: [{ pattern: /^1[2|3|4|5|6|7|8][0-9]\d{8}$/, message: "请输入正确的手机号", trigger: "blur" },
                ],
                email: [{ pattern: /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/, message: "请输入正确的邮箱", trigger: "blur" },
                ],
            },
            seen: true,
            tuPianUrl: 'http://localhost:8080',
            js:false
        };
    },
    methods: {
        cancel() {
            router.go(-1);
        }, xianshi() {
            if (userGroup === "教师") {
                this.axios.post("/teacher/selectmessage", {
                    username:username
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
                        this.form.createTime = res.data[0]["createTime"];
                        if (this.form.avatar == "") {
                            this.seen = false
                        }
                        this.js=true;
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
            } else {
                this.axios.post("/user/selectmessage", {
                    username:username
                }).then(res => res.data).then(res => {
                    if (res.code == 200) {
                        this.form.username = res.data[0]["username"];
                        this.form.password = res.data[0]["password"];
                        this.form.avatar = res.data[0]["avatar"];
                        this.form.phone = res.data[0]["phone"];
                        this.form.email = res.data[0]["email"];
                        this.form.user_group = res.data[0]["userGroup"];
                        this.form.loginTime = res.data[0]["loginTime"];
                        this.form.status = res.data[0]["status"];
                        this.form.createTime = res.data[0]["createTime"];
                        if (this.form.avatar == "") {
                            this.seen = false
                        }
                    }
                    else {
                        return this.$message({
                            duration: 3000,
                            offset: 100,
                            message: "查询数据失败",
                            type: "error"
                        });
                    }
                });
            }
        }, submit() {
            if (userGroup === "教师") {
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
                this.axios.post('/user/modgly', this.form)
                    .then(res => res.data).then(res => {
                        console.log(this.form);
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
            }
        }, touxiang() {
            this.axios.post('/upload/avatar1', {
                username: username,
                userGroup: userGroup
            })
                .then(res => res.data).then(res => {
                    if (res.code === 200) {
                        let time = 0;
                        const aaa = setInterval(() => {
                            // console.log("aaa")
                            time++;
                            if (time === 5) {
                                router.go(0)
                                clearInterval(aaa);
                            }
                        }, 2000);
                    }
                }
                )
        }
    },
    beforeMount() {
        this.xianshi();
    },
}
</script>


<style>
/* 大框架 */
#user_info .card {
    padding: 2rem 1rem;
    background-color: #eeeeee !important;
    width: 90%;
    margin: 0 auto;
}

.el-select svg {
    margin-left: -180px;
}

.el-select .el-input__suffix {
    width: 10px;
}

/* 个人信息字 */
#user_info h1 {
    text-align: center;
    color: #00838F !important;
    font-weight: bold;
}

/* 头像等字的颜色 */
#user_info .el-form-item__label {
    color: #00838F !important;
}

#user_info .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
    width: 180px;
    height: 182px;
}

/* 头像框鼠标放上去 */
#user_info .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
}

/* 头像框内图标大小 */
#user_info .el-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
}

/* 头像框大小 */
#user_info .avatar {
    width: 178px;
    height: 178px;
    display: block;
}

#user_info .avatar-uploader {
    width: 230px;
    height: 200px;
}

/* 并排 */
#user_info .el_form_item_warp {
    display: flex;
    font-size: 14px;
    margin-bottom: 22px;
    padding-top: 15px;
    width: 330px;
    line-height: 40px;
    /* display: inline-block; */
    margin: 0 auto;
    float: left;
}

.zj {
    padding-left: 100px;
}
.el-select svg{
    margin-left: -220px;
}
.el-select .el-input__suffix {
    /* margin-left: 150px; */
    width: 0px;
    height: 20px;
}
/* 按钮 */
.el_form_btn_warp {
    margin-left: 320px;
    color: #ffffff;
    display: inline-block;
    margin-top: 20px;
}
</style>
