import java.io.*;
import java.util.*;
  
public class Main {
    
    public static class Node{
        int data;
        Node left;
        Node right;
         Node(int key){
            data = key;
        }
    }
    public static void preOrder(Node root)
    {
       if(root==null){
           return;
       }
       System.out.print(root.data+ " ");
       preOrder(root.left);
       preOrder(root.right);
    }
  
    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.right = new Node(3);
        root.right.left = new Node(7);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);
        preOrder(root);
    }
}
