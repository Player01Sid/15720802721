package com.example.top_products;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;


@RestController
@RequestMapping(path="/test/companies")
public class ProductsController {

    private final ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping(path = "{company}/")
    public Mono<List<Product>> getRequest(
            @RequestParam(required = false) String top,
            @RequestParam(required = false) String minPrice,
            @RequestParam(required = false) String maxPrice

    ){
        return productsService.getProducts();
    }
}
