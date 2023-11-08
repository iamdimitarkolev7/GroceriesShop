import React, { useEffect, useState } from 'react';

import './BasketStyles.css';
import { calculateBasketResult, emptyBasket, getBasketProducts } from '../../services/basketService';

const Basket = () => {
  const [finalPrice, setFinalPrice] = useState(0);
  const [basketProducts, setBasketProducts] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      const p = await getBasketProducts();
      setBasketProducts(p);
    };
  
    const fetchInterval = 100;
  
    const intervalId = setInterval(fetchData, fetchInterval);

    return () => {
      clearInterval(intervalId);
    };
  }, []);

  const calculateTotal = async () => {

    const basketResult = await calculateBasketResult();
    setFinalPrice(basketResult);
    console.log(finalPrice);
  };

  const handlePurchase = () => {
    emptyBasket();
    setFinalPrice(0);
  };

  return (
    <div className='basketContainer'>
      <h1>Shopping Basket</h1>
      <ul>
        {basketProducts !== null && basketProducts.length > 0 && basketProducts.map((product, index) => (
          <li key={index}>
            {product.name} - {product.price}clouds - {product.deal}
          </li>
        ))}
      </ul>
      <button onClick={calculateTotal}>Calculate</button>
      <button onClick={handlePurchase}>Empty Basket</button>
      {finalPrice > 0 && (
        <p>Final Price: {Math.floor(finalPrice / 100)}aws and {finalPrice % 100}clouds</p>
      )}
    </div>
  );
}

export default Basket;
