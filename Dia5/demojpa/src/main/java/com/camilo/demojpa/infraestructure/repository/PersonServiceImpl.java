package com.camilo.demojpa.infraestructure.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.camilo.demojpa.application.service.PersonService;
import com.camilo.demojpa.domain.Person;
import com.camilo.demojpa.domain.Rol;

@Service
public class PersonServiceImpl implements PersonService {
    
    private final Personrepository personRepository;
    private final RoleRepository roleRepository;





    public PersonServiceImpl(Personrepository personRepository, RoleRepository roleRepository){
        this.personRepository= personRepository;
        this.roleRepository= roleRepository;

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

    @Override
    public List<Rol> findAllRolesByFilter(String filter, String value) {
        // TODO Auto-generated method stub
        
        return roleRepository.findAll();
    }
    
}
