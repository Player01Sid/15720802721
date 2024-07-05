package com.example.top_products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ProductsService implements ResourceLoaderAware {

    private final WebClient webClient;

    @Autowired
    public ApiService(WebClient.Builder webClientBuilder,
                      @Value("${api.baseurl}") String baseUrl,
                      @Value("${api.token}") String bearerToken) {
        this.webClient = webClientBuilder.baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + bearerToken)
                .build();
    }

    public Mono<String> fetchDataFromExternalApi() {
        return webClient.get()
                .uri("/endpoint")
                .retrieve()
                .bodyToMono(String.class);
    }
}
