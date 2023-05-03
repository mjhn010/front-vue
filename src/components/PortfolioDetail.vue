<script setup>
import { ref } from "vue";

// Mock data
const member = { nickname: "D.BRONZE", image: "d.bronze.jpg" };
const portfolio = {
  id: "1",
  title: "COMMAX IoT Smart Home Display UI/UX",
  awardDate: "2023.03.24",
};
const usedSkills = [
  { engName: "HTML" },
  { engName: "CSS" },
  { engName: "JavaScript" },
];
const portfolioCopyright = [
  { name: "cc" },
  { name: "by" },
  { name: "nc" },
  { name: "nd" },
];
const portfolios = [
  { id: 2, title: "포트폴리오2", thumbnail: "aurora-over-iceland.png" },
  { id: 3, title: "포트폴리오3", thumbnail: "calm.jpg" },
  { id: 4, title: "포트폴리오4", thumbnail: "cherryblossom.jpg" },
  { id: 5, title: "포트폴리오5", thumbnail: "corn.jpg" },
  { id: 6, title: "포트폴리오6", thumbnail: "aurora-over-iceland.png" },
  { id: 7, title: "포트폴리오7", thumbnail: "himalayan-desert-mountains.jpg" },
  { id: 8, title: "포트폴리오8", thumbnail: "calm.jpg" },
  { id: 9, title: "포트폴리오9", thumbnail: "cherryblossom.jpg" },
  { id: 10, title: "포트폴리오10", thumbnail: "corn.jpg" },
  { id: 11, title: "포트폴리오11", thumbnail: "aurora-over-iceland.png" },
];
const contents = [
  {
    content: "aurora-over-iceland.png",
    type: "1",
    orders: "1",
  },
  {
    content:
      '<section class="mb-12 px-6 xl:px-12">\n' +
      '          <h2 class="text-lg font-bold">\n' +
      "            IoT Device Smart Home Display UI | UX Design\n" +
      "          </h2>\n" +
      '          <p class="my-4 text-xs">\n' +
      "            코맥스는 인터폰부터 비디오폰, 스마트홈 시스템과 시큐리티 솔루션 등\n" +
      "            앞선 기술력과 차별화된 제품은 물론 고객이 누려야 할 삶의 안전과\n" +
      "            가치를 위한 다양한 서비스&플랫폼을 제공하는 A.I HOME 전문\n" +
      "            기업입니다.\n" +
      "          </p>\n" +
      '          <p class="my-4 text-xs">\n' +
      "            COMMAX is a specialized A.I home company that offers a variety of\n" +
      "            services and platforms to enhance the safety and value of customers'\n" +
      "            lives. The company's products are differentiated by advanced\n" +
      "            technologies, such as interphones, video phones, smart home systems,\n" +
      "            and security solutions.\n" +
      "          </p>\n" +
      "        </section>",
    type: "0",
    orders: "2",
  },
  {
    content: "cherryblossom.jpg",
    type: "1",
    orders: "3",
  },
  {
    content:
      '<section class="mb-12 px-6 xl:px-12">\n' +
      '          <h2 class="text-lg font-bold">UX | UI planning approach</h2>\n' +
      '          <p class="my-4 text-xs">\n' +
      "            사용자들이 WallPad에서 제공되는 정보를 쉽게 파악할 수 있도록\n" +
      "            백그라운드를 활용하는 방법을 사용하였습니다. Home Screen에서 Control\n" +
      "            Window 전환은 상세 조작이 가능한 화면으로 진입해 있다는 인식을 Depth\n" +
      "            발생을 통해 인지하도록 구현하였습니다. 더 세밀한 조작을 위한 Second\n" +
      "            Control Window는 Modal Window에 Dialog UI로 구성을 하였습니다. 이는\n" +
      "            상세 조작을 위해 한 단계 더 깊이 들어가는 Depth를 사용자가 느끼지\n" +
      "            못하게 하기 위해 Modal Window로 플래닝을 하였으며, 언제든 Home\n" +
      "            Screen으로 빠져나갈 수 있습니다. UI | UX 또한 코맥스만의 시각적인\n" +
      "            일관성을 보여주기 위한 플래닝으로 디자인 하였습니다.\n" +
      "          </p>\n" +
      '          <p class="my-4 text-xs">\n' +
      "            We utilized the background to enable users to easily understand the\n" +
      "            information provided on the WallPad. To help users recognize the\n" +
      "            transition from the Home Screen to the Control Window, we\n" +
      "            implemented Depth perception. The Second Control Window, which\n" +
      "            allows for more detailed operations, was designed as a Modal Window\n" +
      "            with a Dialog UI. This was planned as a Modal Window to prevent\n" +
      "            users from feeling the additional Depth required for more detailed\n" +
      "            operations, and users can return to the Home Screen at any time. The\n" +
      "            UI/UX was also designed with planning to show COMMAX's visual\n" +
      "            consistency.\n" +
      "          </p>\n" +
      "        </section>",
    type: "0",
    orders: "4",
  },
  {
    content: "corn.jpg",
    type: "1",
    orders: "5",
  },
  {
    content:
      '<section class="mb-12 px-6 xl:px-12">\n' +
      '          <h2 class="text-lg font-bold">Acrylic Fluent Design</h2>\n' +
      '          <p class="my-4 text-xs">\n' +
      "            다중 레이어 방식으로 백그라운드에 표현되는 날씨 정보나 컬러를 통해\n" +
      "            정확하게 화면을 보지 않더라도 정보를 인지할 수 있도록 하였습니다.\n" +
      "            자세한 정보가 표시되는 상태 정보창은 Opacity 퍼센트의 변화를 주어\n" +
      "            배경과 정보창의 분리를 통해 가독성을 높이고 명확한 정보인식을 할 수\n" +
      "            있도록 하였습니다.\n" +
      "          </p>\n" +
      '          <p class="my-4 text-xs">\n' +
      "            We used a multi-layered approach to display weather information or\n" +
      "            colors on the background, allowing users to perceive information\n" +
      "            accurately without looking at the screen carefully. The status\n" +
      "            information window, which displays detailed information, was\n" +
      "            designed to increase readability and enable clear information\n" +
      "            recognition by changing the Opacity percentage to separate the\n" +
      "            background and the information window.\n" +
      "          </p>\n" +
      "        </section>",
    type: "0",
    orders: "6",
  },
  {
    content: "dandelion.jpg",
    type: "1",
    orders: "7",
  },
  {
    content:
      '<section class="mb-12 px-6 xl:px-12">\n' +
      '          <h2 class="text-lg font-bold">COMMAX UI | UX Design Plan</h2>\n' +
      '          <p class="my-4 text-xs">\n' +
      "            출근 전 시간 확인 또는 우산을 챙겨야 하는지 알기 위해 날씨 확인,\n" +
      "            미세먼지 확인, 그리고 집안의 전열기구 등의 현재 사용량을 파악 확인\n" +
      "            등, 사용자의 WallPad 사용목적을 정확하게 파악한 후 이에 적합한\n" +
      "            디자인 플랜을 계획하였습니다. 바쁜 일상생활 속에서 WallPad는 빠르고\n" +
      "            정확하게 정보 확인이 가능하여야 합니다. WallPad에 집중하지 않더라도\n" +
      "            표현되는 정보를 쉽게 파악할 수 있도록 하기 위해 컬러를 이용한 사용자\n" +
      "            인지 반응 시간을 단축시켰습니다. 긍정의 정보 표현은 하늘색에서\n" +
      "            연두색으로 표현, 위험 또는 조심의 정보 표현은 분홍에서 보라색으로\n" +
      "            표현하여 사용자들이 쉽게 인지할 수 있도록 하였으며, 톤 다운된\n" +
      "            백그라운드 컬러를 사용하여 컬러 대비 값을 높이는 방법을 채택, 더\n" +
      "            인지 반응 시간을 단축시켰습니다.\n" +
      "          </p>\n" +
      '          <p class="my-4 text-xs">\n' +
      "            We planned a suitable design plan after accurately understanding the\n" +
      "            user's purpose of using WallPad, such as checking the time before\n" +
      "            going to work, checking the weather and fine dust, and checking the\n" +
      "            current usage of home heating appliances to see if an umbrella needs\n" +
      "            to be taken. In busy daily life, WallPad needs to provide quick and\n" +
      "            accurate information. To make it easy for users to perceive the\n" +
      "            displayed information even without focusing on WallPad, we shortened\n" +
      "            the user perception reaction time using colors. Positive information\n" +
      "            is expressed in shades of green from sky blue, and dangerous or\n" +
      "            cautious information is expressed in shades of purple from pink to\n" +
      "            help users easily perceive it. We also adopted the method of using\n" +
      "            toned-down background colors to increase color contrast values and\n" +
      "            further shorten the perception reaction time.\n" +
      "          </p>\n" +
      "        </section>",
    type: "0",
    orders: "8",
  },
];

