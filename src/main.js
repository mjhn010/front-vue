import { createApp } from 'vue'
import {createRouter,createWebHashHistory} from 'vue-router'
import Index from "./components/Index.vue";


// 맴버
import PortfolioRegister from'./components/member/PortfolioRegister.vue';
// import CommunityRegister from'./components/member/CommunityRegister.vue';
import App from './App.vue'


const routes = [
    { path: "/index", component: Index},
    {path:"/pofo/reg",component:PortfolioRegister}

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