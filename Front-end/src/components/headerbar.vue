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
</template>

<script>
export default {
    name: "headerbar",
}
</script>

<style scoped>
h1 {
    cursor: pointer;
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
</style>