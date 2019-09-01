import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios';
import 'v-slim-dialog/dist/v-slim-dialog.css'
import SlimDialog from 'v-slim-dialog'

// import * as vizceralvue from 'vizceral-vue';

Vue.config.productionTip = false;
Vue.prototype.$http = axios;
Vue.use(SlimDialog)
// Vue.use(vizceralvue);

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
