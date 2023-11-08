<template>
  <div class="signup">
    <div class="container">
      <div class="Sign-up">
        <div class="box">
          <h2>Create a new account</h2>
          <router-link to="../" class="form-p">
            <p>Already have account ? Log in here</p>
          </router-link>
        </div>
        <form>
          <label for="username" class="child-left">Username</label>
          <input type="text" id="username" placeholder="Someone5121">
          <label for="email" class="child-left">Email</label>
          <input type="email" id="email" placeholder="someone@gmail/com">
          <label for="password" class="child-left">Password</label>
          <input type="password" id="password" placeholder="password">
          <label for="age" class="child-left">Age</label>
          <input type="age" id="age" placeholder="18">
          <button class="Sign-up-button">Sign-up</button>
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
// @ is an alias to /src
import login from './Login.vue'

export default {
  name: 'signup',
  components: {
    login
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
.Sign-up{
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
</style>
