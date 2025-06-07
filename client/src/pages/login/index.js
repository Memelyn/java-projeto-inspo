import React, {useState} from 'react';
import './styles.css';
import '../../global.css';
import { useNavigate } from 'react-router-dom';



import api from '../../services/api'; 

export default function Login(){

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
   const navigate = useNavigate();


    async function login(e) {
        e.preventDefault();

        const data = {
            username,
            password,
        };
       try {
  const response = await api.post('auth/signin', data);
  //console.log('Resposta do login:', response.data); 

  localStorage.setItem('username', username);
  localStorage.setItem('accessToken', response.data.body.accessToken); 

  navigate('/books');
} catch (err) {
  //console.error('Erro no login:', err.response?.data || err.message);
  alert('Login failed: try again');
}

    }

    return (
        <div className="login-container">
           <section className="form">
            <form onSubmit={login}>
                <input 
                placeholder='userName'
                value = {username}
                onChange={e => setUsername(e.target.value)}
                />
                <input 
                type='password' placeholder='password'
                value = {password}
                onChange={e => setPassword(e.target.value)}
                />

            <button type="submit">Login</button>
            </form>
            </section> 
        </div>
    )
}