package com.example.top_products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ProductsService {

    private final WebClient webClient;

    @Autowired
    public ProductsService(WebClient.Builder webClientBuilder,
                      @Value("${api.url}") String baseUrl,
                      @Value("${api.token}") String bearerToken) {
        this.webClient = webClientBuilder.baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + bearerToken)
                .build();
    }

    public Mono<List<Product>> getProducts(String top, String minPrice, String maxPrice, String company) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.
                        path("/products")
                        .queryParam("top","10")
                        .queryParam("minPrice","1")
                        .queryParam("maxPrice","10000")
                        .build())
                .retrieve()
                .bodyToFlux(Product.class) // Convert JSON array to Flux of Product
                .collectList(); // Collect all items into a List<Product>
    }
}
