package ru.netology.shop.filter;

import java.util.Collection;

public interface IFilter<T> {

    Collection<T> filter(Collection<T> items);

}
