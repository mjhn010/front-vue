<script setup>
import { reactive, ref, onMounted } from "vue";
import { useRouter, useRoute } from "vue-router";
import Modal from "./Modal.vue";

//--------------데이터
let email = ref("");
let title = ref("");
let showModal = ref(false);

let router = useRouter();
let route = useRoute();

onMounted(() => {
  async function checkuuid() {
    let query = route.query.uuid;
    let response = await fetch(
      `http://localhost:8080/email/uuidcheck?uuid=${query}`
    );
    let result = await response.text();
    console.log(result);
    if (result == "ok") {
      router.push("/pwdreset");
    } else {
      showModal.value = true;
      title.value = "주소가 유효하지 않습니다. main화면으로 이동합니다";
      router.push("/index");
    }
  }
  checkuuid();
});

// if (result === "ok") {
//   showModal.value = true;
//   title.value = "이메일이 존재하지 않습니다. 다시 확인해주세요";
// } else {
//   let sendLink = await fetch(
//     `http://localhost:8080/email/findpwd?email=${email.value}`,
//     {
//       method: "POST",
//     }
//   );
// }
</script>

<template>
  <!DOCTYPE html>
  <html>
    <head>
      <meta charset="UTF-8" />
      <meta http-equiv="X-UA-Compatible" content="IE=edge" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <title>ResetPasswordPage</title>
    </head>

    <body>
      <section class="main">
        <main class="reset-border">
          <h1 class="margin-top-9">
            <img src="/src/assets/images/pofo.svg" class="logo-img" />
          </h1>
          <h2 class="margin-top-9">비밀번호 변경</h2>

          <form id="reset-form" style="display: inline-grid">
            <div class="margin-top-9">
              <input
                class="input-text input-text-placeholder"
                type="password"
                id="pasword"
                placeholder="비밀번호(숫자,영문,특수문자 포함 8~16자리)"
                name="pwd"
                autocomplete="off"
              />
              <span id="pwd-validation" class="block-red margin-top-2"></span>
            </div>

            <input
              class="input-text input-text-placeholder margin-top-8"
              type="password"
              id="password-check"
              placeholder="비밀번호 확인"
              autocomplete="off"
            />
            <span id="pwd-certification" class="block-red margin-top-2"></span>

            <input
              class="margin-top-10 btn btn-1"
              type="button"
              value="비밀번호 변경"
              id="send-btn"
            />
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
  <Modal :show="showModal" @ok="showModal = false" type="1" :title="title" />
</template>

<style scoped>
@import url("/src/assets/css/compoment/pwd-page.css");
@import url("/src/assets/css/common/reset.css");
@import url("/src/assets/css/common/style.css");
@import url("/src/assets/css/common/util.css");
@import url("/src/assets/css/common/buttons.css");
</style>
