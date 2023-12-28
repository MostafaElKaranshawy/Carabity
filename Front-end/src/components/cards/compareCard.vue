<template>
  <div class="compare-card">
    <div class="images">
    <img :src="require(`../../assets/cars-photos/${comparableCar1.Photo}`)" />
    <img :src="require(`../../assets/cars-photos/${comparableCar2.Photo}`)" />
  </div>
    <table>
      <tr class="head">
        <th>Property</th>
        <th>Car 1</th>
        <th>Car 2</th>
      </tr>
      <tr v-for="(value, key) in comparableCar1" :key="key">
        <td v-if="shouldShow(key)">{{ key }}</td>
        <td v-if="shouldShow(key)">{{ value }}</td>
        <td v-if="shouldShow(key)">{{ comparableCar2[key] }}</td>
      </tr>
      <tr class="features">
        <td  rowspan="10">Features</td>
      </tr>
      <tr v-for="(feature, index) in comparableCar1.Features" :key="index">
        <td>{{ feature }}</td>
        <td>{{ comparableCar2.Features[index] }}</td>
      </tr>
    </table>
  </div>
</template>
<script>
export default{
    data(){
        return{
          
        }
    },
    props :{
      comparableCar1 : Object,
      comparableCar2 : Object
    }, 
    name: 'compareCard',
    mounted() {
        // console.log(this.Photo)
    },
    methods: {
        choosecar(){
            this.$emit('child-event', this.id);
        },
        currentImg() {
            return this.Photo;
        },
        appear(){
          console.log(this.car1)
        },
        shouldShow(key) {
      return (
        key !== 'id' &&
        key !== 'Description' &&
        key !== 'Photo' &&
        key !== 'Features'
      );
    },
    }
}
</script>
<style scoped>
.compare-card {
  display: flex;
  flex-direction: column;
  border-radius: 20px;
  align-items: center;
  text-align: center;
  padding: 20px;
  background-color: #f0f0f0;
  overflow: hidden;
}
table {
  width: 100%;
  border-radius: 20px;
  border-collapse: collapse;
  margin-top: 20px;
}

th, td {
  border: 1px solid #ddd;
  padding: 15px;
  font-family: 'Helvetica', sans-serif;
  text-align: center; /* Center align content */
}

th {
  background-color: #210070;
  color: white;
}

td {
  background-color: #fff;
}

tr {
  border-bottom: 1px solid #ddd;
  transition: transform 0.3s;
  margin-bottom: 5px;
}

tr:hover {
  transform: scale(1.05);
}
.features:hover,.head:hover{
  transform:none;
}
.images {
  display: flex;
  margin-bottom: 20px; /* Add margin to separate images from the table */
}

img {
  width: 47%;
  height: auto; /* Make images responsive */
  margin-right: 6%;
  border-radius: 7px;
}

</style>