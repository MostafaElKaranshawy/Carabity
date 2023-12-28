<template>
        <headerbar/>
        <div class="page">
            <h1>About</h1>
            <p class="about">
                Carabity is a web application that provides cars for the users with the ability to rent and buy both used and new cars!
            </p>
            <p class="names" >
                We are team of six members
            </p>
            <div class="container-images">
                <img class="mySlides" src="../assets/person1.jpg" style="width:100%">
                <span class="name">Amen</span>
                <span class="role">Backend</span>
                <img class="mySlides" src="../assets/person2.jpg" style="width:100%">
                <span class="name">Andrew</span>
                <span class="role">Frontend</span>
                <img class="mySlides" src="../assets/person3.jpg" style="width:100%">
                <span class="name">Mostafa</span>
                <span class="role">Frontend</span>
                <img class="mySlides" src="../assets/person4.jpg" style="width:100%">
                <span class="name">Rafy</span>
                <span class="role">Backend</span>
                <img class="mySlides" src="../assets/person5.jpg" style="width:100%">
                <span class="name">Yomna</span>
                <span class="role">Full Stack</span>
                <img class="mySlides" src="../assets/person6.jpg" style="width:100%">
                <span class="name">Youssef</span>
                <span class="role">Full Stack</span>

                <div class="slider-button1" @click="plusDivs(-1)">&#10094;</div>
                <div class="slider-button2" @click="plusDivs(1)">&#10095;</div>
            </div>
        </div>
        <div class="header footer">
        <div class="logo">
            <h1>Carabity</h1>
            <p>Our vision is to provide convenience and help increase your sales business</p>
        </div>
        <div class="contact">
            <p>Socials</p>
            <a href="">Youtube<img src="../assets/youtube.jpg" alt=""></a>
            <a href="">Twitter<img src="../assets/twitter.jpg" alt=""></a>
            <a href="">Facebook<img src="../assets/facebook.jpg" alt=""></a>
        </div>
    </div>
</template>
<script>
import headerbar from "../components/headerbar.vue"
export default{
    name: "about",
    components: {
        headerbar
    },
    data(){
        return{
            slideIndex:1,
        }
    },
    mounted(){
        this.showDivs(this.slideIndex)
    },
    methods:{
        plusDivs(n) {
            this.showDivs(this.slideIndex += n);
        },
        showDivs(n) {
            var i;
            var x = document.getElementsByClassName("mySlides");
            if (n > x.length) {this.slideIndex = 1}
            if (n < 1) {this.slideIndex = x.length}
            for (i = 0; i < x.length; i++) {
                x[i].style.display = "none";  
            }
            x[this.slideIndex-1].style.display = "block";  

            x = document.getElementsByClassName("name");
            if (n > x.length) {this.slideIndex = 1}
            if (n < 1) {this.slideIndex = x.length}
            for (i = 0; i < x.length; i++) {
                x[i].style.display = "none";  
            }
            x[this.slideIndex-1].style.display = "block";
            
            
            x = document.getElementsByClassName("role");
            if (n > x.length) {this.slideIndex = 1}
            if (n < 1) {this.slideIndex = x.length}
            for (i = 0; i < x.length; i++) {
                x[i].style.display = "none";  
            }
            x[this.slideIndex-1].style.display = "block";  
        }
    }
}
</script>
<style scoped>
.page{
    background-color:#eee;
    padding-bottom: 200px;
}
.logo h1 {
    color: #4b00ff;
}
.role {
    right: 24%;
    top: 65%;
    position: absolute;
    padding: 10px;
    background-color: #fefefe;
    border-radius: 5px;
    font-weight: bold;
}
.name {
    left: 24%;
    top: 65%;
    position: absolute;
    padding: 10px;
    background-color: #fefefe;
    border-radius: 5px;
    font-weight: bold;
}
.names {
    color: #210070;
    padding: 20px 20px 0px;
    font-size: 50px;
}
.slider-button1:hover,
.slider-button2:hover{
    background-color: #ddd;
    color: #4b00ff
}
.slider-button1,
.slider-button2 {
    cursor: pointer;
    background: white;
    width: 40px;
    height: 40px;
    font-weight: bold;
    font-size: 25px;
    border-radius: 7px;
    position: absolute;
    display: flex;
    align-items: center;
    justify-content: center;
}
.about {
    color: #210070;
    margin: auto;
    width: 60%;
    padding: 20px;
    font-weight: bold ;
    font-size: 30px;
}
.slider-button1 {
    top: 90%;
    left: 20%;
}
.slider-button2 {
    top: 90%;
    right: 20%;
}
.container-images {
    width: 60%;
    margin: 50px auto;
    display: flex;
    justify-content: center;
}
.mySlides {
    height: 600px;
    display:none;
    border-radius: 10px;
}
h1 {
    padding: 30px;
    font-size: 60px;
    color: #210070;
}
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

.footer{
    border-bottom: 0.25px solid #cfcdff;
    color: #4b00ff;
    background: white;
    display: flex;
    justify-content: space-between;
    align-items : center;
    height: 250px;
    padding: 20px 50px;
}
.footer .logo {
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: flex-start;
    max-width: 400px;
}
.footer .logo h1 {
    margin: 30px 0;
    font-size: 40px;
}
.footer .logo p{
    font-size: 20px;
    color: #bcbcbc;
    text-align: left;
}
.footer .contact a{
    font-size:20px;
    color:#bcbcbc;
    text-decoration: none;
    margin-bottom: 20px;
    width: 160px;
    display: flex;
    justify-content: space-between;
}
.footer .contact a:hover {
    color:#4b00ff;
}
.footer p{
    margin-bottom: 50px;
    font-size: 25px;
    font-weight: bold;
    color: black;
}
.contact img{
width:25px;
border-radius: 50%;
margin: 0 20px;
}
.about-us,.parteners,.contact{
margin-right: 30px;
margin-left: 30px;
}
.contact{
display:flex;
flex-direction: column;
align-items: flex-start;
}
</style>