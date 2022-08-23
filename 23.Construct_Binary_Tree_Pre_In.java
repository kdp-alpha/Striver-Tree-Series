class Solution {
public TreeNode buildTree(int[] inorder,int[] postorder) {
        int n= postorder.length;
        return helper(postorder,0,n-1,inorder,0,n-1);
    }
    
    public TreeNode helper(int[] postorder,int psi,int pei,int[] inorder,int isi,int iei){
        if (psi > pei)
            return null;

        

        int idx = isi;
        while (inorder[idx] != postorder[pei])
            idx++;

        int tnel = idx - isi; // total no of elements.
        TreeNode node = new TreeNode(postorder[pei]);
        node.left = helper(postorder, psi, psi + tnel - 1, inorder, isi, idx - 1);
        node.right = helper(postorder, psi + tnel, pei - 1, inorder, idx + 1, iei);

        return node;
        
    }
}
