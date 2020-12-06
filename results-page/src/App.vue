<template>
  <div id="app">
    <nav class="navbar">
      <div class="logo">CompraJá<span class="logo-end">.pt</span></div>

      <div class="vertical-type">TV NET VOZ</div>
    </nav>

    <main>
      <List v-bind:products="products"></List>
    </main>
  </div>
</template>

<script>
const URL = "https://run.mocky.io/v3/7fa187d0-7aaa-40b3-946e-dbd94c279f75";

import List from "./components/List";

export default {
  name: "App",
  components: { List },
  data() {
    return {
      products: [],
    };
  },
  methods: {
    fetchData() {
      fetch(URL)
        .then((response) => response.json())
        .then((data) => {
          data.forEach((item) => {
            // Replace boolean string for the actual boolean value
            if (item.is_sponsored === "False") item.is_sponsored = false;
            if (item.is_sponsored === "True") item.is_sponsored = true;
          });

          // Creates array with just the sponsored items
          let sponsored_items = data.filter((item) => item.is_sponsored);
          // Filter through data array for just the non sponsored items
          data = data.filter((item) => !item.is_sponsored);
          // Unshifts items from the sponsored array into the start of the data array
          sponsored_items.forEach((item) => data.unshift(item));

          this.products = data;
        })
        .catch((e) => {
          console.log(e);
        });
    },
  },
  mounted() {
    this.fetchData();
  },
};
</script>

<style>
* {
  margin: 0;
  padding: 0;
}

:root {
  font-size: 12px;

  --bg-color: #f5f5f5;
  --dark-primary-color: #007ac1;
  --primary-color: #03a9f4;
  --secondary-color: #81c784;
  --dark-secondary-color: #519657;
  --light-secondary-color: #d4ecd58e;
}

body {
  background-color: rgb(245, 245, 245);
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  color: #2c3e50;
}

.navbar {
  height: 6rem;
  background-color: var(--dark-primary-color);
  display: flex;
  align-items: center;
  justify-content: space-around;
  padding: 0 5rem;
}

.logo {
  color: #fff;
  font-weight: bold;
  font-size: 3rem;
}

.logo-end {
  font-size: 1.5rem;
}

.vertical-type {
  color: #fff;
  font-size: 1.5rem;
}
</style>
