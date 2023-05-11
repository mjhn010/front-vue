<template>
  <!-- <header class="com-header">
          <ul class="menu-bar">
              <li><a href=""><img class="header-logo" src="/imgs/Pofo.svg" alt="logo"></a></li>
              <li class="pro"><a href="">프로젝트</a></li>
              <li class="community"><a href="">커뮤니티</a></li>
          </ul>
          <div class="search-box"><img class="search-img" src="/imgs/free-icon-search-482631-3.svg" alt="돋보기"><input class="header-search" type="text" placeholder="검색어를 입력해보세요"></div>
          <ul class="m-menu user-bar">
              <li class="login-li" ><a class="login" href="">로그인</a></li>
              <li class="sign-up-li"><a href=""><button class="btn btn-3 sign-up">회원가입</button></a></li>
              <li><img class="hamburger-bar" src="/imgs/menu.png" alt=""></li>
          </ul>
      </header> -->
  <!-- 맴버 -->
  <header class="com-header">
    <ul class="menu-bar">
      <li>
        <router-link to="/index"><img class="header-logo" src="/src/assets/images/Pofo.svg" alt="logo" /></router-link>
      </li>
      <li class="pro"><a href="">프로젝트</a></li>
      <li class="community">
        <router-link to="/community">커뮤니티</router-link>
      </li>
    </ul>
    <div class="search-box">
      <img class="search-img" src="/src/assets/images/free-icon-search-482631-3.svg" alt="돋보기" /><input
        class="header-search" type="text" placeholder="검색어를 입력해보세요" />
    </div>
    <ul class="m-menu member-bar">
      <li>
        <router-link to="/pofo/reg"><button class="btn btn-3 prj-register">
            프로젝트 등록
          </button></router-link>
      </li>
      <button @click="showModalMessage">
        <li><img class="dm" src="/src/assets/images/email.png" alt="DM" /></li>
      </button>
      <button @click="showModalNotify">
        <li>
          <img class="bell" src="/src/assets/images/bell.png" alt="알림" />
        </li>
      </button>
      <li>
        <button @click="showModalProfile">
          <img class="header-profile" src="/src/assets/images/proflie.svg" alt="마이프로필" />
        </button>
      </li>
      <li>
        <img class="hamburger-bar" src="/src/assets/images/menu.png" alt="" />
      </li>
    </ul>
  </header>
  <div class="head-popup" :class="modalChange" v-if="isModalOpenMessage" v-click-outside="closeModal">
    <div class="noti-list" @click.stop>
      <div class="noti-header">
        <!-- <div class="noti-title">읽지않은 알림</div> -->
        <div class="noti-title-content">
          메시지<a href="#" class="font-size-14">모든메시지 보기 ></a>
        </div>
        <div class="alarm-item">
          <div class="alarm-content">
            <div class="modal-wrap">
              <div class="modal-thumbnail">
                <div width="40" height="40" class="modal-thumbnail-circle">
                  <div class="profile-image-wrap" style="width: 40px; height: 40px">
                    <span class="profile-username-uppercase" style="width: 40px; height: 40px">K</span>
                  </div>
                </div>
              </div>
              <div width="16px" height="100%" class="modal-wall"></div>
              <div class="modal-content">
                <div class="modal-title">
                  <div class="modal-name">
                    <p class="modal-nickname">JongWoo</p>
                  </div>
                  <div class="modal-date">2023년 04월 21일</div>
                </div>
                <div class="modal-title-wall"></div>
                <div class="modal-last-msg">
                  <p class="modal-msg-text" title="아아아아아">아아아아아</p>
                </div>
              </div>
            </div>
            <div class="bottom-line"></div>
          </div>
        </div>
      </div>
      <!-- <div class="noti-background">
          <div class="alarm-empty"></div>
        </div> -->
    </div>
  </div>
  <div class="head-popup" :class="modalChange" v-if="isModalOpenNotify" v-click-outside="closeModal">
    <div class="noti-list" @click.stop>
      <div class="noti-header">
        <!-- <div class="noti-title">읽지않은 알림</div> -->
        <div class="noti-title-content">
          알림<a href="#" class="font-size-14"></a>
        </div>
        <div class="alarm-item">
          <div class="alarm-content">
            <div class="modal-wrap">
              <div class="modal-thumbnail">
                <div width="40" height="40" class="modal-thumbnail-circle">
                  <div class="profile-image-wrap" style="width: 40px; height: 40px">
                    <span class="profile-username-uppercase" style="width: 40px; height: 40px">K</span>
                  </div>
                </div>
              </div>
              <div width="16px" height="100%" class="modal-wall"></div>
              <div class="modal-content">
                <div class="modal-title">
                  <p class="modal-msg-text" style="font-weight: lighter" title="Thomas님이 좋아요를 누르셨습니다.">
                    Thomas님이 좋아요를 누르셨습니다.
                  </p>
                  <div class="modal-date">2023년 04월 21일</div>
                </div>
                <div class="modal-title-wall"></div>
              </div>
            </div>
            <div class="bottom-line"></div>
          </div>
        </div>
      </div>
      <!-- <div class="noti-background">
          <div class="alarm-empty"></div>
        </div> -->
    </div>
  </div>
  <div class="head-popup" :class="modalChange" v-if="isModalOpenProfile" v-click-outside="closeModal">
    <div class="noti-list" @click.stop>
      <div class="noti-header">
        <!-- <div class="noti-title">읽지않은 알림</div> -->
        <div class="user-main-wrap">
          <a href="#" width="56" height="56" target="_blank" class="">
            <div class="profile-image-wrap" style="width: 56px width: 56px;">
              <span class="profile-username-uppercase" style="width: 56px; height: 56px">K</span>
            </div>
          </a>
          <div class="user-detail-wrap">
            <div class="user-detail-id">msi881010</div>
            <div class="user-detail-email">msi881010@gmail.com</div>
          </div>
        </div>
        <div class="profile-menu-wrap">
          <a href="#" class="upload menu-item margin-top-5">새로운 포트폴리오 업로드</a>
          <a href="#" class="mypofo menu-item">나의 포트폴리오</a>
          <a href="#" class="pofile-setting menu-item">설정</a>
          <div class="line-bar"></div>
          <a href="#" class="menu-item top-border-line">로그아웃</a>
        </div>
      </div>
    </div>
  </div>
