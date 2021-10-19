package ru.netology.shop.product;

public class AppleIPhoneBuilder<T extends AppleIPhoneBuilder<T>> extends SmartPhoneBuilder<T> {

    private static final String NAME = "iPhone";
    private static final String MANUFACTURER = "Apple";

    public AppleIPhoneBuilder() {
        super();
        super.setManufacturer(MANUFACTURER);
        super.setName(NAME);
    }

    @Override
    public T setName(String name) {
        throw new IllegalArgumentException("Cannot redefine Apple iPhone name");
    }

    @Override
    public T setManufacturer(String manufacturer) {
        throw new IllegalArgumentException("Cannot redefine Apple iPhone manufacturer");
    }

}
