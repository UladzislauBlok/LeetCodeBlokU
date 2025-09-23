package org.ubdev.task.graph.medium;

import org.ubdev.domain.Node;

import java.util.HashMap;
import java.util.Map;

class CloneGraph {

    private final Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        if (map.containsKey(node.val))
            return map.get(node.val);
        Node copy = new Node(node.val);
        map.put(node.val, copy);
        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(cloneGraph(neighbor));
        }
        return copy;
    }
}
