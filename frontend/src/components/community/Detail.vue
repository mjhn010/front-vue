<script setup>
import { reactive, onMounted } from 'vue';
import Header from '../Header.vue';
import { useRoute } from 'vue-router';


// --- Variables ---------------------------------------
let data = reactive({
    community: {}
});

let route = useRoute();

// --- Life Cycles -------------------------------------
onMounted(() => {
    fetchCommunity();
})

// --- Event Handlers ----------------------------------
async function fetchCommunity(){
    let param = route.params.id;
    const url = new URL(`http://localhost:8080/community/${param}`);

    let response = await fetch(url);
    let json = await response.json();
    data.community = json.community;

    console.log(data.community);
}


</script>

<template>
    <Header />
    <main>
        <div style="display:flex">
            <img loading="lazy" class="css-l68de9 e5kxa4l0"
                :src="'http://localhost:8080/communityImage/' + data.community.thumbnail">
        </div>

        <div class="CodeBlock_block__3Yr6P css-3y3f20">
            <div class="contents-form-relative">

                <div class="contens-title-box">
                    <div class="contents-title-text">{{ data.community.title }}</div>
                </div>
                <div class="contents-status-box">
                    <div class="contents-status-1">모집 중</div>
                    <!-- <div class="contents-status-2"></div> -->
                </div>

                <div class="divider"></div>

                <div class="contents-details">
                    <div class="contents-details-box">
                        <div class="contents-detail-header-text">진행</div>
                        <div class="contents-details-text">{{ data.community.memberId }}</div>
                    </div>
                    <div class="contents-details-box">
                        <div class="contents-detail-header-text">장소</div>
                        <span class="contents-status-2">online</span>
                        <!-- <span class="contents-status-2">offline</span> -->
                        <div class="contents-details-text location-info">{{ data.community.locationInfo }}</div>
                    </div>
                    <div class="contents-details-box">
                        <div class="contents-detail-header-text">기간</div>
                        <div class="contents-details-text">{{ data.community.period }}</div>
                    </div>
                    <div class="contents-details-box">
                        <div class="contents-detail-header-text">인원</div>
                        <div class="contents-details-text">{{ data.community.teamSize }}명</div>
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
    width: 50px;
    height: 16px;
    margin: auto 6px auto 15px;
    border: 0.5px none #000;
    border-radius: 3px;
    background-color: #dbeddb;
    font-size: 12px;
    font-weight: 400;
    color: #fff;
    background-color: #8CCCF4;
    
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

.location-info {
    margin-left: 0;
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