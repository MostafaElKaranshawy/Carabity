<template>
    <nav>
        <header>
            <h1 @click="this.logout=true">Carabity</h1>
            <div class="logout" v-if="this.logout == true">
                <sup @click="this.logout = false">X</sup>
                <span>Are you sure you want to log out?</span>
                <div>
                    <p @click="this.logout = false, LogOut()">YES</p>
                    <p @click="this.logout = false">NO</p>
                </div>
            </div>
            <input type="search" placeholder="Search a car" class="search-bar" v-if="!this.carview" @input="handlesearching" v-model="searchbar">
            <div class="links">
                <router-link to="/home" class="no-decoration">Home</router-link>
                <router-link to="/about" class="no-decoration">About</router-link>
                <router-link to="/contact" class="no-decoration">Contact</router-link>
                <router-link to="/" class="no-decoration none"></router-link>
            </div>
        </header>
        <div class="loading" v-if="cars.length === 0">
            <loading/>
        </div>
        <!-- <div  v-if="this.comparePressed"> -->
        <div class="cars" v-if="!this.carview">
            <h2>Popular cars</h2>
            <div class="suggestions" v-if="this.suggestedcars.length > 0">
                <suggestion @child-event="clickcar" v-for="suggestedcar in suggestedslider"
                :key="suggestedcar"
                :id="suggestedcar.id"
                :Photo="suggestedcar.Photo"
                :Price="suggestedcar.Price"
                :Brand="suggestedcar.Brand"
                :Model="suggestedcar.Model"
                :Year="suggestedcar.Year"
                :AdType="suggestedcar.AdType"
                :Fuel="suggestedcar.Fuel"
                :Transmission="suggestedcar.Transmission"
                :State="suggestedcar.State"
                :Engine="suggestedcar.Engine"
                :Description="suggestedcar.Description"
                :Features="suggestedcar.Featues"
                :Availability="suggestedcar.Availability"
                />
                <a class="prev" @click="prev" href="#">&#10094; Previous</a>
                <a class="next" @click="next" href="#">Next &#10095;</a>
                <div style="text-align:center" class="dots">
                    <span  v-for="d in this.suggestedcars.length" :key="d">
                    <span class="dot activedot" v-if="(currentIndex)%this.suggestedcars.length+1 === d||(currentIndex+1)%this.suggestedcars.length+1 === d"></span>
                    <span class="dot" v-else></span>
                    </span>
                </div>
            </div>
            <div class="categories">
                <div class="cartab" id="all" @click="filtercars('all')">All</div>
                <div class="cartab" id="new" @click="filtercars('new')">New</div>
                <div class="cartab" id="used" @click="filtercars('used')">Used</div>
                <div class="cartab" id="rent" @click="filtercars('rent')">Rent</div>
            </div>
            <!-- compare -->
            <div>
                <div class="contain-button">
                <div class="compareButton cartab"
                id="comparebutton" 
                    @click="comparePressedFunction"
                    >compare</div>
                </div>
                <div class="chooseCompareCar" v-if="comparePressed">
                    <h2>select the 2 cars</h2>
                    <div class="two-drops-container">
                        <!-- <div class="comparedPhotoDiv"  v-if="comparableCar1">
                        <img class="comparedPhoto" :src="require(`../assets/${comparableCar1.Photo}`)" alt="">
                        </div> -->
                        <div class="selection-container">
                        
                        <div class="selection-part">
                            <label for="brandDropdown1">Select a Brand:</label>
                            <select class="dropBox" id="brandDropdown1" v-model="selectedBrand1">
                            <option v-for="Brand in uniqueBrands" :key="Brand" :value="Brand">{{ Brand }}</option>  
                            </select>
                        </div>
                        <div class="selection-part">
                            <label for="modelDropdown1">Select a model:</label>
                            <select class="dropBox" v-model="selectedModel1" @change="getCarsToCompare(1)" id="modelDropdown1" :disabled="!selectedBrand1">
                            <option v-for="model in modelsByBrand(selectedBrand1)" :key="model" :value="model">{{ model }}</option>
                            </select>              
                        </div>
                        </div>

                    
                        <div class="selection-container">
                        <div class="selection-part">
                            <label for="brandDropdown2">Select a Brand:</label>
                            <select class="dropBox" id="brandDropdown2" v-model="selectedBrand2">
                            <option v-for="Brand in uniqueBrands" :key="Brand" :value="Brand" >{{ Brand }}</option>  
                            </select>
                        </div>
                        <div class="selection-part">
                            <label for="modelDropdown2">Select a model:</label>
                            <select class="dropBox" v-model="selectedModel2" @change="getCarsToCompare(2)" id="modelDropdown2" :disabled="!selectedBrand2">
                            <option v-for="model in modelsByBrand(selectedBrand2)" :key="model" :value="model">{{ model }}</option>
                            </select>              
                        </div>
                        </div>

                    </div>
                    <div>
                        
                    <button class="compareButton" @click="checkModels" id="readytocompare">Let's compare</button>
                    <compare-card v-if="isReadyToCompare"  
                        :comparableCar1="this.comparableCar1"  :comparableCar2="this.comparableCar2" />

                    </div>
                </div>
            
            <div class="cars-list">
                <card v-for="car in filteredcars" @click="this.selectedcar = car, this.carview=true"
                    :key="car"
                    :id="car.id"
                    :Photo="car.Photo"
                    :Price="car.Price"
                    :Brand="car.Brand"
                    :Model="car.Model"
                    :Year="car.Year"
                    :AdType="car.AdType"
                    :Fuel="car.Fuel"
                    :Transmission="car.Transmission"
                    :State="car.State"
                    :Engine="car.Engine"
                    :Description="car.Description"
                    :Features="car.Featues"
                    :Availability="car.Availability"
                />
            </div>
        </div>
        </div>
        <div class="backbutton" v-if="this.carview" @click="this.carview=!this.carview, this.selectedcar=null, fetchcars()">&lt; BACK</div>
        <cardview v-if="this.carview"
            :key="car"
            :id="this.selectedcar.id"
            :Photo="this.selectedcar.Photo"
            :Price="this.selectedcar.Price"
            :Brand="this.selectedcar.Brand"
            :Model="this.selectedcar.Model"
            :Year="this.selectedcar.Year"
            :AdType="this.selectedcar.AdType"
            :Fuel="this.selectedcar.Fuel"
            :Transmission="this.selectedcar.Transmission"
            :State="this.selectedcar.State"
            :Engine="this.selectedcar.Engine"
            :Description="this.selectedcar.Description"
            :Features="this.selectedcar.Features"
            :Availability="selectedcar.Availability"
        />
        <div class="header footer">
            <div class="logo">
                <h1>Carabity</h1>
                <p>Our vision is to provide convenience and help increase your sales business</p>
            </div>
            <div class="contact">
                <p>Socials</p>
                <a href="">Youtube<img src="../assets/youtube.jpg" alt=""></a>
                <a href="">Twitter<img src="../assets/twitter.jpg" alt=""></a>
                <a href="">Facebook<img src="../assets/facebook.jpg" alt=""></a>
            </div>
        </div>
    </nav>
