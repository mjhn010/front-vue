<script setup>
import { reactive } from "vue";
import { useRouter, useRoute } from "vue-router";
import { useUserDetailsStore } from "../stores/useUserDetailsStore";
import { decodeCredential } from "vue3-google-login";
//--------------데이터
let router = useRouter();
let route = useRoute();
let userDetails = useUserDetailsStore();
let user = reactive({
  email: "",
  password: "",
});

//-------------소셜로그인
async function googleLoginHandler(response) {
  fetch(
    `https://www.googleapis.com/oauth2/v3/userinfo?access_token=${response.access_token}`
  )
    .then((res) => res.json())
    .then((credential) => {
      userDetails.email = credential.email;
    });

  //구글 아이디로 회원가입을 한적이 있는지 확인해야함
  let resp = await fetch(
    `http://localhost:8080/email/checkemail?email=${userDetails.email}`
  );
  let result = await resp.text();
  //우리 DB에 없을 시 회원가입 화면으로 넘어가진다.
  if (result === "ok") {
    router.push("/signup?type=oauth");
    return;
  }

  let returnURL = route.query.returnURL;
  if (returnURL) router.push(returnURL);
  else router.push("/index");
}
//-------------이벤트 핸들러
async function loginHandler() {
  let response = await fetch("http://localhost:8080/user/login", {
    method: "POST",
    headers: {
      Accept: "application/json",
      "Content-type": "application/x-www-form-urlencoded",
    },
    body: `email=${user.email}&password=${user.password}`,
  });
  let json = await response.json();
  userDetails.id = json.result.id;
  userDetails.email = json.result.email;
  userDetails.nickname = json.result.nickname;
  userDetails.profileSrc = json.result.image;
  let returnURL = route.query.returnURL;

  if (!userDetails.email) {
    router.push("/login");
    user.email = "";
    user.password = "";
  } else if (returnURL) router.push(returnURL);
  else router.push("/index");
}
</script>
<template>
  <section class="main">
    <div class="login-border">
      <div class="login-box">
        <router-link to="/index"
          ><img src="/src/assets/images/pofo.svg" class="logo-img"
        /></router-link>

        <form class="margin-top-15">
          <p class="font-weight-500">이메일</p>
          <input type="text" class="input-text" v-model="user.email" />

          <p class="font-weight-500">비밀번호</p>
          <input
            type="password"
            class="input-text"
            v-model="user.password"
            autocomplete="off"
          />
          <button
            class="btn btn-0 margin-top-8 margin-bottom-5"
            @click.prevent="loginHandler"
          >
            로그인
          </button>
          <router-link to="/sendlink"
            ><a class="font-size1 margin-top-3 float-right"
              >비밀번호 찾기 ></a
            ></router-link
          >
        </form>

        <div class="margin-top-20 sub-section">
          <p class="margin-bottom-5 font-weight-500 font-size1 text-center">
            SNS로 간편하게 시작하기
          </p>

          <div class="logos margin-top-1">
            <GoogleLogin :callback="googleLoginHandler" popup-type="TOKEN">
              <img
                src="/src/assets/images/google_logo.png"
                class="social-logo"
              />
            </GoogleLogin>
            <a><img src="/src/assets/images/kakao_logo.png" /></a>
            <a><img src="/src/assets/images/naver_logo.svg" /></a>
          </div>
        </div>

        <div class="margin-top-20">
          <span class="margin-right-22 font-size1"
            >아직 포폴의 회원이 아니세요?</span
          >
          <router-link to="/signup"
            ><span class="font-size1 margin-left-5 underline">
              회원가입 하기</span
            ></router-link
          >
        </div>
      </div>
    </div>
  </section>
</template>
<style scoped>
@import url("/src/assets/css/compoment/login.css");
.social-logo:hover {
  cursor: pointer;
}
</style>
