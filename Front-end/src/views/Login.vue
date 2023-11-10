<template>
    <nav>
    <router-link to="/login" class="no-decoration">Login</router-link> | 
    <router-link to="/signup" class="no-decoration">Sign Up</router-link>
    </nav>
    <div class="Login">
      <div class="container">
        <logo/>
        <div class="login">
          <div class="box">
            <h2>Login</h2>
            <p>Sign in to continue</p>
          </div>
          <form :action="registed">
            <label for="email" class="child-left">Email</label>
            <input type="email" id="email" placeholder="someone@gmail/com" required v-model="email">
            <label for="password" class="child-left">Password</label>
            <input type="password" id="password" placeholder="password" required v-model="password" minlength="8">
            <button class="login-button" @click="check()">Login</button>
            <p class="forget-password form-p">Forget Password ?</p>
            <router-link to="/signup" class="form-p">Sign Up !</router-link>
          </form>
        </div>
      </div>
    </div>
</template>

<script>
// @ is an alias to /src
import logo from "../components/logo.vue"
import signup from './SignUp.vue'
import axios from 'axios'
export default {
  name: 'Login',
  data() {
    return {
      email : '',
      password : '', 
      username: '',
      registed : '' ,
    }
  },
  components: {
    signup,
    logo
  },
  methods: {
    check() {
      if(this.email != '' && this.password != ''){
        axios.post('http://localhost:8081/getuser', {"email" : this.email,"password" :this.password})
        .then(res => {
          this.username = res.data.username;
          if(this.username != "none"){
            alert("Hello " + this.username) ;
            this.registed='/home';
        }
          else {
            alert("Wrong Email or password")
          }
        }).catch(rejected =>{
          alert("Wrong Email or Password");
        })
      }
    },
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
}.login{
  margin: 0 100px;
  color: white;
  background-image: linear-gradient(90deg, #000000, #4b00ff);
  padding: 50px;
  padding-bottom: 100px;
  border-radius: 30px;
}
h2 {
  margin: 0;
  font-size: 40px;
}
.box {
  margin-bottom: 30px;
}
.box p{
  font-size: 11px;
  color: white;
  letter-spacing: 1px;
  opacity: 90%;
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
.login-button {
  padding:15px 20px;
  border-radius: 30px;
  background: #6200ff;
  color: white;
  font-weight: bold;
  border: none;
  margin-bottom: 20px;
}
.login-button:hover { 
  background: #6200ff73;
  color: #eee;
  cursor: pointer;
}
.form-p {
  margin: 3px 0 0 0;
  cursor: pointer;
  color: #eeeeeec8;
  font-size: 13px;
  text-decoration: none;
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
