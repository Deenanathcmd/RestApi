package com.example.deena.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.deena.model.TicBook;

public interface TicRepo extends JpaRepository<TicBook, Integer> {

}
