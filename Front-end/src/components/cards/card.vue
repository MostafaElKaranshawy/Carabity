<template>
    <div class="card">
        <div class="type">{{ cartype }}</div>
        <div class="type1">Sport</div>
        <span class="photo">
            <img src="../cover1.jpg" alt="CAR">
        </span>
        <br>
        <div class="data">
            <span class="price"> ${{carprice}}</span>
        </div>
    </div>
</template>
<script>
import { library } from '@fortawesome/fontawesome-svg-core'

/* import font awesome icon component */
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

/* import specific icons */
import { faUserSecret } from '@fortawesome/free-solid-svg-icons'
export default{
    props : ["carphoto", "carprice", "cartype", "cardate"],
    name: 'card',
    components : {
        FontAwesomeIcon
    }
}
</script>
<style>
.icon {
    font-size: 50px;
}
.card{
    width: 200px;
    background-color: white;
    color: black;
    border: 1px solid #afafaf;
    padding: 20px;
    border-radius: 10px;
    font-size: 15px;
    transition: .3s;
}

.card:hover{
    transform: scale(1.1);
}
.type{
    text-align: left;
    font-size: 15px;
    font-weight: bold;
}
.type1 {
    text-align: left;
    font-size: 12px;
    color: #b5b5b5;
    margin-bottom: 20px;
}
.photo img{
    height: 150px;
    max-width: 100%;
    border-radius: 5px;
    margin-bottom: 20px;
}
.data{
    text-align: left;
    font-size: 15px;
    font-weight: bold;
    margin-bottom: 20px;
}
.see {
    background:inherit;
    padding: 10px;
    border-radius: 10px;
    width: 90%;
    margin: 20px 0;
    border: 0;
    transition: .3s;
    color: white;
}
.see:hover{
    background: rgb(225, 225, 225);
    color:black;
    font-weight: bold;
    cursor:pointer;
}
</style>