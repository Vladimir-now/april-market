package ru.geekbrains.aprilmarket.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.aprilmarket.dto.ProductDto;
import ru.geekbrains.aprilmarket.services.CartService;
import ru.geekbrains.aprilmarket.services.ProductService;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartController {
    private ProductService productService;
    private CartService cartService;

    @PostMapping("{id}")
    public Map<ProductDto, Integer> addProduct(@PathVariable Long id) {
        cartService.addProductToCart(productService.findProductDtoById(id).orElseThrow(() -> new RuntimeException("Not found!!!")));
        return cartService.getProducts();
    }

    @DeleteMapping("{id}")
    public Map<ProductDto, Integer> deleteProduct(@PathVariable Long id) {
        cartService.deleteProductFromCart(productService.findProductDtoById(id).orElseThrow(() -> new RuntimeException("Not found!!!")));
        return cartService.getProducts();
    }
}
