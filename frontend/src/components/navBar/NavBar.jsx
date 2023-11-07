import React, { useContext } from 'react';

import './NavBarStyles.css';
import { AuthContext } from '../../contexts/AuthContext';
import NavBarButton from '../buttons/navBarButton/NavBarButton';

const NavBar = () => {

  const { isLoggedIn, logout } = useContext(AuthContext);

  return (
    <nav>
      <ul className="navbar">
        <li>
          <p className='logo'>GroceriesShop</p>
        </li>
        <li>
          <NavBarButton title='Home' direction='/'/>
        </li>
        { !isLoggedIn &&
          <li>
            <NavBarButton title='Login' direction='/login'/>
          </li> }
        { !isLoggedIn &&
        <li>
          <NavBarButton title='Register' direction='/register'/>
        </li> }
        { isLoggedIn &&
          <li>
            <NavBarButton title='Logout' direction='/logout' onclick={logout}/>
          </li> }
      </ul>
    </nav>
  );
}

export default NavBar;