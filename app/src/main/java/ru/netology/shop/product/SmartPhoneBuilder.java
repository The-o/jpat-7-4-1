package ru.netology.shop.product;

import ru.netology.shop.exceptions.NotEnoughProductData;

public class SmartPhoneBuilder<T extends SmartPhoneBuilder<T>> extends PhoneBuilder<T> {

    private static final String PREFIX_SMARTPHONE = "Смартфон";
    private static final String POSTFIX_GB = "GB";
    private static final String KEYWORD_SMARTPHONE = "смартфон";

    protected Integer memoryInGb;

    public SmartPhoneBuilder() {
        keywords.add(KEYWORD_SMARTPHONE);
    }

    @SuppressWarnings("unchecked")
    public T setMemoryAmount(int memoryInGb) {
        if (memoryInGb < 0) {
            throw new IllegalArgumentException("Memory amount cannot be negative");
        }
        if (this.memoryInGb != null) {
            keywords.remove(this.memoryInGb + POSTFIX_GB);
        }

        this.memoryInGb = memoryInGb;
        keywords.add(memoryInGb + POSTFIX_GB);

        return (T)this;
    }

    public Product build() throws NotEnoughProductData {
        checkBuild();

        return new Product(PREFIX_SMARTPHONE + " " + manufacturer + " " + name + " " + model + " " + memoryInGb + POSTFIX_GB, price, keywords);
    }

    @Override
    protected void checkBuild() throws NotEnoughProductData {
        super.checkBuild();

        if (memoryInGb == null) {
            throw new NotEnoughProductData("Smartphone memory amount not set");
        }
    }
}
