package com.company;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SearchSuggestionSystem {
    static final  int ALPHABETS_SIZE = 26;
    static class TrieNode {
        TrieNode[] childs = new TrieNode[ALPHABETS_SIZE];
        boolean isEndOfString ;
        TrieNode() {
            isEndOfString = false;
            for(int i = 0; i < ALPHABETS_SIZE; i++){
                childs[i] = null;
            }

        }
    }
    static TrieNode root;
    private void insertInTrie(String word) {
        int index;
        TrieNode mover = root;
        for(int i = 0; i < word.length(); i++) {
            index = word.charAt(i) - 'a';
            if(null == mover.childs[index]) {
                mover.childs[index] = new TrieNode();
            }
            mover = mover.childs[index];
        }
        mover.isEndOfString = true;
    }

    private boolean search(String word) {
        //int length = word.length();
        int index;
        TrieNode mover = root;
        for (int i = 0; i < word.length(); i++) {
            index = word.charAt(i) - 'a';
            if(mover.childs[index] == null) {
                return false;
            }
            mover = mover.childs[index];
        }
        System.out.println("new search value"+ mover.isEndOfString);
        return mover.isEndOfString;
    }
    public void searchSuggestion(List<String> products, String searchWord) {
        Iterator productsIterator = products.iterator();
        while(productsIterator.hasNext()) {
            insertInTrie(productsIterator.next().toString());
        }
        StringBuilder searching = new StringBuilder();
        for(int i =0; i < searchWord.length(); i++) {
            searching.append(searchWord.charAt(i));
            System.out.println("Searching " + searching.toString() + " found " + search(searching.toString()));
        }
    }

    public static void main(String[] args) {
        SearchSuggestionSystem searchSuggestionSystem = new SearchSuggestionSystem();
        root = new TrieNode();
        searchSuggestionSystem.searchSuggestion(Arrays.asList("bags","baggage","banner","box","cloths"), "bags");
    }
}


