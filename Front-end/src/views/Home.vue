<template>
    <nav>
        <h1>Carabity</h1>
        <input type="search" placeholder="Search a car" class="search-bar">
        <div class="links">
            <router-link to="/home" class="no-decoration">Home</router-link>
            <router-link to="/about" class="no-decoration">About</router-link>
            <router-link to="/contact" class="no-decoration">Contact</router-link>
        </div>
    </nav>
    <!-- <div class="cars">
        <div class="cars-list">
            <card v-for="car in cars" 
            :key="car"
            :carphoto="car.carphoto"
            :cartype="car.cartype" 
            :carprice="car.carprice" 
            :cardate="car.cardate"
            />
        </div>
    </div> -->
</template>
<script>
import card from '../components/cards/card.vue'
import Cars from "../components/cards.json"
import about from "../views/about.vue"
import contact from "../views/contact.vue"
export default{
    data: function(){
        return {
            cars : Cars,
            show : false,
        }
    },
    name: 'home',
    components: { 
        card ,
        about, contact
    },
}
</script>
<style scoped>
.no-decoration {
    text-decoration: none;
}
nav {
    border-bottom: 0.25px solid #cfcdff;
    color: #4b00ff;
    background: white;
padding: 20px;
display: flex;
justify-content: space-between;
}

nav a {
    font-size: 15px;
font-weight: bold;
color: #4b00ff;
padding: 10px;
margin: 10px;
background: white;
border-radius: 6px;
}
nav a:hover {
color: white;
background: #4b00ff;
}
nav a.router-link-exact-active {
    color: white;
    background: #4b00ff;}

.search-bar {
    color: #4b00ff;
    border: solid 0.25px #d4d4d4;
    font-size: 15px;
    background: white;
    width: 500px;
    border-radius: 10px;
    padding: 5px;
}
.search-bar:hover {
    background: rgb(232 240 255);
}
.cars {
    min-height: 100vh;
    background-color: #cbcbcb;
}
.cars-list{
    padding: 50px;
    display :grid;
    grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
    justify-content: center;
    align-items: center;
    grid-column-gap : 20px;
    grid-row-gap : 50px;
}
.carbutton {
    width: 100px;
    height: 50px;
    background-color: #cfcfcf;
    color: #303030;
    margin: 20px;
    border-radius: 10px;
    font-weight: bold;
    border: none;
}
.carbutton:hover{
    border : 1px solid #cfccfc;
    cursor: pointer;
    color: #cfcfcf;
    background-color: #303030;
}
</style>