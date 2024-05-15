package dto;

import co.edu.cue.proyectoc2.models.Category;

public record ProductDto(Long id, String type, String brand, String model, Category category,int price, String available,String name) {
}
