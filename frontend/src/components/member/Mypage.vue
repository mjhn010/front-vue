<script setup>
import Header from '../Header.vue'
</script>
<template>
    <Header></Header>
    <main class="container">

<section class="margin-right-5 profile">
    <h1 class="d-none">왼편 프로필 창</h1>
    <div class="profile-info">
        <img class="profile-img" src="/src/assets/images/logo.png">
        <div class="nickname">
            김선호
        </div>
        <a class="url" href="#">www.ksh.github.com</a>
        <div>
            <button class="btn btn-0 font-size-15 btn-height">프로필 편집</button>
            <button class="d-none">팔로우</button>
        </div>
    </div>



    <div class="margin-top-10 margin-bottom-5 font-size-14">활동 정보</div>

    <div class="activity-boxes">
        <div>
            <div class="margin-bottom-5 font-size-15 bold">0</div>
            <div class="font-size-14 font-gray">작업 보기</div>
        </div>
        <div>
            <div class="margin-bottom-5 font-size-15 bold">0</div>
            <div class="font-size-14 font-gray">좋아요 받음</div>
        </div>
        <div>
            <div class="margin-bottom-5 font-size-15s bold">0</div>
            <div class="font-size-14 font-gray">컬렉션 북마크</div>
        </div>
        <div>
            <div class="margin-bottom-5 font-size-15 bold">0</div>
            <div class="font-size-14 font-gray">팔로잉</div>
        </div>
        <div>
            <div class="margin-bottom-5 font-size-15 bold">0</div>
            <div class="font-size-14 font-gray">팔로우</div>
        </div>
    </div>
</section>

<section class="profile-content">
    <div class="tab-container">
        <div class="items">
            <div>
                <span class="font-weight-700">작업</span>
                <span class="num">15</span>
            </div>
            <div>
                <span class="non-selected">좋아요</span>
                <span class="num-non-selected num">15</span>
            </div>
            <div>
                <span class="non-selected">컬렉션</span>
                <span class="num-non-selected num">15</span>
            </div>
            <div>
                <span class="non-selected">임시보관함</span>
                <span class="num-non-selected num">15</span>
            </div>
        </div>
    </div>

    <div class="portfolio-lists">
        <img src="../../assets/images/test.jpg">
        <img src="../../assets/images/test.jpg">
        <img src="../../assets/images/test.jpg">
        <img src="../../assets/images/test.jpg">
        <img src="../../assets/images/test.jpg">
        <img src="../../assets/images/test.jpg">
        <img src="../../assets/images/test.jpg">
        <img src="../../assets/images/test.jpg">
        <img src="../../assets/images/test.jpg">
        <img src="../../assets/images/test.jpg">
        <img src="../../assets/images/test.jpg">
        <img src="../../assets/images/test.jpg">
        <img src="../../assets/images/test.jpg">
        <img src="../../assets/images/test.jpg">
        <img src="../../assets/images/test.jpg">
        <img src="../../assets/images/test.jpg">
        <img src="../../assets/images/test.jpg">
        <img src="../../assets/images/test.jpg">
        <img src="../../assets/images/test.jpg">
        <img src="../../assets/images/test.jpg">
        <img src="../../assets/images/test.jpg">
        <img src="../../assets/images/test.jpg">
        <img src="../../assets/images/test.jpg">
        <img src="../../assets/images/test.jpg">
        <img src="../../assets/images/test.jpg">
        <img src="../../assets/images/test.jpg">
    </div>

</section>
</main>
</template>
<style scoped>
@import url("/src/assets/css/compoment/profile.css");
</style>