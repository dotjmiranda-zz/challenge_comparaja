# Challenge Compara Já

## Questions

### API Design & Implementation

1. SELECT \* FROM Products JOIN Verticals ON Products.vertical_id=Verticals.id WHERE Verticals.name='Broadband'

2. ```javascript
   // Assuming products have this structure
   /* 
   {
     id: 8,
     is_sponsored: false,
     data: {
       p: 3,
       internet_download_speed_in_mbs: 500,
       internet_upload_speed_in_mbs: 200,
       tv_channels: 120,
       mobile_phone_count: 0,
       mobile_phone_data_in_gbps: null,
       price: 29.99,
     },
     providerName: "MEO",
   }
   */

   const filterProducts = (downloadSpeed, phoneCount, phoneData, maxPrice) => {
     return products.filter(({ data }) => {
       // destructure data object from product
       const {
         internet_download_speed_in_mbs,
         mobile_phone_count,
         mobile_phone_data_in_gbps,
         price,
       } = data;

       return (
         internet_download_speed_in_mbs >= downloadSpeed &&
         mobile_phone_count >= phoneCount &&
         mobile_phone_data_in_gbps >= phoneData &&
         price <= maxPrice
       );
     });
   };
   ```
