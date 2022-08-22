public static Node mid(Node head){
        if(head==null || head.right==null) return head;
        
        Node fast = head;
        Node slow = head;
        
        while(fast.right!=null && fast.right.right!=null){
            fast = fast.right.right;
            slow = slow.right;
        }
        
        return slow;
    }
    
  // left : prev, right : next
  public static Node SortedDLLToBST(Node head) {
        if(head==null || head.right==null){
            return head;
        }
        
        Node middle = mid(head);
        Node prev = middle.left;
        Node forw = middle.right;
        
        middle.left = middle.right= forw.left = null;
        
        if(prev!=null){
            prev.right = null;
        }
        
        Node root = middle;
        Node lefthead = (prev !=null ? head:null);
        Node righthead = forw;
        
        root.left = SortedDLLToBST(lefthead);
        root.right = SortedDLLToBST(righthead);
        
        return root;
  }
