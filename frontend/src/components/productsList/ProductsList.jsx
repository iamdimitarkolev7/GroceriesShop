import React from 'react';
import Product from '../product/Product';

import './ProductsListStyles.css';

const ProductList = ({ products }) => {

  if (!Array.isArray(products) || products.length === 0) {
    return <div>No products to display</div>;
  }

  return (
    <div id='productListContainer'>
      { products.map((product, index) => (
        <Product 
          key={index} 
          name={product.name} 
          price={product.price} 
          deal={product.deal} 
          imageUrl={product.imageUrl} />
      ))}
    </div>
  );
};

export default ProductList;