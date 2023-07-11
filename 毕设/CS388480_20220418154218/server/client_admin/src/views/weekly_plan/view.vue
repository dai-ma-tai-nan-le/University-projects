<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','student_user') || $check_field('add','student_user') || $check_field('set','student_user')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="学生用户" prop="student_user">
						<div v-if="user_group !== '管理员'">
							{{ get_user_session_student_user(form['student_user']) }}
							<!--<el-input id="business_name" v-model="form['student_user']" placeholder="请输入学生用户"-->
							<!--v-if="user_group === '管理员' || (form['weekly_plan_id'] && $check_field('set','student_user')) || (!form['weekly_plan_id'] && $check_field('add','student_user'))" :disabled="disabledObj['student_user_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','student_user')">{{form['student_user']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['weekly_plan_id'] && $check_field('set','student_user')) || (!form['weekly_plan_id'] && $check_field('add','student_user'))" id="student_user" v-model="form['student_user']" :disabled="disabledObj['student_user_isDisabled']">
								<el-option v-for="o in list_user_student_user" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','student_user')" id="student_user" v-model="form['student_user']" :disabled="true">
								<el-option v-for="o in list_user_student_user" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="student_user" v-model="form['student_user']" :disabled="disabledObj['student_user_isDisabled']">
							<el-option v-for="o in list_user_student_user" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','student_number') || $check_field('add','student_number') || $check_field('set','student_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="学号" prop="student_number">
					<el-input id="student_number" v-model="form['student_number']" placeholder="请输入学号"
							  v-if="user_group === '管理员' || (form['weekly_plan_id'] && $check_field('set','student_number')) || (!form['weekly_plan_id'] && $check_field('add','student_number'))" :disabled="disabledObj['student_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','student_number')">{{form['student_number']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','full_name') || $check_field('add','full_name') || $check_field('set','full_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="姓名" prop="full_name">
					<el-input id="full_name" v-model="form['full_name']" placeholder="请输入姓名"
							  v-if="user_group === '管理员' || (form['weekly_plan_id'] && $check_field('set','full_name')) || (!form['weekly_plan_id'] && $check_field('add','full_name'))" :disabled="disabledObj['full_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','full_name')">{{form['full_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','zhou_hao') || $check_field('add','zhou_hao') || $check_field('set','zhou_hao')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="周号" prop="zhou_hao">
					<el-input id="zhou_hao" v-model="form['zhou_hao']" placeholder="请输入周号"
							  v-if="user_group === '管理员' || (form['weekly_plan_id'] && $check_field('set','zhou_hao')) || (!form['weekly_plan_id'] && $check_field('add','zhou_hao'))" :disabled="disabledObj['zhou_hao_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','zhou_hao')">{{form['zhou_hao']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','class_name') || $check_field('add','class_name') || $check_field('set','class_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="班级名称" prop="class_name">
					<el-input id="class_name" v-model="form['class_name']" placeholder="请输入班级名称"
							  v-if="user_group === '管理员' || (form['weekly_plan_id'] && $check_field('set','class_name')) || (!form['weekly_plan_id'] && $check_field('add','class_name'))" :disabled="disabledObj['class_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','class_name')">{{form['class_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','start_time') || $check_field('add','start_time') || $check_field('set','start_time')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="开始时间" prop="start_time">
					<el-date-picker :disabled="disabledObj['start_time_isDisabled']" v-if="user_group === '管理员' || (form['weekly_plan_id'] && $check_field('set','start_time')) || (!form['weekly_plan_id'] && $check_field('add','start_time'))" id="start_time"
						v-model="form['start_time']" type="datetime" placeholder="选择日期时间">
					</el-date-picker>
					<div v-else-if="$check_field('get','start_time')">{{form['start_time']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','end_time') || $check_field('add','end_time') || $check_field('set','end_time')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="结束时间" prop="end_time">
					<el-date-picker :disabled="disabledObj['end_time_isDisabled']" v-if="user_group === '管理员' || (form['weekly_plan_id'] && $check_field('set','end_time')) || (!form['weekly_plan_id'] && $check_field('add','end_time'))" id="end_time"
						v-model="form['end_time']" type="datetime" placeholder="选择日期时间">
					</el-date-picker>
					<div v-else-if="$check_field('get','end_time')">{{form['end_time']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','completion') || $check_field('add','completion') || $check_field('set','completion')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="完成情况" prop="completion">
					<el-input id="completion" v-model="form['completion']" placeholder="请输入完成情况"
							  v-if="user_group === '管理员' || (form['weekly_plan_id'] && $check_field('set','completion')) || (!form['weekly_plan_id'] && $check_field('add','completion'))" :disabled="disabledObj['completion_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','completion')">{{form['completion']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','self_scoring') || $check_field('add','self_scoring') || $check_field('set','self_scoring')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="自我打分" prop="self_scoring">
					<el-select id="self_scoring" v-model="form['self_scoring']"
						v-if="user_group === '管理员' || (form['weekly_plan_id'] && $check_field('set','self_scoring')) || (!form['weekly_plan_id'] && $check_field('add','self_scoring'))">
						<el-option v-for="o in list_self_scoring" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','self_scoring')">{{form['self_scoring']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','teacher_number') || $check_field('add','teacher_number') || $check_field('set','teacher_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="教师编号" prop="teacher_number">
						<el-select v-if="user_group === '管理员' || (form['weekly_plan_id'] && $check_field('set','teacher_number')) || (!form['weekly_plan_id'] && $check_field('add','teacher_number'))" id="teacher_number" v-model="form['teacher_number']" :disabled="disabledObj['teacher_number_isDisabled']">
							<el-option v-for="o in list_user_teacher_number" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','teacher_number')" id="teacher_number" v-model="form['teacher_number']" :disabled="true">
							<el-option v-for="o in list_user_teacher_number" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','tasks_this_week') || $check_field('add','tasks_this_week') || $check_field('set','tasks_this_week')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="本周任务" prop="tasks_this_week">
					<el-input type="textarea" id="tasks_this_week" v-model="form['tasks_this_week']" placeholder="请输入本周任务"
						v-if="user_group === '管理员' || (form['weekly_plan_id'] && $check_field('set','tasks_this_week')) || (!form['weekly_plan_id'] && $check_field('add','tasks_this_week'))" :disabled="disabledObj['tasks_this_week_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','tasks_this_week')">{{form['tasks_this_week']}}</div>
				</el-form-item>
			</el-col>
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "weekly_plan_id",
				url_add: "~/api/weekly_plan/add?",
				url_set: "~/api/weekly_plan/set?",
				url_get_obj: "~/api/weekly_plan/get_obj?",
				url_upload: "~/api/weekly_plan/upload?",

				query: {
					"weekly_plan_id": 0,
				},

				form: {
					"student_user": 0, // 学生用户
					"student_number":'', // 学号
					"full_name":'', // 姓名
					"zhou_hao":'', // 周号
					"class_name":'', // 班级名称
					"start_time":'', // 开始时间
					"end_time":'', // 结束时间
					"completion":'', // 完成情况
					"self_scoring":'', // 自我打分
					"teacher_number": 0, // 教师编号
					"tasks_this_week":'', // 本周任务
					"weekly_plan_id": 0, // ID

				},
				disabledObj:{
					"student_user_isDisabled": false,
					"student_number_isDisabled": false,
					"full_name_isDisabled": false,
					"zhou_hao_isDisabled": false,
					"class_name_isDisabled": false,
					"start_time_isDisabled": false,
					"end_time_isDisabled": false,
					"completion_isDisabled": false,
					"self_scoring_isDisabled": false,
					"teacher_number_isDisabled": false,
					"tasks_this_week_isDisabled": false,
				},
				// 用户列表
				list_user_student_user: [],
				// 用户组
				group_user_student_user: "",
				//自我打分选项列表
				list_self_scoring: ['1','2','3','4','5','6','7','8','9','10'],
				// 用户列表
				list_user_teacher_number: [],
			}
		},
		methods: {
			/**
			 * 获取学生用户列表
			 */
			async get_list_user_student_user() {
                // if(this.user_group !== "管理员" && this.form["student_user"] === 0) {
                //     this.form["student_user"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=学生");
                if(json.result && json.result.list){
                    this.list_user_student_user = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
			/**
			 * 获取学生用户组
			 */
			async get_group_user_student_user() {
				this.form["student_user"] = this.user.user_id;
				var json = await this.$get("~/api/user_group/get_obj?name=学生");
				if(json.result && json.result.obj){
					this.group_user_student_user = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_student_user(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_student_user.source_table+"/get_obj?"
				this.$get(url, user_id, function(res) {
					if (res.result && res.result.obj) {
						var arr = []
						for (let key in res.result.obj) {
							arr.push(key)
						}
						var arrForm = []
						for (let key in _this.form) {
							arrForm.push(key)
						}
						for (var i=0;i<arr.length;i++){
							for (var j=0;j<arrForm.length;j++){
								if (arr[i]===arrForm[j]){
									if (arr[i]!=="student_user") {
										_this.form[arrForm[j]] = res.result.obj[arr[i]]
										_this.disabledObj[arrForm[j] + '_isDisabled'] = true
										break;
									}else {
										_this.disabledObj[arrForm[j] + '_isDisabled'] = true
									}
								}
							}
						}
					}
				});
			},
			get_user_student_user(id){
				var obj = this.list_user_student_user.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},
			/**
			 * 获取教师用户列表
			 */
			async get_list_user_teacher_number() {
                // if(this.user_group !== "管理员" && this.form["teacher_number"] === 0) {
                //     this.form["teacher_number"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=教师");
                if(json.result && json.result.list){
                    this.list_user_teacher_number = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
			get_user_teacher_number(id){
				var obj = this.list_user_teacher_number.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},

			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
				/**
				* 请求列表前
				* @param {Object} param
				*/
				var user_group = this.user.user_group;
				if (user_group !== "管理员") {
					switch (user_group) {
						case "学生用户":
							if(param["student_user"] > 0){
								param["student_user"] = this.user.user_id;
							}
							break;
						case "教师编号":
							if(param["teacher_number"] > 0){
								param["teacher_number"] = this.user.user_id;
							}
							break;
					}
				}
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
				this.form["start_time"] = this.$toTime(parseInt(this.form["start_time"]),"yyyy-MM-dd hh:mm:ss")
				this.form["end_time"] = this.$toTime(parseInt(this.form["end_time"]),"yyyy-MM-dd hh:mm:ss")
				$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){
				if(parseInt(this.form["start_time"]) > 9999){
					this.form["start_time"] = this.$toTime(parseInt(this.form["start_time"]),"yyyy-MM-dd hh:mm:ss")
				}
				if(parseInt(this.form["end_time"]) > 9999){
					this.form["end_time"] = this.$toTime(parseInt(this.form["end_time"]),"yyyy-MM-dd hh:mm:ss")
				}
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/weekly_plan/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/weekly_plan/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/weekly_plan/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/weekly_plan/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/weekly_plan/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
			this.get_list_user_student_user();
			this.get_group_user_student_user();
			this.get_list_user_teacher_number();
		},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}
</style>
