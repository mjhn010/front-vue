import { createApp } from 'vue'
import {createRouter,createWebHashHistory} from 'vue-router'
//로그인,회원가입
import Login from'./components/Login.vue';

// 유저
import Index from "./components/Index.vue";


// 맴버
import PortfolioRegister from'./components/member/PortfolioRegister.vue';
import Mypage from'./components/member/Mypage.vue';



//커뮤니티
import CommunityReg from'./components/member/CommunityRegister.vue'

import App from './App.vue'


const routes = [
    { path: "/index", component: Index},

    //pofo경로
    {path:"/pofo/reg",component:PortfolioRegister},

    //community경로
    {path:"/community/reg",component:CommunityReg},

    // 로그인,회원가입,비밀번호찾기
    {path:"/login",component:Login},
    {path:"/mypage",component:Mypage}

    // { path: "/member", component: MemberLayout,children:[
    //     {path:'communityreg',component:CommunityRegister}
    // ] }
    //수업내용
    // {
    //   path: "/",
    //   component: Layout,
    //   children: [
    //     { path: "menu/list", component: MenuList },
    //     { path: 'menu/:id', component: Detail },
    //     { path: "about", component: About },
    //   ],
    // },
    // { path: "/admin", component: AdminLayout,
    // children:[{path:"menu/list",component:AdminList}]}
  ];
  
  const router = createRouter({
    // 4. Provide the history implementation to use. We are using the hash history for simplicity here.
    history: createWebHashHistory(),
    routes, // short for `routes: routes`
  });


createApp(App)
.use(router)
.mount('#app')