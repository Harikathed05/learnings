package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// A binary tree node
 class Node {

    public int data;
    public Node left, right;

    Node(int d)
    {
        data = d;
        left = right = null;
    }
}
public class InorderSuccessor {
         Node head;
         List<Integer> integers = new ArrayList<>();
         /* Given a binary search tree and a number,
      inserts a new node with the given number in
      the correct place in the tree. Returns the new
      root pointer which the caller should then use
      (the standard trick to avoid using reference
      parameters). */

         public void printInOrder(Node root) {
             if (Objects.isNull(root)) return;
             printInOrder(root.left);
             System.out.println(root.data);
             integers.add(root.data);
             printInOrder(root.right);
         }


         public static void main(String[] args) {
             InorderSuccessor tree = new InorderSuccessor();
             // root = null, temp = null, suc = null, min = null;
             Node root = new Node(100);
             root.left = new Node(97);
             root.right = new Node(102);
             root.left.left = new Node(96);
             root.left.right = new Node(99);
             root.left.right.left = new Node(98);



             /*root = tree.insert(root, 100);
             root = tree.insert(root, 98);
             root = tree.insert(root, 102);
             root = tree.insert(root, 96);
             root = tree.insert(root, 99);
             root = tree.insert(root, 97);*/


             //temp = root.left.right.right;
             int successorOf = 96;
             tree.printInOrder(root);
             System.out.println(tree.integers.size());
             int nextSuccessor = tree.integers.stream().filter( x -> x > successorOf).findFirst().orElse(null);
             System.out.println("nextSuccessor " + nextSuccessor);
         }
     }

