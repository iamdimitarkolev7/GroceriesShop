import React, { useState } from 'react';
import { calculateResult } from '../../utils/calculateResult';

import './BasketStyles.css';

const Basket = ({ basketProducts, clearBasket }) => {
  const [finalPrice, setFinalPrice] = useState(0);

  const calculateTotal = () => {
    setFinalPrice(calculateResult(basketProducts));
    console.log(finalPrice);
  };

  const handlePurchase = () => {
    clearBasket();
    setFinalPrice(0);
  };

  return (
    <div className='basketContainer'>
      <h1>Shopping Basket</h1>
      <ul>
        {basketProducts.length > 0 && basketProducts.map((product, index) => (
          <li key={index}>
            {product.name} - {product.price}clouds - {product.deal}
          </li>
        ))}
      </ul>
      <button onClick={calculateTotal}>Calculate</button>
      <button onClick={handlePurchase}>Purchase</button>
      {finalPrice > 0 && (
        <p>Final Price: {Math.floor(finalPrice / 100)}aws and {finalPrice % 100}clouds</p>
      )}
    </div>
  );
}

export default Basket;
