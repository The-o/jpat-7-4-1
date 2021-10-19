package ru.netology.shop.product;

import ru.netology.shop.exceptions.NotEnoughProductData;

public class PhoneBuilder<T extends PhoneBuilder<T>> extends ProductBuilder<T> {

    private static final String PREFIX_PHONE = "Телефон";
    private static final String KEYWORD_PHONE = "телефон";

    protected String manufacturer;
    protected String model;

    public PhoneBuilder() {
        keywords.add(KEYWORD_PHONE);
    }

    @SuppressWarnings("unchecked")
    public T setName(String name) {
        if (this.name != null) {
            keywords.remove(this.name);
        }
        super.setName(name);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T setManufacturer(String manufacturer) {
        if (manufacturer == null) {
            throw new IllegalArgumentException("Manufacturer cannot be null");
        }
        if (this.manufacturer != null) {
            keywords.remove(this.manufacturer);
        }

        this.manufacturer = manufacturer;
        keywords.add(manufacturer);

        return (T)this;
    }

    @SuppressWarnings("unchecked")
    public T setModel(String model) {
        if (model == null) {
            throw new IllegalArgumentException("Model cannot be null");
        }
        this.model = model;

        return (T)this;
    }

    public Product build() throws NotEnoughProductData {
        checkBuild();

        return new Product(PREFIX_PHONE + " " + manufacturer + " " + name + " " + model, price, keywords);
    }

    @Override
    protected void checkBuild() throws NotEnoughProductData {
        super.checkBuild();
        if (manufacturer == null) {
            throw new NotEnoughProductData("Phone manufacturer not set");
        }
        if (model == null) {
            throw new NotEnoughProductData("Phone model not set");
        }
    }



}
