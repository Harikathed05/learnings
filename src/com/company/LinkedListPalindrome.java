package com.company;

/**
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 * Input: head = [1,2,2,1]
 * Output: true
 */
public class LinkedListPalindrome {
    public Node head = null;
    class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data =  data;
            this.next = null;
        }
    }

    public void printLL(final Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(" " + temp.data);
            temp =  temp.next;
        }
    }
    public boolean isPalindromeLL(Node start, Node half) {
        Node temp = half;
        while (temp != null) {
            if(start.data != temp.data) {
                return false;
            }
            if(start == temp) continue;
            start = start.next;
            temp = temp.next;
        }
        return true;
    }
    public Node reverseLL(Node newHead) {
        Node t = null ;
        Node prev = null;
        Node curr = newHead;
        while (curr != null) {
            t = curr.next;
            curr.next = prev;
            prev = curr;
            curr = t;
        }
        newHead = prev;
        return newHead;
    }
    //addNode() will add a new node to the list
    public void addNode(int data) {
        //Create a new node
        Node newNode = new Node(data);
        Node temp = head;
        if(temp == null) {
            head = newNode;
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public Node findMid(final Node head) {
        Node slow = head;
        int count = 0;
        while(slow != null) {
            count++;
            slow = slow.next;
        }
        Node mid = head;
        int midCount = count%2 == 0 ? count/2 -1 : count/2;
        int temp = 0;
        while (temp < midCount) {
            mid = mid.next;
            temp++;
        }
        return mid;
    }


    public static void main(String [] agrs) {
        LinkedListPalindrome linkedListPalindrome = new LinkedListPalindrome();
        linkedListPalindrome.addNode(4);
        linkedListPalindrome.addNode(2);
        linkedListPalindrome.addNode(3);
        linkedListPalindrome.addNode(8);
        linkedListPalindrome.addNode(9);
        linkedListPalindrome.addNode(3);
        linkedListPalindrome.addNode(2);
        linkedListPalindrome.addNode(4);
        linkedListPalindrome.printLL(linkedListPalindrome.head);
        Node midNode = linkedListPalindrome.findMid(linkedListPalindrome.head);
        System.out.println("\nmid node is " + midNode.data);
        Node reverseHead = linkedListPalindrome.reverseLL(midNode.next);
        midNode.next = reverseHead;
        System.out.println("reversal node head is " + reverseHead.data);
        linkedListPalindrome.printLL(reverseHead);
        System.out.println("\nList after reversal of half");
        linkedListPalindrome.printLL(linkedListPalindrome.head);
        System.out.println("\nLinkedList is Palindrome " + linkedListPalindrome.isPalindromeLL(linkedListPalindrome.head, midNode.next));
    }

}
