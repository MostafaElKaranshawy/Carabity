<template>
  <div class="Login">
    <div class="container">
      <div class="login">
        <div class="box">
          <h2>Login</h2>
          <p>Sign in to continue</p>
        </div>
        <form>
          <label for="email" class="child-left">Email</label>
          <input type="email" id="email" placeholder="someone@gmail/com">
          <label for="password" class="child-left">Password</label>
          <input type="password" id="password" placeholder="password">
          <button class="login-button">Login</button>
          <p class="forget-password form-p">Forget Password ?</p>
          <router-link to="/signup" class="form-p">Sign Up !</router-link>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
import signup from './SignUp.vue'
export default {
  name: 'Login',
  components: {
    signup,
  }
}
</script>
<style scoped>
.container {
  margin: 50px auto;
  transform: translate(-50%, -50%);
  position: absolute;
  top: 50%;
  left: 50%;
}
.login{
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
  /* box-shadow: 1px 1px 10px 0px #000000; */
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
</style>
