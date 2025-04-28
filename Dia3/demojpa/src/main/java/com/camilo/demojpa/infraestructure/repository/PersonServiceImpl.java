package com.camilo.demojpa.infraestructure.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.camilo.demojpa.application.service.PersonService;
import com.camilo.demojpa.domain.Person;

@Service
public class PersonServiceImpl implements PersonService {
    
    private final Personrepository personRepository;
    public PersonServiceImpl(Personrepository personRepository){
        this.personRepository= personRepository;

    }

    @Override
    public List<Person> findAllByFilter(String filter, String value){
        if(filter.toLowerCase().equals("name") && !value.isEmpty()){
            return personRepository.findByNameContains(value);
        } else if (filter.toLowerCase().equals("language")  && !value.isEmpty()) {
            return personRepository.findByLanguageEquals(value);
            
        }
        return personRepository.findAll();
    }
    
}
