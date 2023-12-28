<template>
    <div class="view">
        <div class="container">
            <!-- <slider/> -->
            <div class="photos">
                <img :src="require(`../../assets/cars-photos/${Photo}`)" />
                <!-- <img src="../.././assets/cover1.jpg" alt="img"> -->
                <!-- <img :src="Photo" alt="img"> -->
            </div>
            <div class="details">
                <div class="header">
                    <div class="price">
                        <div><sup>EPG</sup><span> {{Price.toLocaleString()}} </span>  <span v-if="AdType==='Rent'">/day</span><span>For {{AdType}} </span></div>
                        <img src="../../assets/heart.png" alt="fav" class="filter">
                    </div>
                    <div class="availability" v-if="Availability =='unavailable'">Un Available</div>
                    <div class="type">
                        <div class="name">
                            <span>{{Brand}}</span>
                            <span>{{Model}}</span>
                        </div>
                        <div class="location">
                            <p>6-October city, Cairo</p>
                            <img src="../../assets/location.png" alt="loc" class="filter">
                        </div>
                    </div>
                </div>
                <div class="detail">
                    <span>Details</span>
                    <div class="item">
                        <p>Price</p>
                        <p> {{ Price }} </p>
                    </div>
                    <hr>
                    <div class="item">
                        <p>Brand</p>
                        <p> {{Brand}} </p>
                    </div>
                    <hr>
                    <div class="item">
                        <p>Model</p>
                        <p> {{ Model }} </p>
                    </div>
                    <hr>
                    <div class="item">
                        <p>Date of factory</p>
                        <p>{{Year}}</p>
                    </div>
                    <hr>
                    <div class="item">
                        <p>Ad type</p>
                        <p>For {{AdType}}</p>
                    </div>
                    <hr>
                    <div class="item">
                        <p>Fuel Type</p>
                        <p>{{Fuel}}</p>
                    </div>
                    <hr>
                    <div class="item">
                        <p>Transimision type</p>
                        <p>{{Transmission}}</p>
                    </div>
                    <hr>
                    <div class="item">
                        <p>State</p>
                        <p>{{State}}</p>
                    </div>
                    <hr>
                    <div class="item">
                        <p>Engine Capacity</p>
                        <p>{{Engine}}</p>
                    </div>
                    <hr>
                </div>
                <div class="description">
                    <h2>Description</h2>
                    <p>{{Description}}</p>
                    <br>
                    <br>
                    <p>Is For {{ AdType }} Now!</p>
                </div>
                <div class="features">
                    <div class="feature" v-for="feature in Features" :key="feature">{{feature}}</div>
                </div>
                <button v-if="Availability == 'unavailable'" class="unavailable online-shipment">Un Available</button>
                <div v-else>
                    <button v-if="forSale()" class="online-shipment" @click="displaypaymentPage()"> Order Online </button>
                    <button v-else class="online-shipment" @click="rentOnline=!rentOnline" > Rent Online </button>
                </div>
                <div v-if="rentOnline" class="online-rent" >
                    <button class="exit-rent" @click="rentOnline=!rentOnline">X</button>
                    <label for="startDate">Start Date:</label>
                    <input v-model="startDate" type="date" id="startDate" name="startDate"  />
                    <label for="endDate">End Date:</label>
                    <input v-model="endDate" type="date" id="endDate" name="endDate" />
                    <p class="check-date-input">{{ daysDifference }}</p>
                    <button class="online-shipment" @click="handleRentDisplayment()">Continue to Pay</button>
                </div>
            </div>
        </div>
    </div>
    <div class="payment" id="payment" @click="checkFocus()">
        <div class="title">
            <h1>Payment</h1>
            <svg @click="mainPage()" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-lg" viewBox="0 0 16 16" id="x">
                <path d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8 2.146 2.854Z"/>
            </svg>
        </div>
        <form action="" method="get" class="payment-form">
            <div v-if="forSale()" class="price-display"> EGP {{Price.toLocaleString()}} </div>
            <div v-else class="price-display"> EGP {{ handleRendPrice() }} </div>
            <label for="credit-card" id="creditcard">Card number</label>
            <div class="card">
                <input type="text" name="cardnumber" id="credit-card" autocomplete="off" maxlength="16" @keypress='validateString(event)' @keyup="validateCard(1)">
                <img src="../../assets/VISA.jpg" alt="" class="cards-images">
                <img src="../../assets/mastercard.jpg" alt="" class="cards-images">
                <img src="../../assets/American_Express.jpg" alt="" class="american-express-card">
            </div>
            <div class="error-message"></div>

        </form>
        <button id="buy-now" @click="submitCard()">Buy Now</button>
        <div class="successful-payment"></div>
    </div>
    <div class="confirm-payment" id="confirm-payment">
        <p>Confirm Payment</p>
        <div class="yes-no-buttons">
            <button class="yes" @click="confirmBuy(0)">Yes</button>
            <button class="no" @click="confirmBuy(1)">No</button>
        </div>
    </div>
    <div id="overlay" @click="mainPage()"></div>
