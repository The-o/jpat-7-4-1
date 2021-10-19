package ru.netology.shop.filter;

import java.util.Collection;
import java.util.stream.Collectors;

public class KeywordsFilter<T extends IKeywordsAware> implements IFilter<T> {
    
    private final Collection<String> keywords;

    public KeywordsFilter(Collection<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public Collection<T> filter(Collection<T> items) {
        return items.stream()
            .filter(this::hasKeywords)
            .collect(Collectors.toSet());
    }

    private boolean hasKeywords(T item) {
        Collection<String> itemKeywords = item.getKeywords();
        return keywords.stream().allMatch(keyword -> hasKeyword(itemKeywords, keyword));
    }

    private boolean hasKeyword(Collection<String> itemKeywords, String keyword) {
        String lowerCaseKeyword = keyword.toLowerCase();
        return itemKeywords.stream().anyMatch(itemKeyword -> itemKeyword.toLowerCase().equals(lowerCaseKeyword));
    }

}
