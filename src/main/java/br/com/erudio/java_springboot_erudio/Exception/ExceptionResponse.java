package br.com.erudio.java_springboot_erudio.Exception;

import java.util.Date;

// record simplifica a criação de classes que vão apenas armazenar valores
// usado caso a classe não seja alterada depois que a instância é criada
// antigo POJO
//promove a imutabilidade, aumentando a segurança do código, além disso deixa o código
// mias claro pq deixa explicito o que ta acontecendo
// apó compilar cria automaticamente contrutor, getters, hashcode e toString
public record ExceptionResponse(Date timestamp, String message, String details) {}

// vai ser usado para fomatar a nossa excessão de uma forma mais amigável, retornando um JSON
// ao invés de uma Excessão
