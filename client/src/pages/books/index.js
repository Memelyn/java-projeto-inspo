import React, { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { FiPower, FiEdit, FiTrash2 } from 'react-icons/fi'

import api from '../../services/api'

import './styles.css';


export default function Books(){

    const [books, setBooks] = useState([]);
    const [page, setPage] = useState(1);
    
    const username = localStorage.getItem('username');
    const accessToken = localStorage.getItem('accessToken');
    const navigate = useNavigate();

    //navigate('/books')

    async function logout() {
        localStorage.clear();
        navigate('/');
    }

    async function editBook(id) {
        try {
            navigate(`/book/new/${id}`)
        } catch (error) {
            alert('Edit failed! Try again.');
        }
    }
    async function deleteBook(id) {
        try {
            await api.delete(`api/book/v1/${id}`, {
                headers: {
                    Authorization: `Bearer ${accessToken}`
                }
            })

            setBooks(books.filter(book => book.id !== id))
        } catch (err) {
            alert('Delete failed! Try again.');
        }
    }

    async function fetchMoreBooks() {
    const response = await api.get('api/book/v1', {
        headers: {
            Authorization: `Bearer ${accessToken}`
        },
        params: {
            page: page,
            size: 4,
            direction: 'asc'
        }
    });

    console.log('Resposta da API:', response.data); // <-- ADICIONE AQUI

    // Apenas tente acessar se _embedded existir
    if (response.data._embedded) {
        const embeddedKeys = Object.keys(response.data._embedded);
        console.log('Chaves dentro de _embedded:', embeddedKeys); // <-- ADICIONE AQUI TAMBÉM

        const key = embeddedKeys[0]; // pega a primeira chave, ex: 'bookDTOList'
        const newBooks = response.data._embedded[key];

        setBooks([...books, ...newBooks]);
        setPage(page + 1);
    } else {
        console.warn('Nenhum _embedded encontrado na resposta da API.');
    }
}


    useEffect(() => {
        fetchMoreBooks();
    }, [])
    
    return (
        <div className="book-container">
            <header>
                <span>Bem vindo, <strong>{username.toUpperCase()}</strong>!</span>
                <Link className="button" to="/book/new/0">Adicionar Livro</Link>
                <button onClick={logout} type="button">
                    <FiPower size={18} color="#251FC5" />
                </button>
            </header>

            <h1>Livros Registrados</h1>
            <ul>
                {books.map(book => (
                    <li key={book.id}>
                        <strong>Title:</strong>
                        <p>{book.title}</p>
                        <strong>Author:</strong>
                        <p>{book.author}</p>
                        <strong>Price:</strong>
                        <p>{Intl.NumberFormat('pt-BR', {style: 'currency', currency: 'BRL'}).format(book.price)}</p>
                        <strong>Release Date:</strong>
                        <p>{Intl.DateTimeFormat('pt-BR').format(new Date(book.launchDate))}</p>
                        
                        <button onClick={() => editBook(book.id)} type="button">
                            <FiEdit size={20} color="#251FC5"/>
                        </button>
                        
                        <button onClick={() => deleteBook(book.id)} type="button">
                            <FiTrash2 size={20} color="#251FC5"/>
                        </button>
                    </li>
                ))}
            </ul>

            <button className="button" onClick={fetchMoreBooks} type="button">Carregar mais</button>
        </div>
    );
}