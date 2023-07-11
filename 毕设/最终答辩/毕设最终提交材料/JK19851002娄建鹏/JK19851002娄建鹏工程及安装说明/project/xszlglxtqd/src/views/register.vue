<template>
  <div class="register">
    <article class="sign_in register_wrap">
      <el-scrollbar>
        <el-row>
          <el-col>
            <el-form ref="form" :model="form" :rules="rules" label-width="80px" class="form">
              <h1>注册</h1>
              <el-form-item label="账号" prop="username">
                <el-input type="text" v-model="form.username" placeholder="用户名">
                </el-input>
              </el-form-item>
              <el-form-item label="密码" prop="password">
                <el-input type="password" v-model="form.password" placeholder="6 到 16 个字符" autocomplete="off">
                </el-input>
              </el-form-item>
              <el-form-item label="确认密码" prop="confirm_password">
                <el-input type="password" v-model="form.confirm_password" placeholder="6 到 16 个字符" autocomplete="off">
                </el-input>
              </el-form-item>
              <el-form-item label="邮箱" prop="email">
                <el-input type="email" v-model="form.email" placeholder="例：test@test.com!">
                </el-input>
              </el-form-item>
              <el-form-item label="身份" prop="user_group">
                <el-select v-model="form.user_group">
                  <el-option :key="1" :value="'学生'" :label="'学生'"></el-option>
                  <el-option :key="2" :value="'教师'" :label="'教师'"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item v-show="form.user_group === '学生'" label="学号" prop="stu_number">
                <el-input type="text" v-model="form.stu_number" placeholder="请输入学号">
                </el-input>
              </el-form-item>
              <el-form-item v-show="form.user_group === '学生'" label="姓名" prop="stu_name">
                <el-input type="text" v-model="form.stu_name" placeholder="请输入姓名">
                </el-input>
              </el-form-item>
              <!-- <el-form-item v-show="form.user_group === '学生'" label="手机号" prop="phone">
              <el-input type="phone" v-model="form.phone" placeholder="例: 18955552312">
              </el-input>
            </el-form-item> -->
              <!-- <el-form-item v-show="form.user_group === '学生'" label="性别" prop="gender">
              <el-select v-model="form.gender">
                <el-option :key="1" :value="'男'" :label="'男'"></el-option>
                <el-option :key="2" :value="'女'" :label="'女'"></el-option>
              </el-select>
            </el-form-item> -->
              <el-form-item v-show="form.user_group === '学生'" label="学院" prop="academy">
                <el-input type="text" v-model="form.academy" placeholder="请输入学院">
                </el-input>
              </el-form-item>
              <!-- <el-form-item v-show="form.user_group === '学生'" label="专业" prop="major">
              <el-input type="text" v-model="form.major" placeholder="请输入专业">
              </el-input>
            </el-form-item>
            <el-form-item v-show="form.user_group === '学生'" label="班级名称" prop="class_name">
              <el-input type="text" v-model="form.class_name" placeholder="请输入班级名称">
              </el-input>
            </el-form-item> -->
              <el-form-item v-show="form.user_group === '教师'" label="教师编号" prop="tea_number">
                <el-input type="text" v-model="form.tea_number" placeholder="请输入教师编号">
                </el-input>
              </el-form-item>
              <el-form-item v-show="form.user_group === '教师'" label="姓名" prop="tea_name">
                <el-input type="text" v-model="form.tea_name" placeholder="请输入姓名">
                </el-input>
              </el-form-item>
              <!-- <el-form-item v-show="form.user_group === '教师'" label="手机号" prop="phone">
              <el-input type="phone" v-model="form.phone" placeholder="例: 18955552312">
              </el-input>
            </el-form-item> -->
              <!-- <el-form-item v-show="form.user_group === '教师'" label="性别" prop="gender">
                <el-select v-model="form.gender">
                  <el-option :key="1" :value="'男'" :label="'男'"></el-option>
                  <el-option :key="2" :value="'女'" :label="'女'"></el-option>
                </el-select>
              </el-form-item> -->
              <!-- <el-form-item v-show="form.user_group === '教师'" label="所教课程" prop="courses">
                <el-input type="text" v-model="form.grade" placeholder="请输入所教课程">
                </el-input>
              </el-form-item> -->
              <el-form-item v-show="form.user_group === '教师'" label="所在专业" prop="faculties">
                <el-input type="text" v-model="form.faculties" placeholder="请输入所在专业">
                </el-input>
              </el-form-item>
              <div class="btns">
                <el-button type="primary" @click="submit()">注册</el-button>
                <router-link class="el-button el-button--primary" to="./login">返回</router-link>
              </div>
            </el-form>
          </el-col>
        </el-row>
      </el-scrollbar>
    </article>
  </div>