</template>
<script>
import slider from "../slider.vue"
export default{
    data: function(){
        return {
            rentOnline : false,
            startDate: null,
            endDate: null,
            rentPrice:null,
            dataFull :false,
        }
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
    name: 'cardview',
    components: {
        slider
    },
    methods: {
    handleRendPrice (){
        if(this.rentPrice != null)
            return this.rentPrice.toLocaleString()
        else{return}
    },
    confirmBuy(buyCheck){
        var successful = document.querySelector('.successful-payment')
        if(buyCheck == 0) //clicked yes
        {
            if(this.State == 'Used' && this.AdType == 'Sale'){
                fetch("http://localhost:8081/user/addold",{
                    method:"POST",
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded',
                    },
                    body: new URLSearchParams({
                        car: this.id
                }),
                }).then(response=>{
                }).catch(error => {
                    console.error("Error:", error);
                    this.isError = true;
                });
                }
            else if(this.State == 'New' && this.AdType == 'Sale'){
                fetch("http://localhost:8081/user/addnew",{
                method:"POST",
                headers: {
                        'Content-Type': 'application/x-www-form-urlencoded',
                    },
                    body: new URLSearchParams({
                        car: this.id
                    }),  
                }).then(response=>{
                })
                .catch(error => {
                    console.error("Error:", error);
                    this.isError = true;
                });
                }
            else if(this.AdType == 'Rent'){
                fetch("http://localhost:8081/user/rent",{
                    method:"POST",
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded',
                    },
                    body: new URLSearchParams({
                        car: this.id
                      }),
                }).then(response=>{
                }).catch(error => {
                    console.error("Error:", error);
                    this.isError = true;
                });
                }
            successful.innerHTML = 'Payment is successful !'
            successful.style.color = '#12a52f'
        }else{
            successful.innerHTML = ''
        }
        
        document.getElementById('confirm-payment').style.display = 'none';
    },
    forSale() {
        return this.AdType === "Sale";
    },
    handleRentDisplayment(){
        if(this.dataFull){
            this.displaypaymentPage();
        }
        else{
            document.querySelector(".check-date-input").style.color="red"
        }
    }
    ,
    displayConfirmMessage(){
        document.getElementById('confirm-payment').style.display = 'block';
        // Center the pop-up dynamically
        this.centerPopupConfirm()

        // Update the pop-up position on window resize
        window.addEventListener('resize', this.centerPopupConfirm());
    },
    centerPopupConfirm(){
            const popup = document.getElementById('confirm-payment');
            const windowHeight = window.innerHeight;
            const popupHeight = popup.clientHeight;

            // Calculate the top position to center the pop-up
            const topPosition = Math.max(0, (windowHeight - popupHeight) / 2);

            // Set the top position dynamically
            popup.style.top = topPosition + 'px';
    },
    displaypaymentPage(){
            document.querySelector('.successful-payment').innerHTML = ''
            document.getElementById('credit-card').value = ''
            this.displayError(-1)
            document.getElementById('overlay').style.display = 'block';
            document.getElementById('payment').style.display = 'block';

        // Center the pop-up dynamically
            this.centerPopup()

        // Update the pop-up position on window resize
            window.addEventListener('resize', this.centerPopup());
            document.getElementById('credit-card').focus();
        },
        mainPage(){
      // Hide the overlay and pop-up
            document.getElementById('overlay').style.display = 'none';
            document.getElementById('payment').style.display = 'none';
            document.getElementById('confirm-payment').style.display = 'none';

            // Remove the resize event listener
            window.removeEventListener('resize', this.centerPopup());
        },
        centerPopup() {
            const popup = document.getElementById('payment');
            const windowHeight = window.innerHeight;
            const popupHeight = popup.clientHeight;

            // Calculate the top position to center the pop-up
            const topPosition = Math.max(0, (windowHeight - popupHeight) / 2);

            // Set the top position dynamically
            popup.style.top = topPosition + 'px';
        },
        validateString(evt) {
            var theEvent = evt || window.event;

            // Handle paste
            if (theEvent.type === 'paste') {
                key = event.clipboardData.getData('text/plain');
            } else {
            // Handle key press
                var key = theEvent.keyCode || theEvent.which;
                key = String.fromCharCode(key);
            }
            var data = document.getElementById("credit-card").value
            var regex = /[0-9]|\./;
            if( !regex.test(key) ) {
                theEvent.returnValue = false;
                if(theEvent.preventDefault) theEvent.preventDefault();
            }
        },
        validateCard(focus){
            var data = document.getElementById("credit-card").value
            var successful = document.querySelector(".successful-payment").innerHTML =''
            switch (data.length) {
                case 0:
                    this.displayError(-1)
                    break;
                case 1:
                    if(Number(data[0]) == 3 || Number(data[0]) == 4 || Number(data[0]) == 5) {this.displayError(-1)}
                    else {this.displayError(0)}
                    break
                case 2:
                    if((Number(data[0]) == 3 && Number(data[1]) == 4) || (Number(data[0]) == 3 && Number(data[1]) == 7)
                    || (Number(data[0]) == 5 && Number(data[1]) == 1) || (Number(data[0]) == 5 && Number(data[1]) == 2) 
                    || (Number(data[0]) == 5 && Number(data[1]) == 3) || (Number(data[0]) == 5 && Number(data[1]) == 4)
                    || (Number(data[0]) == 5 && Number(data[1]) == 5) || (Number(data[0]) == 4)) {
                        if(focus == 1)
                            this.displayError(-1)
                        else
                            this.displayError(1)
                    }
                    else {this.displayError(0)}
                    break;
                case 16:
                    if((Number(data[0]) == 3 && Number(data[1]) == 4) || (Number(data[0]) == 3 && Number(data[1]) == 7)
                    || (Number(data[0]) == 5 && Number(data[1]) == 1) || (Number(data[0]) == 5 && Number(data[1]) == 2) 
                    || (Number(data[0]) == 5 && Number(data[1]) == 3) || (Number(data[0]) == 5 && Number(data[1]) == 4)
                    || (Number(data[0]) == 5 && Number(data[1]) == 5) || (Number(data[0]) == 4)) {
                        this.displayError(-1)
                    }
                    else{
                        this.displayError(0)
                        return
                    }
                    this.validateNumber()
                    break;
                default:
                    if(focus == 1){
                        if((Number(data[0]) == 3 && Number(data[1]) == 4) || (Number(data[0]) == 3 && Number(data[1]) == 7)
                        || (Number(data[0]) == 5 && Number(data[1]) == 1) || (Number(data[0]) == 5 && Number(data[1]) == 2) 
                        || (Number(data[0]) == 5 && Number(data[1]) == 3) || (Number(data[0]) == 5 && Number(data[1]) == 4)
                        || (Number(data[0]) == 5 && Number(data[1]) == 5) || (Number(data[0]) == 4)) {
                            this.displayError(-1)
                        }
                        else{
                            this.displayError(0)
                            return
                        }
                    }
                    else{
                        if((Number(data[0]) == 3 && Number(data[1]) == 4) || (Number(data[0]) == 3 && Number(data[1]) == 7)
                        || (Number(data[0]) == 5 && Number(data[1]) == 1) || (Number(data[0]) == 5 && Number(data[1]) == 2) 
                        || (Number(data[0]) == 5 && Number(data[1]) == 3) || (Number(data[0]) == 5 && Number(data[1]) == 4)
                        || (Number(data[0]) == 5 && Number(data[1]) == 5) || (Number(data[0]) == 4)) {
                            this.displayError(1)
                        }
                        else{
                            this.displayError(0)
                            return
                        }
                    }
                    break;
            }
        },
        validateNumber(){
            var checkSum = 0
            var num1 = 0
            var num2 = 0
            var sumOfProductDigits = 0;
            var sumOfNonProductDigits = 0;

            var data = document.getElementById('credit-card').value
            if (data.length != 16){return false}
            var ccNumbers1 = parseInt(data); // Used for checkSum
            while (ccNumbers1 > 0)
            {
                num1 = ccNumbers1 % 10; // out: 4
                sumOfNonProductDigits += num1; // add 4

                ccNumbers1 = ccNumbers1 - num1; // minus the last digit
                ccNumbers1 = ccNumbers1 / 10; // reduce by one last digit by dividing by 10

                num2 = ccNumbers1 % 10; // out: 1

                ccNumbers1 = ccNumbers1 - num2;
                ccNumbers1 /= 10;

                if (num2 * 2 > 9) // if there's two digits you'll have to add each digit
                {
                    // Product result is double digits. Repeat the same thing to split numbers
                    // and reduce the ccNumbers1
                    num2 = num2 * 2;
                    var numSlice = num2 % 10; // split by getting the last digit
                    sumOfProductDigits += numSlice;
                    sumOfProductDigits += ((num2 - numSlice) / 10); // add to products sum
                }
                else
                {
                    // multiply the digit by 2 and add to sumOfProductDigits
                    num2 = num2 * 2;
                    sumOfProductDigits += num2;
                }
            }

            checkSum = sumOfProductDigits + sumOfNonProductDigits;
            if (checkSum % 10 == 0){
                this.displayError(-1)
                return true
            }else{
                this.displayError(2)
                return false
            }
        },
        displayError(status){
            //status: -1 -> No error
            //status: 0  -> Card number not supported
            //status: 1  -> Card number has invalid length
            //status: 2  -> Card number is invalid (according to eqn.)
            var data = document.getElementById('credit-card')
            var message = document.querySelector('.error-message')
            message.style.color = '#ff0000'
            if(status == -1){
                message.innerHTML = ''
            }else{
                if(data.value.length == 0){
                    message.innerHTML = 'Card number is required'
                }else if(data.value.length != 16 && status == 0){
                    message.innerHTML = 'Invalid or unsupported from of payment'
                }else if(data.value.length != 16 && status == 1){
                    message.innerHTML = 'Card number has invalid length'
                }else if(status == 2){
                    message.innerHTML = 'Card number is invalid'
                }

            }
        },
        checkFocus(){
            var data = document.getElementById('credit-card')
            if(data != document.activeElement){
                if(data.value.length == 0){
                    this.displayError(1)
                }
                else if(data.value.length != 16){
                    this.validateCard(0)
                }
                else{
                    this.validateNumber()
                }
            }
        },
        submitCard(){
            var successful = document.querySelector('.successful-payment')
            if(this.validateNumber() == true){
                this.displayConfirmMessage()
            }else{
                this.displayError(2)
                successful.innerHTML = ''
            }
        },
},  
computed: {
  daysDifference() {
    const startDate = new Date(this.startDate);
    const endDate = new Date(this.endDate);
    if (!this.startDate || !this.endDate) {
      return 'Please select both start and end dates.';
    }
    if (startDate >= endDate) {
        document.querySelector(".check-date-input").style.color="red"
      return 'End date must be after the start date.';
    }
    document.querySelector(".check-date-input").style.color="#210070"
    const days = (endDate - startDate) / (1000 * 60 * 60 * 24);
    const totalRentPrice = (days * this.Price);
    const formattedRentPrice = totalRentPrice.toLocaleString();
    this.rentPrice=totalRentPrice;
    this.dataFull=true;
    return `To rent the car for ${days} days, you have to pay ${formattedRentPrice}EG`;
  },
},
}
</script>
<style scoped>
.availability{
    font-size: 40px;
    font-weight: bold;
    color: red;
}
.confirm-payment p {
    font-weight: bold;
    margin: 5px 5px 10px;
}

