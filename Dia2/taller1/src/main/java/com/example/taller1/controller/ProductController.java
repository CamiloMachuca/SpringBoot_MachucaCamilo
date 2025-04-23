package com.example.taller1.controller;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.taller1.domain.Product;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductRepository repo;
    public ProductController(ProductRepository repo) { 
      this.repo = repo; 
    }

    @GetMapping("/products")
    public List<Product> getProducts(
        @RequestParam(required = false) Double minPrice,
        @RequestParam(required = false) Double maxPrice,
        @RequestParam(required = false) String category
    ) {
      	//Aplica los filtros de minPrice, maxPrice y category, recuerda que pueden aplicarse todos o ninguno
        List<Product> listadoFiltrado= repo.findAll().stream()
        .filter(pro ->minPrice ==null || pro.getPrice()>=minPrice)
        .filter(pro ->maxPrice ==null || pro.getPrice()<=maxPrice)
        .filter(pro ->category ==null || pro.getCategory().equalsIgnoreCase(category))
        .toList();

        
        
        return listadoFiltrado;
    }
    
    @GetMapping("/products/stats")
    public Map<String, Double> getStats(
        @RequestParam(required = false) String category
    ) {
     
    DoubleSummaryStatistics statistics= repo.findAll().stream()
        .filter(pro ->category ==null || pro.getCategory().equalsIgnoreCase(category))
        .mapToDouble(pro -> pro.getPrice())
        .summaryStatistics();

        
    
     //Obtenga el listado de productos filtrados por categoría
   
        return Map.of(
           "count", (double) statistics.getCount(),
           "avgPrice", statistics.getAverage(),
           "minPrice", statistics.getMin(),
           "maxPrice", statistics.getMax(),
           "totalValue", statistics.getSum()
        );
   }

}
