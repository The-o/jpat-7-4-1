package ru.netology.shop.product;

import java.util.Collection;

import ru.netology.shop.filter.IKeywordsAware;
import ru.netology.shop.filter.IPriceAware;

public class Product implements IKeywordsAware, IPriceAware {
    
    private final String name;
    private final int price;
    private final Collection<String> keywords;
    
    public Product(String name, int price, Collection<String> keywords) {
        this.name = name;
        this.price = price;
        this.keywords = keywords;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public Collection<String> getKeywords() {
        return keywords;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((keywords == null) ? 0 : keywords.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + price;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Product other = (Product) obj;

        if (price != other.price) {
            return false;
        }
        if (keywords == null) {
            if (other.keywords != null) {
                return false;
            }
        } else if (!keywords.equals(other.keywords)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
