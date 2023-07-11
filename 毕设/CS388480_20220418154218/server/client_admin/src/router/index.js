import Vue from 'vue';
import VueRouter from 'vue-router';
import index from '../views/index.vue';
import login from '../views/login.vue';
import forgot from '../views/forgot.vue';
import register from '../views/register.vue';
Vue.use(VueRouter)

const routes = [
	// 主页
	{
		path: '/',
		redirect:'daily_plan/table',
		// name: 'index',
		component: index,
		// meta: {
		// 	index: 0,
		// 	title: '首页'
		// }
	},

	// 登录
	{
		path: '/login',
		name: 'login',
		component: login,
		meta: {
			index: 0,
			title: '登录'
		}
	},
	// 注册
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {
			index: 0,
			title: '注册'
		}
	},

	// 忘记密码
	{
		path: '/forgot',
		name: "forgot",
		component: forgot,
		meta: {
			index: 0,
			title: '忘记密码'
		}
	},

	// 修改密码
	{
		path: '/user/password',
		name: "password",
		component: () => import("../views/user/password.vue"),
		meta: {
			index: 0,
			title: '修改密码'
		}
	},

	// 视频播放页
	{
		path: "/media/video",
		name: "video",
		component: () => import('../views/media/video.vue'),
		meta: {
			index: 0,
			title: "视频"
		}
	},

	// 音频播放页
	{
		path: "/media/audio",
		name: "audio",
		component: () => import('../views/media/audio.vue'),
		meta: {
			index: 0,
			title: "音频"
		}
	},
	// 学生路由
	{
		path: '/student/table',
		name: 'student_table',
		component: () => import('../views/student/table.vue')
	},
	{
		path: '/student/view',
		name: 'student_view',
		component: () => import('../views/student/view.vue')
	},
	// 每日计划路由
	{
		path: '/daily_plan/table',
		name: 'daily_plan_table',
		component: () => import('../views/daily_plan/table.vue')
	},
	{
		path: '/daily_plan/view',
		name: 'daily_plan_view',
		component: () => import('../views/daily_plan/view.vue')
	},
	// 每周计划路由
	{
		path: '/weekly_plan/table',
		name: 'weekly_plan_table',
		component: () => import('../views/weekly_plan/table.vue')
	},
	{
		path: '/weekly_plan/view',
		name: 'weekly_plan_view',
		component: () => import('../views/weekly_plan/view.vue')
	},
	// 心得总结路由
	{
		path: '/summary_of_experience/table',
		name: 'summary_of_experience_table',
		component: () => import('../views/summary_of_experience/table.vue')
	},
	{
		path: '/summary_of_experience/view',
		name: 'summary_of_experience_view',
		component: () => import('../views/summary_of_experience/view.vue')
	},
	// 放松天地路由
	{
		path: '/relax_the_world/table',
		name: 'relax_the_world_table',
		component: () => import('../views/relax_the_world/table.vue')
	},
	{
		path: '/relax_the_world/view',
		name: 'relax_the_world_view',
		component: () => import('../views/relax_the_world/view.vue')
	},
	// 学生信息路由
	{
		path: '/student_information/table',
		name: 'student_information_table',
		component: () => import('../views/student_information/table.vue')
	},
	{
		path: '/student_information/view',
		name: 'student_information_view',
		component: () => import('../views/student_information/view.vue')
	},
	// 教师路由
	{
		path: '/teacher/table',
		name: 'teacher_table',
		component: () => import('../views/teacher/table.vue')
	},
	{
		path: '/teacher/view',
		name: 'teacher_view',
		component: () => import('../views/teacher/view.vue')
	},
	// 次日计划路由
	{
		path: '/next_day_plan/table',
		name: 'next_day_plan_table',
		component: () => import('../views/next_day_plan/table.vue')
	},
	{
		path: '/next_day_plan/view',
		name: 'next_day_plan_view',
		component: () => import('../views/next_day_plan/view.vue')
	},

	// 用户路由
	{
		path: '/user/table',
		name: 'user_table',
		component: () => import('../views/user/table.vue'),
		meta: {
			index: 0,
			title: '用户列表'
		}
	},
	{
		path: '/user/view',
		name: 'user_view',
		component: () => import('../views/user/view.vue'),
		meta: {
			index: 0,
			title: '用户详情'
		}
	},
	{
		path: '/user/info',
		name: 'user_info',
		component: () => import('../views/user/info.vue'),
		meta: {
			index: 0,
			title: '个人信息'
		}
	},
	// 用户组路由
	{
		path: '/user_group/table',
		name: 'user_group_table',
		component: () => import('../views/user_group/table.vue'),
		meta: {
			index: 0,
			title: '用户组列表'
		}
	},
	{
		path: '/user_group/view',
		name: 'user_group_view',
		component: () => import('../views/user_group/view.vue'),
		meta: {
			index: 0,
			title: '用户组详情'
		}
	}
]
//地址带不带#
const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})

router.beforeEach((to, from, next) => {
	let token = to.query.token;
	if (token){
		$.db.set("token",token,120);
	}
	next();
})

router.afterEach((to, from, next) => {
	let title = "学生自律管理系统-admin";
	document.title = title;
})

export default router
