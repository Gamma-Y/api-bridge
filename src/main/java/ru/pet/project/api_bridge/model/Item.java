package ru.pet.project.api_bridge.model;

import lombok.Data;

import java.util.UUID;

/**
 * @author Gamma on 13.02.2025
 */
@Data
public class Item {
    private UUID id;
    private String name;
    private double price;
    private int stock;
}
