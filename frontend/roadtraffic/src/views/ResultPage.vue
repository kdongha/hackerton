<template>
    <div class="container">
        <h3>{{roadData.road_start}} <-> {{roadData.end}}</h3>
        <ul class="nav nav-tabs" v-for="time in roadData.road_flag.length">
            <li @click="showDetail(time)"><a href="#">{{time}}</a></li>
        </ul>
        <div class="tab-content" v-for = "idx in 5">
            <div class="media">
                <i v-if="idx === roadData.opt_table[selection]" class="fa fa-check align-self-center mr-3"></i>
                <i v-else class="fa fa-times align-self-center mr-3"></i>
                <div class="media-body">
                    <h3 class="mt-0">Now</h3>
                    <p>{{roadData.road_flag[selection][idx].complexity}}</p>
                    <p>{{roadData.road_flag[selection][idx].density}}</p>
                    <p class="mb-0">{{roadData.road_flag[selection][idx].velocity}}</p>
<!--                    <p class="mb-0">{{roadData.road_flag[selection][idx].flow}}</p>-->
                </div>

            </div>

        </div>

    </div>
</template>

<script>
    export default {
        name: "ResultPage",
        data() {
            return {
                selection : 0
            }
        },
        props: {
            roadData: null
        },
        methods: {
            showDetail(time) {
                this.selection = time
            }
        }
    }
</script>

<style scoped>

</style>