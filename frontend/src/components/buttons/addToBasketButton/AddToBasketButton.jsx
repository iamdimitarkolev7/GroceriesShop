import React from 'react';

import './AddToBasketButtonStyles.css';

const AddToBasketButton = ({onClickHandler}) => {

  return (
    <button className='addToBasket' onClick={onClickHandler}>Add to basket</button>
  )
}

export default AddToBasketButton;