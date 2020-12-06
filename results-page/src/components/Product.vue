<template>
  <div>
    <div v-if="product.is_sponsored" class="tag">Sponsored</div>

    <div
      class="product-wrap"
      v-bind:class="{ sponsored: product.is_sponsored }"
    >
      <div class="item provider">
        <h1>{{ product.name }}</h1>
      </div>

      <div class="item channels">
        <div class="data">{{ product.data.tv_channels }}</div>
        <div class="data-info">canais</div>
      </div>

      <div class="item download">
        <div class="data">
          {{ product.data.internet_download_speed_in_mbs }}
        </div>
        <div class="data-info">Mbps</div>
      </div>

      <div class="item price">
        <div class="data">{{ product.data.price }}€</div>
      </div>

      <div class="item button-container">
        <button>ADHERE</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Product",
  props: ["product"],
};
</script>

<style>
.product-wrap {
  background-color: #fff;
  border: 1px solid rgba(0, 0, 0, 0.635);
  margin: 0 0 20px 0;
  display: grid;
  grid-template-columns: 220px repeat(4, 1fr);
  grid-template-rows: repeat(4, 30px);
  grid-template-areas:
    "provider channels download price button"
    "provider channels download price button"
    "provider channels download price button"
    "provider channels download price button"
    "provider channels download price button";
}

.tag {
  line-height: 1.5rem;
  display: flex;
  justify-content: flex-end;
  align-items: flex-end;
  color: goldenrod;
  font-weight: bold;
}

.sponsored {
  border: 2px solid goldenrod;
  background-color: rgba(218, 165, 32, 0.171);
}

.item {
  text-align: center;
  width: 100%;
  /* Center contents inside the grid item */
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.provider {
  grid-area: provider;
  font-size: 1.5rem;
}

.channels {
  grid-area: channels;
}

.download {
  grid-area: download;
}

.price {
  grid-area: price;
}

.data {
  font-weight: bold;
  font-size: 2rem;
}

.data-info {
  color: rgba(0, 0, 0, 0.616);
}

.button-container {
  font-weight: bold;
  grid-area: button;
}

.button-container button {
  cursor: pointer;
  background-color: var(--primary-color);
  color: #fff;
  font-weight: bold;
  font-size: 1.5rem;
  padding: 1rem;
  border-radius: 1.5rem;
  border: 0;
  box-shadow: inset 0 -0.6em 0 -0.35em var(--dark-primary-color);
}

.button-container button:hover {
  background-color: #007ac1b9;
}

.button-container button:focus {
  outline: none;
}
</style>