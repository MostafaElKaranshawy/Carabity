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
import about from "../views/about.vue"
import contact from "../views/contact.vue"
import home from "../views/Home.vue"
export default {
    name: "headerbar",
    components: {
        home,
        contact,
        about,
    }
}
</script>

<style scoped>
.no-decoration {
    text-decoration: none;
}
nav {
color: white;
background:#140044;
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
    background: lightgrey;
    width: 500px;
    border: none;
    border-radius: 10px;
    padding: 5px;
}
.search-bar:hover {
    background: rgb(171, 171, 171);
}
</style>