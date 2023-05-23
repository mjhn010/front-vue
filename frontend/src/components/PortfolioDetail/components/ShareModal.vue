<script setup>
const props = defineProps({
  portfolioThumbnail: {
    type: String,
    required: true,
  },
  portfolioTitle: {
    type: String,
    required: true,
  },
  nickname: {
    type: String,
    required: true,
  },
  show: {
    type: Boolean,
    default: false,
  }
});

const url = window.location.href;
const uri = encodeURI(encodeURIComponent(url));

function shareToNaver() {
  const title = encodeURI(props.portfolioTitle);
  const shareURL = "https://share.naver.com/web/shareView?url=" + uri + "&title=" + title;
  document.location = shareURL;
}

function copyLink() {
  navigator.clipboard.writeText(url);
}
</script>

<template>
  <div
    class="screen"
    :class="{ 'd-none': !show }"
  >
    <div class="h-96 w-96 rounded-lg border bg-white shadow-lg">
      <div class="flex h-16 items-center justify-between border-b p-3">
        <span class="block text-xl font-bold text-gray-800">
          포트폴리오 공유하기
        </span>
        <div
          class="x-mark-icon h-8 w-8 cursor-pointer bg-no-repeat opacity-75 hover:opacity-100"
          @click.prevent="$emit('ok')"
        />
      </div>
      <figure class="mx-4 flex items-center border-b border-dashed py-4">
        <img
          class="mr-4 h-14 w-14 rounded-lg object-cover object-center"
          :src="`http://localhost:8080/portfolio/thumbnails/${portfolioThumbnail}`"
          alt="Portfolio thumbnail"
        >
        <figcaption class="flex h-12 flex-col justify-between">
          <span
            class="text-sm text-gray-700 font-bold"
            v-text="portfolioTitle"
          />
          <span
            class="text-sm text-gray-500"
            v-text="nickname"
          />
        </figcaption>
      </figure>
      <nav class="mt-12 mb-10 grid grid-cols-3">
        <a
          class="flex flex-col items-center"
          :href="`https://twitter.com/intent/tweet?text=${uri}`"
        >
          <div class="absolute h-20 w-12 bg-twitter bg-no-repeat hover:opacity-75" />
          <span class="text-sm mt-14">트위터</span>
        </a>
        <div
          class="flex flex-col items-center cursor-pointer"
          @click.prevent="shareToNaver"
        >
          <div class="absolute h-12 w-12 bg-naver bg-cover bg-center hover:opacity-75" />
          <span class="text-sm mt-14">네이버</span>
        </div>
        <a
          class="flex flex-col items-center"
          href="https://twitter.com/intent/tweet?text=Hello%20world"
        >
          <div class="absolute block h-12 w-12 bg-kakao bg-cover hover:opacity-75" />
          <span class="text-sm mt-14">카카오</span>
        </a>
      </nav>

      <div class="flex h-8 w-full px-4">
        <div
          class="w-9/12 pl-2 cursor-default rounded-l-lg border border-r-0 bg-gray-50 p-1 text-xs text-gray-600 flex items-center"
          v-text="url"
        />
        <div class="w-3/12 cursor-pointer rounded-r-lg border p-1 flex justify-center items-center text-sm text-gray-700 hover:bg-blue-50">
          URL 복사
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
@import url("@/assets/css/tailwind.css");

.screen {
  background-color: rgba(0, 0, 0, 0.8);
  left: 0;
  top: 0;
  width: 100vw;
  height: 100vh;
  position: fixed;
  display: flex;
  align-items: center;
  justify-content: center;
}

.flex-row-between1 {
  display: flex;
  justify-content: space-between;
  width: 100%;
}

.center {
  text-align: center;
}

.d-none {
  display: none !important;
}

.check-btn {
  padding: 6px 25px;
  background-color: #000000;
  border-radius: 4px;
  /* 외곽선 없애기 */
  border: none;
  color: #fff;
  font-family: "Noto Sans KR", sans-serif;
}

.x-mark-icon {
  background-image: url("/src/assets/images/x-mark.svg");
}
</style>
