<template>
  <div>
    <div
      class="heading-wrapper"
      :class="{ 'sticky-headings': scrollPosition > 60 }"
    >
      <div class="heading-container">
        <div class="heading">Provider</div>

        <div
          class="heading selectable-heading"
          :class="{ 'chosen-heading': orderBy === 1 }"
          v-on:click="() => order(1)"
        >
          <span>Download Speed</span>
          <svg
            v-if="orderBy === 1"
            xmlns="http://www.w3.org/2000/svg"
            class="icon icon-tabler icon-tabler-arrow-down"
            width="20"
            height="20"
            viewBox="0 0 24 24"
            stroke-width="1.5"
            stroke="#fff"
            fill="none"
            stroke-linecap="round"
            stroke-linejoin="round"
          >
            <path stroke="none" d="M0 0h24v24H0z" fill="none" />
            <line x1="12" y1="5" x2="12" y2="19" />
            <line x1="18" y1="13" x2="12" y2="19" />
            <line x1="6" y1="13" x2="12" y2="19" />
          </svg>
        </div>

        <div
          class="heading selectable-heading"
          :class="{ 'chosen-heading': orderBy === 2 }"
          v-on:click="() => order(2)"
        >
          <span>Number of Channels</span>
          <svg
            v-if="orderBy === 2"
            xmlns="http://www.w3.org/2000/svg"
            class="icon icon-tabler icon-tabler-arrow-down"
            width="20"
            height="20"
            viewBox="0 0 24 24"
            stroke-width="1.5"
            stroke="#fff"
            fill="none"
            stroke-linecap="round"
            stroke-linejoin="round"
          >
            <path stroke="none" d="M0 0h24v24H0z" fill="none" />
            <line x1="12" y1="5" x2="12" y2="19" />
            <line x1="18" y1="13" x2="12" y2="19" />
            <line x1="6" y1="13" x2="12" y2="19" />
          </svg>
        </div>

        <div class="heading">Mobile Phone</div>

        <div
          class="heading selectable-heading"
          :class="{ 'chosen-heading': orderBy === 0 }"
          v-on:click="() => order(0)"
        >
          <span>Base Monthly Fee</span>
          <svg
            v-if="orderBy === 0"
            xmlns="http://www.w3.org/2000/svg"
            class="icon icon-tabler icon-tabler-arrow-down"
            width="20"
            height="20"
            viewBox="0 0 24 24"
            stroke-width="1.5"
            stroke="#fff"
            fill="none"
            stroke-linecap="round"
            stroke-linejoin="round"
          >
            <path stroke="none" d="M0 0h24v24H0z" fill="none" />
            <line x1="12" y1="5" x2="12" y2="19" />
            <line x1="18" y1="13" x2="12" y2="19" />
            <line x1="6" y1="13" x2="12" y2="19" />
          </svg>
        </div>
      </div>
    </div>

    <div class="wrapper">
      <div class="filter" :class="{ 'sticky-filter': scrollPosition > 60 }">
        <div class="filter-title">Minimum Download Speed</div>
        <div class="filter-range">
          0
          <input
            id="downloadSpeed"
            type="range"
            min="0"
            max="1000"
            step="50"
            v-model="downloadSpeed"
          />
          1000
        </div>
        <div class="filter-value">{{ downloadSpeed }} Mbps</div>

        <div class="filter-title">Minimum Number of Phones</div>
        <div class="filter-range">
          0
          <input type="range" v-model="phoneCount" min="0" max="5" step="1" />
          5
        </div>
        <div class="filter-value">{{ phoneCount }} phones</div>

        <div class="filter-title">Maximum Price</div>
        <div class="filter-range">
          0
          <input type="range" v-model="price" min="0" max="100" step="10" />
          100
        </div>
        <div class="filter-value">{{ price }}€</div>
      </div>

      <Product
        v-for="product in filteredData"
        :key="product.key"
        :product="product"
      ></Product>
    </div>
  </div>
</template>

<script>
const URL = "https://run.mocky.io/v3/7fa187d0-7aaa-40b3-946e-dbd94c279f75";

import Product from "./Product";

export default {
  name: "List",
  data() {
    return {
      products: [],
      scrollPosition: null,
      downloadSpeed: 0,
      phoneCount: 0,
      price: 100,
      orderBy: 0,
    };
  },
  components: {
    Product,
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

          // Orders data array
          switch (this.orderBy) {
            case 0: // By price
              data.sort((a, b) => a.data.price - b.data.price);
              break;
            case 1: // By download speed
              data.sort(
                (a, b) =>
                  a.data.internet_download_speed_in_mbs -
                  b.data.internet_download_speed_in_mbs
              );
              break;
            case 2: // By number of channels
              data.sort((a, b) => a.data.tv_channels - b.data.tv_channels);
              break;
            default:
              break;
          }

          // Creates array with just the sponsored items
          let sponsored_items = data.filter((item) => item.is_sponsored);
          // Filter through data array for just the non sponsored items
          data = data.filter((item) => !item.is_sponsored);
          // Unshifts items from the sponsored array into the start of the data array
          //sponsored_items.forEach((item) => data.unshift(item));
          data = [...sponsored_items, ...data];

          this.products = data;
        })
        .catch((e) => {
          console.log(e);
        });
    },
    order(column) {
      this.orderBy = column;
      this.fetchData();
    },
    updateScroll() {
      this.scrollPosition = window.scrollY;
    },
  },
  mounted() {
    this.fetchData();
    window.addEventListener("scroll", this.updateScroll);
  },
  computed: {
    filteredData: function () {
      return this.products.filter(
        (product) =>
          product.data.internet_download_speed_in_mbs >= this.downloadSpeed &&
          product.data.mobile_phone_count >= this.phoneCount &&
          product.data.price <= this.price
      );
    },
  },
};
</script>

<style>
.wrapper {
  width: 1100px;
  margin: 1rem auto;
}

.filter {
  background-color: var(--light-secondary-color);
  border: 1px solid var(--secondary-color);
  position: fixed;
  top: 160px;
  left: 5rem;
  width: 250px;
  z-index: 3;
  transition: 0.1s ease all;
  display: flex;
  flex-direction: column;
  padding: 1rem;
}

.filter > div {
  margin-bottom: 1rem;
}

.sticky-filter {
  top: 90px;
}

.filter-title {
  font-size: 1.25rem;
  font-weight: bold;
  text-align: center;
}

.filter-value {
  text-align: center;
  font-weight: bold;
}

.filter-range {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
}

.sticky-headings {
  position: fixed;
  top: 0;
  width: 100%;
  z-index: 2;
}

.heading-wrapper {
  background-color: var(--secondary-color);
  display: flex;
  justify-content: center;
}

.heading-container {
  color: #fff;
  width: 1100px;

  display: grid;
  grid-template-columns: 220px repeat(5, 1fr);
  grid-template-rows: 50px;
}

.heading-container:first-child {
  border-left: 1px solid #fff;
}

.heading {
  text-align: center;
  width: 100%;
  font-size: 1.5rem;
  border-right: 1px solid #fff;
  /* Center contents inside the grid item */
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: row;
}

.selectable-heading {
  cursor: pointer;
}

.selectable-heading:hover {
  background-color: var(--dark-secondary-color);
  border-left: 1px solid #fff;
}

.chosen-heading {
  background-color: var(--dark-secondary-color);
  border-left: 1px solid #fff;
  cursor: default;
}
</style>