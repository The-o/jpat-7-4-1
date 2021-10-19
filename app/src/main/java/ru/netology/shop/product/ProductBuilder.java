package ru.netology.shop.product;

import java.util.Collection;
import java.util.HashSet;

import ru.netology.shop.exceptions.NotEnoughProductData;

public class ProductBuilder<T extends ProductBuilder<T>> {

    protected final Collection<String> keywords = new HashSet<>();
    protected String name;
    protected Integer price;

    @SuppressWarnings("unchecked")
    public T setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.name = name;

        return (T)this;
    }

    @SuppressWarnings("unchecked")
    public T setPrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;

        return (T)this;
    }

    @SuppressWarnings("unchecked")
    public T addKeyword(String keyword) {
        keywords.add(keyword);

        return (T)this;
    }

    public Product build() throws NotEnoughProductData {
        checkBuild();

        return new Product(name, price, keywords);
    }

    protected void checkBuild() throws NotEnoughProductData {
        if (name == null) {
            throw new NotEnoughProductData("Product name not set");
        }
        if (price == null) {
            throw new NotEnoughProductData("Product price not set");
        }
    }

}
