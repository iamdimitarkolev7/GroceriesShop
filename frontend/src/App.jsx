import React from 'react';
import './App.css';
import { Route, Routes } from 'react-router-dom';
import NavBar from './components/navBar/NavBar';
import Home from './views/Home';
import Register from './views/Register';
import Login from './views/Login';
import { AuthProvider } from './contexts/AuthContext'

const App = () => {
  
  return (
    <div className='App'>
      <AuthProvider>
        <NavBar/>
        <Routes>
          <Route path='/' exact element={<Home/>} />
          <Route path='/register' element={<Register/>} />
          <Route path='/login' element={<Login/>} />
        </Routes>
      </AuthProvider>
    </div>
  );
}

export default App;
