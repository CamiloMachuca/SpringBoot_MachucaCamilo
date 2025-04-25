package com.camilo.demojpa.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.camilo.demojpa.domain.Person;
import com.camilo.demojpa.repository.PersonRepository;
import com.camilo.demojpa.repository.Personrepository;

@RestController
@RequestMapping(value="/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {


    private final Personrepository personRepository;

    public ApiController(Personrepository personRepository) {
        this.personRepository= personRepository;
    }


    @GetMapping("/users")
    public List<Person>findAll(){
        List<Person> results=personRepository.findByLanguageEquals("Java");
        return results;
    }


    @GetMapping("/person")
    public List<Person> getPerson(
        @RequestParam(required = false) String lastName,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String language
    ) {
      	
        List<Person> listadoFiltrado= personRepository.findAll().stream()
        .filter(per ->name ==null || per.getName().equalsIgnoreCase(name))
        .filter(per ->lastName ==null || per.getLastName().equalsIgnoreCase(lastName))
        .filter(per ->language ==null || per.getLanguage().equalsIgnoreCase(language))
        .toList();

        return listadoFiltrado;
    }

}
