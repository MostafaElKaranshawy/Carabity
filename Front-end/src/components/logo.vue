<template>
    <div class="main-container">
        <div class="text">
            <router-link to="/" class="h1" replace>
                <h1>Carabity</h1>
            </router-link>
            <p>Buy and rent any car you want.</p>
        </div>
    </div>
</template>

<script>
import staticpage from "../views/staticpage.vue"
export default {
    name : "logo",
    components: {
        staticpage
    }
}
</script>

<style scoped>
.main-container {
    font-family: 'Cairo', sans-serif;
    font-size: 15px;
}
h1, .h1 { 
    font-size: 80px;
    color: #01015b;
    text-decoration: none;
}

.text {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-left: 200px;
}
p {
    font-weight: bold;
    color: #01015b;
}
@media (max-width: 768px) {
    .text{
        margin: 50px 0;
    }
}
</style>