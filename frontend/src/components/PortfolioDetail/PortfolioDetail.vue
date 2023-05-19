<script setup>
import { onMounted, reactive, ref } from "vue";
import { useUserDetailsStore } from "@/stores/useUserDetailsStore";
import {onBeforeRouteUpdate} from "vue-router";

// Components
import Modal from "@/components/Modal.vue";
import Header from "../Header.vue";

// Mock data
const portfolioCopyright = [
  { name: "cc" },
  { name: "by" },
  { name: "nc" },
  { name: "nd" },
];

// Modal
let showModal = ref(false);

//모달 끄기
function dlgOkHandler() {
  showModal.value = false;
}

// Data
const portfolioId = ref(window.location.hash.split("/")[2]);
const onCommentBoxOpen = ref(false);
const state = reactive({
  member: {},
  portfolio: {},
  contents: [],
  skills: [],
  more: [],
  comments: [],
  likes: [],
  bookmarks: [],
  reports: [],
  onLiked: false,
  onBookmarked: false,
  onReported: false,
  isMine: false,
});

async function checkMine() {
  if (state.member.id === useUserDetailsStore().id) {
    state.isMine = true;
  } else {
    state.isMine = false;
  }
}

function copyLink() {
  const url = window.location.href;
  navigator.clipboard.writeText(url);
  alert("링크가 복사되었습니다.");
}

function scrollToTop() {
  window.scrollTo(0, 0);
}

function toggleCommentBox() {
  onCommentBoxOpen.value = !onCommentBoxOpen.value;

  const scrollContainer = document.querySelector(".scroll-container");
  if (onCommentBoxOpen.value) {
    scrollContainer.scrollLeft += 12;
  } else {
    scrollContainer.scrollLeft -= 12;
  }
}

function contentToHTML(item) {
  if (item.type === "0") {
    return item.content;
  } else if (item.type === "1") {
    return `<img class="mb-12 w-fit" src="http://localhost:8080/portfolio/contents/${item.content}" alt="Content image"/>`;
  }
}

function scrollLeft() {
  const scrollContainer = document.querySelector(".scroll-container");
  if (onCommentBoxOpen.value) {
    scrollContainer.scrollLeft -= 336;
  } else scrollContainer.scrollLeft -= 323.3;
}

function scrollRight() {
  const scrollContainer = document.querySelector(".scroll-container");
  if (onCommentBoxOpen.value) {
    scrollContainer.scrollLeft += 336;
  } else scrollContainer.scrollLeft += 323.3;
}

async function scrollReset() {
  const scrollContainer = document.querySelector(".scroll-container");
  scrollContainer.scrollLeft = 0;
}

