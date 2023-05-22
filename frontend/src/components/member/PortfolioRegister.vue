<script setup>
import Header from "../Header.vue";
import { onMounted, onUpdated, reactive, ref } from "vue";
import { useUserDetailsStore } from '../../stores/useUserDetailsStore';

let showModal = ref(false);
let thumbnail = ref('');
let imgUpLoad = ref(false);
// 제목 양방향 바인딩 추가
let title = ref('');
let list = reactive([]);
let listIndex = 0;
// 체크박스 선택 하나만
let singgle = ref(true);
let team = ref(false);

let userDetails = useUserDetailsStore();



function arrayRemove(event, index) {
  list.splice(index, 1);
}
function imgPlusHandler() {
  //img 키 값은 화면 출력용 src를 가지고 있는 녀석
  //fileInfo 선택된 이미지 파일의 정보를 가지고 있는 녀석
  list.push({ type: "img", text: "", img: [], fileInfo: [] });
  listIndex++;
}
function textPlusHandler() {
  list.push({ type: "text", text: "", img: [], fileInfo: [] });
  listIndex++;
}
function showModalHandler() {
  showModal.value = !showModal.value;
}

function imgClickHandler(e) {
  let previousElement = e.target.previousElementSibling;
  previousElement.click();
}



function thumbmailClick(e) {
  let upSibling = e.target.previousSibling
  let thumClick = upSibling.firstElementChild
  thumClick.click()
}

function imgInputHandler(e, index) {
  let urls = [];
  let files = e.target.files;
  list[index].fileInfo = files;
  for (let file of files) {
    urls.push(URL.createObjectURL(file));
  }
  list[index].img = urls;
  let element1 = e.target.parentElement;
  while (element1.className != 'sub-box')
    element1 = element1.parentElement;
  element1.classList.add("d-none");

  let element2 = e.target.parentElement;
  while (element2.className != 'start-app')
    element2 = element2.parentElement;
  element2.nextElementSibling.classList.add("d-none");
}

function thumbnailImg(e) {
  let file = e.target.files[0];
  thumbnail.value = URL.createObjectURL(file);
  imgUpLoad.value = true;

}
function thumbmailDrop(e) {
  e.preventDefault();
  let file = e.dataTransfer.files[0];
  thumbnail.value = URL.createObjectURL(file);
  imgUpLoad.value = true;
}

function addDnone(e) {
  let hoverMouse = e.target.querySelector(".erase-box");
  hoverMouse.classList.add("d-none");
}
function removeDnone(e) {
  let hoverMouse = e.target.querySelector(".erase-box");
  if (hoverMouse == null)
    hoverMouse = e.currentTarget.querySelector(".erase-box");
  hoverMouse.classList.remove("d-none");
}


function dropHandler(event, index) {
  let startApp = event.target.closest(".start-app");
  let mainTitle = startApp.nextElementSibling;
  event.preventDefault();
  let objecUrls = [];
  let files = [...event.dataTransfer.files];
  list[index].fileInfo = files;
  for (let flie of files)
    objecUrls.push(URL.createObjectURL(flie))

  list[index].img = objecUrls;

  startApp.classList.add("d-none");
  mainTitle.classList.add("d-none");
}

// 체크박스 하나만 선택해서 하기 선택자 사용하지않고 짜증나네
function singgleChecked(e) {
  if (e.target == singgle.value) {
    console.log(e.target)
    singgle.value.checked = true;
    team.value.checked = false;
    let look = e.target.closest(".select-team")
    let teamBox = look.nextElementSibling
    let teamInput = teamBox.nextElementSibling
    teamBox.classList.add("d-none")
    teamInput.classList.add("d-none")
  }
}
function teamChecked(e) {
  if (e.target == team.value) {
    console.log(e.target)
    team.value.checked = true;
    singgle.value.checked = false;
    let look = e.target.closest(".select-team")
    let teamBox = look.nextElementSibling
    let teamInput = teamBox.nextElementSibling
    teamBox.classList.remove("d-none")
    teamInput.classList.remove("d-none")
  }
}

function saveData(event, index) {
  list[index].text = event.target.innerHTML;
}

async function send(e) {
  let form = document.querySelector("#form")
  let formData = new FormData(form);
  formData.append("memberId",userDetails.id);
  let res = await fetch("http://localhost:8080/members/regpofo", {
    method: "POST",
    // body: formData,
    body:formData,
    headers: {
      "Accept": "application/json",
    }
  });

  let order = 0;
  for (let content of list) {
    if (content.img.length != 0) {
      for (let img of content.fileInfo) {
        let formdata = new FormData();
        formdata.append("contents", img);
        formdata.append("orders", order++);
        await fetch("http://localhost:8080/members/regcontent", {
          method: "POST",
          headers: {
            "Accept": "application/json"
          },
          body: formdata
        });
      }
    } else {
      let formdata = new FormData();
      formdata.append("contents", content.text);
      formdata.append("orders", order++);
      await fetch("http://localhost:8080/members/regcontent", {
        method: "POST",
        headers: {
          "Accept": "application/json"
        },
        body: formdata
      });
    }
  }
}



