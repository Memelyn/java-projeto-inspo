import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';

import Login from './pages/login';
import Books from './pages/books';
import NewBook from './pages/newBook';
import Register from './pages/register';

export default function AppRoutes() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Login />} />
                <Route path="/books" element={<Books />} />
                <Route path="/book/new/:bookId" element={<NewBook />} />
                <Route path="/register" element={<Register />} />
            </Routes>
        </BrowserRouter>
    );
}
