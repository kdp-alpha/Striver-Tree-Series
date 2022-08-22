class Solution {
    public void Bt_Bst(TreeNode root) {
        if(root==null) return root;
        TreeNode head = bt_dll(root);
        head = mergeSort(head);
        TreeNode temp = SortedDLLToBST(head);
        display(temp);
        
    }
      public static TreeNode mid(TreeNode head){
        if(head==null || head.right==null) return head;
        
        TreeNode fast = head;
        TreeNode slow = head;
        
        while(fast.right!=null && fast.right.right!=null){
            fast = fast.right.right;
            slow = slow.right;
        }
        
        return slow;
    }

    public static TreeNode mergeTwoSortedDll(TreeNode l1,TreeNode l2){
        if(l1==null || l2==null){
            return l1!=null ? l1:l2;
        }

        TreeNode dummy = new TreeNode(-1);
        TreeNode prev = dummy;
        TreeNode c1 = l1;
        TreeNode c2 = l2;

        while(c1!=null && c2!=null){
            if(c1.val <= c2.val){
                prev.right = c1;
                c1.left = prev;
                c1 = c1.right;
            }
            else{
                prev.right = c2;
                c2.left = prev;
                c2 = c2.right;
            }

            prev = prev.right;
        }
        if(c1!=null){
            prev.right = c1;
            c1.left = prev;
        }
        else{
            prev.right = c2;
            c2.left = prev;
        }

        TreeNode head = dummy.right;
        dummy.right = head.left = null;

        return head;
    
    }
    public static TreeNode SortedDLLToBST(TreeNode head) {
        if(head==null || head.right==null){
            return head;
        }
        
        TreeNode middle = mid(head);
        TreeNode prev = middle.left;
        TreeNode forw = middle.right;
        
        middle.left = middle.right= forw.left = null;
        
        if(prev!=null){
            prev.right = null;
        }
        
        TreeNode root = middle;
        TreeNode lefthead = (prev !=null ? head:null);
        TreeNode righthead = forw;
        
        root.left = SortedDLLToBST(lefthead);
        root.right = SortedDLLToBST(righthead);
        
        return root;
  }
    public static TreeNode mergeSort(TreeNode head){
        if(head==null || head.right==null){
            return head;
        }
        TreeNode middle = mid(head);
        TreeNode forw = middle.right;
        forw.left = middle.right = null;

        return mergeTwoSortedDll(mergeSort(head),mergeSort(forw));
    }
    
    public static TreeNode rightmost(TreeNode ln,TreeNode curr){
        while(ln.right!=null && ln.right!=curr){
            ln = ln.right;
        }

        return ln;
    }
    public static TreeNode bt_dll(TreeNode root){
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

        return head;
    }
    
    public static void display(TreeNode root){
    if(root==null){
        return;
    }
    String str = "";

    str += ((root.left!=null ? String.valueOf(root.left.val) : "."));
    str += ("->" + String.valueOf(root.val) + "<-");
    str += ((root.right !=null ? String.valueOf(root.right.val) : ".")); 

    System.out.println(str);

    display(root.left);
    display(root.right);
  }
}