.confirm-payment div {
    display: flex;
    justify-content: space-evenly;
}

.confirm-payment button{
    background: #fefefe;
    padding: 10px 15px;
    color: #210070;
    font-weight: bold;
    border-radius: 5px;
    border-color: #210070;
}

.confirm-payment button:hover {
    background: #210070;
    color: #fefefe;
}

.confirm-payment {  
    border: 5px solid #210070;
    padding: 25px;
    position: fixed;
    top: 46%;
    left: 40%;
    display: flex;
    flex-direction: column;
    background-color: #fcfcfc;
    min-width: 15%;
    max-width: 50%;
    max-height: 50%;
    border-radius: 10px;
    box-shadow:0 0 10px 5px #ccc;
    display: none;
    z-index: 1001;
}

.exit-rent {
  position: absolute;
  top: 10px;
  right: 10px;
  cursor: pointer;
  font-size: 18px;
  width:30px;
  height:30px;
  color: black; 
  background-color: white;
  border: none;
  border-radius:15px;
  text-align: center;
}

.online-rent {
  position: relative;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100%;
  background-color: #f2f2f2;
  border-radius: 10px;
  padding: 20px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  margin-bottom:20px;
}
.online-rent label {
  font-size: 18px;
  margin-bottom: 8px;
}

.online-rent input {
  width: 100%;
  padding: 10px;
  margin-bottom: 16px;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-sizing: border-box;
}

