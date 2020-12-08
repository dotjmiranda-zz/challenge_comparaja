HOST: api.comparaja.pt

# **ComparaJá Broadband API**

API documentation for ComparaJá Broadband products

## **Products**

### **URL**

/products

### **Method:**

`GET /products`

### **Query Parameters**

#### **Optional:**

| Name          | Description            | Call Example                |
| ------------- | ---------------------- | --------------------------- |
| downloadSpeed | Minimum Download Speed | /products?downloadSpeed=100 |
| phoneCount    | Phone SIM Card Number  | /products?phoneCount=1      |
| phoneData     | Mobila Data in GBPs    | /products?phoneData=2       |
| price         | Maximum Price          | /products?price=60          |

### **Success Response:**

If successful, it returns an HTTP status code of 200 and a list of objects that contain information about the products.

#### **Code:** 200

#### **Content:**

```json
[
  {
    "id": 8,
    "is_sponsored": "False",
    "data": {
      "p": 3,
      "internet_download_speed_in_mbs": 500,
      "internet_upload_speed_in_mbs": 200,
      "tv_channels": 120,
      "mobile_phone_count": 0,
      "mobile_phone_data_in_gbps": null,
      "price": 29.99
    },
    "name": "MEO"
  },
  {
    "id": 7,
    "is_sponsored": "False",
    "data": {
      "p": 3,
      "internet_download_speed_in_mbs": 1000,
      "internet_upload_speed_in_mbs": 400,
      "tv_channels": 120,
      "mobile_phone_count": 0,
      "mobile_phone_data_in_gbps": null,
      "price": 39.99
    },
    "name": "MEO"
  },
  {
    "id": 2,
    "is_sponsored": "False",
    "data": {
      "p": 4,
      "internet_download_speed_in_mbs": 200,
      "internet_upload_speed_in_mbs": 100,
      "tv_channels": 120,
      "mobile_phone_count": 1,
      "mobile_phone_data_in_gbps": 5,
      "price": 39.99
    },
    "name": "MEO"
  }
]
```

- **Error Response:**

  - **Code:** 404 NOT FOUND <br />
    **Content:** `{ error : "" }`

  OR

  - **Code:** 422 UNPROCESSABLE ENTRY <br />
    **Content:** `{ error : "Wrong format for TV Channels" }`
