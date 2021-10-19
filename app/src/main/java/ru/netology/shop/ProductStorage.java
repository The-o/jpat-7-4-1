package ru.netology.shop;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ru.netology.shop.exceptions.NotEnoughProductsException;
import ru.netology.shop.product.Product;

public class ProductStorage {

    private final Map<Product, Integer> productsAmount = new HashMap<>();

    public void addProduct(Product product, int amount) {
        amount += getAmount(product);
        productsAmount.put(product, amount);
    }

    public int getAmount(Product product) {
        return productsAmount.getOrDefault(product, 0);
    }

    public void retrieveProduct(Product product, int amount) throws NotEnoughProductsException {
        amount = getAmount(product) - amount;
        
        if (amount < 0) {
            throw new NotEnoughProductsException();
        }

        productsAmount.put(product, amount);
    }

    public Collection<Product> getProducts() {
        return productsAmount.keySet();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(Product product: getProducts()) {
            sb.append(product)
                .append(" - ")
                .append(getAmount(product))
                .append("шт.")
                .append("\n");
        }

        return sb.toString();
    }

    
}
