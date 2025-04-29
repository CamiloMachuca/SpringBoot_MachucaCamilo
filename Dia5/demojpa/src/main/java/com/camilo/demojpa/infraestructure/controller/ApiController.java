package com.camilo.demojpa.infraestructure.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.camilo.demojpa.application.service.PersonService;
import com.camilo.demojpa.domain.Person;
import com.camilo.demojpa.domain.Rol;

@RestController
@RequestMapping(value="/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {


    private final PersonService personService;
    // 
    public ApiController(PersonService personService) {
        this.personService= (PersonService) personService;
    }


   
    // filtrar por el nombre
    @GetMapping("/users2")
    public List<Person>findAll(        
        @RequestParam(name= "filter", defaultValue = "") String filter,
        @RequestParam(name="value", defaultValue = "")String value
    ){
        List<Person> results=personService.findAllByFilter(filter, value);
        return results;
    }

    // filtrar por el nombre
    @GetMapping("/roles")
    public List<Rol>findAllRoles(        
        @RequestParam(name= "filter", defaultValue = "") String filter,
        @RequestParam(name="value", defaultValue = "")String value
    ){
        List<Rol> results=personService.findAllRolesByFilter(filter, value);
        return results;
    }










    /* 
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


    
    @GetMapping("/users")
    public List<Person>findAll2(){
        List<Person> results=personRepository.findByLanguageEquals("Java");
        return results;
    }
        */

}
