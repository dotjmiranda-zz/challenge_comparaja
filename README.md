# Challenge Compara Já

## Questions

### Question 1

```sql
SELECT * FROM Products
JOIN Verticals ON Products.vertical_id=Verticals.id
JOIN Providers ON Products.provider_id=Providers.id
WHERE Verticals.name='Broadband' AND Providers.is_active=TRUE;
```

### Question 2

```javascript
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

### Question 3

A documentação da API encontra-se no documento markdown "api_doc.md"

### Question 4 - Front-end for Results Page

O projeto encontra-se na pasta "results-page".

Para os dados usei uma mock api:
https://run.mocky.io/v3/7fa187d0-7aaa-40b3-946e-dbd94c279f75

### Question 5 - Bonus

Existe um ficheiro README.md na pasta do projeto "booklist" que tem detalhes acerca do mesmo.
