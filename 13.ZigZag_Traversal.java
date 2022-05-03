class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> mq = new ArrayDeque<>();
        mq.add(root);
        //first fill the arraylist level wise
        //first test case
        //3
        //9 20
        //15 7
      
        while(mq.size()>0){
            int size = mq.size();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++){
                root = mq.remove();
                list.add(root.val);
                if(root.left!=null){
                    mq.add(root.left);
                }
                if(root.right!=null){
                    mq.add(root.right);
                }
            }
            ans.add(list);
        }
        
        for(int i=0;i<ans.size();i++){
            if(i%2!=0){ //travel left to right
                List<Integer> arr = ans.remove(i);
                Collections.reverse(arr);
                ans.add(i,arr); // add at particular index
                
                
            }else{
                //do nothing when index is even
            }
        }
        
        return ans;
    }
}
