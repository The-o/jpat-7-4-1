package ru.netology.shop.filter;

import java.util.Collection;
import java.util.HashSet;

public class ComplexFilterBuilder<T> {
    
    private final Collection<IFilter<T>> filters = new HashSet<>();

    public ComplexFilterBuilder<T> addFilter(IFilter<T> filter) {
        filters.add(filter);

        return this;
    }

    public ComplexFilter<T> build() {
        return new ComplexFilter<>(filters);
    }

}
