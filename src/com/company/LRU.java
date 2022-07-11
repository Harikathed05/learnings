package com.company;

import java.util.*;

public class LRU {

    Queue<Integer> lruQueue ;

    public LRU(Queue<Integer> queue) {
        this.lruQueue =  queue;
    }
    public boolean searchInQueue(Queue<Integer> currentPages, int searchElement) {
        if(currentPages.contains(searchElement)){
            currentPages.remove(searchElement);
            return true;
        } else return false;
    }

    private int lruPageFault(int insertElement, int pages) {
        if (lruQueue.isEmpty()) {
            lruQueue.add(insertElement);
            return 1;
        }
        if(lruQueue.size() != pages && !(searchInQueue(lruQueue, insertElement))) {
            lruQueue.add(insertElement);
            return 1;
        } else if(searchInQueue(lruQueue, insertElement)) {
            lruQueue.add(insertElement);
            return 0;
        }
        else if(lruQueue.size() == pages) {
            lruQueue.remove();
            lruQueue.add(insertElement);
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        List<Integer> pagesList = Arrays.asList(1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5);
        //List<Integer> pagesList = Arrays.asList( 4, 7, 6, 1, 7, 6, 1, 2, 7, 2);
        int pages = 3;
        int pageFault = 0;
        Queue<Integer> queue = new LinkedList<>();
        LRU lru = new LRU(queue);
        for (int pageValue:
             pagesList) {
            pageFault += lru.lruPageFault(pageValue, pages);

        }
        System.out.println("Page fault count "+pageFault);
        queue.forEach(System.out::println);
    }
}