</template>
<script>
import card from '../components/cards/card.vue'
import cardview from '../components/cards/cardview.vue'
import Suggestion from '@/components/cards/suggestion.vue'
import loading from '@/components/loading.vue'
import compareCard from '@/components/cards/compareCard.vue'
export default{
    data: function(){
        return {
            cars: [],
            filteredcars: [],
            suggestedcars: [],
            suggestedslider: [],
            currentIndex: 0,
            show : false,
            searchbar: '',
            name: 'home',
            carview :false,
            selectedcar: null,
            windowWidth:0,
            comparePressed : false,
            selectedBrand1 : '',
            selectedBrand2 : '',
            selectedModel1 : '',
            selectedModel2 : '',
            comparableCar1 : null,
            comparableCar2 : null,
            isReadyToCompare : false,
            logout: false,
        }
    },
    components: { 
        card ,
        loading,
        cardview,
        Suggestion,
        compareCard
    },
    mounted(){
        this.fetchcars();
        this.windowWidth = window.innerWidth;
    },
    methods: {
        LogOut(){
            document.querySelector(".log-out").click();
        },
        setwindow(){
            this.startSlide();
            this.windowWidth = window.innerWidth;
        },
        fetchcars(){
            fetch('http://localhost:8081/user/getCarsInfo',{
            method:'GET',
            headers:{
                'Content-Type':'application/json',
            },
        }).then(response => {
            let data = response.json();
            return data;
        }).then(response => {
            this.cars = response;
            this.filtering();
        }).catch(error => {
            console.log(error);
        })
        },
        filtering(){
            this.filtercars('all');
            this.suggestedcars = this.cars.filter(car => car.Year > 2021).filter(car => car.Availability === 'available');
            this.startSlide();
        },
        filtercars(type) {
            if(type === 'all'){
                this.filteredcars = this.cars;
                document.querySelector("#all").classList.add("active");
                document.querySelector("#new").classList.remove("active");
                document.querySelector("#used").classList.remove("active");
                document.querySelector("#rent").classList.remove("active");
            }
            if(type === 'new'){
                this.filteredcars = this.cars.filter(car=> car.State === 'New' && car.AdType === 'Sale');
                document.querySelector("#all").classList.remove("active");
                document.querySelector("#new").classList.add("active");
                document.querySelector("#used").classList.remove("active");
                document.querySelector("#rent").classList.remove("active");
            }
            if(type === 'used'){
                this.filteredcars = this.cars.filter(car=> car.State === 'Used' && car.AdType === 'Sale');
                document.querySelector("#all").classList.remove("active");
                document.querySelector("#new").classList.remove("active");
                document.querySelector("#used").classList.add("active");
                document.querySelector("#rent").classList.remove("active");
            }
            if(type === 'rent'){
                this.filteredcars = this.cars.filter(car=> car.AdType === 'Rent');
                document.querySelector("#all").classList.remove("active");
                document.querySelector("#new").classList.remove("active");
                document.querySelector("#used").classList.remove("active");
                document.querySelector("#rent").classList.add("active");
            }
        },
        clickcar(data){
            console.log(data);
            this.selectedcar =this.cars.find(car => car.id === data);
            this.carview = true;
            // console.log(this.selectedcar);
        },
        startSlide: function() {
            this.timer = setInterval(this.next, 6000);
            this.suggestedslider[0] = this.suggestedcars[Math.abs(this.currentIndex) % this.suggestedcars.length];
            if(this.suggestedcars.length > 1 && window.innerWidth > 1330)this.suggestedslider[1] = this.suggestedcars[(Math.abs(this.currentIndex)+1) % this.suggestedcars.length];
            // if(this.suggestedcars.length > 2 && window.innerWidth > 1840)this.suggestedslider[2] = this.suggestedcars[(Math.abs(this.currentIndex)+2) % this.suggestedcars.length];
        },
        next: function() {
            this.currentIndex += 1;
            this.suggestedslider[0] = this.suggestedcars[Math.abs(this.currentIndex) % this.suggestedcars.length];
            if(this.suggestedcars.length > 1 && window.innerWidth > 1330)this.suggestedslider[1] = this.suggestedcars[(Math.abs(this.currentIndex)+1) % this.suggestedcars.length];
            // if(this.suggestedcars.length > 2 && window.innerWidth > 1840)this.suggestedslider[2] = this.suggestedcars[(Math.abs(this.currentIndex)+2) % this.suggestedcars.length];
        },
        prev: function() {
            this.currentIndex -= 1;
            this.suggestedslider[0] = this.suggestedcars[Math.abs(this.currentIndex) % this.suggestedcars.length];
            if(this.suggestedcars.length > 1 && window.innerWidth > 1330)this.suggestedslider[1] = this.suggestedcars[(Math.abs(this.currentIndex)+1) % this.suggestedcars.length];
            // if(this.suggestedcars.length > 2 && window.innerWidth > 1840)this.suggestedslider[2] = this.suggestedcars[(Math.abs(this.currentIndex)+2) % this.suggestedcars.length];
        },
        
        modelsByBrand(selectedBrand) {
            const models = this.cars
            .filter(car => car.Brand === selectedBrand)
            .map(car => car.Model);

            return [...new Set(models)];
        },
        checkModels(){
            if(this.selectedModel1 !== '' && this.selectedModel2 !== '')
            this.isReadyToCompare = true

            if(this.isReadyToCompare){
                document.querySelector("#readytocompare").classList.add("active");
            }
            else{
                document.querySelector("#readytocompare").classList.remove("active");
            }
        },
        getCarsToCompare(choice){
            let temp1 = null
            if(choice === 1 && this.selectedModel1 !== '' ){
                for (let i = 0; i < this.cars.length; i++){
                if(this.cars[i].Brand === this.selectedBrand1 && this.cars[i].Model === this.selectedModel1){
                    this.comparableCar1 = this.cars[i]
                    break
                }
                }
            }
            else if(choice === 2 && this.selectedModel2 !== ''){
                for (let i = 0; i < this.cars.length; i++){
                if(this.cars[i].Brand === this.selectedBrand2 && this.cars[i].Model === this.selectedModel2){
                    this.comparableCar2 = this.cars[i]
                    break
                }
                }
            }
        },
        comparePressedFunction(){
            this.comparePressed = !this.comparePressed
            if(this.comparePressed){
                document.querySelector("#comparebutton").classList.add("active");
            }
            else{
                document.querySelector("#comparebutton").classList.remove("active");
            }
            if(this.comparePressed === false){
            this.selectedBrand1 = ''
            this.selectedModel1 = ''
            this.selectedBrand2 = ''
            this.selectedModel2 = ''
            this.isReadyToCompare = false
            }
        }
    },
    computed: {
        uniqueBrands() {
            const uniqueBrandSet = new Set();
            this.cars.forEach(car => {
            uniqueBrandSet.add(car.Brand);
            });
            // console.log(uniqueBrandSet);
            return Array.from(uniqueBrandSet);
        }
    }
}
</script>
<style scoped>
.none{
    display: none;
    position: absolute;
}
nav {
    padding:0;
    margin:0;
}
.no-decoration {
    text-decoration: none;
}
.no-decoration {
    text-decoration: none;
}
header {
    border-bottom: 0.25px solid #cfcdff;
    color: #4b00ff;
    background: white;
    padding: 20px;
    display: flex;
    justify-content: space-between;
}
header h1 {
    cursor: pointer;
}
.logout{
    padding: 25px;
    position: fixed;
    top: 75px;
    left: 33px;
    display: flex;
    flex-direction: column;
    background-color: #fcfcfc;
    border: none;
    border-radius: 10px;
    box-shadow: 0 0 10px 5px #ccc;
    z-index: 1000;
    color: #210070;
}
.logout div:first-child{
    display: flex;
    justify-content: space-around;
    padding: 14px;
    font-size: 18px;
}
.logout div:first-child span{
    margin: 0 10px;
}
.logout sup{
    font-size: 15px;
    padding: 5px;
    transition: 0.3s;
    border-radius: 5px;
    cursor: pointer;
    transform: translateY(-10px);
    align-self: flex-end;
}
.logout span {
    font-weight: bold;
    margin-bottom: 23px;
}
.logout  sup:hover{
    color: white;
    background: #210070;
}
.logout div{
    display: flex;
    justify-content: space-evenly;
    padding: 14px;
    font-size: 18px;
}
.logout div p{
    font-size: 15px;
    font-weight: bold;
    padding: 10px 50px;
    transition: 0.3s;
    border-radius: 5px;
    cursor: pointer;
    transform: translateY(-10px);
    align-self: flex-end;
}
.logout div p:hover{
    color: white;
    background: #210070;
}
header a{
    font-size: 15px;
    font-weight: bold;
    color: #4b00ff;
    padding: 10px;
    margin: 10px;
    background: white;
    border-radius: 6px;
}
header a:hover{
color: white;
background: #4b00ff;
}
header a.router-link-exact-active {
    color: white;
    background: #4b00ff;
}

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
.loading {
    margin-top: 200px;
    display: flex;
    align-self: center;
    direction: column;
}
.cars {
    /*min-height: 50vh;*/
    background-color: #eee;
    padding: 50px 100px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: stretch;
}
.suggestions {
    padding: 50px;
    display: flex;
    flex-wrap: wrap;
    grid-column-gap : 10px;
    grid-row-gap : 50px;
    justify-content: center;
    justify-items: center;
    position: relative;
}
@media (max-width = 1620px) {
    .suggestions{
        flex-direction: column;
    }
}
.dots {
    position: absolute;
    bottom: 0;
}
.prev, .next {
    cursor: pointer;
    position: absolute;
    top: 40%;
    width: auto;
    padding: 16px;
    color: #210070;
    font-weight: bold;
    font-size: 18px;
    transition: 0.7s ease;
    border-radius: 0 4px 4px 0;
    text-decoration: none;
    user-select: none;
}