</template>

<script>
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
    //检查是否重名
    let checkDuplicate = (rule, value, callback) => {
      this.axios.get('/teacher/findByUsername?username=' + this.form.username)
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
      this.axios.get('/teacher/findByteanumber?tea_number=' + this.form.tea_number)
        .then(res => {
          // console.log(res)
          if (res.data.code == 200) {
            callback();
          } else {
            callback(new Error('教师编号已存在'));
          }
        })
    };
    //检查是否重学生编号
    let checkstunumber = (rule, value, callback) => {
      this.axios.get('/student/findBystunumber?stu_number=' + this.form.stu_number)
        .then(res => {
          // console.log(res)
          if (res.data.code == 200) {
            callback();
          } else {
            callback(new Error('该学号已存在'));
          }
        })
    };
    return {
      form: {
        username: "",
        password: "",
        confirm_password: '',
        email: "",
        stu_number: "",
        user_group: "",
        stu_name: "",
        // gender: "",
        academy: "",
        // major: "",
        // class_name: "",
        tea_number: "",
        tea_name: "",
        // courses:"",
        faculties: ""
      },
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
        stu_name: [{ required: true, message: "请输入学生姓名", trigger: "blur" },
        ],
        stu_number: [{ required: true, message: "请输入学号", trigger: "blur" },
        { pattern: /^[0-9]+$/, message: '请输入数字', trigger: 'blur' },
        { validator: checkstunumber, trigger: 'blur' }
        ],
        tea_number: [{ required: true, message: "请输入教师编号", trigger: "blur" },
        { pattern: /^[0-9]+$/, message: '请输入数字', trigger: 'blur' },
        { validator: checkteanumber, trigger: 'blur' }
        ],
        tea_name: [{ required: true, message: "请输入教师姓名", trigger: "blur" },
        ],
        email: [{ required: true, message: "请输入邮箱", trigger: "blur" },
        { pattern: /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/, message: "请输入正确的邮箱", trigger: "blur" },
        ],
        faculties: [{ required: true, message: "请输入所在专业", trigger: "blur" }
        ],
        academy: [{ required: true, message: "请输入学院", trigger: "blur" }
        ],
      },
    }
  },
  methods: {
    submit() {
      this.axios.post('/user/register', this.form)
        .then(res => res.data).then(res => {
          console.log(res);
          if (res.code == 200) {
            this.$message({
              duration: 3000,
              offset: 50,
              message: '注册成功',
              type: 'success'
            });
          } else {
            this.$message({
              duration: 3000,
              offset: 50,
              message: '注册失败',
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
  color: rgb(255, 255, 255);
}

h1 {
  margin-left: 50px;
  margin-bottom: 10px;
}

/* 登录居中 */
.sign_in h1 {
  text-align: center;
}

/* 登录框的位置 */
.sign_in .btns {
  text-align: center;
  margin-left: 3rem;
}

.sign_in .btns .el-button {
  width: 40%;
}

.sign_in .el-form-item__label {
  color: #fff;
}

.sign_in .form {
  box-sizing: border-box;
  padding: 0.5rem 3rem;
  margin: auto;
  margin-top: 7rem;
  width: 100%;
  max-width: 25rem;
  box-shadow: 0 0 0 1px hsla(240, 0%, 100%, .3),
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