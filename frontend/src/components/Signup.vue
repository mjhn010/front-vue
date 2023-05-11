<script setup>
import { ref, watch } from 'vue';
import { useRouter } from 'vue-router';


let email = ref('');
let nickname = ref('');
let router = useRouter();
let certiNum = ref();
let minutes = ref(2);
let seconds = ref(0);


let buttonText = ref('인증번호 전송');

// 이메일 입력 관련
let isDisabled = ref(false);

let isCountDownVisible = ref(false);
// 인증번호 일치 여부
let isNotEqual = ref(false);
// 인증번호 입력창 보이기 여부
let isVisible = ref(false);
// 이메일 인증 성공 여부
let resultOfCertification = ref(false);

let nickNameCount = ref();

watch(nickname, ()=>{
    if(nickname.value.length===0){
        nickNameCount = ref();
    }
})



async function signupHandler() {
    let form = document.querySelector("#form");
    let formData = new FormData(form);
    let response = await fetch("http://localhost:8080/user/signup", {
        method: "POST",
        body: formData
    });
    let result = await response.text();

    if (result == "ok") {
        router.push("/login");
    }
}

async function sendEmail() {
    buttonText.value = '전송 중'
    isDisabled.value = true;
    let response = await fetch(`http://localhost:8080/email/sendemail?email=${email.value}`);
    let result = await response.text();
    if (result) {
        buttonText.value = '전송 완료';
        isVisible.value = true;
    } else {
        isDisabled.value = true;
        buttonText.value = '인증번호 전송';
    }
}

async function checkNum() {
    let response = await fetch(`http://localhost:8080/email/check?certificationnum=${certiNum.value}&email=${email.value}`);
    let result = await response.text();
    console.log(result)
    if (result == 'ok') {
        buttonText.value = '인증 성공';
        isVisible.value = false;
        resultOfCertification.value = true;
    } else {
        isNotEqual.value = true;
    }
}

async function checkNickname() {
    let response = await fetch(`http://localhost:8080/user/nicknamecheck?nickname=${nickname.value}`);
    let result = await response.text();
    if (result == 'ok') {
        nickNameCount.value = 0;
    } else {
        nickNameCount.value = 1;
    }
}



</script>

<template>
    <div class="black-bg">
        <div class="white-bg">
            <header class="">
                <router-link to="/index"><img src="/src/assets/images/pofo.svg" class="logo-img"></router-link>
            </header>
            <form id="form">
                <div class="flex-colum line-text">이메일로 가입하기</div>
                <div class="margin-top-5">
                    <h6 class="margin-top-10">이메일주소</h6>
                    <input type="text" class="security-input-text" v-model="email" @input="" autocomplete="off" name="email"
                        :readonly="isDisabled">
                    <button class="security-btn margin-top-2" @click.prevent="sendEmail" :disabled="isDisabled">{{
                        buttonText }}</button>
                    <span class="margin-top-1 green" v-if="resultOfCertification">이메일 인증에 성공하셨습니다.</span>

                    <div v-if="isVisible">
                        <h6 class="margin-top-5">이메일 인증</h6>
                        <input type="text" class="security-input-text" v-model="certiNum">
                        <button class="security-btn margin-top-2" @click.prevent="checkNum">인증하기</button>
                        <span class="margin-top-1 red" v-if="isNotEqual">인증번호가 다릅니다.</span>
                    </div>

                    <h6 class="margin-top-5">닉네임</h6>
                    <input type="text" class="security-input-text" v-model="nickname" autocomplete="off" name="nickname">
                    <button class="security-btn margin-top-2" @click.prevent="checkNickname">중복 확인</button>
                    <span class="margin-top-1 red" v-if="nickNameCount==1">닉네임이 중복됩니다.</span>
                    <span class="margin-top-1 green" v-if="nickNameCount==0">사용가능한 닉네임입니다.</span>
                </div>

                <div class="margin-top-5">
                    <h6 class="margin-top-5">비밀번호</h6>
                    <input type="password" class="input-text1" placeholder="6자이상" autocomplete="off" name="pwd">
                    <h6 class="margin-top-5">비밀번호확인</h6>
                    <input type="password" class="input-text1" placeholder="6자이상" autocomplete="off">
                    <h6 class="margin-top-5">URL 추가</h6>
                    <input type="text" class="input-text1" name="url">

                </div>
            </form>
            <div class="flex-row-between1 margin-top-10">
                <button class="btn-back">이전화면</button>
                <button class="btn-next" @click="signupHandler">회원가입</button>
            </div>
        </div>
    </div>
</template>
<style scoped>
@import url("/src/assets/css/compoment/signup.css");
</style>