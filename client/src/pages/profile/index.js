import React, { useEffect, useState } from 'react';
import './styles.css';
import '../../global.css';
import api from '../../services/api';
import { useNavigate } from 'react-router-dom';

export default function Profile() {
  const [user, setUser] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    async function fetchUser() {
      const token = localStorage.getItem('accessToken');

      if (!token) {
        alert('You must be logged in');
        navigate('/login');
        return;
      }

      try {
        const response = await api.get('/users/me', {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        });
        setUser(response.data);
      } catch (err) {
        console.error(err);
        alert('Failed to fetch user data');
        navigate('/login');
      }
    }

    fetchUser();
  }, [navigate]);

  if (!user) {
    return <div>Loading user info...</div>;
  }

  return (
    <div className="login-container">
      <section className="form">
        <h1>User Profile</h1>
        <p><strong>Username:</strong> {user.userName}</p>
        <p><strong>Full Name:</strong> {user.fullName}</p>
        <p><strong>Account Non Expired:</strong> {user.accountNonExpired ? 'Yes' : 'No'}</p>
        <p><strong>Account Non Locked:</strong> {user.accountNonLocked ? 'Yes' : 'No'}</p>
        <p><strong>Credentials Non Expired:</strong> {user.credentialsNonExpired ? 'Yes' : 'No'}</p>
        <p><strong>Enabled:</strong> {user.enabled ? 'Yes' : 'No'}</p>
      </section>
    </div>
  );
}
