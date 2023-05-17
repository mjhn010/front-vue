<script setup>
import Header from './Header.vue'
import { onMounted, reactive, ref, shallowRef, triggerRef, watch } from 'vue';
import {useRoute} from 'vue-router';
import { useUserDetailsStore } from '../stores/useUserDetailsStore';

let userDetails = useUserDetailsStore();

//현재 클릭되어있는 TAB
let current = ref();
let route = useRoute();



let model = reactive({
    myInfo: {},
    list: [[], [], []],
    currentList: [],
    activities: {}
})


onMounted(() => {
    load();
});


async function load() {
    let param = route.params.id;
    let response = await fetch(`http://localhost:8080/profile/${param}`);
    let json = await response.json();
    model.myInfo = json.member;
    model.list[0] = json.works;
    model.list[1] = json.likes;
    model.list[2] = json.collections;
    model.currentList = json.works;
    model.activities = json.activities;
}

function clickWork() {
    current.value = 0;
    model.currentList = model.list[0];
}

function clickLikes() {
    current.value = 1;
    model.currentList = model.list[1];
}

function clickCollections() {
    current.value = 2;
    model.currentList = model.list[2];
}

</script>
<template>
    <Header></Header>
    <main class="container">

        <section class="margin-right-5 profile">
            <h1 class="d-none">왼편 프로필 창</h1>
            <div class="profile-info">
                <img class="profile-img" src="/src/assets/images/proflie.svg" alt="마이프로필"  v-if="model.myInfo.image==null"/>
                <img :src="'http://localhost:8080/profileImage/' + model.myInfo.image" class="profile-img" v-else/>
                <div class="nickname">
                    {{ model.myInfo.nickname }}
                </div>
                <a :href="model.myInfo.url" class="url" :hash="false">{{ model.myInfo.url }}</a>
                <div>
                    <button class="btn btn-0 font-size-15 btn-height font-weight-700">+ 팔로우</button>
                    <button class="d-none">팔로우</button>
                </div>
            </div>



            <div class="margin-top-10 margin-bottom-5 font-size-14">활동 정보</div>

            <div class="activity-boxes">
                <div>
                    <div class="margin-bottom-5 font-size-15 bold">{{ model.activities.hited }}</div>
                    <div class="font-size-14 font-gray">작업 보기</div>
                </div>
                <div>
                    <div class="margin-bottom-5 font-size-15 bold">{{ model.activities.liked }}</div>
                    <div class="font-size-14 font-gray">좋아요 받음</div>
                </div>
                <div>
                    <div class="margin-bottom-5 font-size-15s bold">{{ model.activities.collected }}</div>
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
                    <div @click="clickWork">
                        <span :class="{ 'non-seleted': current != 0, 'selected': current == 0 }">작업</span>
                        <span class="num" :class="{ 'num-non-selected': current != 0 }">{{ model.list[0].length }}</span>
                    </div>
                    <div @click="clickLikes">
                        <span :class="{ 'non-seleted': current != 1, 'selected': current == 1 }">좋아요</span>
                        <span class="num" :class="{ 'num-non-selected': current != 1 }">{{ model.list[1].length }}</span>
                    </div>
                    <div @click="clickCollections">
                        <span :class="{ 'non-seleted': current != 2, 'selected': current == 2 }">컬렉션</span>
                        <span class="num" :class="{ 'num-non-selected': current != 2 }">{{ model.list[2].length }}</span>
                    </div>
                    <!-- <div>
                <span class="non-selected">임시보관함</span>
                <span class="num-non-selected num">15</span>
            </div> -->
                </div>
            </div>

            <div class="portfolio-lists">
                <router-link :to="'/pofo/' + pofo.id" v-for="pofo in model.currentList">
                    <div class="thumbnail" :data-title="pofo.title">
                        <span>
                            <img :src="'http://localhost:8080/portfolio/thumbnails/' + pofo.thumbnail">
                        </span>
                    </div>
                </router-link>
            </div>

        </section>
    </main>
</template>
<style scoped>
@import url("/src/assets/css/compoment/profile.css");

.thumbnail:hover::before {
    content: attr(data-title);
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background-color: rgba(0, 0, 0, 0.5);
    z-index: 1;
    display: flex;
    color: #fff;

    align-items: flex-end;
    justify-content: flex-start;
    font-size: 1rem;
    padding-left: 5px;
    padding-bottom: 5px;

    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
}

.font-weight-700{
    font-weight: 700;
    font-size: 0.9rem;
}

.thumbnail:hover img {
    filter: brightness(80%);
}
</style>