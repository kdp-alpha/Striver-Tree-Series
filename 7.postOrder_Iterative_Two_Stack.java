class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
         ArrayList<Integer> ans = new ArrayList<>();
        iterative(root,ans);
        return ans;
        
    }
    
    public void iterative(TreeNode root,ArrayList<Integer> ans){
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(root);
        while(!st1.isEmpty()){
            root = st1.pop();
            st2.push(root);
            if(root.left!=null){
                st1.add(root.left);
                
            }
            if(root.right!=null){
                st1.add(root.right);
            }
        }
        while(!st2.isEmpty()){
           ans.add(st2.pop().val);
        }
        
        
    }
}