// Data
async function getData() {
  fetch(`http://localhost:8080/pofo/${portfolioId.value}`)
    .then((res) => res.json())
    .then((data) => {
      state.portfolio = data.portfolio;
      state.member = data.member;
    })
    .catch((error) => {
      console.error("Error:", error);
    });

  fetch(`http://localhost:8080/pofo/${portfolioId.value}/contents`)
    .then((res) => res.json())
    .then((data) => {
      state.contents = data;
    })
    .catch((error) => {
      console.error("Error:", error);
    });

  fetch(`http://localhost:8080/pofo/${portfolioId.value}/comments`)
    .then((res) => res.json())
    .then((data) => {
      state.comments = data;
    })
    .catch((error) => {
      console.error("Error:", error);
    });

  fetch(`http://localhost:8080/pofo/${portfolioId.value}/likes`)
    .then((res) => res.json())
    .then((data) => {
      state.likes = data;
    })
    .then(checkLikes)
    .catch((error) => {
      console.error("Error:", error);
    });

  fetch(`http://localhost:8080/pofo/${portfolioId.value}/bookmarks`)
    .then((res) => res.json())
    .then((data) => {
      state.bookmarks = data;
    })
    .then(checkBookmarks)
    .catch((error) => {
      console.error("Error:", error);
    });

  fetch(`http://localhost:8080/pofo/${portfolioId.value}/reports`)
    .then((res) => res.json())
    .then((data) => {
      state.reports = data;
    })
    .then(checkReports)
    .then(checkMine)
    .catch((error) => {
      console.error("Error:", error);
    });

  fetch(`http://localhost:8080/pofo/${portfolioId.value}/more`)
      .then((res) => res.json())
      .then((data) => {
        state.more = data;
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  fetch(`http://localhost:8080/pofo/${portfolioId.value}/skills`)
      .then((res) => res.json())
      .then((data) => {
        state.skills = data;
      })
      .catch((error) => {
        console.error("Error:", error);
      });
}

// Like
function toggleLike() {
  if (!useUserDetailsStore().id) {
    return (showModal.value = true);
  }

  if (!state.onLiked) {
    saveLike();
    return (state.onLiked = true);
  } else {
    deleteLikes();
    return (state.onLiked = false);
  }
}

async function checkLikes() {
  state.likes.forEach((like) => {
    if (like.memberId === useUserDetailsStore().id) {
      return (state.onLiked = true);
    } else {
      return (state.onLiked = false);
    }
  });
}

async function saveLike() {


  const like = {
    memberId: useUserDetailsStore().id,
    portfolioId: portfolioId.value,
  };

  return fetch(`http://localhost:8080/pofo/${portfolioId.value}/likes`, {
    mode: "cors",
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(like),
  })
    .catch((error) => {
      console.error("Error:", error);
    })
    .finally(() => {
      getData();
    });
}

async function deleteLikes() {
  const like = {
    memberId: useUserDetailsStore().id,
    portfolioId: portfolioId.value,
  };

  return fetch(`http://localhost:8080/pofo/${portfolioId.value}/likes`, {
    mode: "cors",
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(like),
  })
    .catch((error) => {
      console.error("Error:", error);
    })
    .finally(() => {
      getData();
    });
}

// Comment
function saveComment() {
  if (!useUserDetailsStore().id) {
    return (showModal.value = true);
  } else if (!document.querySelector("#comment-input").value) {
    return alert("댓글을 입력해주세요.");
  } else {
    const comment = {
      memberId: useUserDetailsStore().id,
      portfolioId: portfolioId.value,
      content: document.querySelector("#comment-input").value,
    };

    return fetch(`http://localhost:8080/pofo/${portfolioId.value}/comments`, {
      mode: "cors",
      method: "POST",
      headers: {
        "Content-type": "application/json",
      },
      body: JSON.stringify(comment),
    })
      .catch((error) => {
        console.error("Error:", error);
      })
      .finally(getData);
  }
}

// Bookmark
function toggleBookmark() {
  if (!useUserDetailsStore().id) {
    return (showModal.value = true);
  }

  if (!state.onBookmarked) {
    postBookmark();
    return (state.onBookmarked = true);
  } else {
    deleteBookmark();
    return (state.onBookmarked = false);
  }
}

async function checkBookmarks() {
  state.bookmarks.forEach((bookmark) => {
    if (bookmark.memberId === useUserDetailsStore().id) {
      return (state.onBookmarked = true);
    } else {
      return (state.onBookmarked = false);
    }
  });
}

function postBookmark() {


  const bookmark = {
    portfolioId: portfolioId.value,
    memberId: useUserDetailsStore().id,
  };

  return fetch(`http://localhost:8080/pofo/${portfolioId.value}/bookmarks`, {
    mode: "cors",
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(bookmark),
  })
    .catch((error) => {
      console.error("Error:", error);
    })
    .finally(getData);
}

function deleteBookmark() {


  const bookmark = {
    portfolioId: portfolioId.value,
    memberId: useUserDetailsStore().id,
  };

  return fetch(`http://localhost:8080/pofo/${portfolioId.value}/bookmarks`, {
    mode: "cors",
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(bookmark),
  })
    .catch((error) => {
      console.error("Error:", error);
    })
    .finally(getData);
}

// Report
function toggleReport() {
  if (!useUserDetailsStore().id) {
    return (showModal.value = true);
  }

  if (!state.onReported) {
    postReport();
    return (state.onReported = true);
  } else {
    deleteReport();
    return (state.onReported = false);
  }
}

async function checkReports() {
  state.reports.forEach((report) => {
    if (report.memberId === useUserDetailsStore().id) {
      return (state.onReported = true);
    } else {
      return (state.onReported = false);
    }
  });
}

function postReport() {

  const url = `http://localhost:8080/pofo/${portfolioId.value}/reports`;

  const report = {
    memberId: useUserDetailsStore().id,
    portfolioId: portfolioId.value,
  };

  return fetch(url, {
    mode: "cors",
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(report),
  })
    .catch((error) => {
      console.error("Error:", error);
    })
    .finally(getData);
}

function deleteReport() {

  const url = `http://localhost:8080/pofo/${portfolioId.value}/reports`;

  const report = {
    memberId: useUserDetailsStore().id,
    portfolioId: portfolioId.value,
  };

  return fetch(url, {
    mode: "cors",
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(report),
  })
    .catch((error) => {
      console.error("Error:", error);
    })
    .finally(getData);
}

// Lifecycle
onMounted(()=>{
  getData();
});

onBeforeRouteUpdate((to, from, next) => {
  if (to.params.portfolioId !== from.params.portfolioId) {
    portfolioId.value = to.params.portfolioId;
    scrollToTop();
    scrollReset();
    getData();
  }
  next();
});
</script>

<template>
  <Header />
  <Modal
    :show="showModal"
    @ok="dlgOkHandler"
    type="0"
    title="로그인이 필요한 기능입니다."
    style="z-index: 1"
  />
  <div
    class="absolute min-h-full w-full gap-y-2 bg-gray-50 xl:grid xl:grid-cols-12 xl:px-16 xl:pb-8 xl:pt-12"
  >
    <div
      class="w-full bg-white pb-4 xl:ml-36 xl:rounded-lg xl:border"
      :class="onCommentBoxOpen ? 'xl:col-span-7' : 'xl:col-span-9'"
    >
      <!-- Profile -->
      <figure class="flex p-6">
        <router-link
          :to="
            state.isMine
              ? `/member/profile/${state.member.id}`
              : `/profile/${state.member.id}`
          "
        >
          <img
            class="mr-4 mt-2 h-12 w-12 cursor-pointer rounded-full duration-300 hover:opacity-50"
            :src="`http://localhost:8080/profileImage/${state.member.image}`"
            alt="Profile image"
            @click="scrollToTop"
          >
        </router-link>

        <figcaption class="flex cursor-default flex-col justify-evenly">
          <h1
            class="text-sm font-bold sm:text-2xl"
            v-text="state.portfolio.title"
          />
          <div>
            <router-link
              :to="
                state.isMine
                  ? `/member/profile/${state.member.id}`
                  : `/profile/${state.member.id}`
              "
            >
              <span
                class="cursor-pointer text-xs font-semibold hover:text-gray-500 sm:text-lg"
                v-text="state.member.nickname"
              />
            </router-link>
            <span class="text-xs sm:text-lg">ᆞ</span>
            <span
              class="cursor-pointer text-xs font-semibold hover:text-gray-500 sm:text-lg"
              @click="toggleCommentBox"
            >팔로우</span>
          </div>
        </figcaption>
      </figure>

      <!-- Main -->
      <main>
        <template
          :key="content.id"
          v-for="content in state.contents"
        >
          <div v-html="contentToHTML(content)" />
        </template>
      </main>

      <!-- SkillTags and Copyright bar -->
      <div
        class="flex flex-col-reverse justify-between px-5 sm:flex-row sm:px-10 sm:pb-12 xl:py-10"
      >
        <!-- SkillTags -->
        <nav class="flex gap-x-2 py-3 text-xs sm:px-0">
          <router-link
            v-for="skill in state.skills"
            :key="skill.id"
            :to="`/search?text=${skill.engName.toLowerCase()}`"
          >
            <div
              class="block w-fit cursor-pointer rounded-full border px-3 py-1 font-semibold text-gray-600 hover:bg-blue-50"
              v-text="skill.engName"
            />
          </router-link>
        </nav>
        <!-- Copyright -->
        <div class="w- flex items-center gap-x-1 hover:cursor-pointer">
          <img
            :src="`/src/assets/images/${copyright.name}.svg`"
            alt="copyright"
            class="h-6 w-6"
            :key="copyright.name"
            v-for="copyright in portfolioCopyright"
          >
        </div>
      </div>
      <!-- Banner -->
      <div
        class="flex h-48 flex-col items-center justify-between bg-gray-950 py-9 sm:py-10"
        :class="state.portfolio.awardDate ? 'sm:h-64' : 'sm:h-56'"
      >
        <div class="flex w-32 justify-evenly">
          <div
            class="mb-2 flex h-12 w-12 cursor-pointer flex-col items-center justify-center rounded-full"
            :class="
              state.onLiked ? 'bg-gray-800 hover:bg-gray-900' : 'bg-white'
            "
            @click="toggleLike"
          >
            <div
              class="absolute flex h-12 w-12 items-center justify-center hover:animate-pulse"
            >
              <div
                class="bg-heart bg-center bg-no-repeat"
                :class="state.onLiked ? 'mb-4 mt-1 h-4 w-4' : 'h-6 w-6'"
              />
            </div>
            <span
              class="mt-4 text-xs font-bold text-white"
              :class="state.onLiked ? 'bottom-0.5 block' : 'bottom-0.5 hidden'"
              v-text="state.likes.length"
            />
          </div>
          <div
            class="collection-icon mb-2 cursor-pointer rounded-full border-2 duration-300 hover:bg-blue-50"
            :class="
              state.onBookmarked ? 'bg-gray-300 hover:bg-gray-400' : 'bg-white'
            "
            @click="toggleBookmark"
          />
        </div>
        <span
          class="text-sm font-bold text-blue-300"
          v-if="state.portfolio.awardDate != null"
        >POFO PICK 선정</span>
        <span
          class="text-lg font-bold text-white sm:text-xl"
          v-text="state.portfolio.title"
        />
        <span
          class="text-xs font-semibold text-white sm:text-sm"
          v-if="state.portfolio.awardDate != null"
          v-text="
            `${state.portfolio.awardDate
              .substring(0, 10)
              .replace(/-/g, '.')} | 그래픽 디자인 · UI/UX`
          "
        />
        <span
          class="text-xs font-semibold text-white sm:text-sm"
          v-else
        >
          그래픽 디자인 · UI/UX
        </span>
        <span></span>
      </div>

      <!-- Member's portfolio list bar -->
      <div class="flex justify-between px-7 py-6">
        <span class="block font-semibold text-gray-900">모든 작업 목록</span>
        <router-link
          :to="
            state.isMine
              ? `/member/profile/${state.member.id}`
              : `/profile/${state.member.id}`
          "
          @click="scrollToTop"
          class="flex items-center justify-end"
        >
          <span class="block text-sm font-semibold text-gray-500">프로필 자세히 보기</span>
          <img
            src="/src/assets/images/chevron-right.svg"
            alt="Chevron right icon"
            class="h-4 w-4 opacity-50 mt-0.5"
          >
        </router-link>
      </div>

      <!-- Member's portfolio list -->
      <div class="w-full">
        <div
          class="scroll-container scrollbar-hide flex h-60 overflow-x-scroll scroll-smooth"
          :class="onCommentBoxOpen ? 'ml-8 mr-10 gap-x-12' : ' mx-8 gap-x-9'"
        >
          <figure
            class="h-48 w-96 cursor-pointer"
            :key="morePortfolio.id"
            v-for="morePortfolio in state.more"
          >
            <router-link
              :to="`/pofo/${morePortfolio.id}`"
            >
              <img
                :src="`http://localhost:8080/portfolio/thumbnails/${morePortfolio.thumbnail}`"
                alt="#"
                class="h-full w-72 rounded-t-lg"
              >
              <figcaption
                class="w-72 rounded-b-lg bg-gray-950 px-5 text-sm font-bold text-white"
                v-text="morePortfolio.title"
              />
            </router-link>
          </figure>
        </div>

        <!-- Scroll buttons -->
        <div class="relative bottom-40 flex h-0 w-full justify-between px-4">
          <div
            class="chevron-left-icon cursor-pointer border bg-white shadow-lg hover:bg-blue-50 hover:duration-300"
            @click="scrollLeft"
          />
          <div
            class="chevron-right-icon col-start-12 cursor-pointer justify-self-center border bg-white shadow-lg hover:bg-blue-50 hover:duration-300"
            :class="onCommentBoxOpen ? 'mr-3' : 'mr-0'"
            @click="scrollRight"
          />
        </div>
      </div>
    </div>

    <!-- Sidebar -->
    <div
      class="sidebar fixed hidden flex-col text-xs"
      :class="onCommentBoxOpen ? 'xl:hidden' : 'xl:block'"
    >
      <figure class="">
        <router-link
          :to="
            state.isMine
              ? `/member/profile/${state.member.id}`
              : `/profile/${state.member.id}`
          "
          class="flex justify-center"
          @click="scrollToTop"
        >
          <img
            class="mb-2 h-12 w-12 rounded-full border-2"
            src="/src/assets/images/temp/d.bronze.jpg"
            alt="Profile image"
          >
        </router-link>

        <figcaption class="block text-center text-sm font-bold">
          프로필
        </figcaption>
      </figure>
      <div
        class="my-6 flex flex-col items-center text-center text-sm font-bold"
      >
        <div
          class="mb-2 flex h-12 w-12 cursor-pointer flex-col items-center justify-center rounded-full border-2"
          :class="state.onLiked ? 'bg-gray-800 hover:bg-gray-900' : 'bg-white'"
          @click="toggleLike"
        >
          <div
            class="absolute flex h-12 w-12 items-center justify-center hover:animate-pulse"
          >
            <div
              class="bg-heart bg-center bg-no-repeat"
              :class="state.onLiked ? 'mb-4 mt-1 h-4 w-4' : 'h-6 w-6'"
            />
          </div>
          <span
            class="mt-4 text-xs font-bold text-white"
            :class="state.onLiked ? 'bottom-0.5 block' : 'bottom-0.5 hidden'"
            v-text="state.likes.length"
          />
        </div>
        좋아요
      </div>
      <div
        class="my-6 flex flex-col items-center text-center text-sm font-bold"
      >
        <div
          class="collection-icon mb-2 cursor-pointer rounded-full border-2 duration-300 hover:bg-blue-50"
          :class="
            state.onBookmarked ? 'bg-gray-300 hover:bg-gray-400' : 'bg-white'
          "
          @click="toggleBookmark"
        />
        북마크
      </div>
      <div
        class="my-6 flex flex-col items-center text-center text-sm font-bold"
      >
        <div
          class="comment-icon mb-2 cursor-pointer rounded-full border-2 bg-white duration-300 hover:bg-blue-50"
          @click="toggleCommentBox"
        />
        댓글
      </div>
      <div
        class="my-6 flex flex-col items-center text-center text-sm font-bold"
      >
        <div
          class="share-icon mb-2 cursor-pointer rounded-full border-2 bg-white duration-300 hover:bg-blue-50"
          @click="copyLink"
        />
        공유하기
      </div>
      <div
        class="my-6 flex flex-col items-center text-center text-sm font-bold"
      >
        <div
          class="mb-2 flex h-12 w-12 cursor-pointer items-center justify-center rounded-full border-2 duration-300 hover:bg-blue-50"
          :class="
            state.onReported ? 'bg-gray-300 hover:bg-gray-400' : 'bg-white'
          "
          @click="toggleReport"
        >
          <div class="h-7 w-7 bg-fire" />
        </div>
        신고하기
      </div>
    </div>

    <!-- Comment box -->
    <div
      class="comment-box fixed hidden overflow-y-auto rounded-lg border bg-white"
      :class="onCommentBoxOpen ? 'xl:block' : 'xl:hidden'"
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
        <div
          class="mb-2 flex h-12 w-12 cursor-pointer flex-col items-center justify-center rounded-full border-2"
          :class="state.onLiked ? 'bg-gray-800 hover:bg-gray-900' : 'bg-white'"
          @click="toggleLike"
        >
          <div
            class="absolute flex h-12 w-12 items-center justify-center hover:animate-pulse"
          >
            <div
              class="bg-heart bg-center bg-no-repeat"
              :class="state.onLiked ? 'mb-4 mt-1 h-4 w-4' : 'h-6 w-6'"
            />
          </div>
          <span
            class="mt-4 text-xs font-bold text-white"
            :class="state.onLiked ? 'bottom-0.5 block' : 'bottom-0.5 hidden'"
            v-text="state.likes.length"
          />
        </div>
        <div
          class="collection-icon mb-2 cursor-pointer rounded-full border-2 duration-300 hover:bg-blue-50"
          :class="
            state.onBookmarked ? 'bg-gray-300 hover:bg-gray-400' : 'bg-white'
          "
          @click="toggleBookmark"
        />
        <div
          class="share-icon col-start-7 mb-2 cursor-pointer rounded-full border-2 bg-white duration-300 hover:bg-blue-50"
          @click="copyLink"
        />
        <span
          class="col-span-2 my-5 font-bold"
          v-text="`댓글(${state.comments.length})`"
        />
        <textarea
          id="comment-input"
          class="col-span-7 mb-5 h-36 min-w-fit resize-none rounded-lg border border-black px-5 py-3 text-sm font-normal"
          placeholder="이 작업에 대한 댓글을 남겨주세요."
        />
        <button
          class="col-span-2 col-start-5 mr-1 flex h-9 items-center justify-center rounded-full border text-center text-sm font-semibold"
          @click="saveComment"
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
            <router-link
              class="h-0"
              :to="
                state.isMine
                  ? `/member/profile/${comment.memberId}`
                  : `/profile/${comment.memberId}`
              "
            >
              <img
                class="h-12 w-12 rounded-full"
                :src="`/src/assets/images/temp/${comment.memberImage}`"
                alt="Profile image"
              >
            </router-link>
            <router-link
              class="h-0"
              :to="`/profile/${comment.memberId}`"
            >
              <div
                class="col-start-2 font-bold hover:text-gray-600"
                v-text="comment.memberNickname"
              />
            </router-link>
            <div
              class="col-start-2 text-xs font-semibold text-gray-500"
              v-text="comment.regDate.substring(0, 10).replace(/-/g, '.')"
            />
          </figure>
          <p
            class="col-span-7 my-4 text-sm"
            v-text="comment.content"
          />
          <div
            class="col-span-2 cursor-pointer text-start text-xs text-gray-500"
          >
            답글 남기기
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
@import url("/src/assets/css/tailwind.css");

main:deep(img) {
  @apply mb-12 h-1/5 w-full;
}

main:deep(h2) {
  @apply mx-6 xl:mx-12 text-lg font-bold sm:text-2xl;
}

main:deep(p) {
  @apply mx-6 xl:mx-12 my-8 text-xs sm:text-base;
}

.sidebar {
  margin-left: 80%;
}

.comment-box {
  width: 26rem;
  height: 85.9%;
  margin-left: 63.8%;
}

.chevron-left-icon {
  width: 48px;
  height: 48px;
  background-image: url("/src/assets/images/chevron-left.svg");
  background-position: center;
  background-size: 50%;
  background-repeat: no-repeat;
  border-radius: 100%;
}

.chevron-right-icon {
  width: 48px;
  height: 48px;
  background-image: url("/src/assets/images/chevron-right.svg");
  background-position: center;
  background-size: 50%;
  background-repeat: no-repeat;
  border-radius: 100%;
  right: 23.7rem;
}

.collection-icon {
  width: 48px;
  height: 48px;
  background-image: url("/src/assets/images/folder.svg");
  background-position: center;
  background-size: 50%;
  background-repeat: no-repeat;
  border-radius: 100%;
}

.comment-icon {
  width: 48px;
  height: 48px;
  background-image: url("/src/assets/images/chat-bubble-left.svg");
  background-position: center;
  background-size: 50%;
  background-repeat: no-repeat;
}

.share-icon {
  width: 48px;
  height: 48px;
  background-image: url("/src/assets/images/share-icon.svg");
  background-position: center;
  background-size: 50%;
  background-repeat: no-repeat;
  border-radius: 100%;
}

.x-mark-icon {
  width: 28px;
  height: 28px;
  margin-left: 82%;
  margin-top: -1%;
  background-image: url("/src/assets/images/x-mark.svg");
}

/* For Webkit-based browsers (Chrome, Safari and Opera) */
.scrollbar-hide::-webkit-scrollbar {
  display: none;
}

/* For IE, Edge and Firefox */
.scrollbar-hide {
  -ms-overflow-style: none; /* IE and Edge */
  scrollbar-width: none; /* Firefox */
}
</style>