import { createRouter, createWebHistory } from 'vue-router'
//重定向登录
const routes = [
  {
    path: '/',
    redirect: '/study_plan/main1'
  },
  //登录
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/login.vue')
  },
  //注册
  {
    path: '/register',
    name: 'register',
    component: () => import('../views/register.vue')
  },
  //忘记密码
  {
    path: '/forgot',
    name: 'forgot',
    component: () => import('../views/forgot.vue')
  },
  //学生登录后主页面
  {
    path: '/study_plan/main1',
    name: 'study_plan_main1',
    component: () => import('../components/home.vue'),
    children: [
      //个人信息
      {
        path: '/user/info1',
        name: 'user_info1',
        component: () => import('../views/user/info(xs).vue'),
        meta: {
          title: '个人信息'
        }
      },
      //修改密码
      {
        path: '/user/password1',
        name: 'password1',
        component: () => import('../views/user/password(xs).vue'),
        meta: {
          title: '修改密码'
        }
      },
      //通知主页面
      {
        path: '/notice/main1',
        name: 'notice_main1',
        component: () => import('../views/notice/main(xs).vue'),
        meta: {
          title: '我的通知'
        }
      },
      // // 通知详情页面
      // {
      //   path: '/notice/view1',
      //   name: 'notice_view1',
      //   component: () => import('../views/notice/view(xs).vue'),
      //   meta: {
      //     title: '我的通知详情'
      //   }
      // },
      //未来目标主页面
      {
        path: '/goal_plan/main1',
        name: 'goal_plan_main1',
        component: () => import('../views/goal_plan/main(xs).vue'),
        meta: {
          title: '未来目标'
        }
      },
      //未来目标详情页面
      {
        path: '/goal_plan/view1',
        name: 'goal_plan_view1',
        component: () => import('../views/goal_plan/view.vue'),
        meta: {
          title: '未来目标详情'
        }
      },
      //学习计划主页面
      {
        path: '/study_plan/main1',
        name: 'study_plan_main1',
        component: () => import('../views/study_plan/main(xs).vue'),
        meta: {
          title: '学习计划'
        }
      },
      //学习计划详情页面
      {
        path: '/study_plan/view1',
        name: 'study_plan_view1',
        component: () => import('../views/study_plan/view.vue'),
        meta: {
          title: '学习计划详情'
        }
      },
      //心得主页面
      {
        path: '/experience/main1',
        name: 'experience_main1',
        component: () => import('../views/experience/main(xs).vue'),
        meta: {
          title: '心得记录'
        }
      },
      //心得交流页面
      {
        path: '/experience/view1',
        name: 'experience_view1',
        component: () => import('../views/experience/view(xs).vue'),
        meta: {
          title: '心得交流'
        }
      },
      //自习室主页面
      {
        path: '/study_room/main1',
        name: 'study_room_main1',
        component: () => import('../views/study_room/main(xs).vue'),
        meta: {
          title: '自习室'
        }
      },
      //自习室创建页面
      {
        path: '/study_room/create1',
        name: 'study_room_create1',
        component: () => import('../views/study_room/create.vue'),
        meta: {
          title: '自习室创建'
        }
      },
      //自习室里页面
      {
        path: '/study_room/view1',
        name: 'study_room_view1',
        component: () => import('../views/study_room/view(xs).vue'),
        meta: {
          title: '我的自习室'
        }
      },
      //自习室资料页面
      {
        path: '/study_room/book1',
        name: 'study_room_book1',
        component: () => import('../views/study_room/book(xs).vue'),
        meta: {
          title: '资料分享'
        }
      },
      //自习室问题页面
      {
        path: '/study_room/question1',
        name: 'study_room_question1',
        component: () => import('../views/study_room/question(xs).vue'),
        meta: {
          title: '问题解答'
        }
      },
      //自习室问题详情页面
      {
        path: '/study_room/discuss1',
        name: 'study_room_discuss1',
        component: () => import('../views/study_room/discuss(xs).vue'),
        meta: {
          title: '问题解答详情'
        }
      },
      //成就页面
      {
        path: '/accomplishment/cj1',
        name: 'accomplishment_cj1',
        component: () => import('../views/accomplishment/cj(xs).vue'),
        meta: {
          title: '成就'
        }
      },
      //数据统计页面
      {
        path: '/data_count/view1',
        name: 'data_count_view1',
        component: () => import('../views/data_count/view(xs).vue'),
        meta: {
          title: '数据统计'
        }
      },
    ]
  },
  //管理员登录后主页面
  {
    path: '/study_plan/main',
    name: 'study_plan_main',
    component: () => import('../components/main.vue'),
    children: [
      //个人信息
      {
        path: '/user/info',
        name: 'user_info',
        component: () => import('../views/user/info.vue'),
        meta: {
          title: '个人信息'
        }
      },
      //修改密码
      {
        path: '/user/password',
        name: 'password',
        component: () => import('../views/user/password.vue'),
        meta: {
          title: '修改密码'
        }
      },
      //管理员页面
      {
        path: '/user/main',
        name: 'user_main',
        component: () => import('../views/user/main.vue'),
        meta: {
          title: '管理员'
        }
      },
      //管理员详情页面
      {
        path: '/user/view',
        name: 'user_view',
        component: () => import('../views/user/view.vue'),
        meta: {
          title: '管理员详情'
        }
      },
      //学生信息主页面
      {
        path: '/student/main',
        name: 'student_main',
        component: () => import('../views/student/main.vue'),
        meta: {
          title: '学生'
        }
      },
      // 学生信息详情页面
      {
        path: '/student/view',
        name: 'student_view',
        component: () => import('../views/student/view.vue'),
        meta: {
          title: '学生详情'
        }
      },
      //教师信息主页面
      {
        path: '/teacher/main',
        name: 'teacher_main',
        component: () => import('../views/teacher/main.vue'),
        meta: {
          title: '教师'
        }
      },
      // 教师信息详情页面
      {
        path: '/teacher/view',
        name: 'teacher_view',
        component: () => import('../views/teacher/view.vue'),
        meta: {
          title: '教师详情'
        }
      },
      //通知主页面
      {
        path: '/notice/main',
        name: 'notice_main',
        component: () => import('../views/notice/main.vue'),
        meta: {
          title: '我的通知'
        }
      },
      //通知详情页面
      {
        path: '/notice/view',
        name: 'notice_view',
        component: () => import('../views/notice/view.vue'),
        meta: {
          title: '我的通知详情'
        }
      },
      //未来目标主页面
      {
        path: '/goal_plan/main',
        name: 'goal_plan_main',
        component: () => import('../views/goal_plan/main.vue'),
        meta: {
          title: '未来目标'
        }
      },
      //学习计划主页面
      {
        path: '/study_plan/main',
        name: 'study_plan_main',
        component: () => import('../views/study_plan/main.vue'),
        meta: {
          title: '学习计划'
        }
      },
      //心得主页面
      {
        path: '/experience/main',
        name: 'experience_main',
        component: () => import('../views/experience/main.vue'),
        meta: {
          title: '心得记录'
        }
      },
      //心得交流页面
      {
        path: '/experience/view',
        name: 'experience_view',
        component: () => import('../views/experience/view.vue'),
        meta: {
          title: '心得记录'
        }
      },
      //心得交流详情页面
      {
        path: '/experience/views',
        name: 'experience_views',
        component: () => import('../views/experience/views.vue'),
        meta: {
          title: '心得记录详情'
        }
      },
      //自习室主页面
      {
        path: '/study_room/main',
        name: 'study_room_main',
        component: () => import('../views/study_room/main.vue'),
        meta: {
          title: '自习室'
        }
      },
      //自习室成员页面
      {
        path: '/study_room/view',
        name: 'study_room_view',
        component: () => import('../views/study_room/view.vue'),
        meta: {
          title: '自习室'
        }
      },
      //自习室资料页面
      {
        path: '/study_room/book',
        name: 'study_room_book',
        component: () => import('../views/study_room/book.vue'),
        meta: {
          title: '资料分享'
        }
      },
      //自习室问题页面
      {
        path: '/study_room/question',
        name: 'study_room_question',
        component: () => import('../views/study_room/question.vue'),
        meta: {
          title: '问题解答'
        }
      },
      // 自习室问题详情页面
      {
        path: '/study_room/discuss',
        name: 'study_room_discuss',
        component: () => import('../views/study_room/discuss.vue'),
        meta: {
          title: '问题解答详情'
        }
      },
      //数据统计页面
      {
        path: '/data_count/main',
        name: 'data_count_main',
        component: () => import('../views/data_count/main.vue'),
        meta: {
          title: '数据统计'
        }
      },
      //数据统计详情页面
      {
        path: '/data_count/view',
        name: 'data_count_view',
        component: () => import('../views/data_count/view.vue'),
        meta: {
          title: '数据统计'
        }
      },
      //成就页面
      {
        path: '/accomplishment/cj',
        name: 'accomplishment_cj',
        component: () => import('../views/accomplishment/cj.vue'),
        meta: {
          title: '成就'
        }
      },
    ]
  },
  //倒计时页面
  {
    path: '/time/main',
    name: 'time_main',
    component: () => import('../views/time/main.vue')
  },
  //休息页面
  {
    path: '/time/view',
    name: 'time_view',
    component: () => import('../views/time/view.vue')
  }
]
//地址带不带#
const router = createRouter({
  history: createWebHistory(),
  routes
})
//每次都让title变成学生自律管理系统
router.afterEach((to, from, next) => {
  let title = "学生自我管理系统";
  document.title = title;
})
// //没登陆自动跳到登录页
router.beforeEach((to, from, next) => {
  const username = sessionStorage.getItem('username');
  if (to.path==="/register"||to.path==="/forgot") {
    next();
  }
  if (to.name !== 'login' && !username) {
    next({
      name: 'login'
    })
  }
  next();
})
//角色不能还想看对方的页面
router.beforeEach((to, from, next) => {
  // 获取用户角色
  // if (to.path === '/register') {
  //   next('/register');
  // }
  // if (to.path === '/forgot') {
  //   next('/forgot');
  // }
  let userGroup = sessionStorage.getItem('userGroup');
  // console.log(userGroup)
  // 判断用户角色是否是学生
  if (userGroup === "学生") {
    //重定向到对应的页面
    if (to.path === '/study_plan/main'||to.path === '/user/main'||to.path === '/user/view'||to.path === '/teacher/main'||to.path === '/teacher/view'||to.path === '/student/main'||to.path === '/student/view') {
      return next('/study_plan/main1');
    } else if (to.path === "/study_plan/view") {
      return next("/study_plan/view1");
    } else if (to.path === "/user/info") {
      return next("/user/info1");
    } else if (to.path === "/user/password") {
      return next("/user/password1");
    } else if (to.path === "/notice/main"||to.path === "/notice/view"||to.path === "/notice/view1") {
      return next("/notice/main1");
    } else if (to.path === "/goal_plan/main") {
      return next("/goal_plan/main1");
    } else if (to.path === "/goal_plan/view") {
      return next("/goal_plan/view1");
    } else if (to.path === "/experience/main") {
      return next("/experience/main1");
    }else if (to.path === "/experience/view"||to.path === "/experience/views") {
      return next("/experience/view1");
    } else if (to.path === "/study_room/main") {
      return next("/study_room/main1");
    } else if (to.path === "/study_room/view") {
      return next("/study_room/view1");
    } else if (to.path === "/study_room/create") {
      return next("/study_room/create1");
    } else if (to.path === "/study_room/book") {
      return next("/study_room/book1");
    } else if (to.path === "/study_room/question"||to.path === "/study_room/discuss") {
      return next("/study_room/question1");
    } else if (to.path === "/accomplishment/cj") {
      return next("/accomplishment/cj1");
    } else if (to.path === "/data_count/view"||to.path === "/data_count/main") {
      return next("/data_count/view1");
    }else if (to.path === "/login") {
      return next(from);
    }else if (to.path === "/register") {
      return next(from);
    }else if (to.path === "/forgot") {
      return next(from);
    }else {
      return next();
     }
  }else if (userGroup === "教师" || userGroup === "管理员") {   // 判断用户角色是否是教师/管理员
    //重定向到对应的页面
    if (to.path === '/study_plan/main1'||to.path === '/time/main'||to.path === '/time/view'||to.path === "/study_plan/view1"||to.path === "/study_plan/view") {
      return next('/study_plan/main');
    } else if (to.path === "/user/info1") {
      return next("/user/info");
    } else if (to.path === "/user/password1") {
      return next("/user/password");
    } else if (to.path === "/notice/main1") {
      return next("/notice/main");
    } else if (to.path === "/notice/view1") {
      return next("/notice/view");
    } else if (to.path === "/goal_plan/main1"||to.path === "/goal_plan/view1"||to.path === "/goal_plan/view") {
      return next("/goal_plan/main");
    } else if (to.path === "/experience/main1") {
      return next("/experience/main");
    } else if (to.path === "/experience/view1") {
      return next("/experience/view");
    } else if (to.path === "/study_room/main1"||to.path === "/study_room/view1"||to.path === "/study_room/create1"||to.path === "/study_room/create"||to.path === "/study_room/book1"||to.path === "/study_room/question1"||to.path === "/study_room/discuss1") {
      return next("/study_room/main");
    }else if (to.path === "/data_count/view1"||to.path === "/accomplishment/cj1") {
      return next("/data_count/main");
    }else if (to.path === "/login") {
      return next(from);
    }else if (to.path === "/register") {
      return next(from);
    }else if (to.path === "/forgot") {
      return next(from);
    }else {
      return next();
     }
  } else {
    return next();
  }
});
export default router