</template>

<style>
@import url("/src/assets/css/common/reset.css");
@import url("/src/assets/css/common/style.css");
@import url("/src/assets/css/common/util.css");
@import url("/src/assets/css/common/buttons.css");
@import url("/src/assets/css/compoment/modal.css");
@import url("/src/assets/css/compoment/header.css");
</style>

<script>
import vClickOutside from "click-outside-vue3";
export default {
  directives: {
    clickOutside: vClickOutside.directive,
  },
  data() {
    return {
      isModalOpenMessage: false,
      isModalOpenNotify: false,
      isModalOpenProfile: false,
      modalChange: "",
    };
  },
  methods: {
    showModalMessage() {
      this.isModalOpenNotify = false;
      this.isModalOpenMessage = true;
      this.isModalOpenProfile = false;
      this.modalChange = "noti-content-message";
    },
    showModalNotify() {
      this.isModalOpenMessage = false;
      this.isModalOpenNotify = true;
      this.isModalOpenProfile = false;
      this.modalChange = "noti-content-notify";
    },
    showModalProfile() {
      this.isModalOpenMessage = false;
      this.isModalOpenNotify = false;
      this.isModalOpenProfile = true;
      this.modalChange = "noti-content-profile";
    },
    closeModal() {
      this.isModalOpenMessage = false;
      this.isModalOpenNotify = false;
      this.isModalOpenProfile = false;
    },
  },
};
</script>
