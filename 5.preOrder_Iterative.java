class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        iterative(root,ans);
        return ans;
    }
    
    public void iterative(TreeNode root,ArrayList<Integer> ans){
        Stack<TreeNode>st = new Stack<>();
        st.add(root);
        while(st.size()>0){
            root = st.pop();
            ans.add(root.val);
                if(root.right!=null){
                    st.add(root.right);
                }
                if(root.left!=null){
                    st.add(root.left);
                }
           
        }
    }
}
