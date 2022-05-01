import java.io.*;
import java.util.*;
  
public class practice{
    static ArrayList<Integer> preorder = new ArrayList<>();
    static ArrayList<Integer> inorder = new ArrayList<>();
    static ArrayList<Integer> postorder = new ArrayList<>();
    
    public static class Node{
        int data;
        Node left;
        Node right;
         Node(int key){
            data = key;
        }
    }
    
    
    
    
    public static class Pair{
        Node val;
        int count;
        
        Pair(Node val,int count){
            this.val =val;
            this.count = count;
        }
    }
    
    public static void allOrder(Node root){
        Stack<Pair> st = new Stack<>();
        st.add(new Pair(root,1));
        
        while(!st.isEmpty()){
            Pair p = st.peek();
            if(p.count == 1){
                preorder.add(p.val.data);
                p.count++;
                if(p.val.left!=null){
                    Pair p1 = new Pair(p.val.left,1);
                    st.push(p1);
                }
            }
            else if(p.count==2){    
                inorder.add(p.val.data);
                p.count++;
                
                if(p.val.right!=null){
                    Pair p1 = new Pair(p.val.right,1);
                    st.push(p1);
                }
            }
            else{
                postorder.add(p.val.data);
                st.pop();
            }
        }
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
        allOrder(root);
        
        System.out.println(preorder);
        System.out.println(inorder);
        System.out.println(postorder);
    }
    
}
