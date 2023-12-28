<template>
    <nav>
        <div class="one"></div>
        <div class="two"></div>
        <div class="three"></div>
    </nav>
</template>
<script>
export default {
    name: "loading"
}
</script>
<style scoped>
nav{
    width: 100%;
    height: 100vh;
    display: flex;
    margin:100px;
    justify-content: center;
}
div{
    width: 50px;
    height: 50px;
    background-color: #4b00ff;
    border-radius:50%;
    border:solid transparent;
    margin:10px;
    animation-name: up;
    animation-duration:0.9s;
    animation-iteration-count: infinite;
    /* animation-timing-function:linear; */
    animation-direction: alternate;
}
.two{
    animation-delay:0.3s ;
}
.three{
    animation-delay:0.6s ;
}
@keyframes up{
    to{
        transform: translatey(-50px);
        opacity: .2;
    }

}
</style>