.next {
right: 0;
}

.prev {
left: 0;
}

.prev:hover, .next:hover {
background-color: #210070;
color: white;
}
.cars .categories {
    display: flex;
    padding: 10px;
    margin: 20px;
    justify-content: space-between;
    align-self: center;
    font-size: 25px;
    font-weight: bold;
}
.cartab{
    padding: 10px;
    margin: 10px;
    color: #210070;
    transition: 0.3s;
    cursor: pointer;
}
.chooseCompareCar {
    padding: 50px;
    background: #e4e4e4;
    border-radius: 20px;
    color: #210070;
    border-left: 1px solid #210070;
    border-right: 1px solid #210070;
    display: flex;
    flex-direction: column;
    align-content: center;
    align-items: center;
}
.compareButton{
    padding: 10px;
    margin: 10px;
    color: #210070;
    transition: 0.3s;
    align-self: center;
    cursor: pointer;
    border: none;
    justify-content: space-between;
    align-self: center;
    font-size: 25px;
    font-weight: bold;
}
.active {
    background: #210070;
    color: white;
}
.cartab:hover , .compareButton:hover{
    background: #210070;
    color: white;
}
.contain-button{
    width: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
}
.chooseCompareCar h2{
    margin-bottom: 50px;
}
.chooseCompareCar select{
    cursor: pointer;
}
.chooseCompareCar select option{
    cursor: pointer;
}
.chooseCompareCar select option::value {
    font-weight: bold;
    color: white;
    background-color: #210070
}
.selection-container{
    width: 50%;
    font-size: 18px;
    font-weight: bold;
    /* padding: 10px; */
    display :grid;
    /* grid-template-columns: repeat(auto-fill, minmax(350px, 1fr)); */

}
.two-drops-container{
    width: 50%;;
    display: flex ;
    /* grid-template-columns: repeat(auto-fill, minmax(350px, 1fr)); */
    flex-direction: row;

    justify-content: center;
    align-items: center;
    /* padding-left: 100px; */

}
    .selection-part{
    margin: 10px;
    display: flex;
    flex-direction: column;
    }
    .dropBox{
    padding: 6px 10px;
    margin-top: 8px;
    font-weight: 500;

    }
    .comparedPhoto{
    width: 20px;
    margin-right: 100px;
    margin-left: 100px;
    }

