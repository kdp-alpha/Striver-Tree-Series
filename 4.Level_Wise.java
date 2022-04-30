//bfs
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> mq = new ArrayDeque<>();
        List<List<Integer>> arr = new ArrayList<>();
        mq.add(root);
        
        while(mq.size()>0){
            int count = mq.size();
            List<Integer> ans = new ArrayList<>();
            for(int i=0;i<count;i++){
                root = mq.remove();
                ans.add(root.val);
                
                if(root.left!=null){
                    mq.add(root.left);
                }
                
                if(root.right!=null){
                    mq.add(root.right);
                }
             
                
            }
               arr.add(ans);
        }
        
        return arr;
        
    }
}
