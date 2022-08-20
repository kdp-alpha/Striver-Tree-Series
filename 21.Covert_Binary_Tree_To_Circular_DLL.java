public class Traversal {
    public static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int key){
            data = key;
            left = right = null;
        }
    }

    public TreeNode treeToDoublyList(TreeNode root) {
        return morris_order_dll (root);
    }
    public TreeNode rightmost(TreeNode ln,TreeNode curr){
        if(ln.right!=null && ln.right!=curr){
            ln = ln.right;
        }

        return ln;
    }
    public TreeNode morris_order_dll(TreeNode root){
        TreeNode curr = root;
        TreeNode dummy = new TreeNode(-1);
        TreeNode prev = dummy;
        while(curr!=null){
            TreeNode ln = curr.left;
            if(ln==null){
                prev.right = curr;
                curr.left = prev;
                prev = prev.right;

                curr = curr.right;
            }
            else{
                TreeNode rightN = rightmost(ln, curr);
                if(rightN.right==null){
                    rightN.right = curr;
                    curr = curr.left;
                }
                else{
                        rightN.right = null;
                        prev.right = curr;
                        curr.left = prev;
                        prev = prev.right;

                        curr = curr.right;

                }
            }
        }
        TreeNode head = dummy.right;
        dummy.right = head.left = null;

        head.left = prev;
        prev.right = head;

        return head;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(6);


    }
}
