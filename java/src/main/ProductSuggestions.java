package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductSuggestions {


    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        ArrayList<List<String>> productSuggestions = new ArrayList<>();

        String[] remainingProducts = products;
        for(int i = 1; i <= searchWord.length(); i++) {
            ArrayList<String> searchResults = new ArrayList<>();
            String searchCharacters = searchWord.substring(0, i);
            for(String product: remainingProducts) {
                if(product.startsWith(searchCharacters)) {
                    searchResults.add(product);
                }
            }
            Collections.sort(searchResults);
            productSuggestions.add(searchResults.subList(0, Math.min(3, searchResults.size())));
            remainingProducts = searchResults.toArray(new String[0]);
        }
        return productSuggestions;
    }

    public static void main(String[] args) {
        ProductSuggestions solution = new ProductSuggestions();
        System.out.println(solution.suggestedProducts(new String[] {"mobile","mouse","moneypot","monitor","mousepad"},
                "mouse"));
    }

}
