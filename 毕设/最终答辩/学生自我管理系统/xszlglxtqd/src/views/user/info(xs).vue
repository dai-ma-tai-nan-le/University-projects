<template>
    <div class="info" id="user_info">
        <!-- <h1>个人信息</h1> -->
        <div class="header1">
            <el-form ref="form" :rules="rules" :model="form1" label-width="100px" class="zj">
                <el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
                    <!-- <el-form-item label="头像"> -->
                    <el-form-item>
                        <!-- <el-upload class="avatar-uploader" accept="image/gif, image/jpeg, image/png, image/jpg"
                            action=" http://localhost:8080/upload/avatar" :show-file-list="false" :on-success="handleAvatarSuccess">
                            <img v-if="seen" :src="tuPianUrl + form1.avatar" style="width: 178px;height: 178px;" />
                            <img v-else src="/img/error.png" style="width: 178px;height: 178px;" />
                        </el-upload> -->
                        <el-upload class="avatar-uploader" accept="image/gif, image/jpeg, image/png, image/jpg"
                            action="http://localhost:8080/upload/avatar" :show-file-list="false" @click="touxiang">
                            <img v-if="seen" :src="tuPianUrl + form1.avatar" style="width: 178px;height: 178px;" />
                            <img v-else src="/img/error.png" style="width: 178px;height: 178px;" />
                        </el-upload>
                    </el-form-item>
                </el-col>
                <div style="font-size:30px;padding-top: 30px;">
                    {{ form1.username }}
                </div>
                <div style="font-size:30px;padding-top: 30px;">
                    {{ form1.user_group }}
                </div>
            </el-form>
        </div>
        <div class="jbxx">
            <h1>个人信息</h1>
        </div>
        <div class="jbgrxx">
            <!-- <div style="width: 800px;margin: 0 auto;background-color:aqua;padding-top: 20px;"> -->
            <div style="width: 800px;margin: 0 auto;padding-top: 20px;">
                <el-form ref="form" :rules="rules" :model="form" label-width="100px" class="zj">
                    <el-form-item prop="username" style="margin-left: -130px;">
                        <span class="ys" style="margin-left: -90px;">用</span>
                        <span class="ys" style="margin-left: 20px;">户</span>
                        <span class="ys" style="margin-left: 20px;">名:</span>
                        <span> {{ form.username }}</span>
                    </el-form-item>
                    <el-form-item prop="user_group" style="margin-left: -130px;">
                        <span class="ys" style="margin-left: -90px;">用</span>
                        <span class="ys" style="margin-left: 20px;">户</span>
                        <span class="ys" style="margin-left: 20px;">组:</span>
                        <span>{{ form.user_group }}</span>
                    </el-form-item>
                    <el-form-item label="账 号 状 态:" label-width="120px" prop="status" style="margin-left: -125px;">
                        <span style="margin-left:30px ;">{{ form.status }}</span>
                    </el-form-item>
                    <el-form-item prop="gender" label-width="120px" style="margin-left: -150px;">
                        <span class="ys" style="margin-left: -90px;">性</span>
                        <span class="ys" style="margin-left: 55px;">别:</span>
                        <span>
                            <el-select v-model="form.gender" placeholder="请选择" style="width: 300px;">
                                <el-option :key="1" :value="'男'" :label="'男'"></el-option>
                                <el-option :key="2" :value="'女'" :label="'女'"></el-option>
                            </el-select>
                        </span>
                    </el-form-item>
                    <el-form-item label="手 机 号 码:" label-width="120px" prop="phone" style="margin-left: -125px;">
                        <span style="margin-left:25px ;"><el-input type="phone" v-model="form.phone" placeholder="请输入手机号码"
                                style="width: 300px;height: 40px;"></el-input></span>
                    </el-form-item>
                    <el-form-item prop="email" style="margin-left: -130px;">
                        <span class="ys" style="margin-left: -90px;">邮</span>
                        <span class="ys" style="margin-left: 55px;">箱:</span>
                        <span><el-input type="email" v-model="form.email" placeholder="请输入邮箱"
                                style="width: 300px;"></el-input></span>
                    </el-form-item>
                    <el-form-item prop="stuNumber" style="margin-left: -130px;">
                        <span class="ys" style="margin-left: -90px;">学</span>
                        <span class="ys" style="margin-left: 55px;">号:</span>
                        <!-- <span><el-input v-model="form.stuNumber" placeholder="请输入学号" style="width: 300px;"></el-input></span> -->
                        <span>{{ form.stuNumber }}</span>
                    </el-form-item>
                    <el-form-item label="学 生 姓 名:" prop="stuName" label-width="120px" style="margin-left: -125px;">
                        <!-- <span style="margin-left:25px ;"><el-input v-model="form.stuName" placeholder="请输入学生姓名" style="width: 300px;"></el-input></span> -->
                        <span style="margin-left:25px ;">{{ form.stuName }}</span>
                    </el-form-item>
                    <el-form-item prop="academy" style="margin-left: -130px;">
                        <span class="ys" style="margin-left: -90px;">学</span>
                        <span class="ys" style="margin-left: 55px;">院:</span>
                        <span><el-input v-model="form.academy" placeholder="请输入学院" style="width: 300px;"></el-input></span>
                    </el-form-item>
                    <el-form-item label="教 师 编 号:" label-width="120px" prop="teaNumber" style="margin-left: -125px;">
                        <!-- <span style="margin-left:25px ;"><el-input v-model="form.teaNumber" placeholder="请输入教师编号" style="width: 300px;"></el-input></span> -->
                        <span style="margin-left:25px ;">{{ form.teaNumber }}</span>
                    </el-form-item>
                    <el-form-item prop="major" style="margin-left: -130px;">
                        <span class="ys" style="margin-left: -90px;">专</span>
                        <span class="ys" style="margin-left: 55px;">业:</span>
                        <span><el-input v-model="form.major" placeholder="请输入专业" style="width: 300px;"></el-input></span>
                    </el-form-item>
                    <el-form-item label="班 级 名 称:" label-width="120px" prop="className" style="margin-left: -125px;">
                        <span style="margin-left:25px ;"><el-input v-model="form.className" placeholder="请输入班级名称"
                                style="width: 300px;"></el-input></span>
                    </el-form-item>
                    <div style="margin-top: 20px;margin-left: 150px;">
                        <el-button type="primary" @click="submit()">提交</el-button>
                        <el-button @click="cancel()">取消</el-button>
                    </div>
                </el-form>
            </div>
        </div>
    </div>
