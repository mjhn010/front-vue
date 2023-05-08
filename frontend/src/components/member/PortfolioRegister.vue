<script setup>
import Header from "../Header.vue";
import { reactive, ref } from "vue";
// 보였다가 없어짐
let clickCheck = ref(true);
let showImg = ref(false);
let showText = ref(false);
let showModal = ref(false)

function imgHandler() {
  clickCheck.value = !clickCheck.value;
  showImg.value = !showImg.value;
  console.log(clickCheck);
}

function textHandler() {
  clickCheck.value = !clickCheck.value;
  showText.value = !showText.value;
}
function showModalHandler(){
  showModal.value = !showModal.value;
}
</script>
<template>
  <div v-show="showModal" class="screen"></div>
  <Header />
  <form action="">
    <div class="container">
      <main class="reg-main">
        <div class="reg-title-box">
          <input
            class="reg-title"
            type="text"
            placeholder="제목을 입력해주세요."
          >
        </div>
        <!--  -->
        <section class="reg-content">
          <section
            v-if="clickCheck"
            class="default-box"
          >
            <div class="main-title">
              <span> 이미지 or 텍스트를 선택하여 업로드를 시작하세요. </span>
            </div>
            <div class="start-app">
              <div class="margin-right-5 sub-box">
                <div
                  @click="imgHandler"
                  class="app-box"
                >
                  <img
                    class="hover"
                    src="/src/assets/images/img.png"
                    alt=""
                  ><img
                    class="hover d-none"
                    src="/src/assets/images/fff-img.png"
                    alt=""
                  >
                </div>
                <div class="app-box-font">
                  이미지
                </div>
              </div>
              <div class="sub-box">
                <div
                  @click="textHandler"
                  class="app-box"
                >
                  <img
                    class="hover"
                    src="/src/assets/images/text.png"
                    alt=""
                  ><img
                    class="hover d-none"
                    src="/src/assets/images/fff-text.png"
                    alt=""
                  >
                </div>
                <div class="app-box-font">
                  텍스트
                </div>
              </div>
            </div>
          </section>
          <!-- 이미지 클릭했을때 나오는 박스 -->
          <section
            v-if="showImg"
            class="default-box click-img-box"
          >
            <div class="start-app">
              <div class="sub-box">
                <div class="app-box">
                  <img
                    class="hover"
                    src="/src/assets/images/img.png"
                    alt=""
                  ><img
                    class="hover d-none"
                    src="/src/assets/images/fff-img.png"
                    alt=""
                  >
                </div>
              </div>
            </div>
            <div class="main-title">
              <span class="img-upLoad-comment margin-top-1">
                이미지(최대10장)을 업로드 또는 드래그하세요.
              </span>
              <span class="img-upLoad-comment margin-top-1 color-eee">
                JPEG,JPG,GIF 이미지파일
              </span>
            </div>
          </section>
          <!-- 텍스트 눌렀을때 나오는 텍스트박스 -->
          <section
            v-if="showText"
            class="click-text-box margin-top-3"
          >
            <div class="start-app">
              <!-- <textarea class="click-text" type="text" placeholder="여기에 텍스트를 입력하세요."> -->
              <textarea
                class="click-text"
                name=""
                id=""
                cols="30"
                rows="2"
                placeholder="여기에 텍스트를 입력하세요."
              />
            </div>
          </section>
          <!--  -->
        </section>
      </main>
      <aside class="aside">
        <nav class="margin-top-4 nav">
          <ul class="content-select">
            <li class="aside-li border-none">
              <button class="aside-btn">
                <img
                  class="aside-img"
                  src="/src/assets/images/img.png"
                  alt=""
                >이미지추가
              </button>
            </li>
            <li class="aside-li border-none">
              <button class="aside-btn">
                <img
                  class="aside-img"
                  src="/src/assets/images/text.png"
                  alt=""
                >텍스트추가
              </button>
            </li>
          </ul>
          <ul class="content-select">
            <li class="aside-li">
              <button class="aside-btn">
                <img
                  class="aside-img"
                  src="/src/assets/images/content.svg"
                  alt=""
                >콘텐츠재정렬
              </button>
            </li>
            <li class="aside-li">
              <button class="aside-btn">
                <img
                  class="aside-img"
                  src="/src/assets/images/preview.png"
                  alt=""
                >미리보기
              </button>
            </li>
          </ul>
          <button @click="showModalHandler" class="register-btn btn-1 margin-top-5">
            등록하기
          </button>
          <button class="register-btn-1 btn-1 margin-top-5">
            임시저장
          </button>
        </nav>
      </aside>
      <div class="m-comment d-none">
        <span>작업 업로드 및 수정은 PC버전에서만 지원이 가능합니다.</span>
      </div>
    </div>
   <div v-show="showModal" class="reg-modal-box">
    <div class="modal-h1">
      <p class="modal-s-title">세부 정보 입력</p>
      <button @click="showModalHandler" class="modal-close"></button>
    </div>
    <div class="reg-modal">
      <div class="modal-flex">
      <div class="thumbnail-box">
        <div class="modal-thumbnail-text">
          <span class="thumbnail-span">커버</span><span class="thumbnail-color">(필수)</span>
        </div>
        <div class="thumbnail-img-box margin-top-5">
          <img class="thumbnail-img" src="" alt="">
          <input class="d-none" type="file">
        </div>
      </div>
      <div class="border-right"></div>
    </div>
      <!-- 모달 -->
      <div class="modal-main-box">
        <div class="modal-main-text margin-top-3">
          <span class="thumbnail-span">제목</span><span class="thumbnail-color">(필수)</span>
        </div>
        <input class="modal-main-title margin-top-2" type="text" placeholder="제목을 입력하세요">
        <div class="modal-main-text margin-top-5">
          <span class="thumbnail-span">기술스택</span><span class="thumbnail-color">(필수)</span>
        </div>
        <div class="check-box margin-top-2">
          <label><input class="cb" type="checkbox" value="java" checked="checked">java</label>
          <label><input class="cb" type="checkbox" value="javaScript">javaScript</label>
          <label><input class="cb" type="checkbox" value="python">python</label>
          <label><input class="cb" type="checkbox" value="C">C</label>
          <label><input class="cb" type="checkbox" value="C#">C#</label>
          <label><input class="cb" type="checkbox" value="VisualBasic">VisualBasic</label>
          <label><input class="cb" type="checkbox" value="HTML">HTML</label>
          <label><input class="cb" type="checkbox" value="CSS">CSS</label>
          <label><input class="cb" type="checkbox" value="spring">Spring</label>
          <label><input class="cb" type="checkbox" value="springBoot">SpringBoot</label>
        </div>
        <div class="modal-main-text margin-top-5">
          <span class="thumbnail-span">개인or팀</span><span class="thumbnail-color">(필수)</span>
        </div>
        <div class="team-info margin-top-3">
          <input type="checkbox" name="singgle" value="0">개인
          <input type="checkbox" name="team" value="1">팀
        </div>
        <div class="modal-main-text margin-top-5">
          <span class="thumbnail-span">팀원등록</span><span class="thumbnail-color">(선택)</span>
        </div>
        <input class="modal-main-team margin-top-2" type="text" placeholder="팀원을 등록해보세요.">
        <div class="submit-box margin-top-7">
          <input class="modal-submit-btn" type="submit" value="업로드">
        </div>
      </div>
    </div>
    </div>
  </form>
</template>
<style scoped>
@import url("/src/assets/css/compoment/register.css");
</style>