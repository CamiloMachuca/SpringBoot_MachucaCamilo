package com.camilo.demojpa.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.camilo.demojpa.domain.Person;

// SERVIR ES UNA ESPECIALIZACION O UNA CLASE QUE NOS OFRECE UNA FUNCIONALIDAD QUE CONTIENE LA LOGICA DE NEGOCIO DE LA APLICACION 
@Service
public interface PersonService {
    public List<Person> findAllByFilter(String filter, String value);

    
}
