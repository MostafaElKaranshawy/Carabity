<template>
    <div class="card">
        <div class="type">
            <span>{{ Brand }}</span>
            <span> {{Model}} </span>
        </div>
        <div class="data">
            <p> {{ Description }}</p>
        </div>
        <div class="photo">
            <span @click="choosecar">Car Info</span>
            <img :src="require(`../../assets/cars-photos/${Photo}`)" />
        </div>
    </div>
</template>
<script>
export default{
    data(){
        return{}
    },
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
    name: 'suggestion',
    mounted() {
        // console.log(this.Photo)
    },
    methods: {
        choosecar(){
            this.$emit('child-event', this.id);
        },
        currentImg() {
            return this.Photo;
        }
    }
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
    max-width: 600px;
    /*background-image: url("../../assets/background.jpg");*/
    background-image: linear-gradient(45deg, #55a3ff, #21349d);    background-repeat: repeat-x;
    color: black;
    padding: 20px;
    border-radius: 10px;
    font-size: 15px;
    transition: .3s;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
}
.card:hover {
    transform: scale(1.05);
    cursor: pointer;
}
@media (max-width: 450px) {
    .card { 
        max-width: 300px;
    }
}
@media (max-width: 756px) {
    .card { 
        max-width: 400px;
    }
}
.type{
    text-align: left;
    font-size: 15px;
    font-weight: bold;
    margin-bottom: 20px;
}
.type span:first-child {
    color: white;
    font-size: 40px;
    font-weight: bold;
    margin:0 20px 20px 0;
}
.type span:last-child {
    color: white;
    font-size: 20px;
    font-weight: bold;
    margin-bottom: 20px;
}
.data p {
    color: white;
    font-size: 15px;
    text-align: left;
    letter-spacing: 1px;
    line-height: 35px;
    width: 80%;
    margin-bottom:20px ;
}
.photo {
    width: 100%;
    display: flex;
    justify-content: space-evenly;
    align-items: center;
}
.photo span {
    background: white;
    color: #210070;
    font-size: 20px;
    font-weight: bold;
    padding:  5px 30px;
    border-radius: 20px;
    transition: 0.3s;
    cursor: pointer;
}
.photo span:hover {
    color: white;
    background: #210070;
}
.photo img {
    width: 50%;
    max-height: 180px;
}
</style>