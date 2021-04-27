package ru.geekbrains.aprilmarket.dto;

import lombok.Data;
import ru.geekbrains.aprilmarket.entities.Product;

@Data
public class ProductDto {
    private Long id;
    private String title;
    private Integer price;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
    }
}
