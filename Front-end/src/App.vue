<template>
  <router-view/>
</template>

<style>
.no-decoration {
  text-decoration: none;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  color:#140044;
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}
nav a:hover {
  color: #4b00ff;
}
nav a.router-link-exact-active {
  color: #4b00ff;
}
</style>