.online-rent input[type="date"] {
  appearance: none;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-sizing: border-box;
  width: calc(100% - 22px);
  display: inline-block;
}
.online-rent p {
    font-size: 18px;
    margin-top: 20px;
  }
.online-rent input[type="date"]::-webkit-inner-spin-button,
.online-rent input[type="date"]::-webkit-outer-spin-button {
  -webkit-appearance: none;
  margin: 0;
}
.online-shipment{
    color:white;
    width:30%;
    font-size:25px;
    align-content: center;
    margin-bottom:30px;
    margin-top:20px;
    background-color:#210070;
    border:none;
    height:60px;
    border-radius: 30px;
    cursor: pointer;
}
.american-express-card{
    width: 100px;
    height: 40px;
}
.exit-rent {
  position: absolute;
  top: 10px;
  right: 10px;
  cursor: pointer;
  font-size: 18px;
  width:30px;
  height:30px;
  color: black; 
  background-color: white;
  border: none;
  border-radius:15px;
  text-align: center;
}

.online-rent {
  position: relative;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100%;
  background-color: #f2f2f2;
  border-radius: 10px;
  padding: 20px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}
.online-rent label {
  font-size: 18px;
  margin-bottom: 8px;
}

.online-rent input {
  width: 100%;
  padding: 10px;
  margin-bottom: 16px;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-sizing: border-box;
}