</template>

<script>
import router from '../../router';
let username = sessionStorage.getItem("username")
export default {
    data() {
        return {
            form1: {
                username: "",
                avatar: "",
                user_group: "学生",
            },
            form: {
                username: "",
                password: "",
                avatar: "",
                phone: "",
                email: "",
                user_group: "",
                status: "",
                academy: '',
                major: '',
                className: '',
                gender: '',
                stuName: '',
                stuNumber: '',
                teaNumber: ''
            },
            rules: {
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
            router.go(-1);
        }, xianshi() {
            this.axios.post("/student/selectmessage", {
                username: username
            }).then(res => res.data).then(res => {
                if (res.code == 200) {
                    // console.log(res.data);
                    this.form.username = res.data[0]["username"];
                    this.form1.username = res.data[0]["username"];
                    this.form.password = res.data[0]["password"];
                    this.form1.avatar = res.data[0]["avatar"];
                    // this.form.avatar = res.data[0]["avatar"];
                    this.form.phone = res.data[0]["phone"];
                    this.form.email = res.data[0]["email"];
                    // this.form.user_group = res.data[0]["userGroup"];
                    this.form1.user_group = res.data[0]["userGroup"];
                    this.form.loginTime = res.data[0]["loginTime"];
                    this.form.status = res.data[0]["status"];
                    this.form.academy = res.data[0]["academy"];
                    this.form.major = res.data[0]["major"];
                    this.form.className = res.data[0]["className"];
                    this.form.gender = res.data[0]["gender"];
                    this.form.stuName = res.data[0]["stuName"];
                    this.form.stuNumber = res.data[0]["stuNumber"];
                    this.form.teaNumber = res.data[0]["teaNumber"];
                    // if (this.form.avatar == "") {
                    //     this.seen = false
                    // }
                    if (this.form1.avatar == "") {
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
            this.axios.post('/student/modstu', this.form)
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
        }, touxiang() {
            this.axios.post('/upload/avatar1', {
                username: username,
                userGroup: this.form1.user_group
            })
                .then(res => res.data).then(res => {
                    // console.log(res.code)
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

        },
    },
    beforeMount() {
        this.xianshi();
    },
}
</script>


<style>
/* 大框架 */
.info {
    padding: 2rem 1rem;
    background-color: #eeeeee !important;
    width: 90%;
    margin: 0 auto;
}

/* 个人信息字 */
#user_info h1 {
    /* text-align: center; */
    color: #00838F !important;
    font-weight: bold;
    padding-top: 8px;
    padding-left: 20px;
}

.el-button>span {
    margin: 0 auto;
}

span {
    margin-left: 40px;
}

.ys {
    color: #00838F;
    font-size: 20px;
}

.jbxx {
    width: 1200px;
    background-color: #ffffff;
    height: 50px;
    margin: 0 auto;
    margin-top: 20px;
}

.header1 {
    width: 1200px;
    background-color: #ffffff;
    height: 250px;
    margin: 0 auto;
    margin-top: -20px;
}

.jbgrxx {
    width: 1200px;
    background-color: #ffffff;
    height: 700px;
    margin: 0 auto;
    margin-top: 2px;

}

/* 头像等字的颜色 */
#user_info .el-form-item__label {
    color: #00838F !important;
    font-size: 20px;
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

.el-form-item__content {
    font-size: 16px;
}

.el-select svg {
    margin-left: -300px;
}

.el-select .el-input__suffix {
    /* margin-left: 150px; */
    width: 0px;
    height: 20px;
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

/* 按钮 */
.el_form_btn_warp {
    margin-left: 50px;
    color: #ffffff;
    display: inline-block;
    padding-top: 20px;
}
</style>
