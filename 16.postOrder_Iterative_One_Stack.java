class Tree
{
 
    ArrayList<Integer> postOrder(Node root)
    {
       // Your code goes here
       ArrayList<Integer> ans = new ArrayList<>();
       Node curr = root;
       Node temp = null;
       Stack<Node> st = new Stack<>();
       while(curr!=null || !st.isEmpty()){
            if(curr!=null){
                st.push(curr);
                curr = curr.left;
            }
            else{
               temp = st.peek().right;
              
               if(temp==null){
                   temp = st.pop();
                   ans.add(temp.data);
                   while(st.size()!=0 && temp== st.peek().right){
                       temp = st.pop();
                       ans.add(temp.data);
                       
                   }
               }
               else{
                   curr = temp;
               }
            }
       }
       
       return ans;
    }
}