.online-rent input[type="date"] {
  appearance: none;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-sizing: border-box;
  width: calc(100% - 22px);
  display: inline-block;
}
.online-rent p {
    font-size: 18px;
    margin-top: 20px;
  }
.online-rent input[type="date"]::-webkit-inner-spin-button,
.online-rent input[type="date"]::-webkit-outer-spin-button {
  -webkit-appearance: none;
  margin: 0;
}
.online-shipment{
    color:white;
    width:30%;
    font-size:25px;
    align-content: center;
    margin-bottom:30px;
    margin-top:20px;
    background-color:#210070;
    border:none;
    height:60px;
    border-radius: 30px;
    cursor: pointer;
    transition: background-color 0.3s ease, margin-top 0.3s ease;
}
.online-shipment:hover {
    color: #ffffff;
    background-color: #3b266b;
}
.view {
    color: #210070;
    border-bottom: 1px solid #01014a;
}
.container {
    margin: 0 200px;
}
.photos {
    width: 100%;
}
.photos img {
    width: 100%;
}
.american-express-card{
    width: 100px;
    height: 40px;
}
.cards-images {
    width:50px;
    height: 50px;
}

.view {
    color: #210070;
    border-bottom: 1px solid #01014a;
}
.container {
    margin: 0 200px;
}
.photos {
    width: 100%;
}
.photos img {
    width: 100%;
}
.container .price {
    padding: 20px;
    color: #210070;
    font-size: 30px;
    display: flex;
    justify-content: space-between;
    margin-bottom: 20px;
}
.container .price span{
    font-weight: bold;
}
.container .price span:nth-child(3){
    font-size: 20px;
    font-weight: normal;
}
.price img {
    width: 40px;
}
.filter {
    filter: contrast(0);
}
.type{
    padding: 0 20px;
    display: flex;
    justify-content: space-between;
    margin-bottom: 20px;
}
.type .name {
    display: flex;
    align-items: flex-end;
    font-weight: bold;
}
.type .name span:first-child {
    font-size: 40px;
    margin-right: 10px;
}
.name span:last-child {
    font-size: 20px;
}
.location{
    display: flex;
    align-items: center;
    justify-content: space-between;
}
.location img{
    width: 40px;
}
.details .detail {
    background: #e5ebf8;
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    text-align: left;
    letter-spacing: 1.5px;
    padding: 20px;
}
.detail span{
    font-weight: bold;
    margin-bottom: 10px;
}
.detail .item {
    padding: 10px 5px;
    color: #471cab;
    min-width: 60%;
    max-width: 80%;
    display: flex;
    justify-content: space-between;
    text-align: left;
}
.detail .item p{
    width: 50%;
}
.description{
    flex-direction: column;
    text-align: left;
    padding: 20px;
    border-bottom: 1px solid #01014a;
    background: #e5ebf8;

}
.description h2{
    margin-bottom: 20px;
}
.features {
    padding: 50px;
    display :grid;
    grid-template-columns: repeat(auto-fill, minmax(350px, 1fr));
    justify-content: center;
    align-items: center;
    grid-column-gap : 20px;
    grid-row-gap : 50px;
}
.features .feature {
    border-radius: 10px;
    border: #01014a 1px solid;
    padding: 10px;
    font-weight: bold;
}