// Functions
const commentBoxOpen = ref(false);

function scrollToTop() {
  window.scrollTo(0, 0);
}

function toggleCommentBox() {
  commentBoxOpen.value = !commentBoxOpen.value;
}

function contentToHTML(item) {
  if (item.type === "0") {
    return item.content;
  } else if (item.type === "1") {
    return `<img class="mb-12 w-fit" src="/src/assets/images/temp/${item.content}" alt="Content image" style="width: 100%"/>`;
  }
}

function scrollLeft() {
  const scrollContainer = document.querySelector(".scroll-container");
  scrollContainer.scrollLeft -= 326;
}

function scrollRight() {
  const scrollContainer = document.querySelector(".scroll-container");
  scrollContainer.scrollLeft += 326;
}
</script>

<template>
  <div
    class="absolute grid min-h-full gap-y-2 bg-gray-50 xl:min-w-full xl:grid-cols-12 xl:px-16 xl:pb-8 xl:pt-12"
  >
    <div
      class="col-start-2 bg-white pb-4 xl:ml-36 xl:rounded-lg xl:border"
      :class="commentBoxOpen ? 'xl:col-span-8' : 'xl:col-span-10'"
    >
      <!-- Profile -->
      <figure class="flex p-6">
        <router-link :to="`/${member.nickname.toLowerCase()}`">
          <img
            class="mr-4 mt-2 h-12 w-12 cursor-pointer rounded-full duration-300 hover:opacity-50"
            :src="`/src/assets/images/temp/${member.image}`"
            alt="Profile image"
            @click="scrollToTop"
          >
        </router-link>

        <figcaption class="flex cursor-default flex-col justify-evenly">
          <h1
            class="text-2xl font-bold"
            v-text="portfolio.title"
          />
          <div>
            <router-link to="/nickname">
              <span
                class="cursor-pointer text-lg font-semibold hover:text-gray-500"
                v-text="member.nickname"
              />
            </router-link>
            <span
              class="cursor-pointer text-lg font-semibold hover:text-gray-500"
              @click="toggleCommentBox"
            >ᆞ팔로우</span>
          </div>
        </figcaption>
      </figure>

      <!-- Main -->
      <main>
        <template
          :key="content.orders"
          v-for="content in contents"
        >
          <div v-html="contentToHTML(content)" />
        </template>
      </main>

      <!-- Tags and Copyright bar -->
      <div
        class="flex flex-col-reverse justify-between px-5 sm:flex-row sm:px-10 sm:pb-12 xl:py-10"
      >
        <!-- Tags -->
        <nav class="flex gap-x-2 py-3 text-xs sm:px-0">
          <router-link
            v-for="skill in usedSkills"
            :key="skill.engName"
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
        :class="portfolio.awardDate ? 'sm:h-64' : 'sm:h-56'"
      >
        <div class="flex w-32 justify-evenly">
            <div class="mb-2 cursor-pointer bg-white rounded-full border-2">
                <div class="heart-icon hover:animate-ping" />
            </div>
          <div
            class="collection-icon mb-2 cursor-pointer rounded-full border-2 bg-white hover:bg-blue-50"
          />
        </div>
        <!-- Portfolio banner -->
        <span
          class="text-sm font-bold text-blue-300"
          v-if="portfolio.awardDate != null"
        >POFO PICK 선정</span>
        <span
          class="text-lg font-bold text-white sm:text-xl"
          v-text="portfolio.title"
        />
        <span
          class="text-xs font-semibold text-white sm:text-sm"
          v-if="portfolio.awardDate != null"
          v-text="`${portfolio.awardDate} | 그래픽 디자인 · UI/UX`"
        />
        <span
          class="text-xs font-semibold text-white sm:text-sm"
          v-else
        >그래픽 디자인 · UI/UX</span>
      </div>

      <!-- Member's portfolio list bar -->
      <div class="flex justify-between px-7 py-6">
        <span class="block font-semibold text-gray-900">모든 작업 목록</span>
        <router-link
          to="/nickname"
          @click="scrollToTop"
          class="flex items-center justify-end"
        >
          <span class="block text-sm font-semibold text-gray-500">프로필 자세히 보기</span>
          <img
            src="@/assets/images/chevron-right.svg"
            alt="Chevron right icon"
            class="h-4 w-4 opacity-50"
          >
        </router-link>
      </div>

      <!-- Member's portfolio list -->
      <div
        class="scroll-container scrollbar-hide mx-8 flex h-60 overflow-x-scroll scroll-smooth"
        style="column-gap: 2.38rem"
      >
        <div
          class="chevron-left-icon absolute bottom-40 left-56 cursor-pointer border bg-white shadow-lg hover:bg-blue-50 hover:duration-300"
          @click="scrollLeft"
        />
        <figure
          class="h-48 w-96 cursor-pointer"
          :key="memberPortfolio.id"
          v-for="memberPortfolio in portfolios"
        >
          <router-link :to="`/pofo/${memberPortfolio.id}`">
            <img
              :src="`/src/assets/images/temp/${memberPortfolio.thumbnail}`"
              alt="#"
              class="h-full w-72 rounded-t-lg"
            >
            <figcaption
              class="w-72 rounded-b-lg bg-gray-950 px-5 text-sm font-bold text-white"
              v-text="memberPortfolio.title"
            />
          </router-link>
        </figure>
        <div
          class="chevron-right-icon absolute bottom-40 cursor-pointer border bg-white shadow-lg hover:bg-blue-50 hover:duration-300"
          @click="scrollRight"
        />
      </div>
    </div>

    <!-- Sidebar -->
    <div
      class="sidebar fixed hidden flex-col text-xs"
      :class="commentBoxOpen ? 'xl:hidden' : 'xl:block'"
    >
      <figure class="">
        <router-link
          to="/nickname"
          class="flex justify-center"
          @click="scrollToTop"
        >
          <img
            class="mb-2 h-12 w-12 rounded-full border-2"
            src="@/assets/images/temp/d.bronze.jpg"
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
        <div class="rounded-full bg-white border-2 mb-2">
          <div class="heart-icon cursor-pointer hover:animate-ping" />
        </div>
        좋아요
      </div>
      <div
        class="my-6 flex flex-col items-center text-center text-sm font-bold"
      >
        <div
          class="collection-icon mb-2 cursor-pointer rounded-full border-2 bg-white duration-300 hover:bg-blue-50"
        />
        컬렉션
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
        />
        공유하기
      </div>
    </div>

    <!-- Comment box -->
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
          <h2 class="text-md col-span-7 font-bold">
            COMMAX IoT Smart Home Display UI/UX
          </h2>
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
      <div class="mx-5 border-t py-5">
        <div class="grid grid-cols-7 grid-rows-2">
          <figure class="col-span-7 grid grid-cols-6 grid-rows-2">
            <a
              href="#"
              class="row-span-2"
            >
              <img
                class="h-12 w-12 rounded-full"
                src="@/assets/images/temp/d.bronze.jpg"
                alt="Profile image"
              >
            </a>
            <div class="col-start-2 font-bold">
              nickname
            </div>
            <div class="col-start-2 text-xs font-semibold text-gray-500">
              2023.04.06
            </div>
          </figure>
          <p class="col-span-7 my-4 text-sm">
            댓글 내용
          </p>
          <div
            class="col-span-2 cursor-pointer text-start text-xs text-gray-500"
          >
            답글 남기기
          </div>
        </div>
      </div>

      <!-- Comment component -->
      <div class="mx-5 border-t py-5">
        <div class="grid grid-cols-7 grid-rows-2">
          <figure class="col-span-7 grid grid-cols-6 grid-rows-2">
            <a
              href="#"
              class="row-span-2"
            >
              <img
                class="h-12 w-12 rounded-full"
                src="@/assets/images/temp/d.bronze.jpg"
                alt="Profile image"
              >
            </a>
            <div class="col-start-2 font-bold">
              nickname
            </div>
            <div class="col-start-2 text-xs font-semibold text-gray-500">
              2023.04.06
            </div>
          </figure>
          <p class="col-span-7 my-4 text-sm">
            댓글 내용
          </p>
          <div
            class="col-span-2 cursor-pointer text-start text-xs text-gray-500"
          >
            답글 남기기
          </div>
        </div>
      </div>

      <!-- Comment component -->
      <div class="mx-5 border-t py-5">
        <div class="grid grid-cols-7 grid-rows-2">
          <figure class="col-span-7 grid grid-cols-6 grid-rows-2">
            <a
              href="#"
              class="row-span-2"
            >
              <img
                class="h-12 w-12 rounded-full"
                src="/src/assets/images/temp/d.bronze.jpg"
                alt="Profile image"
              >
            </a>
            <div class="col-start-2 font-bold">
              nickname
            </div>
            <div class="col-start-2 text-xs font-semibold text-gray-500">
              2023.04.06
            </div>
          </figure>
          <p class="col-span-7 my-4 text-sm">
            댓글 내용
          </p>
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

