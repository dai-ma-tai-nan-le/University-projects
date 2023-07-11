<template>
    <div class="plan_view">
        <el-row class="card">
            <el-col>
                <h1>增加未来目标</h1>
            </el-col>
            <el-col>
                <el-form ref="form" :rules="rules" :model="form" label-width="100px"
                    style="width: 500px; margin: auto;margin-top: 20px;">
                    <el-col class="el_form_item_warp">
                        <el-form-item label="目标名称：" prop="goalname">
                            <el-input v-model="form.goalname" :minlength="0" :maxlength="16" placeholder="如:考研" />
                        </el-form-item>
                    </el-col>
                    <el-col class="el_form_item_warp">
                        <el-form-item prop="description" label="目标描述：">
                            <el-input v-model="form.description" placeholder="如:心仪的大学" />
                        </el-form-item>
                    </el-col>
                    <el-col class="el_form_item_warp" style="margin-left: 17px;">
                        <span style="color: #00838F;font-size: 14px;">截止日期：</span>
                        <el-date-picker v-model="form.value1" type="date" placeholder="设定目标日期" :size="size"
                            style="margin-left: 13px;width: 400px;" value-format="YYYY-MM-DD" />
                    </el-col>
                    <el-form-item style="margin-top: 20px;">
                        <el-button text @click="addwlmb()"
                            style="background-color: #fff;width: 120px; margin-left: 30px;margin-top: 20px;">添加</el-button>
                        <el-button class="search_btn_del" type="danger" @click="cancel()"
                            style="width: 120px;margin-top: 20px;">取消</el-button>
                    </el-form-item>
                </el-form>
            </el-col>
        </el-row>
    </div>
</template>

<script>
import router from "../../router";
let username = sessionStorage.getItem("username")
export default {
    data() {
        //查重名
        let checkplanname = (rule, value, callback) => {
            this.axios.get('/goalPlan/findplanname?username=' +username+'&goalname=' + this.form.goalname)
				.then(res => {
					// console.log(res)
					if (res.data.code == 200) {
						callback();
					} else {
						callback(new Error('该目标名称已存在'));
					}
				})
        };
        return {
            // 表单
            form: {
                goalname: "",
                description: "",
                value1:''
            },

            // 校验规则
            rules: {
                goalname: [{ required: true, message: '昵称不能为空！', trigger: 'blur'},
                { validator: checkplanname, trigger: 'blur' }
                ]
            }
        }
    },methods:{
        cancel() {
            router.push('/goal_plan/main1')
        },addwlmb() {
            console.log(this.form.value1)
            this.axios.post('/goalPlan/addplan', {
                username: username,
                goalname: this.form.goalname,
                description: this.form.description,
                value1: this.form.value1
            })
                .then(res => res.data).then(res => {
                    // console.log(res);
                    if (res.code == 200) {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '目标添加成功',
                            type: 'success'
                        });
                        router.push('/goal_plan/main1').then(() => {
				            setTimeout(router.go(0), 0);
			            });
                    } else {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '目标添加失败',
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
.plan_view {
    padding: 2rem 1rem;
    background-color: #eeeeee !important;
    width: 70%;
    margin: 0 auto;
}

.el-form-item__label {
    color: #00838F !important;
}

/* 个人信息字 */
h1 {
    text-align: center;
    color: #00838F !important;
    font-weight: bold;
}
</style>