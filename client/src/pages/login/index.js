import React, {useState} from 'react';
import './styles.css';
import '../../global.css';
import { useNavigate, Link } from 'react-router-dom';

import api from '../../services/api'; 

export default function Login(){

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    async function login(e) {
        e.preventDefault();

        const data = { username, password };

        try {
            const response = await api.post('auth/signin', data);

            localStorage.setItem('username', username);
            localStorage.setItem('accessToken', response.data.body.accessToken); 

            navigate('/books');
        } catch (err) {
            alert('Login failed: try again');
        }
    }

    return (
        <div className="login-container">
            <section className="form">
                 <h1>Login</h1>
                <form onSubmit={login}>
                    <input 
                        placeholder='Nome do Usuário'
                        value={username}
                        onChange={e => setUsername(e.target.value)}
                    />
                    <input 
                        type='password' 
                        placeholder='Senha'
                        value={password}
                        onChange={e => setPassword(e.target.value)}
                    />

                    <button type="submit" className="button">Login</button>
                    <Link to="/register" className="register-button">Cadastrar-se</Link>
                </form>
            </section> 
        </div>
    );
}
