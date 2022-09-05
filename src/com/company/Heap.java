package com.company;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Heap {
    private int collideTwoStones(int a, int b) {
        return a != b ? Math.abs(a - b) : 0;
    }
    public int collideAllStones(PriorityQueue<Integer> priorityQueue) {
        //while (!priorityQueue.isEmpty() || (priorityQueue.size() > 1)) {
        while ((priorityQueue.size() > 1)) {
            int stone1 = priorityQueue.poll();
            int stone2 = priorityQueue.poll();
            System.out.println("Stone1 is colliding " + stone1 + " to stone2 "+ stone2);
            int newStone = collideTwoStones(stone1, stone2);
            if(newStone > 0) {
                priorityQueue.add(newStone);
            }
        }
        System.out.println("The queue elements:");
        Iterator itr = priorityQueue.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());
        System.out.println("The queue length : " + priorityQueue.poll());
        return priorityQueue.size() == 1 ? priorityQueue.poll() : 0;
    }

    public static void main(String args[]) {
        //int [] stones = new int[]{2,7,4,1,8,1};
        int [] stones = new int[]{2,2};
        // Creating empty priority queue
        PriorityQueue<Integer> pQueue
                = new PriorityQueue<Integer>(
                Collections.reverseOrder());

        // Adding items to our priority queue
        // using add() method
        for (int stone:
             stones) {
            pQueue.add(stone);
        }

        // Printing all elements
        Heap heap = new Heap();
        heap.collideAllStones(pQueue);

    }
}
