//recursive
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        
        return 1 + Math.max(lh,rh);
    }
}

//bfs
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> mq = new ArrayDeque<>();
        mq.add(root);
        int depth = 0;
        while(mq.size()>0){
            int size = mq.size();
            depth++;
            for(int i=0;i<size;i++){
                root = mq.remove();
                
                if(root.left!=null){
                    mq.add(root.left);
                }
                if(root.right!=null){
                    mq.add(root.right);
                }
            }
            
        }
        
        return depth;
        
    }
}
