class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
         if(root==null){
            return new ArrayList<>();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        iterative(root,ans);
        return ans;
        
    }
    
    public void iterative(TreeNode root,ArrayList<Integer> ans){
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while(true){
            if(node!=null){
                st.push(node);
                node = node.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                node = st.pop();
                ans.add(node.val);
                node = node.right;
                
            }
        }
        
       
    }
}
