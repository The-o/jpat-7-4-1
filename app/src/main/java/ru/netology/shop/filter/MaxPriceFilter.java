package ru.netology.shop.filter;

public class MaxPriceFilter<T extends IPriceAware> extends PriceFilter<T> {

    public MaxPriceFilter(int price) {
        super(price);
    }

    @Override
    protected boolean filterPrice(int price, int testPrice) {
        return testPrice <= price;
    }

}
