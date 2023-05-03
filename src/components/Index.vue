
<script setup>
import Header from'./Header.vue';

</script>
<template>
    <Header></Header>
    <main>
        <!-- 이번주 인기 TOP 10 -->
        <section class="slider-container">
            <h1 class="d-none">이번주 인기 TOP 10</h1>
            <div class="slider">
                <a href="/your-post-url-10"><img src="src/assets/images/A3rzk7ZMMuKmrv9y.비비드-rgb.jpg" alt="포트폴리오 섬네일 이미지"></a>
                <a href="/your-post-url-1"><img src="src/assets/images/92sBdzoNV6uRcMTr.11.gif" alt="포트폴리오 섬네일 이미지"></a>
                <a href="/your-post-url-2"><img src="src/assets/images/F9C9aBXD9WcJL9eU.태일_기본_백터.png" alt="포트폴리오 섬네일 이미지"></a>
                <a href="/your-post-url-3"><img src="src/assets/images/BctLFrYLdnFPix7w.커플.jpg" alt="포트폴리오 섬네일 이미지"></a>
                <a href="/your-post-url-4"><img src="src/assets/images/BctLFrYLdnFPix7w.커플.jpg" alt="포트폴리오 섬네일 이미지"></a>
                <a href="/your-post-url-5"><img src="src/assets/images/BctLFrYLdnFPix7w.커플.jpg" alt="포트폴리오 섬네일 이미지"></a>
                <a href="/your-post-url-6"><img src="src/assets/images/BctLFrYLdnFPix7w.커플.jpg" alt="포트폴리오 섬네일 이미지"></a>
                <a href="/your-post-url-7"><img src="src/assets/images/BctLFrYLdnFPix7w.커플.jpg" alt="포트폴리오 섬네일 이미지"></a>
                <a href="/your-post-url-8"><img src="src/assets/images/BctLFrYLdnFPix7w.커플.jpg" alt="포트폴리오 섬네일 이미지"></a>
                <a href="/your-post-url-9"><img src="src/assets/images/BctLFrYLdnFPix7w.커플.jpg" alt="포트폴리오 섬네일 이미지"></a>
            </div>
            <div class="slider-controls">
                <button class="prev-button"></button>
                <button class="next-button"></button>
            </div>
            <div class="indicator-container">
                <ul class="indicator-list">
                    <li class="indicator active"></li>
                    <li class="indicator"></li>
                    <li class="indicator"></li>
                    <li class="indicator"></li>
                    <li class="indicator"></li>
                    <li class="indicator"></li>
                    <li class="indicator"></li>
                    <li class="indicator"></li>
                    <li class="indicator"></li>
                    <li class="indicator"></li>
                </ul>
            </div>
        </section>

        <!-- 포트폴리오 리스트 -->
        <div class="portfolio-container">

            <!-- 카테고리 & 정렬 -->
            <section class="category-section">
                <h1>POFO의 인기 개발언어를 선택해 보세요.</h1>
                <!-- <div class="category-slider"> -->
                    <ul class="category-list">
                        <li class="category-item entire active">
                            <a href="#전체"> 
                                <span>전체</span>
                            </a>
                        </li>
                        <li class="category-item java">
                            <a href="#전체"> 
                                <span>Java</span>
                            </a>
                        </li>
                        <li class="category-item javascript">
                            <a href="#전체"> 
                                <span>JavaScript</span>
                            </a>
                        </li>
                        <li class="category-item python">
                            <a href="#전체"> 
                                <span>Python</span>
                            </a>
                        </li>
                        <li class="category-item c">
                            <a href="#전체"> 
                                <span>C</span>
                            </a>
                        </li>
                        <li class="category-item c-sharp">
                            <a href="#전체"> 
                                <span>C#</span>
                            </a>
                        </li>
                        <li class="category-item visual-basic">
                            <a href="#전체"> 
                                <span>Visual Basic</span>
                            </a>
                        </li>
                    </ul>
                    <!-- <div class="slider-controls">
                        <button class="prev-button"></button>
                        <button class="next-button"></button>
                    </div> -->
                <!-- </div> -->
                <div class="sorting-options">
                    <span>정렬방식:</span>
                    <button class="sort-button active">최신순</button>
                    <button class="sort-button">좋아요순</button>
                    <button class="sort-button">팔로우 회원만</button>
                </div>
            </section>

            <!-- 리스트 섹션 -->
            <section class="list-section">
                <h1 class="d-none">포트폴리오 리스트 섹션</h1>
                <ul>
                    <li>
                        <div class="thumbnail">
                            <img src="src/assets/images/BctLFrYLdnFPix7w.커플.jpg" alt="포트폴리오 섬네일 이미지">
                        </div>
                        <div class="information">
                            <div class="portfolio-info-profile">
                                <img src="src/assets/images/free-icon-user-847969 28.png" alt="프로필 이미지">
                                <span class="nickname">ilovepofo</span>
                            </div>
                            <div class="portfolio-info-counts">
                                <img src="src/assets/images/eye.png" alt="조회수 이미지">
                                <span class="hit">123</span>
                                <img src="src/assets/images/heart.png" alt="하트 이미지">
                                <span class="like">22</span>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="thumbnail">
                            <img src="src/assets/images/92sBdzoNV6uRcMTr.11.gif" alt="포트폴리오 섬네일 이미지">
                        </div>
                        <div class="information">
                            <div class="portfolio-info-profile">
                                <img src="src/assets/images/free-icon-user-847969 28.png" alt="프로필 이미지">
                                <span class="nickname">ilovepofo</span>
                            </div>
                            <div class="portfolio-info-counts">
                                <img src="src/assets/images/eye.png" alt="조회수 이미지">
                                <span class="hit">12</span>
                                <img src="src/assets/images/heart.png" alt="하트 이미지">
                                <span class="like">2</span>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="thumbnail">
                            <img src="src/assets/images/V8xLj9bx6VaubDZ3.성찰적 존재(Reflective Being).png" alt="포트폴리오 섬네일 이미지">
                        </div>
                        <div class="information">
                            <div class="portfolio-info-profile">
                                <img src="src/assets/images/free-icon-user-847969 28.png" alt="프로필 이미지">
                                <span class="nickname">ilovepofo</span>
                            </div>
                            <div class="portfolio-info-counts">
                                <img src="src/assets/images/eye.png" alt="조회수 이미지">
                                <span class="hit"></span>
                                <img src="src/assets/images/heart.png" alt="하트 이미지">
                                <span class="like"></span>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="thumbnail">
                            <img src="src/assets/images/F9C9aBXD9WcJL9eU.태일_기본_백터.png" alt="포트폴리오 섬네일 이미지">
                        </div>
                        <div class="information">
                            <div class="portfolio-info-profile">
                                <img src="src/assets/images/free-icon-user-847969 28.png" alt="프로필 이미지">
                                <span class="nickname">ilovepofo</span>
                            </div>
                            <div class="portfolio-info-counts">
                                <img src="src/assets/images/eye.png" alt="조회수 이미지">
                                <span class="hit"></span>
                                <img src="src/assets/images/heart.png" alt="하트 이미지">
                                <span class="like"></span>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="thumbnail">
                            <img src="src/assets/images/eye.png" alt="포트폴리오 섬네일 이미지">
                        </div>
                        <div class="information">
                            <div class="portfolio-info-profile">
                                <img src="src/assets/images/free-icon-user-847969 28.png" alt="프로필 이미지">
                                <span class="nickname">ilovepofo</span>
                            </div>
                            <div class="portfolio-info-counts">
                                <img src="src/assets/images/eye.png" alt="조회수 이미지">
                                <span class="hit"></span>
                                <img src="src/assets/images/heart.png" alt="하트 이미지">
                                <span class="like"></span>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="thumbnail">
                            <img src="src/assets/images/A3rzk7ZMMuKmrv9y.비비드-rgb.jpg" alt="포트폴리오 섬네일 이미지">
                        </div>
                        <div class="information">
                            <div class="portfolio-info-profile">
                                <img src="src/assets/images/free-icon-user-847969 28.png" alt="프로필 이미지">
                                <span class="nickname">ilovepofo</span>
                            </div>
                            <div class="portfolio-info-counts">
                                <img src="src/assets/images/eye.png" alt="조회수 이미지">
                                <span class="hit"></span>
                                <img src="src/assets/images/heart.png" alt="하트 이미지">
                                <span class="like"></span>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="thumbnail">
                            <img src="src/assets/images/ujqbJcYv4hQ4ZLZK.20230317_2_65.jpg" alt="포트폴리오 섬네일 이미지">
                        </div>
                        <div class="information">
                            <div class="portfolio-info-profile">
                                <img src="src/assets/images/free-icon-user-847969 28.png" alt="프로필 이미지">
                                <span class="nickname">ilovepofo</span>
                            </div>
                            <div class="portfolio-info-counts">
                                <img src="src/assets/images/eye.png" alt="조회수 이미지">
                                <span class="hit"></span>
                                <img src="src/assets/images/heart.png" alt="하트 이미지">
                                <span class="like"></span>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="thumbnail">
                            <img src="src/assets/images/BctLFrYLdnFPix7w.커플.jpg" alt="포트폴리오 섬네일 이미지">
                        </div>
                        <div class="information">
                            <div class="portfolio-info-profile">
                                <img src="src/assets/images/free-icon-user-847969 28.png" alt="프로필 이미지">
                                <span class="nickname">ilovepofo</span>
                            </div>
                            <div class="portfolio-info-counts">
                                <img src="src/assets/images/eye.png" alt="조회수 이미지">
                                <span class="hit"></span>
                                <img src="src/assets/images/heart.png" alt="하트 이미지">
                                <span class="like"></span>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="thumbnail">
                            <img src="src/assets/images/BctLFrYLdnFPix7w.커플.jpg" alt="포트폴리오 섬네일 이미지">
                        </div>
                        <div class="information">
                            <div class="portfolio-info-profile">
                                <img src="src/assets/images/free-icon-user-847969 28.png" alt="프로필 이미지">
                                <span class="nickname">ilovepofo</span>
                            </div>
                            <div class="portfolio-info-counts">
                                <img src="src/assets/images/eye.png" alt="조회수 이미지">
                                <span class="hit"></span>
                                <img src="src/assets/images/heart.png" alt="하트 이미지">
                                <span class="like"></span>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="thumbnail">
                            <img src="src/assets/images/BctLFrYLdnFPix7w.커플.jpg" alt="포트폴리오 섬네일 이미지">
                        </div>
                        <div class="information">
                            <div class="portfolio-info-profile">
                                <img src="src/assets/images/free-icon-user-847969 28.png" alt="프로필 이미지">
                                <span class="nickname">ilovepofo</span>
                            </div>
                            <div class="portfolio-info-counts">
                                <img src="src/assets/images/eye.png" alt="조회수 이미지">
                                <span class="hit"></span>
                                <img src="src/assets/images/heart.png" alt="하트 이미지">
                                <span class="like"></span>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="thumbnail">
                            <img src="src/assets/images/BctLFrYLdnFPix7w.커플.jpg" alt="포트폴리오 섬네일 이미지">
                        </div>
                        <div class="information">
                            <div class="portfolio-info-profile">
                                <img src="src/assets/images/free-icon-user-847969 28.png" alt="프로필 이미지">
                                <span class="nickname">ilovepofo</span>
                            </div>
                            <div class="portfolio-info-counts">
                                <img src="src/assets/images/eye.png" alt="조회수 이미지">
                                <span class="hit"></span>
                                <img src="src/assets/images/heart.png" alt="하트 이미지">
                                <span class="like"></span>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="thumbnail">
                            <img src="src/assets/images/BctLFrYLdnFPix7w.커플.jpg" alt="포트폴리오 섬네일 이미지">
                        </div>
                        <div class="information">
                            <div class="portfolio-info-profile">
                                <img src="src/assets/images/free-icon-user-847969 28.png" alt="프로필 이미지">
                                <span class="nickname">ilovepofo</span>
                            </div>
                            <div class="portfolio-info-counts">
                                <img src="src/assets/images/eye.png" alt="조회수 이미지">
                                <span class="hit"></span>
                                <img src="src/assets/images/heart.png" alt="하트 이미지">
                                <span class="like"></span>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="thumbnail">
                            <img src="src/assets/images/BctLFrYLdnFPix7w.커플.jpg" alt="포트폴리오 섬네일 이미지">
                        </div>
                        <div class="information">
                            <div class="portfolio-info-profile">
                                <img src="src/assets/images/free-icon-user-847969 28.png" alt="프로필 이미지">
                                <span class="nickname">ilovepofo</span>
                            </div>
                            <div class="portfolio-info-counts">
                                <img src="src/assets/images/eye.png" alt="조회수 이미지">
                                <span class="hit"></span>
                                <img src="src/assets/images/heart.png" alt="하트 이미지">
                                <span class="like"></span>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="thumbnail">
                            <img src="src/assets/images/BctLFrYLdnFPix7w.커플.jpg" alt="포트폴리오 섬네일 이미지">
                        </div>
                        <div class="information">
                            <div class="portfolio-info-profile">
                                <img src="src/assets/images/free-icon-user-847969 28.png" alt="프로필 이미지">
                                <span class="nickname">ilovepofo</span>
                            </div>
                            <div class="portfolio-info-counts">
                                <img src="src/assets/images/eye.png" alt="조회수 이미지">
                                <span class="hit"></span>
                                <img src="src/assets/images/heart.png" alt="하트 이미지">
                                <span class="like"></span>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="thumbnail">
                            <img src="src/assets/images/BctLFrYLdnFPix7w.커플.jpg" alt="포트폴리오 섬네일 이미지">
                        </div>
                        <div class="information">
                            <div class="portfolio-info-profile">
                                <img src="src/assets/images/free-icon-user-847969 28.png" alt="프로필 이미지">
                                <span class="nickname">ilovepofo</span>
                            </div>
                            <div class="portfolio-info-counts">
                                <img src="src/assets/images/eye.png" alt="조회수 이미지">
                                <span class="hit"></span>
                                <img src="src/assets/images/heart.png" alt="하트 이미지">
                                <span class="like"></span>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="thumbnail">
                            <img src="src/assets/images/BctLFrYLdnFPix7w.커플.jpg" alt="포트폴리오 섬네일 이미지">
                        </div>
                        <div class="information">
                            <div class="portfolio-info-profile">
                                <img src="src/assets/images/free-icon-user-847969 28.png" alt="프로필 이미지">
                                <span class="nickname">ilovepofo</span>
                            </div>
                            <div class="portfolio-info-counts">
                                <img src="src/assets/images/eye.png" alt="조회수 이미지">
                                <span class="hit"></span>
                                <img src="src/assets/images/heart.png" alt="하트 이미지">
                                <span class="like"></span>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="thumbnail">
                            <img src="src/assets/images/BctLFrYLdnFPix7w.커플.jpg" alt="포트폴리오 섬네일 이미지">
                        </div>
                        <div class="information">
                            <div class="portfolio-info-profile">
                                <img src="src/assets/images/free-icon-user-847969 28.png" alt="프로필 이미지">
                                <span class="nickname">ilovepofo</span>
                            </div>
                            <div class="portfolio-info-counts">
                                <img src="src/assets/images/eye.png" alt="조회수 이미지">
                                <span class="hit"></span>
                                <img src="src/assets/images/heart.png" alt="하트 이미지">
                                <span class="like"></span>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="thumbnail">
                            <img src="src/assets/images/BctLFrYLdnFPix7w.커플.jpg" alt="포트폴리오 섬네일 이미지">
                        </div>
                        <div class="information">
                            <div class="portfolio-info-profile">
                                <img src="src/assets/images/free-icon-user-847969 28.png" alt="프로필 이미지">
                                <span class="nickname">ilovepofo</span>
                            </div>
                            <div class="portfolio-info-counts">
                                <img src="src/assets/images/eye.png" alt="조회수 이미지">
                                <span class="hit"></span>
                                <img src="src/assets/images/heart.png" alt="하트 이미지">
                                <span class="like"></span>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="thumbnail">
                            <img src="src/assets/images/BctLFrYLdnFPix7w.커플.jpg" alt="포트폴리오 섬네일 이미지">
                        </div>
                        <div class="information">
                            <div class="portfolio-info-profile">
                                <img src="src/assets/images/free-icon-user-847969 28.png" alt="프로필 이미지">
                                <span class="nickname">ilovepofo</span>
                            </div>
                            <div class="portfolio-info-counts">
                                <img src="src/assets/images/eye.png" alt="조회수 이미지">
                                <span class="hit"></span>
                                <img src="src/assets/images/heart.png" alt="하트 이미지">
                                <span class="like"></span>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="thumbnail">
                            <img src="src/assets/images/BctLFrYLdnFPix7w.커플.jpg" alt="포트폴리오 섬네일 이미지">
                        </div>
                        <div class="information">
                            <div class="portfolio-info-profile">
                                <img src="src/assets/images/free-icon-user-847969 28.png" alt="프로필 이미지">
                                <span class="nickname">ilovepofo</span>
                            </div>
                            <div class="portfolio-info-counts">
                                <img src="src/assets/images/eye.png" alt="조회수 이미지">
                                <span class="hit"></span>
                                <img src="src/assets/images/heart.png" alt="하트 이미지">
                                <span class="like"></span>
                            </div>
                        </div>
                    </li>
                </ul>
            </section>

            <!-- 광고 섹션 -->
            <section class="advertising-section">
                <h1 class="d-none">광고</h1>
                <img src="" alt="">
            </section>
        </div>
    </main>
</template>
<style scoped>
@import url("/src/assets/css/compoment/index.css");
</style>