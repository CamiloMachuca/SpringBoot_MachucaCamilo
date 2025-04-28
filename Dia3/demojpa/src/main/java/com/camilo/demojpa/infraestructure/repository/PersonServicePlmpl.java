package com.camilo.demojpa.infraestructure.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.camilo.demojpa.application.service.PersonService;
import com.camilo.demojpa.domain.Person;

@Service
public class PersonServicePlmpl implements PersonService {
    @Override
    public List<Person> findAllByFilter(String filter, String value){
        return List.of(new Person(1L, "adrian", "ruiz", "Otro"));
    }
    
}
