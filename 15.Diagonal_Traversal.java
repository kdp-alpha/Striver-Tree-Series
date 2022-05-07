class Tree
{
     public ArrayList<Integer> diagonal(Node root)
      {
           //add your code here.
           if(root==null){
               return new ArrayList<>();
           }
           Queue<Node> mq = new ArrayDeque<>();
           mq.add(root);
            ArrayList<Integer> list = new ArrayList<>();
           while(mq.size()>0){
               int size = mq.size();
             
               while(size-->0){
                   Node rm = mq.remove();
                   while(rm!=null){
                       list.add(rm.data);
                       if(rm.left!=null){
                           mq.add(rm.left);
                       }
                       
                       rm = rm.right;
                   }
               }
           }
           
           return list;
      }
}