</script>
<template>
  <div v-show="showModal" class="screen"></div>
  <Header />
  <form id="form" action="/members" method="post" enctype="multipart/form-data">
    <div class="container">
      <main class="reg-main">
        <div class="reg-title-box">
          <input v-model="title" class="reg-title" type="text" name="title" placeholder="제목을 입력해주세요.">
        </div>
        <!--  -->
        <section class="reg-content">
          <section v-if="list.length == 0" class="default-box">
            <div class="main-title">
              <span> 이미지 or 텍스트를 선택하여 업로드를 시작하세요. </span>
            </div>
            <div class="start-app">
              <div class="margin-right-5 sub-box">
                <div @click="imgPlusHandler" class="app-box">
                  <img class="hover" src="/src/assets/images/img.png" alt=""><img class="hover d-none"
                    src="/src/assets/images/fff-img.png" alt="">
                </div>
                <div class="app-box-font">
                  이미지
                </div>
              </div>
              <div class="sub-box">
                <div @click="textPlusHandler" class="app-box">
                  <img class="hover" src="/src/assets/images/text.png" alt=""><img class="hover d-none"
                    src="/src/assets/images/fff-text.png" alt="">
                </div>
                <div class="app-box-font">
                  텍스트
                </div>
              </div>
            </div>
          </section>

          <!-- 이미지 클릭했을때 나오는 박스 -->
          <section class="vue-for-box" v-for="(pofo, index) in list">

            <section @dragover.stop.prevent="onDragover" @drop.stop.prevent="dropHandler($event, index)"
              v-on:mouseover.stop.prevent="removeDnone" v-on:mouseleave.stop.prevent="addDnone"
              class="click-img-box" :class="{'default-box' : pofo.type!='text', 'default-box-text' : pofo.type=='text'}">
              <div @click.prevent="arrayRemove($event, index)" class="erase-box d-none">
                <img class="erase" src="/src/assets/images/erase.png" alt="">
              </div>
              <div class="upload-d-none" v-if="pofo.type == 'img'">
                <div class="min-height">
                  <img v-for="src in pofo.img" class=" upload-img" :src="src" alt="Image">
                </div>
                <div class="start-app">
                  <div class="sub-box">
                    <div class="app-box">
                      <input @input="imgInputHandler($event, index)" class="d-none" ref="inputFile" type="file" multiple
                        accept="jpg,gif,png">
                      <img @click.prevent="imgClickHandler" ref="forderOnpe" class="hover"
                        src="/src/assets/images/img.png" alt="">
                    </div>
                  </div>
                </div>
                <div :id="'text' + index" class="main-title">
                  <span class="img-upLoad-comment margin-top-1">
                    이미지(최대10장)을 업로드 또는 드래그하세요.
                  </span>
                  <span class="img-upLoad-comment margin-top-1 color-eee">
                    JPEG,JPG,GIF 이미지파일
                  </span>
                </div>
              </div>
              <!-- 텍스트 눌렀을때 나오는 텍스트박스 -->
              <section style="height: 100%;" v-else-if="pofo.type == 'text'" class="click-text-box margin-top-3">
                <div>
                  <!-- <textarea class="click-text" name="content" value="2" id="" cols="30" rows="16"
                    placeholder="여기에 텍스트를 입력하세요." /> -->
                  <p contenteditable="true" @focusout.prevent="saveData($event, index)" class="p-tags"
                    placeholder="텍스트를 입력해주세요">
                  </p>
                </div>
              </section>
            </section>
          </section>

          <!--  -->
        </section>
      </main>
      <aside class="aside">
        <nav class="margin-top-4 nav">
          <ul class="content-select">
            <li class="aside-li border-none">
              <button @click.prevent="imgPlusHandler" class="aside-btn">
                <img class="aside-img" src="/src/assets/images/img.png" alt="">이미지추가
              </button>
            </li>
            <li class="aside-li border-none">
              <button @click.prevent="textPlusHandler" class="aside-btn">
                <img class="aside-img" src="/src/assets/images/text.png" alt="">텍스트추가
              </button>
            </li>
          </ul>
          <ul class="content-select">
            <li class="aside-li">
              <button class="aside-btn">
                <img class="aside-img" src="/src/assets/images/content.svg" alt="">콘텐츠재정렬
              </button>
            </li>
            <li class="aside-li">
              <button class="aside-btn">
                <img class="aside-img" src="/src/assets/images/preview.png" alt="">미리보기
              </button>
            </li>
          </ul>
          <button @click.prevent="showModalHandler" class="register-btn btn-1 margin-top-5">
            등록하기
          </button>
          <button class="register-btn-1 btn-1 margin-top-5">
            임시저장
          </button>
        </nav>
      </aside>
      <div class="m-comment d-none">
        <span>작업 업로드 및 수정은 PC버전에서만 지원이 가능합니다.</span>
      </div>
    </div>
    <div v-show="showModal" class="reg-modal-box">
      <div class="modal-h1">
        <p class="modal-s-title">세부 정보 입력</p>
        <button @click.prevent="showModalHandler" class="modal-close"></button>
      </div>
      <div class="reg-modal">
        <div class="modal-flex m-r-5">
          <div class="thumbnail-box">
            <div class="modal-thumbnail-text">
              <span class="thumbnail-span">커버</span><span class="thumbnail-color">(필수)</span>
            </div>
            <div @dragover.stop.prevent="onDragover" @drop.stop.prevent="thumbmailDrop($event)"
              class="thumbnail-img-box margin-top-5">
              <input @input="thumbnailImg($event, index)" class="d-none thumbnailInput" type="file" name="thumbnail"
                accept="jpg,gif,png">
              <!-- <img  @click.prevent="imgClickHandler" class="hover" src="/src/assets/images/img.png" alt=""> -->
              <img v-if="imgUpLoad" :src="thumbnail" alt="" class="thumnailImg-upload">
            </div>
            <button class="modal-submit-btn thum-btn" @click.prevent="thumbmailClick($event)"
              type="button">이미지업로드</button>
          </div>
          <div class="border-right"></div>
        </div>
        <!-- 모달 -->
        <div class="modal-main-box">
          <div class="modal-main-text margin-top-3">
            <span class="thumbnail-span">제목</span><span class="thumbnail-color">(필수)</span>
          </div>
          <input v-model="title" class="modal-main-title margin-top-2" type="text" placeholder="제목을 입력하세요">
          <div class="modal-main-text margin-top-5">
            <span class="thumbnail-span">기술스택</span><span class="thumbnail-color">(필수)</span>
          </div>
          <div class="check-box margin-top-2">
            <label class="skill-label"><input class="cb" type="checkbox" name="skills" value="1"
                checked="checked">java</label>
            <label class="skill-label"><input class="cb" type="checkbox" name="skills" value="2">javaScript</label>
            <label class="skill-label"><input class="cb" type="checkbox" name="skills" value="3">python</label>
            <label class="skill-label"><input class="cb" type="checkbox" name="skills" value="4">C</label>
            <label class="skill-label"><input class="cb" type="checkbox" name="skills" value="5">C#</label>
            <label class="skill-label"><input class="cb" type="checkbox" name="skills" value="6">VisualBasic</label>
            <label class="skill-label"><input class="cb" type="checkbox" name="skills" value="7">HTML</label>
            <label class="skill-label"><input class="cb" type="checkbox" name="skills" value="8">CSS</label>
            <label class="skill-label"><input class="cb" type="checkbox" name="skills" value="9">Spring</label>
            <label class="skill-label"><input class="cb" type="checkbox" name="skills" value="10">SpringBoot</label>
          </div>
          <div class="modal-main-text margin-top-5">
            <span class="thumbnail-span">개인or팀</span><span class="thumbnail-color">(필수)</span>
          </div>
          <div class="select-team team-info margin-top-3">
            <label class="skill-label singgle"><input ref="singgle" @click="singgleChecked($event)" class="cb"
                type="checkbox" checked name="collaboration" value="0">개인</label>
            <label class="skill-label team"><input ref="team" @click="teamChecked($event)" class="cb" type="checkbox"
                name="collaboration" value="1">팀</label>
            <!-- <input class="cb" type="checkbox" name="singgle" value="0">개인 -->
            <!-- <input class="cb" type="checkbox" name="team" value="1">팀 -->
          </div>
          <div class="d-none modal-main-text margin-top-5">
            <span class="thumbnail-span">팀원등록</span><span class="thumbnail-color">(선택)</span>
          </div>
          <input class=" d-none modal-main-team margin-top-2" type="text" placeholder="팀원을 등록해보세요.">
          <div class="submit-box margin-top-7">
            <input @click.prevent="send($event)" class="modal-submit-btn" type="submit" value="업로드">
          </div>
        </div>
      </div>
    </div>
  </form>
</template>
<style scoped>
@import url("/src/assets/css/compoment/register.css");

.d-none {
  display: none;
}

.thumnailImg-upload {
  width: 100%;
  height: 100%;
  object-fit: fill;
}

.thum-btn {
  padding: 3%;
  margin-top: 5%;
  margin-left: 30%;
}

.m-r-5 {
  margin-right: 5%;
}

.singgle {
  font-size: 14px;
  font-weight: 400;

}

.team {
  font-size: 14px;
  font-weight: 400;
}

.select-team {
  display: flex;
  justify-content: space-around;
  width: 30%;
}

.p-tags[contenteditable="true"]:empty:before {
  content: attr(placeholder);
  margin-top: 3px;
  color: #9A9A97;
  font-size: 20px;


}

.p-tags:focus {
  outline: none;
  max-width: 90%;
}

</style>