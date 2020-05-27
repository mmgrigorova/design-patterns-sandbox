package com.company.design_patterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class Sentence {
    private String[] words;
    private Map<Integer, WordToken> tokens = new HashMap<>();

    public Sentence(String plainText) {
        words = plainText.split(" ");
    }

    public WordToken getWord(int index) {
        tokens.put(index, new WordToken());
        return tokens.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (tokens.containsKey(i) && tokens.get(i).capitalize) {
                sb.append(words[i].toUpperCase());
            } else {
                sb.append(words[i]);
            }
            if (i < words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
