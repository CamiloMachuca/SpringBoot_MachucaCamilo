package com.camilo.demojpa.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// para inicializar que esta clase va a ser una tabla
@Entity 
// para cambiar el nombre de la tabla
@Table(name= "personas")
public class Person {
    // para definir que es una llave primaria
    @Id
    // PARA HACER AUTOINCREMENT LA ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    
    @Column(name= "programming_language")
    private String language;

    // Se realiza la union de person y rol
    @OneToMany
    private List<Rol> role;


    public Person() {
        
    }
    

    public Person(Long id, String lastName,String name, String language) {
        this.id = id;
        this.name= name;
        this.lastName = lastName;
        this.language = language;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getLanguage() {
        return language;
    }


    public void setLanguage(String language) {
        this.language = language;
    }
    public List<Rol> getRol(){
        return role;
    }
    public void setRole(List<Rol> role){
        this.role=role;
    }



}
