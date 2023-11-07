import React, { createContext, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { register, login, logout } from '../services/userService';

const AuthContext = createContext();

const AuthProvider = ({ children }) => {
  const [isLoggedIn, setIsLoggedIn] = useState(sessionStorage.getItem('userId'));
  const [isAdmin, setIsAdmin] = useState(sessionStorage.getItem('userRole') === 'ROLE_ADMIN');
  const navigate = useNavigate();

  return (
    <AuthContext.Provider value={
      { isLoggedIn,
        isAdmin,
        register: (data) => register(data, setIsLoggedIn, setIsAdmin, navigate), 
        login: (data) => login(data, setIsLoggedIn, setIsAdmin, navigate), 
        logout: () => logout(setIsLoggedIn, navigate) }}>
      { children }
    </AuthContext.Provider>
  );
};

export { AuthContext, AuthProvider };