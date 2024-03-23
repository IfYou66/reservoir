<template>
  <div class="app-container home">
    <div>
      <dv-border-box7 style="padding: 100px 300px; width: 99.8%; height:600px;">
        <div style="float:left; width: 300px;" >
          <img :src="errGif" width="100%" height="100%" alt="Girl has dropped her ice cream.">

        </div>
        <div class="error-page-info" style="float:right;">
          <h1 style="color:white;">抱歉!</h1>
          <span style="color:white;" class="error-page-info-desc">正在施工中...</span>
          <ul class="list-unstyled" style="display: inline-block">
            <li class="link-type" style="list-style: none">
              <router-link to="/">
                <el-button type="primary" round>回首页</el-button>
              </router-link>
            </li>
          </ul>
        </div>
      </dv-border-box7>
    </div>
  </div>
</template>

<script>
  import errGif from '@/assets/ic_403.png'

  export default {
    name: 'Page402',
    data() {
      return {
        errGif: errGif + '?' + +new Date()
      }
    },
    methods: {
      back() {
        if (this.$route.query.noGoBack) {
          this.$router.push({path: '/'})
        } else {
          this.$router.go(-1)
        }
      }
    }
  }
</script>

<style lang="scss" scoped>
  .home {
    margin: 0;
    background-image: url("../../assets/images/bg.png");
    background-size: 100%;
    height: 650px;
  }

  .error-page-info {
    display: inline-block;
  }
</style>
