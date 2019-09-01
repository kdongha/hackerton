<template>
  <div class="about">
    <h1>Time : {{countDown}}</h1>
    <div id="mynetwork" @click="edgeSelected"></div>
    <!-- use the modal component, pass in the prop -->


  </div>
</template>


<script>
import vis from 'vis-network'
import myModal from '../components/DetailRoad.vue'

export default {
  name: 'About',
  props: {
    resData : {}
  },
  data() {
    return {
      nodes: [],
      edges: [],
      container: '',
      network: null,
      options: {
        nodes: {
          shape: 'dot',
        },
        edges: {
          color: {}
        },
      },
      tmpEdges: [],
      countDown: 0,

    }
  },
  components: {
    appMyModal: myModal
  },
  computed: {
    graph_data() {
      return {
        nodes: this.nodes,
        edges: this.tmpEdges
      }
    },
  },
  mounted() {
    this.createNodeEdge()
    // this.network.cluster(this.options);
  },
  methods: {
    createNodeEdge() {
      if(this.countDown < 24) {
        setTimeout(() => {
          // var tmpEdges = []
          // this.nodes = this.resData.nodes;
          for (var i = 0; i < this.resData.nodes.length; i++)  {
            this.nodes[i] = {id : this.resData.nodes[i], label: this.resData.nodes[i]}
          }
          // console.log(this.nodes)
          this.edges = this.resData.edges;
          // console.log(this.edges)

          for (var j = 0; j < this.edges.length; j++) {
            // for (var i = 0; i < this.resData.nodes.length; i++)  {
              if(this.edges[j].build[this.countDown]) {
                this.tmpEdges[j] = {from: this.edges[j].from, to: this.edges[j].to, value: this.edges[j].values[this.countDown], color: {color: 'red'}}
              }else {
                // console.log(this.edges[j].to)
                this.tmpEdges[j] = {from: this.edges[j].from, to: this.edges[j].to, value: this.edges[j].values[this.countDown]}
              }
            }
          // }
          this.countDown += 1;
          this.container = document.getElementById('mynetwork');
          // this.graph_data = {nodes: this.nodes, edges: this.tmpEdges}
          this.network = new vis.Network(this.container, this.graph_data, this.options);
          if(this.countDown == 24) this.countDown = 0;

          this.createNodeEdge()
        }, 3000)
      }
    },

    edgeSelected() {
      var connectedNodes = []
      connectedNodes = this.network.getConnectedNodes(this.network.getSelection().edges[0])
      console.log(this.network.getSelectedEdges());
      // this.$router.push({name: 'result', params: {roaddData: {}}})
      if(connectedNodes[0] != undefined && connectedNodes[1] != undefined) {
        // router.push({name: 'result', param})
        this.$http.get( `http://localhost:3000/result?from=${connectedNodes[0]}&to=${connectedNodes[1]}`,
        ).then((res) => {
          this.$router.push({name: 'result', params: {roaddData: res}})
        }).catch(function(){
          console('FAILURE!!');
        });

        // this.showModal = true
      }
      // console.log(this.network.getSelection())
    }
  }
}
</script>

<style scoped>
  #mynetwork {
    /*width: 600px;*/
    height: 500px;
    /*height: 75%;*/
    border: 1px solid lightgray;
  }

</style>