<template>
	<div>
		<el-form-item v-if="$check_register_field('add','student_number','/student/view')" label="学号" prop="student_number">
		<el-input id="student_number" v-model="form['student_number']" placeholder="请输入学号"></el-input>
		</el-form-item>
		<el-form-item v-if="$check_register_field('add','full_name','/student/view')" label="姓名" prop="full_name">
		<el-input id="full_name" v-model="form['full_name']" placeholder="请输入姓名"></el-input>
		</el-form-item>
		<el-form-item v-if="$check_register_field('add','gender','/student/view')" label="性别" prop="gender">
		<el-select id="gender" v-model="form['gender']">
			<el-option v-for="o in list_gender" :key="o" :label="o" :value="o">
			</el-option>
		</el-select>
		</el-form-item>
		<el-form-item v-if="$check_register_field('add','grade','/student/view')" label="年级" prop="grade">
		<el-input id="grade" v-model="form['grade']" placeholder="请输入年级"></el-input>
		</el-form-item>
		<el-form-item v-if="$check_register_field('add','major','/student/view')" label="专业" prop="major">
		<el-input id="major" v-model="form['major']" placeholder="请输入专业"></el-input>
		</el-form-item>
		<el-form-item v-if="$check_register_field('add','class_name','/student/view')" label="班级名称" prop="class_name">
		<el-input id="class_name" v-model="form['class_name']" placeholder="请输入班级名称"></el-input>
		</el-form-item>

	</div>
</template>

<script>
	import mixin from "@/mixins/component.js";

	export default {
		mixins: [mixin],
		props:{

			form:{
				type: Object,
				default: function(){
					return {
						"student_number":'',
						"full_name":'',
						"gender":'',
						"grade":'',
						"major":'',
						"class_name":'',
						"teacher_number": 0,
					}
				}
			},

		},
		data() {
			return {
				field: "student_id",
				url_add: "~/api/student/add?",
				url_set: "~/api/student/set?",
				url_upload: "~/api/student/upload?",
				list_gender: ['男','女'],

				rules: {
					"student_number": [ {required: true,message: '学号不能为空'}, ],
					"full_name": [ ],
					"gender": [ ],
					"grade": [ ],
					"major": [ ],
					"class_name": [ ],
					"teacher_number": [ ],
				}

			}
		},
		methods: {

		},
		created() {
		}
	}
</script>
