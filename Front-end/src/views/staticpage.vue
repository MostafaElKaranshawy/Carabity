<template>
    <!-- <head>
      <style src="../static.js"></style>
    </head> -->
    <div class="header">
      <!-- {{ showSlides() }} -->
        <div>
          <img class="logo" src="../assets/test-removebg.png" alt="">
        </div>
        <div class="registration">
          <button class="sign-up-button "><router-link to="/signup" class="no-decoration">Sign Up </router-link></button>
          <button class="log-in-button"><router-link to="/login" class="no-decoration">Log In </router-link></button>
        </div>
      </div>
      <div class="slideshow-container">
          <slider/>
      </div>
      <br>
    
      <div class="section-title">What people say...</div>
    
      <div class="container">
    
        <div class="row-content">
    
          <div class="reviews">
            <div class="reviewer-img-div">
              <img class="reviewer-img" src="../assets/blank-profile-picture-973460_1280.webp">
            </div>
            <div class="review-content">
              <p>it was a nice experience with them and the customer service was great...</p>
            </div>
          </div>
    
          <div class="reviews">
            <div class="reviewer-img-div">
              <img class="reviewer-img" src="../assets/blank-profile-picture-973460_1280.webp">
            </div>
            <div class="review-content">
              <p>It's nice that i can rent from them with many facilities and they deliver it to you on the right time..</p>
            </div>
          </div>
    
        </div>
    
    
        <div class="row-content">
    
          <div class="reviews">
            <div class="reviewer-img-div">
              <img class="reviewer-img" src="../assets/blank-profile-picture-973460_1280.webp">
            </div>
            <div class="review-content">
              <p>Carabity seriously helped me with my car deal. Anyone looking to get a car should just use it.</p>
            </div>
          </div>
    
          <div class="reviews">
            <div class="reviewer-img-div">
              <img class="reviewer-img" src="../assets/blank-profile-picture-973460_1280.webp">
            </div>
            <div class="review-content">
              <p>Carabity seriously helped me with my car deal. Anyone looking to get a car should just use it.</p>
            </div>
          </div>
    
        </div>
      </div>
    
    
      <!--  
        <div class="reviews">
          <p>What people Say..</p>
        </div>
        -->
    
      <div class="footer">
        <div class="about-us">About Us</div>
        <div class="parteners">Partners With Us</div>
        <div class="contact">
          <p>Contact with Us</p>
          <div>
            <a href=""><img src="../assets/youtube.jpg" alt=""></a>
            <a href=""><img src="../assets/twitter.jpg" alt=""></a>
            <a href=""><img src="../assets/facebook.jpg" alt=""></a>
          </div>
        </div>
      </div>
</template>
<script>
// import "../static.js";
import slider from "../components/slider.vue";
export default{
    name: "staticpage",
  components : {slider}
}
</script>

<style scoped>
.no-decoration {
  text-decoration: none;
  color: white;
}
.header{
  background-image: linear-gradient(to right,#272626, #001D37, #0C365B,#2B6599);
  height: 80px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  position: absolute;
  left: 0;
  right: 0;
  top: 0;
  z-index: 100;
}

.logo{
  height: 70px;
  width: 300px;

  object-fit: cover;
  background-color: transparent;
  border-width:1px ;
}

.sign-up-button, .log-in-button{
  background-color: transparent; 
  color: white;
  border-color: #128ad0;
  border-width: 1px;
  margin-right:20px;
  border-radius: 11px;
  padding: 7px 18px;
}

.section-title{
  font-weight: bold;
  font-size: xx-large;
  margin-top: 20px;
  margin-bottom: 30px;
  text-align: center;
}


.mySlides {
  display: none;

}
.mySlides img {
  vertical-align: middle;
  height:400px;
  object-fit: cover;
}

.slideshow-container {
  margin-top: 80px;
  width: 100%;
}

.container{
  display: flex;
  flex-direction: column;
  margin-bottom: 50px;
  margin-left: 100px;
  margin-right: 60px;
}

.row-content{
  display: flex;
  flex-direction: row;
  margin-bottom: 20px;
}

.reviews{
  display: flex;
  flex: 1;
}

.review-content{
  font-weight: bold;
  font-size: 17px;
  flex: 1;
  max-width: 400px;
}

.reviewer-img{
  width:100px;
  height:100px;
  border: none;
  object-fit: cover;
  border-radius: 50px;
  margin-right: 15px;
  
}
.active {
  background-color: #717171;
}
.contact img{
  width:25px;
  border-radius: 50%;
  margin-right:5px;
}
.about-us,.parteners,.contact{
margin-right: 30px;
margin-left: 30px;
}
.contact{
  display:flex;
  flex-direction: column;
  align-items: center;
}
.footer{
  position: absolute;
  background-color: #001D37;
  width: 100%;
  height: 130px;
  display:flex;
  align-items: center ;
  justify-content: space-around;
  color:white;
}

</style>