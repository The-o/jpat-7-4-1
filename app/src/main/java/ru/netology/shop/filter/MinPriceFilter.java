package ru.netology.shop.filter;

public class MinPriceFilter<T extends IPriceAware> extends PriceFilter<T> {

    public MinPriceFilter(int price) {
        super(price);
    }

    @Override
    protected boolean filterPrice(int price, int testPrice) {
        return testPrice >= price;
    }

}