main:deep(section) {
  @apply mx-6 mb-12 xl:mx-12;
  line-height: 2rem;
}

main:deep(img) {
  @apply mb-12 w-fit;
}

section:deep(h2) {
  @apply text-lg font-bold;
}

section:deep(p) {
  @apply my-4 text-xs;
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
  background-image: url("@/assets/images/chevron-left.svg");
  background-position: center;
  background-size: 50%;
  background-repeat: no-repeat;
  border-radius: 100%;
}

.chevron-right-icon {
  width: 48px;
  height: 48px;
  background-image: url("@/assets/images/chevron-right.svg");
  background-position: center;
  background-size: 50%;
  background-repeat: no-repeat;
  border-radius: 100%;
  right: 23.7rem;
}

.heart-icon {
  width: 48px;
  height: 48px;
  background-image: url("@/assets/images/heart.svg");
  background-position: center;
  background-size: 50%;
  background-repeat: no-repeat;
}

.collection-icon {
  width: 48px;
  height: 48px;
  background-image: url("@/assets/images/folder.svg");
  background-position: center;
  background-size: 50%;
  background-repeat: no-repeat;
  border-radius: 100%;
}

.comment-icon {
  width: 48px;
  height: 48px;
  background-image: url("@/assets/images/chat-bubble-left.svg");
  background-position: center;
  background-size: 50%;
  background-repeat: no-repeat;
}

.share-icon {
  width: 48px;
  height: 48px;
  background-image: url("@/assets/images/share-icon.svg");
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
  background-image: url("@/assets/images/x-mark.svg");
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
