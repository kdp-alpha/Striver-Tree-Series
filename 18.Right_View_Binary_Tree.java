class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> mq = new ArrayDeque<>();
        mq.add(root);
        
        while(mq.size()>0){
            int size = mq.size();
            ans.add(mq.peek().val);
            for(int i=0;i<size;i++){
                root = mq.remove();
                
                if(root.right!=null){
                    mq.add(root.right);
                }
                if(root.left!=null){
                    mq.add(root.left);
                }
            }
        }
        
        return ans;
        
    }
}
