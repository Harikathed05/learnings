package com.company;

public class UnivaluedSubtrees {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }
   static class Count {
        int count = 0;
   }
   static class UniValued {
        Node node ;
        Count c = new Count();
       public boolean checkUniValuedSubtrees(final Node node, Count c) {
           System.out.println("checkUniValuedSubtrees.. ");
           if (node == null) {
               return false;
           }
           boolean left = checkUniValuedSubtrees(node.left, c);
           boolean right = checkUniValuedSubtrees(node.right, c);
           if ((left == false) || (right == false)) {
               return false;
           }
           if ((node.left != null) && (node.left.value != node.value)) {
               return false;
           }
           if ((node.right != null) && (node.right.value != node.value)) {
               return false;
           }

           c.count++;
           return true;
       }

       public int checkCount(Node node) {

           checkUniValuedSubtrees(node, c);
           return c.count;
       }

   }
    public static void main(String[] args) {
        UnivaluedSubtrees univaluedSubtrees = new UnivaluedSubtrees();
       /* Node root = new Node(5);
        root.left = new Node(1);
        root.right = new Node(5);
        root.right.left = null;
        root.left.left = new Node(5);
        root.left.left.left = null;
        root.left.left.right = null;
        root.left.right = new Node(5);
        root.left.right.right = null;
        root.left.right.left = null;
        root.right.right = new Node(5);
        root.right.right.right = null;
        root.right.right.left = null;*/

        /*Node root = new Node(9);
        root.left = new Node(8);
        root.right = new Node(9);
       // root.right.left = null;
        root.left.left = new Node(8);
        root.left.left.left = new Node(8);;
        //root.left.left.right = null;
        root.left.right = new Node(7);
        root.left.right.right = new Node(7);
        root.left.right.left = new Node(7);
        root.right.right = new Node(9);
       // root.right.right.right = null;
        //root.right.right.left = null;*/
        Node root = new Node(9);
        root.left = new Node(1);
        root.right = new Node(9);


        UniValued univalued = new UniValued();
        //univalued.checkCount(root, c);
        System.out.println("count " + univalued.checkCount(root));

    }
}
