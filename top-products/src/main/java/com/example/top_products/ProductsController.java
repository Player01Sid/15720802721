package com.example.top_products;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(path = "{company}/categories/{category}/products")
    public Mono<List<Product>> getRequest(
            @RequestParam(required = false) String top,
            @RequestParam(required = false) String minPrice,
            @RequestParam(required = false) String maxPrice,
            @PathVariable("company") String company,
            @PathVariable("category") String category
    ){
        return productsService.getProducts(top, minPrice, maxPrice, company, category);
    }
}