@media (max-width:450px) {
    .search-bar{
        display: none;
    }
    .categories{
        margin: 5px;
        padding: 5px;
    }
    .cartab {
        margin: 5px;
        padding: 5px;
        font-size: 18px;
    }
    .suggestions{
        grid-template-columns: repeat(auto-fill, minmax(350px, 1fr));
    }
}
.cars-list{
    padding: 50px;
    display :grid;
    grid-template-columns: repeat(auto-fill, minmax(350px, 1fr));
    justify-content: center;
    justify-items: center;
    grid-column-gap : 20px;
    grid-row-gap : 50px;
}
.contact img{
width:25px;
border-radius: 50%;
margin: 0 20px;
}
.about-us,.parteners,.contact{
margin-right: 30px;
margin-left: 30px;
}
.contact{
display:flex;
flex-direction: column;
align-items: flex-start;
}
.backbutton{
    font-weight: bold;
    width: 100px;
    color: #210070;
    text-align: left;
    padding: 20px;
    cursor: pointer;
    border-top-right-radius: 20px;
    border-bottom-right-radius: 20px;
    transition: 0.3s;
    position: absolute;
    z-index: 10;
}
.backbutton:hover{
    color: white;
    background: #210070;
}

.footer{
    border-bottom: 0.25px solid #cfcdff;
    color: #4b00ff;
    background: white;
    display: flex;
    justify-content: space-between;
    align-items : center;
    height: 250px;
    padding: 20px 50px;
}
.footer .logo {
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: flex-start;
    max-width: 400px;
}
.footer .logo h1 {
    margin: 30px 0;
    font-size: 40px;
}
.footer .logo p{
    font-size: 20px;
    color: #bcbcbc;
    text-align: left;
}
.footer .contact a{
    font-size:20px;
    color:#bcbcbc;
    text-decoration: none;
    margin-bottom: 20px;
    width: 160px;
    display: flex;
    justify-content: space-between;
}
.footer .contact a:hover {
    color:#4b00ff;
}
.footer p{
    margin-bottom: 50px;
    font-size: 25px;
    font-weight: bold;
    color: black;
}
.dot {
    height: 15px;
    width: 15px;
    margin: 20px 2px;
    background-color: #bbb;
    border-radius: 50%;
    display: inline-block;
    transition: background-color 0.6s ease;
}
.activedot{
    background-color: #717171;
}
</style>