<template>
  <div>
    <div
      class="heading-wrapper"
      :class="{ 'sticky-headings': scrollPosition > 60 }"
    >
      <div class="heading-container">
        <div class="heading">Provider</div>

        <div class="heading">Number of Channels</div>

        <div class="heading">Download Speed</div>

        <div class="heading">Base Monthly Fee</div>
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
            max="100"
            step="10"
            v-model="downloadSpeed"
            v-on:change="filterDownload"
          />
          100
        </div>
        <h3 class="filter-value">{{ downloadSpeed }} Mbps</h3>
      </div>

      <div>
        <Product
          v-for="product in products"
          :key="product.key"
          :product="product"
        ></Product>
      </div>
    </div>
  </div>
</template>

<script>
import Product from "./Product";

export default {
  name: "List",
  props: ["products"],
  data() {
    return {
      oldProducts: [],
      scrollPosition: null,
      downloadSpeed: 0,
    };
  },
  components: {
    Product,
  },
  methods: {
    updateScroll() {
      this.scrollPosition = window.scrollY;
    },
    filterDownload: (event) => {
      console.log(event);
    },
  },
  mounted() {
    this.originalProducts = this.products;
    window.addEventListener("scroll", this.updateScroll);
  },
};
</script>

<style>
.wrapper {
  width: 1000px;
  margin: 1rem auto;
}

.filter {
  background-color: var(--light-secondary-color);
  border: 1px solid var(--secondary-color);
  position: fixed;
  top: 160px;
  left: 5rem;
  width: 300px;
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
}

.filter-range {
  display: flex;
  flex-direction: row;
  justify-content: center;
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
  width: 1000px;

  display: grid;
  grid-template-columns: 220px repeat(4, 1fr);
  grid-template-rows: 50px;
}

.heading-container:first-child {
  border-left: 1px solid #fff;
}

.heading {
  text-align: center;
  width: 100%;
  font-size: 1.5rem;
  /* Center contents inside the grid item */
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  border-right: 1px solid #fff;
}
</style>