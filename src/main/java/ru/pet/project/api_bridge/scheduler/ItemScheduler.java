package ru.pet.project.api_bridge.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.pet.project.api_bridge.service.ItemService;

/**
 * @author Gamma on 13.02.2025
 */
@Service
@RequiredArgsConstructor
public class ItemScheduler {
    private final ItemService itemService;


    @Scheduled(fixedRate = 60000)
    public void refreshCache() {
        itemService.getItems().cache().blockLast();
    }
}
