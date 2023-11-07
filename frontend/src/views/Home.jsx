import React, { useContext, useEffect, useState } from 'react';
import AddNewItemForm from '../components/addNewItemForm/AddNewItemForm';
import DeleteItemForm from '../components/deleteItemForm/DeleteItemForm';
import { AuthContext } from '../contexts/AuthContext';

import './styles/HomeStyles.css';
import { getAllProducts } from '../services/productService';
import ProductList from '../components/productsList/ProductsList';
import Basket from '../components/basket/Basket';

const Home = () => {

  const { isLoggedIn, isAdmin } = useContext(AuthContext);
  const [products, setProducts] = useState([]);
  const [basketProducts, setBasketProducts] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      const p = await getAllProducts();
      setProducts(p);
      console.log(p);
    };

    fetchData();
  }, []);

  const addToBasket = (product) => {
    setBasketProducts([...basketProducts, product]);
  }

  const clearBasket = () => {
    setBasketProducts([]);
  }

  return (
    <div>
      <h1 className='header'>This is the GroceriesShop!</h1>
      { isLoggedIn && isAdmin && 
        <div id='adminContainer'>
          <AddNewItemForm></AddNewItemForm>
          <DeleteItemForm></DeleteItemForm>
        </div>
      }
      { isLoggedIn && !isAdmin && 
        <div id='userContainer'>
          <ProductList products={products} addToBasket={addToBasket}></ProductList>
          <Basket basketProducts={basketProducts} clearBasket={clearBasket}></Basket>
        </div>
      }
    </div>
  );
};

export default Home;