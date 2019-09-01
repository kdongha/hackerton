<template>
  <div class="home">
<!--    <img alt="Vue logo" src="../assets/logo.png">-->
    <header class="masthead">
      <div class="container h-100">
        <div class="row h-100 align-items-center justify-content-center text-center">
          <div class="col-lg-10 align-self-end">
            <h1 class="text-uppercase text-white font-weight-bold">가변도로 설치로 인한 혼잡도 개선 시뮬레이션  및 예산 대비 최적 가변도로 추천 시스템 </h1>
            <hr class="divider my-4">
          </div>
          <div class="col-lg-8 align-self-baseline">
            <p class="text-white font-weight-light mb-5">국가 지표 체계에서 제공하는 통계 정보에 의하면 도로 혼잡에 의한 비용은 매년 증가하는 추세로, 2015년 33조원을 돌파하였습니다. 이를 바탕으로 교통 혼잡문제를 완화시킨다면 막대한 예산을 감축 할 수 있을 것으로 예측할 수 있습니다.</p>
          </div>
        </div>
      </div>
    </header>
    <SearchCsv/>
  </div>
</template>

<script>
// @ is an alias to /src
import SearchCsv from "../components/SearchCsv";

export default {
  name: 'home',
  components: {
    SearchCsv,
  }
}
</script>

<style scoped>
  .masthead {
   background: linear-gradient(to bottom,rgba(95,106,135,.8) 0,rgba(0,100,100,.8) 100%),url(../assets/img/seoulnight.gif)
  }

</style>