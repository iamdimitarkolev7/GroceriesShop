import { handleAuthResponse } from './utils/handleAuthResponse';
import { handleError } from './utils/handleError';

const register = (data, setIsLoggedIn, setIsAdmin, navigate) => {
  fetch('http://localhost:8087/api/users/register', {
    method: 'POST',
    body: JSON.stringify(data),
    headers: {
      'Content-type': 'application/json'
    },
    credentials: 'include'
  })
  .then(res => res.json())
  .then(res => handleAuthResponse(res, setIsLoggedIn, setIsAdmin, navigate))
  .catch(err => handleError(err));
}

const login = (data, setIsLoggedIn, setIsAdmin, navigate) => {
  fetch('http://localhost:8087/api/users/login', {
    method: 'POST',
    body: JSON.stringify(data),
    headers: {
      'Content-type': 'application/json'
    },
    credentials: 'include'
  })
  .then(res => res.json())
  .then(res => handleAuthResponse(res, setIsLoggedIn, setIsAdmin, navigate))
  .catch(err => handleError(err));
}

const logout = (setIsLoggedIn, navigate) => {
  sessionStorage.removeItem('userId');
  sessionStorage.removeItem('userRole');
  setIsLoggedIn(false);
  navigate('/');
}

export { register, login, logout };