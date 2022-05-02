//Diameter = longest path between any two nodes
//path does not need to pass via root
class Solution {
    int max = 0;
    public int findDia(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh = findDia(root.left);
        int rh = findDia(root.right);
        max = Math.max(max,lh+rh);
        
        return 1 + Math.max(lh,rh);
    }
    
    
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
      
        findDia(root);
        return max;
    }
}
