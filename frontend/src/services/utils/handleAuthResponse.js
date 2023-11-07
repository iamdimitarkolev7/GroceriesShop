const handleAuthResponse = (response, setIsLoggedIn, setIsAdmin, navigate) => {
  
  const user = response.data.user;
  const userRole = response.data.userRole;

  if (!user) {
    return;
  }

  sessionStorage.setItem('userId', user.userId);
  sessionStorage.setItem('userRole', userRole);
  
  setIsAdmin(userRole === 'ROLE_ADMIN');
  setIsLoggedIn(true);
  navigate('/');
}

export { handleAuthResponse };