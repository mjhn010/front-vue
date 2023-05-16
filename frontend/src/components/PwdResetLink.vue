<template>
  <!DOCTYPE html>
  <html xmlns:th="http://www.thymeleaf.org">
    <head>
      <meta charset="UTF-8" />
      <meta http-equiv="X-UA-Compatible" content="IE=edge" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <title>Document</title>
    </head>
    <body>
      <section class="main">
        <main class="reset-border">
          <h1 class="margin-top-9">
            <img src="/src/assets/images/pofo.svg" class="logo-img" />
          </h1>
          <h2 class="margin-top-9">비밀번호 찾기</h2>
          <p class="font-size1 margin-top-9">가입 시 등록했던 이메일로</p>
          <p class="font-size1 margin-bottom-5">
            비밀번호를 변경할 수 있는 메일을 보내드릴게요.
          </p>
          <form id="reset-form">
            <div class="margin-top-9">
              <input
                class="input-text input-text-placeholder"
                type="email"
                id="email"
                placeholder="이메일 입력"
                name="email"
                autocomplete="off"
              />
              <span id="pwd-validation" class="block-red margin-top-2"></span>
              <input
                class="margin-top-10 btn btn-1"
                type="button"
                value="이메일 전송"
                id="send-btn"
              />
            </div>
          </form>

          <div class="modal-bg d-none">
            <section class="modal-style d-none">
              <div class="margin-top-10">
                <span id="modal-text"></span>
              </div>
              <button class="btn btn-3" type="button" id="cancel">확인</button>
            </section>
          </div>
        </main>
      </section>
    </body>
  </html>
</template>

<style scoped>
@import url("/src/assets/css/compoment/pwd-page.css");
@import url("/src/assets/css/common/reset.css");
@import url("/src/assets/css/common/style.css");
@import url("/src/assets/css/common/util.css");
@import url("/src/assets/css/common/buttons.css");
</style>
