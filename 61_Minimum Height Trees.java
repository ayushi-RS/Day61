class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Set<Integer>[] adj = new HashSet[n];
        
        if(n < 2){
            ArrayList<Integer> centroids = new ArrayList<>();
            for (int i = 0; i < n; i++)
                centroids.add(i);
            return centroids;
        }
        
        for(int i = 0; i < n; i++){
            adj[i] = new HashSet<>();
        }
        
        for(int i = 0; i < edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            
            adj[a].add(b);
            adj[b].add(a);
        }
        
        ArrayList<Integer> leaves = new ArrayList<>();
        
        for(int i = 0; i < adj.length; i++){
            if(adj[i].size() == 1) leaves.add(i);
        }
        
        while(n > 2){
            n -= leaves.size();
            
            ArrayList<Integer> newLeaves = new ArrayList<>();
            
            for(Integer leaf : leaves){
                for(Integer root : adj[leaf]){
                    adj[root].remove(leaf);
                    adj[leaf].remove(root);
                    
                    if(adj[root].size() == 1) newLeaves.add(root);
                }
            }
            
            leaves = newLeaves; 
        }
        
        return leaves;
    }
}