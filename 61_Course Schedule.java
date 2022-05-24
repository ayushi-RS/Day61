public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> graph = new ArrayList<>();
        int[] visited = new int[2001];
        
        for(int i = 0;  i < numCourses;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge: prerequisites){
            graph.get(edge[0]).add(edge[1]);
        }
        
        for(int i = 0 ; i < numCourses ; i++){
            if(visited[i] == 0){
                if(isCyclic(i, graph, visited)){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean isCyclic(int u, List<List<Integer>> graph, int[] visited){
        visited[u] = 1;
        
        for(int v : graph.get(u)){
            if(visited[v] == 0){
                if(isCyclic(v, graph, visited)){
                    return true;
                }
            }else if(visited[v]==1){
                return true;
            }
        }
        
        visited[u] = 2;
        
        return false;
    }