<script setup>
import {ref} from 'vue'; 
let email = ref('');
let nickname = ref('');
let password = ref('');




</script>





<template>
    <div class="black-bg">
        <div class="white-bg">
            <header class="">
                <img src="/src/assets/images/Pofo.svg" alt="">
            </header>
            <form>
                <div class="flex-colum line-text">이메일로 가입하기</div>
                <div class="margin-top-5">
                    <h6 class="margin-top-10">이메일주소</h6>
                    <input type="text" class="security-input-text" v-model="email" @input="">
                    <button class="security-btn margin-top-2">인증</button>
                    <h6 class="margin-top-5">닉네임</h6>
                    <input type="text" class="security-input-text" v-model="nickname">
                    <button class="security-btn margin-top-2">인증</button>
                </div>
                <div class="margin-top-5">
                    <h6 class="margin-top-5">비밀번호</h6>
                    <input type="password" class="input-text1" placeholder="6자이상" v-model="password">
                    <h6 class="margin-top-5">비밀번호확인</h6>
                    <input type="password" class="input-text1" placeholder="6자이상">
                </div>
            </form>
            <div class="flex-row-between1 margin-top-10">
                <button class="btn-back">이전</button>
                <button class="btn-next">다음</button>
            </div>
        </div>
    </div>
</template>
<style scoped>
@import url("/src/assets/css/compoment/signup.css");
</style>