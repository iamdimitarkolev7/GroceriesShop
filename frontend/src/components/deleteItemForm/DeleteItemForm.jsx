import React, { useState } from 'react';

import { deleteProduct } from '../../services/productService';

import './DeleteItemFormStyles.css';

const DeleteItemForm = () => {
  const [productName, setProductName] = useState('');

  const handleNameChange = (event) => {
    setProductName(event.target.value);
  }

  const handleSubmit = (event) => {
    event.preventDefault();

    if (productName) {
      const newProduct = {
        productName
      };

      deleteProduct(newProduct);

      setProductName('');
    }
  }

  return (
    <div className='add-product-container'>
      <h2 className='add-product-title'>Delete Product</h2>
      <form className='form-group' onSubmit={handleSubmit}>
        <div>
          <label>Name:</label>
          <input
            type="text"
            value={productName}
            onChange={handleNameChange}
            required
          />
        </div>
        <button className='submit-button' type="submit">Delete Product</button>
      </form>
    </div>
  );
}

export default DeleteItemForm;