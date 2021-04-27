package ru.geekbrains.aprilmarket.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.aprilmarket.dto.ProductDto;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class CartService {
    private Map<ProductDto, Integer> products = new HashMap<>();

    public CartService() {
    }

    @Transactional
    public void addProductToCart(ProductDto product) {
        int count;
        if (products.get(product) == null) {
            products.put(product, 1);
        } else {
            count = products.get(product);
            products.put(product, ++count);
        }
    }

    @Transactional
    public void deleteProductFromCart(ProductDto product) {
        int count;
        if (products.get(product) == null) return;
        if (products.get(product) == 1) {
            products.remove(product);
        } else {
            count = products.get(product);
            products.put(product, --count);
        }
    }

    public Map<ProductDto, Integer> getProducts() {
        return products;
    }
}