.payment {
    padding: 25px;
    position: fixed;
    top: 75%;
    left: 33%;
    display: flex;
    flex-direction: column;
    background-color: #fcfcfc;
    min-width: 30%;
    max-width: 80%;
    max-height: 80%;
    border: none;
    border-radius: 10px;
    box-shadow:0 0 10px 5px #ccc;
    display: none;
    z-index: 1000;
}

.title {
    display: flex;
    justify-content: space-between;
}

.title svg {
    cursor: pointer;
    padding: 20px;
}

.payment h1{
    font-size: 32px;
    margin: 0px 10px;
}

.card {
    display: flex;
    align-items: center;
}

.card input{
    margin: 20px 0px;
    width: 60%;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 5px;
    background-color: #f5f6f7;
    color: #8d949e;
    display: block;
}

#creditcard{
    display: block;
}

.payment #buy-now {
    cursor: pointer;
    font-weight: bold;
    padding: 10px;
    width: 50%;
    background-color: #5832b0;
    color: white;
    border: none;
    border-radius: 5px;
    margin: 20px auto 20px;
    transition-duration: 200ms;
    letter-spacing: 0.8px;
}

#buy-now {
    font-size: 14px;
}

#buy-now:hover {
    background-color: #422487;
}

#creditcard {
    font-weight: bold;
    font-size: 16px;
    margin: 0px 10px;
}

.payment-form {
    flex-direction: column;
    display: flex;
    justify-content: center;
}


#overlay {
    display: none;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: rgba(0, 0, 0, 0.4);
}

textarea:focus, input:focus{
    outline: none;
}

.error-message {
    height: 14px;
}

.successful-payment {
    height: 14px;
}

#x {
    top: 0%;
    right: 0%;
    position: absolute;
    width: 25px;
    height: 25px;
}

.price-display {
    font-weight: bold;
    margin: 5px;
    font-size: 20px;
}

.unavailable{
    background: grey;
    cursor: default;
}
.unavailable:hover {
    background: grey;
    cursor: default;
}
.exit-rent:hover{
    color: white;
    background:#01014a;
}
</style>