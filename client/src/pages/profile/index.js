import React, { useEffect, useState } from 'react';
import './styles.css';
import '../../global.css';
import api from '../../services/api';
import { useNavigate } from 'react-router-dom';
import { FiArrowLeft, FiUser, FiUserCheck } from 'react-icons/fi';

export default function Profile() {
  const [user, setUser] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    async function fetchUser() {
      const token = localStorage.getItem('accessToken');

      if (!token) {
        alert('You must be logged in');
        navigate('/');
        return;
      }

      try {
        const response = await api.get('/api/user/v1/me', {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        });
        setUser(response.data);
      } catch (err) {
        console.error(err);
        alert('Failed to fetch user data');
        navigate('/');
      }
    }

    fetchUser();
  }, [navigate]);

  if (!user) {
    return <div className="loading">Carregando dados do usuário...</div>;
  }

  return (
    <div className="login-container">
      <section className="form">
        <button className="back-button" onClick={() => navigate('/books')} title="Voltar">
          <FiArrowLeft size={20} color="#251FC5" />
        </button>
        <h1><FiUser size={28} style={{ marginRight: '8px' }} />Perfil do Usuário</h1>
        <p><FiUserCheck size={18} /> <strong>Username:</strong> {user.userName}</p>
        <p><FiUser size={18} /> <strong>Nome completo:</strong> {user.fullName}</p>
      </section>
    </div>
  );
}
