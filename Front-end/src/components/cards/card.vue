<template>
    <div class="card">
        <div class="type">
            <span>{{ Brand }}</span>
            <span> {{Model}} </span>
        </div>
        <span class="photo">
            <!-- <img :src="require(`${Photo}`)" alt="CAR"> -->
            <img :src="require(`../../assets/cars-photos/${Photo}`)" alt="CAR">
        </span>
        <br>
        <div class="data">
            <div class="props">
                <span> {{ Transmission }} </span>
                <span> {{ Engine }} </span>
                <span> {{ Fuel }} </span>
            </div>
            <span class="price"> <sup>EGP</sup> {{ Price.toLocaleString() }} <sub v-if="AdType === 'Rent'">/day</sub></span>
            <span class="available" v-if="Availability === 'unavailable'">Unavailable</span>
        </div>
    </div>
</template>
<script>
export default{
    
    props : ["id"
        ,"Photo",
        "Price",
        "Brand",
        "Model",
        "Year",
        "AdType",
        "Fuel",
        "Transmission",
        "State",
        "Engine",
        "Description",
        "Features",
        "Availability"
        ],
    name: 'card',
}
</script>
<style scoped>
*{
    color: #210070;
}
.icon {
    font-size: 50px;
}
.card{
    width: 300px;
    background-color: white;
    color: black;
    padding: 20px;
    border-radius: 10px;
    font-size: 15px;
    transition: .3s;
    cursor: pointer;
}

.card:hover{
    transform: scale(1.1);
}
.type{
    text-align: left;
    font-size: 15px;
    font-weight: bold;
    margin-bottom: 20px;
}
.photo img{
    height: 200px;
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
.type span:first-child{
    font-size: 25px;
    font-weight: bold;
    margin-bottom: 10px;
    display: block;
}.type span:nth-child(2){
    color: #aea0d1;
}
.price{
    font-size: 25px;
}
sup{
    color: #aea0d1;
    font-size: 20px;
}
sub {
    color: #aea0d1;
    font-size: 18px;
}
.data .props {
    display: flex;
    justify-content: space-evenly;
    margin-bottom: 20px;
}
.data .props span {
    color: #aea0d1;
    font-weight: normal;
}
.available {
    font-weight: bold;
    margin-left: 20px;
    color: rgb(255, 0, 0);
}
</style>