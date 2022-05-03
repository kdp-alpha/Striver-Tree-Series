class Solution
{
    public void printLeaves(Node node,ArrayList<Integer> ans){
        if(node==null){
            return;
        }
        
        printLeaves(node.left,ans);
        
        if(node.left==null && node.right==null){
            ans.add(node.data);
        }
        printLeaves(node.right,ans);
    }
    
    
    public void printLeftBoundary(Node node,ArrayList<Integer> ans){
        if(node==null){
            return;
        }
        
        if(node.left!=null){
            ans.add(node.data);
            printLeftBoundary(node.left,ans);
        }
         else if (node.right != null) {
            ans.add(node.data);
            printLeftBoundary(node.right,ans);
        }
        
    }
    
    public void printRightBoundary(Node node,ArrayList<Integer> ans){
        if(node==null){
            return;
        }
        
        if(node.right!=null){
            printRightBoundary(node.right,ans);
            ans.add(node.data);
        }
        else if(node.left!=null){
            printRightBoundary(node.left,ans);
            ans.add(node.data);
        }
    }
    
    public void printBoundary(Node node,ArrayList<Integer> ans){
        if(node==null){
            return;
        }
        ans.add(node.data);
        
        printLeftBoundary(node.left,ans);
        
        printLeaves(node.left,ans); // left subtree leaves nodes
        
        printLeaves(node.right,ans); // right subtree leaves nodes
        
        printRightBoundary(node.right,ans); 
    }
    
	ArrayList <Integer> boundary(Node node)
	{
	    if(node==null){
	        return new ArrayList<>();
	    }
	    ArrayList<Integer> ans = new ArrayList<>();
	    printBoundary(node,ans);
	    return ans;
	}
}
