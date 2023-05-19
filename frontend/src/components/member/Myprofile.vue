<script setup>
import Header from '../Header.vue';
import { onMounted, reactive, ref } from 'vue';
import { useRoute } from 'vue-router';
import { useUserDetailsStore } from '../../stores/useUserDetailsStore';
import Modal from '../Modal.vue';

let userDetails = useUserDetailsStore();
let route = useRoute();

//현재 클릭되어있는 TAB
let current = ref();
let isThis = ref(false);

let showModal = ref(false);

let src = ref();
let selected = ref(false);

let model = reactive({
    myInfo: {},
    list: [[], [], []],
    currentList: [],
    activities: {}
})


onMounted(() => {
    load();
});

function dlgOkHandler(){
    showModal.value=false;
}

function showModalHandler(){
    showModal.value = true;
}

async function load() {
    let param = route.params.id;
    let response = await fetch(`http://localhost:8080/members/myprofile/${param}`);
    let json = await response.json();
    model.myInfo = json.member;
    model.list[0] = json.works;
    model.list[1] = json.likes;
    model.list[2] = json.collections;
    model.currentList = json.works;
    model.activities = json.activities;
}

function selectImage(e) {
    let fileSelector = e.target.nextElementSibling;
    fileSelector.click();
}

function changeImage(e) {
    selected.value = true;
    let file = e.target.files[0];
    src.value = URL.createObjectURL(file);
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
function profileUpdate() {
    isThis.value = true;
}

</script>
<template>
    <Header></Header>
    <main class="container">

        <section class="margin-right-5 profile">
            <h1 class="d-none">왼편 프로필 창</h1>
            <div class="profile-info">
                <img class="profile-img" src="/src/assets/images/proflie.svg" alt="마이프로필"
                    v-if="userDetails.profileSrc == null" />
                <img :src="'http://localhost:8080/profileImage/' + userDetails.profileSrc" class="profile-img" v-else />
                <div class="nickname">
                    {{ model.myInfo.nickname }}
                </div>
                <a :href="model.myInfo.url" class="url" :hash="false">{{ model.myInfo.url }}</a>
                <div>
                    <button class="btn btn-0 font-size-15 btn-height" @click.prevent="profileUpdate">프로필 편집</button>
                    <button class="d-none">팔로우</button>
                </div>
            </div>

            <div class="margin-top-10 margin-bottom-5 font-size-14">
                활동 정보
            </div>

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
                    <div class="margin-bottom-5 font-size-15 bold">{{ model.activities.following }}</div>
                    <div class="font-size-14 font-gray">팔로잉</div>
                </div>
                <div>
                    <div class="margin-bottom-5 font-size-15 bold">{{ model.activities.follower }}</div>
                    <div class="font-size-14 font-gray">팔로워</div>
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

    <div class="black-bg" v-if="isThis">
        <div class="white-bg">
            <h4> 기본정보</h4>
            <form>
                <div class="center">
                    <div class="margin-top-5 profile-select">
                        <img class="profile-img" src="/src/assets/images/proflie.svg" alt="마이프로필"
                            v-if="userDetails.profileSrc == null && !selected" @click.prevent="selectImage"/>
                        <img :src="'http://localhost:8080/profileImage/' + userDetails.profileSrc" class="profile-img"
                            v-else-if="userDetails.profileSrc != null && !selected" @click="selectImage"/>
                        <img :src=src class="profile-img"
                            v-else @click="selectImage"/>
                        <input type="file" class="d-none" @input="changeImage" />
                    </div>
                </div>
                <div class="flex-colum">
                    <div class="margin-top-4">
                        <span> 닉네임 변경</span>
                        <input class="input-text2" type="text" autocomplete="off">
                    </div>

                    <div class="margin-top-4">
                        <span> 비밀번호 변경</span>
                        <input class="input-text2" type="password" autocomplete="off">
                    </div>

                    <div class="margin-top-4">
                        <span> 비밀번호 확인</span>
                        <input class="input-text2" type="password" autocomplete="off">
                    </div>

                    <div class="margin-top-4">
                        <span> URL주소 변경</span>
                        <input class="input-text2" type="text" autocomplete="off">
                    </div>
                </div>
                <div class="margin-top-8 flex-row-between1">
                    <button class="btn-bye-bye" @click.prevent="showModalHandler">회원탈퇴</button>
                    <button class="btn-updateprofile">수정하기</button>
                </div>
            </form>
        </div>
    </div>
    <Modal :show="showModal" @ok="dlgOkHandler" type=2 title="진심으로 탈퇴요?"/>
</template>
<style scoped>
@import url("/src/assets/css/compoment/profile.css");
@import url("/src/assets/css/compoment/profileupdate.css");

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

.thumbnail:hover img {
    filter: brightness(80%);
}
</style>