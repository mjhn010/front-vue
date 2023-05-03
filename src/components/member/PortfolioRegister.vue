<script setup>
import Header from'../Header.vue';
</script>
<template>
    <Header></Header>
     <form action="">
        <div class="container">
            <main class="reg-main">
                <div class="reg-title-box">
                    <input class="reg-title" type="text" placeholder="제목을 입력해주세요.">
                </div>
                <!--  -->
                <section class="reg-content">
                    <section class="default-box">
                        <div class="main-title">
                          <span>
                              이미지 or 텍스트를 선택하여 업로드를 시작하세요.
                          </span>
                        </div>
                        <div class="start-app">
                          <div class="margin-right-5 sub-box">
                            <div class="app-box"><img class="hover" src="src/assets/images/img.png" alt=""><img class="hover d-none" src="/imgs/fff-img.png" alt=""></div>
                            <div class="app-box-font">이미지</div>
                          </div>
                          <div class="sub-box">
                            <div class="app-box"><img class="hover" src="src/assets/images/text.png" alt=""><img class="hover d-none" src="/imgs/fff-text.png" alt=""></div>
                            <div class="app-box-font">텍스트</div>
                          </div>
                        </div>
                      </section>
                      <!--  -->
                </section>
            </main>
            <aside class="aside">
                <nav class="margin-top-4 nav">
                  <ul class="content-select">
                    <li class="border-none aside-li">
                      <button class="aside-btn">
                        <img class="aside-img" src="src/assets/images/img.png" alt="" />이미지추가
                      </button>
                    </li>
                    <li class="border-none aside-li">
                      <button class="aside-btn">
                        <img class="aside-img" src="src/assets/images/text.png" alt="" />텍스트추가
                      </button>
                    </li>
                  </ul>
                  <ul class="content-select">
                    <li class="aside-li">
                      <button class="aside-btn">
                        <img class="aside-img" src="src/assets/images/content.svg" alt="" />콘텐츠재정렬
                      </button>
                    </li>
                    <li class="aside-li">
                      <button class="aside-btn">
                        <img class="aside-img" src="src/assets/images/preview.png" alt="" />미리보기
                      </button>
                    </li>
                  </ul>
                  <button class="register-btn btn-1 margin-top-5">등록하기</button>
                  <button class="register-btn-1 btn-1 margin-top-5">임시저장</button>
                </nav>
              </aside>
              <div class="m-comment d-none">
                <span>작업 업로드 및 수정은 PC버전에서만 지원이 가능합니다.</span>
              </div>
        </div>
     </form>
</template>
<style scoped>
@import url("/src/assets/css/compoment/register.css");
</style>