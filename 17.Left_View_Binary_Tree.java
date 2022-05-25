//Recursive
class Tree
{
    ArrayList<Integer> helper(boolean[] levels,Node root,int curr,ArrayList<Integer> ans){
        if(root==null){
            return new ArrayList<>();
        }
        
        if(levels[curr]==false){
            ans.add(root.data);
            levels[curr] = true;
        }
        
        helper(levels,root.left,curr+1,ans);
        helper(levels,root.right,curr+1,ans);
        
        return ans;
    }
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      boolean[] levels = new boolean[202];
      Arrays.fill(levels,false);
      int curr = 0;
      ArrayList<Integer> ans = new ArrayList<>();
      helper(levels,root,curr,ans);
      
      return ans;
    }
}

//Iterative
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        if(root==null){
            return new ArrayList<>();
        }
      // Your code here
      Queue<Node> mq = new ArrayDeque<>();
        mq.add(root);
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(mq.size()>0){
            int size = mq.size();
            ans.add(mq.peek().data);
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
        
        return ans;
    }
}
