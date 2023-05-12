import { createApp } from "vue";
import { createRouter, createWebHashHistory } from "vue-router";
import { createPinia } from "pinia";
import piniaPersist from "pinia-plugin-persist";
import App from "./App.vue";

// 로그인,회원가입
import Login from "/src/components/Login.vue";

// 유저
import Index from "/src/components/Index.vue";

// 맴버
import MemberRoute from "./components/member/route.js";

// 커뮤니티
import Community from "/src/components/Community.vue";
import CommunityReg from "/src/components/member/CommunityRegister.vue";

// 포트폴리오 상세정보
import PortfolioDetail from "/src/components/PortfolioDetail/PortfolioDetail.vue";

// 회원가입
import Signup from "/src/components/Signup.vue";
import PortfolioRegister from "@/components/member/PortfolioRegister.vue";

const routes = [
  { path: "/index", component: Index },

  { path: "/pofo/reg", component: PortfolioRegister },
  { path: "/pofo/:id", component: PortfolioDetail },

  // community경로
  { path: "/community", component: Community },
  { path: "/community/reg", component: CommunityReg },

  // 로그인,회원가입,비밀번호찾기
  { path: "/login", component: Login },
  { path: "/signup", component: Signup },
  MemberRoute,
];

const router = createRouter({
  // 4. Provide the history implementation to use. We are using the hash history for simplicity here.
  history: createWebHashHistory(),
  routes, // short for `routes: routes`
});
const pinia = createPinia();
pinia.use(piniaPersist);

createApp(App).use(router).use(pinia).mount("#app");
