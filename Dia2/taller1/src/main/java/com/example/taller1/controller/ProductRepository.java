package com.example.taller1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.taller1.domain.Product;
@Repository
public class ProductRepository {

    private final List<Product> products = new ArrayList<>();
    
    public ProductRepository() {
        products.add(new Product(1, "Phone 10", "Celular", 2000.00, 12));
        products.add(new Product(2, "Phone 14", "Celular", 4000.00, 14));
        products.add(new Product(3, "Laptop Air", "Computadora", 8500.00, 5));
        products.add(new Product(4, "Laptop Pro", "Computadora", 12000.00, 3));
        products.add(new Product(5, "Tablet Mini", "Tablet", 1500.00, 10));
        products.add(new Product(6, "Tablet Pro", "Tablet", 2500.00, 8));
        products.add(new Product(7, "Smartwatch Fit", "Accesorio", 999.99, 20));
        products.add(new Product(8, "Smartwatch Pro", "Accesorio", 1499.99, 15));
        products.add(new Product(9, "Mouse Inalámbrico", "Accesorio", 299.99, 25));
        products.add(new Product(10, "Teclado Mecánico", "Accesorio", 799.99, 12));
        products.add(new Product(11, "Monitor 24", "Pantalla", 1800.00, 6));
        products.add(new Product(12, "Monitor 32", "Pantalla", 2800.00, 4));
        products.add(new Product(13, "Auriculares Bluetooth", "Audio", 499.99, 30));
        products.add(new Product(14, "Bocina Portátil", "Audio", 699.99, 22));
        products.add(new Product(15, "Cargador Rápido", "Accesorio", 199.99, 50));
        products.add(new Product(16, "Cable USB-C", "Accesorio", 79.99, 60));
        products.add(new Product(17, "Webcam HD", "Accesorio", 599.99, 18));
        products.add(new Product(18, "ImpresoraH2", "Impresora", 3500.00, 7));
        products.add(new Product(19, "ImpresoraH4", "Impresora", 4500.00, 10));
        products.add(new Product(20, "ImpresoraPhP", "Impresora", 6000.00, 5));
    }

    public List<Product> findAll() { 
        return products; 
    }

}
