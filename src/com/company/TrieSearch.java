package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class TrieSearch {

    class TrieNode {
        char c;
        HashMap<Character, TrieNode> children = new HashMap<>();
        TrieNode parent;
        boolean isEnd;
        public TrieNode() {
        }
        public TrieNode(char c) {
            this.c = c;
        }
    }

    private  TrieNode root;
    private  ArrayList<String> words;
    TrieNode trieNode;
    String curPrefix;

    public TrieSearch() {
        root = new TrieNode();
        words = new ArrayList<>();
    }

    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
        TrieNode curParent;
        curParent = root;
        for(int i =0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode temp;
            if(children.containsKey(c)) {
                temp = children.get(c);
            } else {
                temp = new TrieNode();
                temp.parent = curParent;
                children.put(c, temp);
            }
            children = temp.children;
            curParent = temp;
            if(i == word.length() -1) {
                temp.isEnd = true;
            }
        }
    }

    public boolean searchWord(String word) {
        TrieNode temp = searchTrieNode(word);
        if(temp != null && temp.isEnd) return true;
        else return false;
    }

    public boolean searchStartWith(String prefix) {
        if(searchTrieNode(prefix) == null) return false;
        else return true;
    }


    public TrieNode searchTrieNode(String word) {
        Map<Character, TrieNode> children = root.children;
        TrieNode temp = null;
        for (int i =0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(children.containsKey(c)){
                temp = children.get(c);
                children = temp.children;
            }
            else return null;
        }
        trieNode = temp;
        curPrefix = word;
        words.clear();
        return temp;
    }

    public void wordsFinderTraversal(TrieNode trieNode, int offset) {
        if(trieNode.isEnd == true) {
            TrieNode altair;
            altair = trieNode;
            Stack<String> hstack = new Stack<>();
            while(altair != trieNode)
            {
                hstack.push( Character.toString(altair.c));
                altair = altair.parent;
            }
            String wrd = curPrefix;
            while (!hstack.empty()) {
                wrd = wrd + hstack.pop();
            }
            words.add(wrd);
        }

        Set<Character> kset = trieNode.children.keySet();
        //println(node.c); println(node.isLeaf);println(kset);
        Iterator itr = kset.iterator();
        ArrayList<Character> aloc = new ArrayList<Character>();

        while(itr.hasNext())
        {
            Character ch = (Character)itr.next();
            aloc.add(ch);
            //println(ch);
        }

        // here you can play with the order of the children

        for( int i=0;i<aloc.size();i++)
        {
            wordsFinderTraversal(trieNode.children.get(aloc.get(i)), offset + 2);
        }

    }

}
