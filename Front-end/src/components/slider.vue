<template>
    <div>
        <transition-group name="fade" tag="div" class="w">
        <div v-for="i in [currentIndex]" :key="i">
            <img :src="require(`${currentImg}`)" />
        </div>
        </transition-group>
        <a class="prev" @click="prev" href="#">&#10094; Previous</a>
        <a class="next" @click="next" href="#">&#10095; Next</a>
        <div style="text-align:center">
            <span  v-for="d in images.length" :key="d">
            <span class="dot active" v-if="currentIndex%images.length+1 === d"></span>
            <span class="dot" v-else></span>
            </span>
        </div>
    </div>
</template>
<script>
export default {
name: "Slider",
data() {
    return {
    images: [
        "./cover1.jpg",
        "./cover3.avif",
        "./cover1.jpg",
        "./cover3.avif",
        ],
    timer: null,
    currentIndex: 0
    };
},

mounted: function() {
    this.startSlide();
},

methods: {
    startSlide: function() {
    this.timer = setInterval(this.next, 2000);
    },

    next: function() {
    this.currentIndex += 1;
    },
    prev: function() {
    this.currentIndex -= 1;
    }
},

computed: {
    currentImg: function() {
    return this.images[Math.abs(this.currentIndex) % this.images.length];
    }
}
};
</script>

<style scoped>
.w {
    height: 600px;
}
.fade-enter-active,
.fade-leave-active {
transition: all 0.9s ease;
overflow: hidden;
visibility: visible;
position: absolute;
width:100%;
opacity: 1;
}
.dot {
    height: 15px;
    width: 15px;
    margin: 20px 2px;
    background-color: #bbb;
    border-radius: 50%;
    display: inline-block;
    transition: background-color 0.6s ease;
}  
.active {
    background-color: #717171;
}
.fade-enter,
.fade-leave-to {
visibility: hidden;
width:100%;
opacity: 0;
}

img {
height:600px;
width:100%
}

.prev, .next {
cursor: pointer;
position: absolute;
top: 40%;
width: auto;
padding: 16px;
color: white;
font-weight: bold;
font-size: 18px;
transition: 0.7s ease;
border-radius: 0 4px 4px 0;
text-decoration: none;
user-select: none;
}

.next {
right: 0;
}

.prev {
left: 0;
}

.prev:hover, .next:hover {
background-color: rgba(0,0,0,0.9);
}
</style>