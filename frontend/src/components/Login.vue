<script setup>
import { reactive } from 'vue';
import { useRouter, useRoute } from 'vue-router';
import { useUserDetailsStore } from '../stores/useUserDetailsStore';
import { decodeCredential } from 'vue3-google-login';
//--------------데이터
let router = useRouter();
let route = useRoute();
let userDetails = useUserDetailsStore();
let user = reactive({
  email: "",
  password: "",
});

//-------------소셜로그인
function googleLoginHandler(response) {
  let userData = decodeCredential(response.credential);
  console.log(userData)

  userDetails.username = userData.name;
  userDetails.email = userData.email;

  let returnURL = route.query.returnURL;
  if (returnURL)
    router.push(returnURL)
  else
    router.push("/index")
}
//-------------이벤트 핸들러
async function loginHandler() {
  let response = await fetch("http://localhost:8080/user/login", {
    method: "POST",
    headers: {
      "Accept": "application/json",
      "Content-type": "application/x-www-form-urlencoded"
    },
    body: `email=${user.email}&password=${user.password}`
  });
  let json = await response.json();
  userDetails.id = json.result.id;
  userDetails.email = json.result.email;
  userDetails.nickname = json.result.nickname;
  let returnURL = route.query.returnURL;

  if (!userDetails.email) {
    router.push("/login");
    user.email = '';
    user.password = '';
  }
  else if (returnURL)
    router.push(returnURL);
  else
    router.push("/index");

}
</script>
<template>
  <section class="main">
    <div class="login-border">
      <div class="login-box">
        <router-link to="/index"><img src="/src/assets/images/pofo.svg" class="logo-img"></router-link>

        <form class="margin-top-15">
          <p class="font-weight-500">
            이메일
          </p>
          <input type="text" class="input-text" v-model="user.email">

          <p class="font-weight-500">
            비밀번호
          </p>
          <input type="password" class="input-text" v-model="user.password" autocomplete="off">
          <button class="btn btn-0 margin-top-8 margin-bottom-5" @click.prevent="loginHandler">
            로그인
          </button>
          <a class="float-right font-size1 margin-top-3">비밀번호 찾기 ></a>
        </form>

        <div class="margin-top-20 sub-section">
          <p class="text-center margin-bottom-5 font-weight-500 font-size1">
            SNS로 간편하게 시작하기
          </p>

          <div class="logos margin-top-1">
            <GoogleLogin :callback="googleLoginHandler">
              <img src="/src/assets/images/google_logo.png" class="social-logo">
            </GoogleLogin>
            <a><img src="/src/assets/images/kakao_logo.png"></a>
            <a><img src="/src/assets/images/naver_logo.svg"></a>
          </div>
        </div>

        <div class="margin-top-20">
          <span class="margin-right-22 font-size1">아직 포폴의 회원이 아니세요?</span>
          <a><span class="font-size1 margin-left-5 underline"> 회원가입 하기</span></a>
        </div>
      </div>
    </div>
  </section>
</template>
<style scoped>
@import url("/src/assets/css/compoment/login.css");
.social-logo:hover{
  cursor: pointer;
}

</style>