public class Morris {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int key){
            data = key;
            left = right = null;
        }
    }

    public static Node rightMostNode(Node ln,Node curr){
        if(ln.right!=null && ln.right!=curr){
            ln = ln.right;
        }
        return ln;
    }

    public static void Morris_Inorder(Node root){
        Node curr = root;

        while(curr!=null){
            Node ln = curr.left;

            if(ln==null){
                System.out.print(curr.data + " ");
                curr = curr.right;
            }
            else{
                Node rightmost = rightMostNode(ln, curr);

                if(rightmost.right==null){
                    rightmost.right = curr;
                    curr = curr.left;
                }
                else{   
                    rightmost.right = null;
                    System.out.print(curr.data + " ");
                    curr = curr.right;
                }
            }

        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(7);
        root.right.left = new Node(6);

        Morris_Inorder(root);

    }
}
