class Solution {
    int maxi = Integer.MIN_VALUE;
    public int maxPath(TreeNode node){
        if(node==null) return 0;
        int left = Math.max(0, maxPath(node.left));
        int right = Math.max(0, maxPath(node.right));
        
        maxi = Math.max(maxi, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
    
    
    
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        
        maxPath(root);
        return maxi;
        
    }
}
