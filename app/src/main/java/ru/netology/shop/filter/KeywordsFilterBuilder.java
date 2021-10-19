package ru.netology.shop.filter;

import java.util.Collection;
import java.util.HashSet;

public class KeywordsFilterBuilder<T extends IKeywordsAware> {
    
    private final Collection<String> keywords = new HashSet<>();

    public KeywordsFilterBuilder<T> addKeyword(String keyword) {
        keywords.add(keyword);

        return this;
    }

    public KeywordsFilter<T> build() {
        return new KeywordsFilter<>(keywords);
    }

}
