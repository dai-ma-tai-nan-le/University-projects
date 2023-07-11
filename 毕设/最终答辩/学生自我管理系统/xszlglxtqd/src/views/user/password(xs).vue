<template>
    <div class="password" id="user_password">
        <el-row>
            <el-col>
                <h1>修改密码</h1>
            </el-col>
            <el-col>
                <el-form ref="form" :rules="rules" :model="form" label-width="100px" class="zj">
                    <el-col :xs="24" :sm="24" :xl="8" class="el_form_item_warp">
                        <el-form-item label="原密码" prop="o_password">
                            <el-input type="password" v-model="form.o_password" :minlength="0" :maxlength="16"
                                placeholder="请输入原密码" />
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="12" :xl="8" class="el_form_item_warp">
                        <el-form-item label="新密码" prop="password">
                            <el-input type="password" v-model="form.password" :minlength="0" :maxlength="16"
                                placeholder="请输入新密码" />
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="12" :xl="8" class="el_form_item_warp">
                        <el-form-item label="请确认密码" prop="confirm_password">
                            <el-input type="password" v-model="form.confirm_password" :minlength="0" :maxlength="16"
                                placeholder="请再次输入新密码" />
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="24" :xl="24" class="el_form_btn_warp">
                        <el-col :xs="24" :sm="12" :lg="12" class="el_form_btn el_form_btn_1">
                            <el-button style="width: 50%; float: left;" type="primary" @click="submit()">提交
                            </el-button>
                        </el-col>
                        <el-col :xs="24" :sm="12" :lg="12" class="el_form_btn el_form_btn_2">
                            <el-button style="width: 50%; float: right;" @click="cancel()">取消</el-button>
                        </el-col>
                    </el-col>
                </el-form>
            </el-col>
        </el-row>
    </div>
</template>

<script>
import router from '../../router';
let username = sessionStorage.getItem("username")
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
        //检查新旧密码是否一致
        let checkDuplicate1 = (rule, value, callback) => {
            if (this.form.password !== this.form.o_password) {
                callback();
            } else {
                callback(new Error('新密码与旧密码一致，请重新输入新密码'));
            }
        };
        //检查是否是该用户的密码
        let checkDuplicate = (rule, value, callback) => {
            this.axios.get('/user/findpassword?username=' + username + '&password=' + this.form.o_password)
                .then(res => {
                    // console.log(res)
                    if (res.data.code == 200) {
                        callback();
                    } else {
                        callback(new Error('此密码不是该用户的密码'));
                    }
                })
        };
        return {
            form: {
                o_password: '',
                password: '',
                confirm_password: ''
            },
            rules: {//校验
                o_password: [{
                    required: true, message: '请输入原密码', trigger: 'blur'
                },
                { min: 6, max: 16, message: '长度在 6 到 16 个字符', trigger: 'blur' },
                { validator: checkDuplicate, trigger: 'blur' }
                ],
                password: [{ required: true, message: '请输入新密码', trigger: 'blur' },
                { min: 6, max: 16, message: '长度在 6 到 16 个字符', trigger: 'blur' },
                { validator: checkDuplicate1, trigger: 'blur' }
                ],
                confirm_password: [{ required: true, message: '请再次输入密码', trigger: 'blur' },
                { min: 6, max: 16, message: '长度在 6 到 16 个字符', trigger: 'blur' },
                { validator: checkpassword, trigger: 'blur' }
                ],
            }
        }
    },
    methods: {
        cancel() {
            router.go(-1)
        },
        submit() {
            this.axios.post('/user/modpassword', {
                username: username,
                password1:this.form.o_password,
                password: this.form.password
            })
                .then(res => res.data).then(res => {
                    // console.log(res);
                    if (res.code == 200) {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '密码修改成功',
                            type: 'success'
                        });
                        router.go(-1);
                    } else if (res.code == 405) {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '请输入密码',
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
.password {
    padding: 2rem 1rem;
    background-color: #eeeeee !important;
    width: 90%;
    margin: 0 auto;
}

#user_password h1 {
    text-align: center;
    color: #00838F;
    font-weight: bold;
    margin-left: -30px;
}

.el-form-item__label {
    color: #00838F !important;
}

#user_password .el_form_item_warp {
    display: flex;
    font-size: 14px;
    margin-bottom: 22px;
    padding-left: 20px;
    padding-top: 30px;
    padding-bottom: 20px;
    width: 330px;
    line-height: 40px;
    margin: 0 auto;
    float: left;
}

.zj {
    margin-left: 140px;
}

/* 按钮 */
.el_form_btn_warp {
    color: #ffffff;
    display: block;
    margin-left: 300px;
}</style>