class Solution {
    Map<Integer, Node> nodeMap = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        if(nodeMap.containsKey(node.val)){
            return nodeMap.get(node.val);
        }
        Node root = new Node(node.val);
        nodeMap.put(node.val,root);
        for(Node neighbor : node.neighbors){
            root.neighbors.add(cloneGraph(neighbor));
        }
        return root;
    }
}