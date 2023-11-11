<template>
  <!-- <headerbar/> -->
  <nav>
    <router-link to="/login" class="no-decoration">Login</router-link> | 
    <router-link to="/signup" class="no-decoration">Sign Up</router-link>
  </nav>
  <div class="signup">
    <div class="container">
      <logo/>
      <div class="Sign-up">
        <div class="box">
          <h2>Create a new account</h2>
          <router-link to="../" class="form-p">
            <p>Already have account ? Log in here</p>
          </router-link>
        </div>
        <form action="/login">
          <label for="username" class="child-left">Username</label>
          <input type="text" id="username" placeholder="Someone5121" required v-model="username" maxlength="20">
          <label for="email" class="child-left">Email</label>
          <input type="email" id="email" placeholder="someone@gmail/com" required v-model="email">
          <label for="password" class="child-left">Password</label>
          <input type="password" id="password" placeholder="password" required v-model="password" minlength="8" maxlength="20">
          <label for="age" class="child-left">Age</label>
          <input type="number" id="age" placeholder="18" required v-model="age" min="18">
          <button class="Sign-up-button" @click="submitform()">Sign-up</button>
          <p v-if="valid">Sign up Successfully</p>
          <router-link to="../" class="form-p">
            <p>Already Have An Account ?</p>
            <p>Click here to Login</p>
          </router-link>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
// import axios from "axios"
// @ is an alias to /src
import headerbar from "../components/headerbar.vue"
import logo from "../components/logo.vue"
import login from './Login.vue'
import axios from 'axios'
export default {
  name: 'signup',
  data(){
    return {
      username: '',
      email: '',
      password: '',
      age: null,
      valid: false
    }
  },  
  components: {
    login,
    logo,
    headerbar
  },
  methods : {
    submitform() {
      document.getElementById('username').classList.remove()
        document.getElementById('email').classList.remove()
        document.getElementById('password').classList.remove()
        document.getElementById('age').classList.remove()
        if(this.username != '' && this.email != '' && this.password != '' && this.age >= 18 &&this.password.length>=8 && this.age < 100){
          

        axios.post('http://localhost:8081/check', {"username" : this.username,"password" :this.password,"email" : this.email,"age" : this.age})
        .then(res => {
          this.valid = res.data
          if(this.username != "none"){
          document.querySelector(".signup-form").onsubmit = function() {
              return false;
            }
            document.querySelector(".form-p").click();
          }
          else {
            alert("Wrong Email or password")
        }
        })
        .then(document.querySelector(".form-p").click())
        .then(alert("Signed up successfully"))
        .catch(err => console.log("error"));
      }
      else{
        if(this.username == ''){
          document.getElementById('username').classList.add('error')
        }

        if(this.email == '')
          document.getElementById('email').classList.add('error')

        if(this.password == '')
          document.getElementById('password').classList.add('error')

        if(this.age == null || this.age >= 100)
          document.getElementById('age').classList.add('error')
      }
  }
}
}
</script>
<style scoped>
nav {
  color: white;
  background:#140044;
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: white;
}
nav a:hover {
  color: #4b00ff;
}
nav a.router-link-exact-active {
  color: #4b00ff;
}
.container {
  max-height: 100vh;
  display: flex;
  width: 100%;
  justify-content: space-evenly;
  align-items: center;
  margin: 50px auto;
  transform: translate(-50%, -50%);
  position: absolute;
  top: 50%;
  left: 50%;
}
.Sign-up{
  margin: 0 100px;
  color: white;
  background-image: linear-gradient(90deg, #000000, #4b00ff);
  padding: 40px 60px;
  border-radius: 30px;
}
h2 {
  margin: 0;
  font-size: 30px;
}
.box {
  margin-bottom: 10px;
}
form {
  display: flex;
  padding: 20px;
  flex-direction: column;
}
.child-left {
  align-self:flex-start;
  font-size: 12px;
  color: #fff;
  letter-spacing: 1px;
  padding-left: 10px;
}
input{
  margin-top:5px;
  margin-bottom: 20px;
  padding: 10px 20px;
  border-radius: 19px;
  background-color: #80808078;
  color: white;
  border: none;
  min-width: 270px;
}
input:hover{
  border: none;
  background-color: darkslateblue;
  cursor: pointer;
}
input:focus{
  border: none;
  background-color: darkslateblue;
  cursor: text;
}
input::placeholder {
  color: rgba(188, 188, 188, 0.549);
}
.Sign-up-button {
  padding:15px 20px;
  border-radius: 30px;
  background: #6200ff;
  color: white;
  font-weight: bold;
  border: none;
  margin-bottom: 20px;
}
.Sign-up-button:hover { 
  background: #6200ff73;
  color: #eee;
  cursor: pointer;
  /* box-shadow: 1px 1px 10px 0px #000000; */
}
.form-p {
  margin: 3px 0 0 0;
  cursor: pointer;
  color: #eeeeeec8;
  font-size: 13px;
  text-decoration: none;
  line-height: 1.3px;
}
.form-p p {
  margin: 13px 0;
}
.form-p:hover {
  color: #eeeeee67;
}
@media (max-width: 768px) {
  .container{
    flex-direction: column;
  }
}
</style>
