package ru.netology.shop.filter;

import java.util.Collection;

public class ComplexFilter<T> implements IFilter<T> {

    private final Collection<IFilter<T>> filters;

    public ComplexFilter(Collection<IFilter<T>> filters) {
        this.filters = filters;
    }

    @Override
    public Collection<T> filter(Collection<T> items) {
        for (IFilter<T> filter : filters) {
            items = filter.filter(items);
        }
        return items;
    }

}
