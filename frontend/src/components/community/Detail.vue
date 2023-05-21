<script setup>
import { reactive } from 'vue';
import Header from '../Header.vue';

// --- Variables ---------------------------------------
let community = reactive({
    
});

// --- Event Handlers ----------------------------------
async function fetchCommunity(){
    const url = new URL('http://localhost:8080/community/detail');
}


</script>

<template>
    <Header />
    <main>
        <div style="display:flex">
            <img loading="lazy" class="css-l68de9 e5kxa4l0"
                src="https://oopy.lazyrockets.com/api/v2/notion/image?src=https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F26a05cc1-4e5c-4811-8e78-c527b8882595%2F%25E1%2584%2592%25E1%2585%25A9%25E1%2586%25BC%25E1%2584%2589%25E1%2585%25A5%25E1%2586%25BC%25E1%2584%258B%25E1%2585%25AE_%25E1%2584%258F%25E1%2585%25A5%25E1%2584%2586%25E1%2585%25B2_%25E1%2584%258A%25E1%2585%25A5%25E1%2586%25B7%25E1%2584%2582%25E1%2585%25A6%25E1%2584%258B%25E1%2585%25B5%25E1%2586%25AF_%25E1%2584%2589%25E1%2585%25AE%25E1%2584%258C%25E1%2585%25A5%25E1%2586%25BC.png&amp;blockId=e2903c2e-80fc-4024-9438-cb80c3f76174">
        </div>

        <div class="CodeBlock_block__3Yr6P css-3y3f20">
            <div class="contents-form-relative">

                <div class="contens-title-box">
                    <div class="contents-title-text">물리 시뮬레이터를 활용한 블렌더 3D</div>
                </div>
                <div class="contents-status-box">
                    <div class="contents-status-1">모집 중</div>
                    <div class="contents-status-2"></div>
                </div>

                <div class="divider"></div>

                <div class="contents-details">
                    <div class="contents-details-box">
                        <div class="contents-detail-header-text">진행</div>
                        <div class="contents-details-text">뇌뇌</div>
                    </div>
                    <div class="contents-details-box">
                        <div class="contents-detail-header-text">장소</div>
                        <div class="contents-details-text">3기 노트폴리오 아카데미(연남동) / 4기 외부 강의장(연희동)</div>
                    </div>
                    <div class="contents-details-box">
                        <div class="contents-detail-header-text">기간</div>
                        <div class="contents-details-text">6/4 - 7/23, 일요일 오후 2시 - 5시(총 8회차, 24시간)</div>
                    </div>
                    <div class="contents-details-box">
                        <div class="contents-detail-header-text">인원</div>
                        <div class="contents-details-text">최대 16명</div>
                    </div>
                </div>

                <div class="divider"></div>

                <div class="contents-apply-form">
                    <p>
                        자세한 팀원 모집은 알림과 채팅 기능을 이용해보세요!
                    </p>
                </div>

            </div>
        </div>

    </main>
</template>

<style scoped>
.css-l68de9 {
    display: block;
    object-fit: cover;
    border-radius: 1px;
    width: 705px;
    height: auto;
    pointer-events: auto;
    border-radius: 0px;

    margin: 0 auto;
}

.css-3y3f20 {
    width: 705px;
    margin: 0 auto;
}

.page-title {
    display: none;
}

.width.padding {
    margin: -20px;
}

.contents-form-relative {
    width: 708px;
    height: 365px;
    padding: 20px;
    line-height: 16px;
    border-style: none solid solid;
    border-width: 1px;
    border-color: #e5e5e5;
    border-radius: 0px 0px 8px 8px;
    background-color: #fff;
}


.contents-title-text {
    font-size: 20px;
    font-weight: 700;
    line-height: 25px;
    color: #222;
}

.contents-status-box {
    display: flex;
    flex-direction: row;
    margin-top: 10px;
    justify-content: flex-start;
}

.contents-status-1 {
    display: flex;
    justify-content: center;
    width: 63.3px;
    height: 16px;
    margin: 0px 6px 4px 0px;
    border: 0.5px none #000;
    border-radius: 3px;
    background-color: #fdecc8;
    font-size: 12px;
    font-weight: 400;
    color: #49290e;
    background-color: #feebe1;
}

.contents-status-2 {
    display: flex;
    justify-content: center;
    width: 63.3px;
    height: 16px;
    margin: 0px 6px 4px;
    border: 0.5px none #000;
    border-radius: 3px;
    background-color: #dbeddb;
    font-size: 12px;
    font-weight: 400;
    color: #fff;
    background-color: #fff;
}

.contents-details-box {
    display: flex;
}

.contents-details {
    display: block;
    margin-top: 16px;
}

.contents-detail-header-text {
    padding-top: 8px;
    padding-bottom: 8px;
    font-weight: 700;
}

.contents-details-text {
    margin-left: 15px;
    padding-top: 8px;
    padding-bottom: 8px;
    padding-left: 0px;
    color: #222;
}

.divider {
    width: 100%;
    margin-top: 15px;
    border-bottom: 1.5px solid #e5e5e5;
}


.contents-apply-form {
    margin-top: 18px;
}

.full-price-text {
    margin-top: 4px;
    margin-bottom: 4px;
    font-size: 14px;
    font-weight: 300;
    color: #737373;
}

.monthly-price-box {
    display: flex;
    -webkit-box-pack: start;
    justify-content: flex-start;
    -webkit-box-align: center;
    align-items: center;
}

.monthly-price-text {
    display: flex;
    color: #222;
    font-size: 20px;
    line-height: 30px;
    font-weight: 700;
}

.monthly-text {
    display: block;
    margin-left: 6px;
    color: #737373;
    font-size: 14px;
    line-height: 15px;
    font-weight: 300;
}
</style>