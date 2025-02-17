package ru.pet.project.api_bridge.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author Gamma on 13.02.2025
 */
@Data
public class Item {
    private UUID id;
    private String name;
    private BigDecimal price;
    private int stock;
}
