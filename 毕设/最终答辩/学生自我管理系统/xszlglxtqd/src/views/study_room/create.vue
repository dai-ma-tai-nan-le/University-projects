<template>
     <div class="create">
        <el-row>
            <el-col>
                <h1>创建自习室</h1>
            </el-col>
            <el-col>
                <el-form ref="form" :rules="rules" :model="form" label-width="100px"
                    style="width: 500px; margin: auto;margin-top: 20px;">
                    <el-col class="el_form_item_warp">
                        <el-form-item label="自习室名称" prop="roomname">
                            <el-input v-model="form.roomname" placeholder="如:考研" />
                        </el-form-item>
                    </el-col>
                    <el-col class="el_form_item_warp">
                        <el-form-item prop="description" label="自习室简介">
                            <el-input v-model="form.description" placeholder="如:上岸" />
                        </el-form-item>
                    </el-col>
                    <el-col class="el_form_item_warp">
                        <el-form-item label="加入所需密码" prop="password">
                            <el-input v-model="form.password" placeholder="您可以设置加入自习室所需的密码，也可以不设置" />
                        </el-form-item>
                    </el-col>
                    <el-col class="el_form_item_warp">
					<el-form-item label="公开自习室否">
						<el-select v-model="form.type" style="width: 400px;">
							<el-option v-for="o in list_type" :key="o" :label="o" :value="o">
							</el-option>
						</el-select>
					</el-form-item>
                    <el-col class="el_form_item_warp">
                        <el-form-item label="自定义人数上限" label-width="120" prop="num" style="margin-left: -20px;">
                            <el-input v-model="form.num" placeholder="默认人数上限为50人。可自定义范围2-300" />
                        </el-form-item>
                    </el-col>
				</el-col>
                <el-form-item style="margin-left: 80px;margin-top: 50px;">
						<el-button type="primary" @click="addzxs()" class="search_btn_find">创建</el-button>
						<el-button @click="cancel()" class="search_btn_reset">取消</el-button>
                    </el-form-item>
                </el-form>
            </el-col>
        </el-row>
    </div>
</template>

<script>
let username = sessionStorage.getItem("username");
import router from '../../router';
export default {
    data() {
        //检查自定义人数上限
        let checkNum = (rule, value, callback) => {
            if (this.form.num > 300) {
                callback(new Error('自定义人数上限不能超过300人'));
            }else if(this.form.num <2){
                callback(new Error('自定义人数上限不能低于2人'));
            }
             else {
                callback();
            }
        };
        // //查重名
        // let checkplanname = (rule, value, callback) => {
        //     this.axios.get('/studyRoom/findroomname?planName=' + this.form.roomname)
		// 		.then(res => {
		// 			// console.log(res)
		// 			if (res.data.code == 200) {
		// 				callback();
		// 			} else {
		// 				callback(new Error('该自习室名称已存在'));
		// 			}
		// 		})
        // };
        return {
            // 表单
            form: {
                type:'公开',
                roomname: "",
                password:'',
                description: "",
                num:50
            },
            // 类型列表
			list_type: ['公开', '不公开'],
            // 校验规则
            rules: {
                roomname: [{required: true, message: '自习室名称不能为空！', trigger: 'blur'},
                         {min: 1,max: 20,message: '长度在 1 到 20 个字符',trigger: 'blur'},
                        //  { validator: checkplanname, trigger: 'blur' }
                ],
                description: [{ required: true,message: '描述不能为空！',trigger: 'blur'},
                { min: 1, max: 50, message: '长度在 1 到 50 个字符',trigger: 'blur'}
                ],
                num:[{ validator: checkNum, trigger: 'blur' }]
            }
        }
    },methods:{
        cancel(){
            router.push("/study_room/main1").then(() => {
				setTimeout(router.go(0), 0);
			});
        },addzxs(){
            this.axios.post('/studyRoom/addzxs', {
                username:username,
                num: this.form.num,
                roomname: this.form.roomname,
                password: this.form.password,
                description: this.form.description,
                type: this.form.type
            })
                .then(res => res.data).then(res => {
                    // console.log(res);
                    if (res.code == 200) {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '自习室创建成功',
                            type: 'success'
                        });
                        router.push("/study_room/view1").then(() => {
				            setTimeout(router.go(0), 0);
			            });
                    } else {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '自习室创建失败',
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
.create {
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