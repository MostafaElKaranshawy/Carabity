<template>
    <div class="card">
        <div class="type">{{cartype}}</div>
        <span class="photo">
            <img src="../cover1.jpg" alt="CAR">
        </span>
        <br>
        <div class="data">
            <div class="price"> Price: {{carprice}}</div>
            <div class="date"> Date: {{cardate}}</div>
        </div>
        <input type="button" class="see" value="See Car">
    </div>
</template>
<script>
export default{
    props : ["carphoto", "carprice", "cardate", "cartype"],
    name: 'card',
}
</script>
<style>
.card{
    width: 300px;
    background-color: rgb(80, 80, 80);
    color: white;
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
    font-size: 15px;
    font-weight: bold;
    margin-bottom: 20px;
}
.photo img{
    max-width: 100%;
    border-radius: 5px;
    margin-bottom: 20px;
}
.data{
    font-size: 13px;
    display: flex;
    justify-content: space-between;
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