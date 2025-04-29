package com.camilo.demojpa.infraestructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.camilo.demojpa.domain.Person;
public interface Personrepository extends JpaRepository<Person, Long> {
    // Para filtrar se utiliza findByNameContains de todos los datos que contegan name
    List<Person> findByNameContains(String name);
    List<Person> findByLanguageEquals(String language);

}
