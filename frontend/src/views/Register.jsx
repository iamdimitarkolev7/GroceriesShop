import React, { useState, useContext } from 'react';
import { AuthContext } from '../contexts/AuthContext';

import './styles/AuthStyles.css';

const Register = () => {
  
  const { register } = useContext(AuthContext);
  
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');

  const handleUsernameChange = (event) => {
    setUsername(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  const handleConfirmpasswordChange = (event) => {
    setConfirmPassword(event.target.value);
  }

  const handleSubmit = (event) => {
    event.preventDefault();
    const data = { username, password, confirmPassword };
    register(data);
  };

  return (
    <div>
      <h2>Register</h2>
      <form onSubmit={handleSubmit} className='register-form'>
        <div className='form-group'>
          <label htmlFor='username'>Username:</label>
          <input
            type='text'
            id='username'
            value={username}
            onChange={handleUsernameChange}
          />
        </div>
        <div className='form-group'>
          <label htmlFor='password'>Password:</label>
          <input
            type='password'
            id='password'
            value={password}
            onChange={handlePasswordChange}
          />
        </div>
        <div className='form-group'>
          <label htmlFor='confirmPassword'>Confirm Password:</label>
          <input
            type='password'
            id='confirmPassword'
            value={confirmPassword}
            onChange={handleConfirmpasswordChange}
          />
        </div>
        <button type='submit' className='submit-button'>Register</button>
      </form>
    </div>
  );
}

export default Register;