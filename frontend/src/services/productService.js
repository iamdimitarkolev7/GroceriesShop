const addNewProduct = (data) => {
  fetch('http://localhost:8087/api/products/addNewProduct', {
    method: 'POST',
    body: JSON.stringify(data),
    headers: {
      'Content-type': 'application/json'
    },
    credentials: 'include'
  })
  .then(res => res.json())
  .then(res => console.log(res))
  .catch(err => console.log(err));
};

const deleteProduct = (data) => {
  fetch('http://localhost:8087/api/products/deleteProduct', {
    method: 'DELETE',
    body: JSON.stringify(data),
    headers: {
      'Content-type': 'application/json'
    },
    credentials: 'include'
  })
  .then(res => res.json())
  .then(res => console.log(res))
  .catch(err => console.log(err));
};

const getAllProducts = async () => {
  try {
    const response = await fetch('http://localhost:8087/api/products/getAll', {
      method: 'GET',
      headers: {
        'Content-type': 'application/json'
      },
      credentials: 'include'
    });
    
    if (!response.ok) {
      throw new Error('Failed to fetch data');
    }

    const data = await response.json();
    const products = data.data.products;

    console.log(products); // You can log the products here if needed
    return products;
  } catch (err) {
    console.error(err);
    return []; // Return an empty array or handle the error as needed
  }
};

export { addNewProduct, deleteProduct, getAllProducts };