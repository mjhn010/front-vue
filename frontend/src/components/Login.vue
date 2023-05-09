<script setup>

</script>
<template>
  <section class="main">
    <div class="login-border">
      <div class="login-box">
        <a><img src="/src/assets/images/pofo.svg" class="logo-img"></a>

        <form class="margin-top-15">
          <p class="font-weight-500">
            이메일
          </p>
          <input type="text" class="input-text">

          <p class="font-weight-500">
            비밀번호
          </p>
          <input type="text" class="input-text">
          <button class="btn btn-0 margin-top-8 margin-bottom-5">
            로그인
          </button>
          <a class="float-right font-size1 margin-top-3">비밀번호 찾기 ></a>
        </form>

        <div class="margin-top-20 sub-section">
          <p class="text-center margin-bottom-5 font-weight-500 font-size1">
            SNS로 간편하게 시작하기
          </p>

          <div class="logos margin-top-1">
            <a><img src="/src/assets/images/google_logo.png"></a>
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
</style>