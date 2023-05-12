<script setup>
import {ref} from "vue";

const commentBoxOpen = ref();
</script>

<template>
  <div
    class="comment-box fixed hidden overflow-y-auto rounded-lg border bg-white"
    :class="commentBoxOpen ? 'xl:block' : 'xl:hidden'"
  >
    <div class="mx-5 mt-7 grid grid-cols-7 gap-x-3 border-b pb-5">
      <div
        class="x-mark-icon absolute cursor-pointer"
        @click="toggleCommentBox"
      />
      <div class="col-span-7 flex h-16 flex-col justify-between">
        <h2
          class="text-md col-span-7 font-bold"
          v-text="state.portfolio.title"
        />
        <span class="col-span-7 mb-5 text-xs font-bold text-gray-500">
          UI/UX · 그래픽 디자인
        </span>
      </div>
      <div class="heart-icon mb-2 cursor-pointer" />
      <div class="collection-icon mb-2 ml-1 cursor-pointer border-2" />
      <div class="share-icon col-start-7 mb-2 cursor-pointer border-2" />
      <span class="col-span-2 my-5 font-bold">댓글(0)</span>
      <textarea
        class="col-span-7 mb-5 h-36 min-w-fit resize-none rounded-lg border border-black px-5 py-3 text-sm font-normal"
        placeholder="이 작업에 대한 댓글을 남겨주세요."
      />
      <button
        class="col-span-2 col-start-5 mr-1 flex h-9 items-center justify-center rounded-full border text-center text-sm font-semibold"
      >
        댓글 작성
      </button>
      <div
        class="col-start-7 flex cursor-pointer items-center justify-center rounded-full border text-sm font-semibold"
      >
        취소
      </div>
    </div>

    <!-- Comment component -->
    <div
      class="mx-5 border-t py-5"
      :key="comment.id"
      v-for="comment in state.comments"
    >
      <div class="grid grid-cols-7 grid-rows-2">
        <figure class="col-span-7 grid grid-cols-6 grid-rows-2">
          <a
            href="#"
            class="row-span-2"
          >
            <img
              class="h-12 w-12 rounded-full"
              :src="`/src/assets/images/temp/${comment.memberImage}`"
              alt="Profile image"
            >
          </a>
          <div
            class="col-start-2 font-bold"
            v-text="comment.memberNickname"
          />
          <div
            class="col-start-2 text-xs font-semibold text-gray-500"
            v-text="comment.regDate.substring(0, 10).replace(/-/g, '.')"
          />
        </figure>
        <p
          class="col-span-7 my-4 text-sm"
          v-text="comment.content"
        />
        <div class="col-span-2 cursor-pointer text-start text-xs text-gray-500">
          답글 남기기
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped></style>