import { useUserDetailsStore } from "../../stores/useUserDetailsStore.js";
import Mypage from './Mypage.vue';
const member = {
  path: "/member", 
  children :[
    { path : "mypage", component : Mypage }
  ],
  beforeEnter(to,from,next) {
    let userDetails = useUserDetailsStore();
    let url = `/login?returnURL=${to.path}`;
    if (!userDetails.isAuthenticated) 
        next(url);
    else if (!userDetails.hasRole("ADMIN")) 
        next("/error/403");
    else 
        next();
  },
};

export default member;
