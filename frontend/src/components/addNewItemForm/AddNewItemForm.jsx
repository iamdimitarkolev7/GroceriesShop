import React, { useState } from 'react';

import { addNewProduct } from '../../services/productService';

import './AddNewItemFormStyles.css';

const dealTypeMapping = {
  '2for3': 'TWO_FOR_THREE',
  'buy1get1half': 'BUY_ONE_GET_ONE_HALF_PRICE',
};

const AddNewItemForm = () => {
  const [productName, setProductName] = useState('');
  const [price, setPrice] = useState('');
  const [imageUrl, setImageUrl] = useState('');
  const [dealType, setDealType] = useState('2for3');

  const handleNameChange = (event) => {
    setProductName(event.target.value);
  }

  const handlePriceChange = (event) => {
    setPrice(event.target.value);
  }

  const handleImageUrlChange = (event) => {
    setImageUrl(event.target.value);
  }

  const handleDealTypeChange = (event) => {
    setDealType(event.target.value);
  }

  const handleSubmit = (event) => {
    event.preventDefault();
    console.log("im here");
    console.log(productName);
    console.log(price);
    console.log(imageUrl);

    if (productName && price && imageUrl) {

      console.log("if");
      const newProduct = {
        productName,
        price: parseFloat(price),
        imageUrl,
        deal: dealTypeMapping[dealType],
      };

      addNewProduct(newProduct);

      setProductName('');
      setPrice('');
      setImageUrl('');
      setDealType('2for3');
    }
  }

  return (
    <div className='add-product-container'>
      <h2 className='add-product-title'>Add a New Product</h2>
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
        <div>
          <label>Price:</label>
          <input
            type="number"
            value={price}
            onChange={handlePriceChange}
            required
          />
        </div>
        <div>
          <label>Image URL:</label>
          <input
            type="url"
            value={imageUrl}
            onChange={handleImageUrlChange}
            required
          />
        </div>
        <div>
          <label>Type of Deal:</label>
          <select value={dealType} onChange={handleDealTypeChange}>
            <option value="2for3">2 for 3</option>
            <option value="buy1get1half">Buy 1 Get 1 Half Price</option>
          </select>
        </div>
        <button className='submit-button' type="submit">Add Product</button>
      </form>
    </div>
  );
}

export default AddNewItemForm;