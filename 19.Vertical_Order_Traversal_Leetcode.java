class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        class Pair implements Comparable<Pair> {
            TreeNode node;
            int h = 0;
            int v = 0;
            
            Pair(TreeNode node, int v, int h) {
                this.node = node;
                this.v = v;
                this.h = h;
            }
            
            public int compareTo(Pair other) {
                if(this.h == other.h) {
                    return this.node.val - other.node.val;
                } else {
                    return this.h - other.h;
                }
            }
        }
        
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(root, 0, 0));
        HashMap<Integer, PriorityQueue<Pair>> map = new HashMap<>();
        
        int lh = 0;
        int rh = 0;
        while(queue.size() > 0) {
            Pair rem = queue.remove();
            if(rem.v < lh) {
                lh = rem.v;
            }            
            
            if(rem.v > rh) {
                rh = rem.v;
            }
            
            if(map.containsKey(rem.v)) {
                map.get(rem.v).add(rem);
            } else {
                PriorityQueue<Pair> pq = new PriorityQueue<>();
                pq.add(rem);
                map.put(rem.v, pq);
            }
            
            if(rem.node.left != null) {
                queue.add(new Pair(rem.node.left, rem.v - 1, rem.h + 1));
            }
            
            if(rem.node.right != null) {
                queue.add(new Pair(rem.node.right, rem.v + 1, rem.h + 1));
            }
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for(int i = lh; i<=rh; i++) {
            List<Integer> list = new ArrayList<>();
            PriorityQueue<Pair> pq = map.get(i);
            
            while(pq.size() > 0) {
                Pair p = pq.remove();
                list.add(p.node.val);
            }
            
            res.add(list);
        }
        
        return res;
    }
}
