<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','student_user') || $check_field('add','student_user') || $check_field('set','student_user')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="学生用户" prop="student_user">
						<div v-if="user_group !== '管理员'">
							{{ get_user_session_student_user(form['student_user']) }}
							<!--<el-input id="business_name" v-model="form['student_user']" placeholder="请输入学生用户"-->
							<!--v-if="user_group === '管理员' || (form['summary_of_experience_id'] && $check_field('set','student_user')) || (!form['summary_of_experience_id'] && $check_field('add','student_user'))" :disabled="disabledObj['student_user_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','student_user')">{{form['student_user']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['summary_of_experience_id'] && $check_field('set','student_user')) || (!form['summary_of_experience_id'] && $check_field('add','student_user'))" id="student_user" v-model="form['student_user']" :disabled="disabledObj['student_user_isDisabled']">
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
							  v-if="user_group === '管理员' || (form['summary_of_experience_id'] && $check_field('set','student_number')) || (!form['summary_of_experience_id'] && $check_field('add','student_number'))" :disabled="disabledObj['student_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','student_number')">{{form['student_number']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','full_name') || $check_field('add','full_name') || $check_field('set','full_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="姓名" prop="full_name">
					<el-input id="full_name" v-model="form['full_name']" placeholder="请输入姓名"
							  v-if="user_group === '管理员' || (form['summary_of_experience_id'] && $check_field('set','full_name')) || (!form['summary_of_experience_id'] && $check_field('add','full_name'))" :disabled="disabledObj['full_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','full_name')">{{form['full_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','class_name') || $check_field('add','class_name') || $check_field('set','class_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="班级名称" prop="class_name">
					<el-input id="class_name" v-model="form['class_name']" placeholder="请输入班级名称"
							  v-if="user_group === '管理员' || (form['summary_of_experience_id'] && $check_field('set','class_name')) || (!form['summary_of_experience_id'] && $check_field('add','class_name'))" :disabled="disabledObj['class_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','class_name')">{{form['class_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','zhou_hao') || $check_field('add','zhou_hao') || $check_field('set','zhou_hao')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="周号" prop="zhou_hao">
					<el-input id="zhou_hao" v-model="form['zhou_hao']" placeholder="请输入周号"
							  v-if="user_group === '管理员' || (form['summary_of_experience_id'] && $check_field('set','zhou_hao')) || (!form['summary_of_experience_id'] && $check_field('add','zhou_hao'))" :disabled="disabledObj['zhou_hao_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','zhou_hao')">{{form['zhou_hao']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','summary_of_this_week') || $check_field('add','summary_of_this_week') || $check_field('set','summary_of_this_week')" :xs="24" :sm="24" :lg="24" class="el_form_editor_warp">
				<el-form-item label="本周总结" prop="summary_of_this_week">
					<quill-editor v-model.number="form['summary_of_this_week']"
						v-if="user_group === '管理员' || (form['summary_of_experience_id'] && $check_field('set','summary_of_this_week')) || (!form['summary_of_experience_id'] && $check_field('add','summary_of_this_week')) ">
					</quill-editor>
					<div v-else-if="$check_field('get','summary_of_this_week')" v-html="form['summary_of_this_week']"></div>
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
				field: "summary_of_experience_id",
				url_add: "~/api/summary_of_experience/add?",
				url_set: "~/api/summary_of_experience/set?",
				url_get_obj: "~/api/summary_of_experience/get_obj?",
				url_upload: "~/api/summary_of_experience/upload?",

				query: {
					"summary_of_experience_id": 0,
				},

				form: {
					"student_user": 0, // 学生用户
					"student_number":'', // 学号
					"full_name":'', // 姓名
					"class_name":'', // 班级名称
					"zhou_hao":'', // 周号
					"summary_of_this_week":'', // 本周总结
					"summary_of_experience_id": 0, // ID

				},
				disabledObj:{
					"student_user_isDisabled": false,
					"student_number_isDisabled": false,
					"full_name_isDisabled": false,
					"class_name_isDisabled": false,
					"zhou_hao_isDisabled": false,
					"summary_of_this_week_isDisabled": false,
				},
				// 用户列表
				list_user_student_user: [],
				// 用户组
				group_user_student_user: "",
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
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
				// 获取缓存数据附加
				form = $.db.get("form");
				$.push(this.form ,form);
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
				$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/summary_of_experience/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/summary_of_experience/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/summary_of_experience/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/summary_of_experience/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/summary_of_experience/view','get');
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
