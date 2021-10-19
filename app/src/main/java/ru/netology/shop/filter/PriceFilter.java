package ru.netology.shop.filter;

import java.util.Collection;
import java.util.stream.Collectors;

public abstract class PriceFilter<T extends IPriceAware> implements IFilter<T> {
    
    private final int price;

    public PriceFilter(int price) {
        this.price = price;
    }

    @Override
    public Collection<T> filter(Collection<T> items) {
        return items.stream()
            .filter(item -> this.filterPrice(price, item.getPrice()))
            .collect(Collectors.toSet());
    }

    protected abstract boolean filterPrice(int price, int testPrice);

}
