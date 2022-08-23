//Construct Binary Tree from Preorder and Inorder Traversal

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n= preorder.length;
        return helper(preorder,0,n-1,inorder,0,n-1);
    }
    
    public TreeNode helper(int[] preorder,int psi,int pei,int[] inorder,int isi,int iei){
        if (psi > pei)
            return null;

        

        int idx = isi;
        while (inorder[idx] != preorder[psi])
            idx++;

        int tnel = idx - isi; // total no of elements.
        TreeNode node = new TreeNode(preorder[psi]);
        node.left = helper(preorder, psi + 1, psi + tnel, inorder, isi, idx - 1);
        node.right = helper(preorder, psi + tnel + 1, pei, inorder, idx + 1, iei);

        return node;
        
    }
}
