export default{
    state:{
        tabslist:[
            //面包屑数据
            {
                path:'/user/main',
                name:'/user/main',
                meta:{
                    title:'管理员'
                }
            }
        ]
    },
    mutations:{
        menuChange(state,val){
            //更新面包屑数据
            if(val.name!=='user/main'){
                const index1=state.tabslist.findIndex(index=>index.index.name===val.index.name);
                if(index1!==-1){
                    state.tabslist.push(val);
                }
            }
        }
    }
}