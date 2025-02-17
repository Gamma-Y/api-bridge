package ru.pet.project.api_bridge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import ru.pet.project.api_bridge.model.Item;

/**
 * @author Gamma on 13.02.2025
 */
@Service
public class ItemService {
    private final WebClient webClient;

    @Autowired
    public ItemService(WebClient.Builder webClientBuilder, @Value("store.api.endpoint") String endpoint) {
        this.webClient = webClientBuilder.baseUrl(endpoint).build();
    }

    @Cacheable(value = "items")
    public Flux<Item> getItems() {
        return webClient.get()
                .uri("/items")
                .retrieve()
                .bodyToFlux(Item.class);
    }


}
