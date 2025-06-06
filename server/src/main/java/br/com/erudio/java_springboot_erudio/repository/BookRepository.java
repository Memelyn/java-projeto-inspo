package br.com.erudio.java_springboot_erudio.repository;

import br.com.erudio.java_springboot_erudio.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {}