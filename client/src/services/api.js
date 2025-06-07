import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080',
});

// Interceptor que injeta o token em toda requisição
api.interceptors.request.use(config => {
  const user = JSON.parse(localStorage.getItem('user')); //  pega o objeto salvo
  const token = user?.accessToken; // acessa o campo accessToken
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});


export default api;
