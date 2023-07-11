<template>
    <div class="plan_view">
        <el-row class="card">
            <el-col>
                <h1>添加学习计划</h1>
            </el-col>
            <el-col>
                <el-form ref="form" :rules="rules" :model="form" label-width="100px"
                    style="width: 500px; margin: auto;margin-top: 20px;">

                    <el-form-item label="计划名称" prop="planName">
                        <el-input v-model="form.planName" placeholder="如:英语;健身" />
                    </el-form-item>
                    <el-form-item label="类型" prop="timeTrend">
                        <el-select v-model="form.timeTrend" style="width: 400px;">
                            <el-option v-for="o in list_type" :key="o" :label="o" :value="o">
                            </el-option>
                        </el-select>
                    </el-form-item>

                    <el-form-item label="计时时长" prop="planTime">
                        <el-input v-model="form.planTime" placeholder="时长在 1 到 180 分钟" />
                    </el-form-item>
                    <el-col class="search_btn_wrap">
                        <el-form-item>
                            <el-button text @click="addxxjh()"
                                style="background-color: #fff;width: 120px; margin-left: 30px;margin-top: 20px;">添加</el-button>
                            <el-button class="search_btn_del" type="danger" @click="cancel()"
                                style="width: 120px;margin-top: 20px;">取消</el-button>
                        </el-form-item>
                    </el-col>
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
        //检查计划时长
        let checkTime = (rule, value, callback) => {
            if (this.form.planTime > 180) {
                callback(new Error('计划时间不能超过180分钟'));
            } else if (this.form.planTime <= 0) {
                callback(new Error('计划时间不能低于1分钟'));
            }
            else {
                callback();
            }
        };
        //查重名
        let checkplanname = (rule, value, callback) => {
            this.axios.get('/studyPlan/findplanname?username=' + username + '&planName=' + this.form.planName)
                .then(res => {
                    // console.log(res)
                    if (res.data.code == 200) {
                        callback();
                    } else {
                        callback(new Error('该计划名称已存在'));
                    }
                })
        };
        return {
            // 表单
            form: {
                planName: '',
                timeTrend: '倒计时',
                planTime: '',
            },
            // 类型列表
            list_type: ['倒计时', '正向计时'],
            // 校验规则
            rules: {
                planName: [{ required: true, message: '计划名称不能为空！', trigger: 'blur' },
                { validator: checkplanname, trigger: 'blur' }
                ],
                timeTrend: [{ required: true, message: '计时方向不能为空！', trigger: 'blur' }
                ],
                planTime: [{ required: true, message: '计时时长不能为空！', trigger: 'blur' },
                { pattern: /^[0-9]+$/, message: '请输入数字', trigger: 'blur' },
                { validator: checkTime, trigger: 'blur' }
                ]
            },
        }
    }, methods: {
        cancel() {
            router.push('/study_plan/main1').then(() => {
                setTimeout(router.go(0), 0);
            });
        },addxxjh() {
            this.axios.post('/studyPlan/addplan', {
                username: username,
                planName: this.form.planName,
                timeTrend: this.form.timeTrend,
                planTime: this.form.planTime
            })
                .then(res => res.data).then(res => {
                    // console.log(res);
                    if (res.code == 200) {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '计划添加成功',
                            type: 'success'
                        });
                        router.push('/study_plan/main1').then(() => {
                            setTimeout(router.go(0), 0);
                        });
                    } else {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '计划添加失败',
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