<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
let email = ref('');
let nickname = ref('');
let router = useRouter();

async function signupHandler() {
    let form = document.querySelector("#form");
    let formData = new FormData(form);
    let response = await fetch("http://localhost:8080/user/signup", {
        method: "POST",
        body: formData
    });
    let json = await response.text();
    //회원 가입 성공하면 로그인 화면으로 이동 시키기
    if (json == "ok") {
        router.push("/login")
    }

}

</script>





<template>
    <div class="black-bg">
        <div class="white-bg">
            <header class="">
                <img src="/src/assets/images/Pofo.svg" alt="">
            </header>
            <form id="form">
                <div class="flex-colum line-text">이메일로 가입하기</div>
                <div class="margin-top-5">
                    <h6 class="margin-top-10">이메일주소</h6>
                    <input type="text" class="security-input-text" v-model="email" @input="" autocomplete="off"
                        name="email">
                    <button class="security-btn margin-top-2">인증</button>

                    <h6 class="margin-top-5">닉네임</h6>
                    <input type="text" class="security-input-text" v-model="nickname" autocomplete="off" name="nickname">
                    <button class="security-btn margin-top-2">인증</button>
                </div>
                <div class="margin-top-5">
                    <h6 class="margin-top-5">비밀번호</h6>
                    <input type="password" class="input-text1" placeholder="6자이상" autocomplete="off" name="password">
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