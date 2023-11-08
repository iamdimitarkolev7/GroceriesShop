import React from 'react';

import './ProductStyles.css';
import AddToBasketButton from '../buttons/addToBasketButton/AddToBasketButton';
import { addProductToBasket } from '../../services/basketService';

const Product = ({name, price, deal, imageUrl}) => {

  const addToBasketHandler = () => {
    
    const data = {
      userId: sessionStorage.getItem('userId'),
      productName: name,
      productPrice: parseFloat(price),
      productDeal: deal
    };

    addProductToBasket(data);
  };

  return (
    <div className='productBox'>
      <h3 className='title'>{name}</h3>
      <div className='asset-icon'>
        <img src={imageUrl} alt='productImg'></img>
      </div>
      <p className='price'>{price} clouds</p>
      <p className='deal'>{deal === 'TWO_FOR_THREE' ? 'Pay for 2, get 3' : 'Buy 1 and get 1 half price'}</p>
      <AddToBasketButton onClickHandler={addToBasketHandler}></AddToBasketButton>
    </div>
  )
}

export default Product;