import React, { useState } from 'react';
import './styles.css';
import '../../global.css';
import { useNavigate } from 'react-router-dom';

import api from '../../services/api';

export default function Register() {
  const [userName, setUserName] = useState('');
  const [fullName, setFullName] = useState('');
  const [password, setPassword] = useState('');

  const navigate = useNavigate();

  async function handleRegister(e) {
    e.preventDefault();

    const data = {
      userName,
      fullName,
      password,
      accountNonExpired: true,
      accountNonLocked: true,
      credentialsNonExpired: true,
      enabled: true
    };

    try {
      await api.post('/api/user/v1', data);
      alert('User registered successfully!');
      navigate('/'); // redireciona para tela de login
    } catch (err) {
      console.error(err.response?.data || err.message);
      alert('Failed to register user. Please try again.');
    }
  }

  return (
    <div className="login-container">
      <section className="form">
         <h1>Cadastro</h1>
        <form onSubmit={handleRegister}>
          <input
            placeholder="Nome do usuário"
            value={userName}
            onChange={e => setUserName(e.target.value)}
          />
          <input
            placeholder="Nome Completo"
            value={fullName}
            onChange={e => setFullName(e.target.value)}
          />
          <input
            type="password"
            placeholder="Senha"
            value={password}
            onChange={e => setPassword(e.target.value)}
          />

          <button type="submit">Register</button>
        </form>
      </section>
    </div>
  );
}
