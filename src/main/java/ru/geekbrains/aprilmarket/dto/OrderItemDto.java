package ru.geekbrains.aprilmarket.dto;

import lombok.Data;
import ru.geekbrains.aprilmarket.entities.OrderItem;
import ru.geekbrains.aprilmarket.entities.Product;

@Data
public class OrderItemDto {
    private Long productId;
    private String productTitle;
    private Integer pricePerProduct;
    private Integer price;
    private Integer quantity;

    public OrderItemDto(OrderItem orderItem) {
        this.productId = orderItem.getProduct().getId();
        this.productTitle = orderItem.getTitle();
        this.pricePerProduct = orderItem.getPricePerProduct();
        this.price = orderItem.getPrice();
        this.quantity = orderItem.getQuantity();
    }
}
