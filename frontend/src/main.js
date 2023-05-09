import { createApp } from "vue";
import { createRouter, createWebHashHistory } from "vue-router";

import App from "./App.vue";

// 로그인,회원가입
import Login from "/src/components/Login.vue";
// 유저
import Index from "/src/components/Index.vue";
// 맴버
import PortfolioRegister from "/src/components/member/PortfolioRegister.vue";
import Mypage from "/src/components/member/Mypage.vue";
// 커뮤니티
import Community from "/src/components/Community.vue";
import CommunityReg from "/src/components/member/CommunityRegister.vue";
// 포트폴리오 상세정보
import PortfolioDetail from "/src/components/PortfolioDetail.vue";
// 회원가입
import Signup from "/src/components/Signup.vue";
const routes = [
  { path: "/index", component: Index },

  // pofo경로
  { path: "/pofo/reg", component: PortfolioRegister },
  { path: "/pofo/:id", component: PortfolioDetail },

  // community경로
  { path: "/community", component: Community},
  { path: "/community/reg", component: CommunityReg },

  // 로그인,회원가입,비밀번호찾기
  { path: "/login", component: Login },
  { path: "/mypage", component: Mypage },
  { path: "/signup", component: Signup}
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

createApp(App).use(router).mount("#app");
