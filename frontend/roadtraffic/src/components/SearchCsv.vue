<template>
  <div class="container">
    <div class="large-12 medium-12 small-12 cell">
      <label>원하는 도로의 CSV 파일을 업로드 해주세요</label>
<!--        <input class="form-control" type="file" id="file" ref="file" v-on:change="handleFileUpload()"/>-->
        <div class="input-group mb-4">
          <div class="input-group-prepend">
            <span class="input-group-text">Upload</span>
          </div>
          <div class="custom-file">
            <input type="file" class="custom-file-input" id="file" ref="file" v-on:change="handleFileUpload()" accept=".csv">
            <label class="custom-file-label" for="inputGroupFile01">{{file.name}}</label>
          </div>
        </div>
        <button v-on:click="submitFile()" class="btn btn-secondary">Submit</button>

    </div>
  </div>
</template>

<script>
// import axios from "axios";

export default {
  name: 'SearchCsv',
  data(){
    return {
      file: ''
    }
  },
  methods: {
    submitFile(){
      let formData = new FormData();
      formData.append('csv', this.file);
      this.$http.post( 'http://localhost:3000/upload/',
              formData,
              {
                headers: {
                  'Content-Type': 'multipart/form-data'
                  // 'Content-Type': 'application/json'
                }
              }
      ).then((res) => {
        // alert('SUCCESS!!');
        // console.log(res)
        if(res.status == 200) {
          // console.log(res)
          this.$router.push({name: 'about', params: {resData: res.data}})
        }else {
          this.showAlert("다른 파일을 upload 해주세요")
        }
        // router.push({name: 'result'})
      }).catch(function(){
        alert('FAILURE!!');
      });
    },

    handleFileUpload(){
      this.file = this.$refs.file.files[0];
      console.log(this.file)
    },

    showAlert(msg) {
      const options = {
        title: 'Info',
        size: 'sm',
      }
      this.$dialogs
              .alert(msg, options)
              .then((res) => {
                console.log((res));
              })

    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
