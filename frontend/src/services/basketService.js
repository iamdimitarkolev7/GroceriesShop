const addProductToBasket = (data) => {
  
  fetch('http://localhost:8087/api/basket/addToBasket', {
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
}

const getBasketProducts = async () => {
  
  try {  
    const response = await fetch(`http://localhost:8087/api/basket/getBasketProducts/${sessionStorage.getItem('userId')}`, {
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

    return products;
  } catch (err) {
    console.error(err);
    return [];
  }
};

const calculateBasketResult = async () => {

  try {
    const response = await fetch(`http://localhost:8087/api/basket/calculateBasketProducts/${sessionStorage.getItem('userId')}`, {
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
    const basketResult = data.data.result;

    return basketResult;
  } catch (err) {
    console.error(err);
    return 0;
  }
}

const emptyBasket = () => {
  
  fetch(`http://localhost:8087/api/basket/emptyBasket/${sessionStorage.getItem('userId')}`, {
    method: 'GET',
    headers: {
      'Content-type': 'application/json'
    },
    credentials: 'include'
  })
  .then(res => res.json())
  .then(res => console.log(res))
  .catch(err => console.log(err));
};

export { addProductToBasket, getBasketProducts, calculateBasketResult, emptyBasket }