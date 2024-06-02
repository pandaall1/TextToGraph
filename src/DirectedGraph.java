import java.util.*;

class DirectedGraph {
    Map<String, Node> nodes;

    public DirectedGraph() {
        this.nodes = new HashMap<>();
    }

    public void addEdge(String source, String destination) {
        Node sourceNode = nodes.computeIfAbsent(source, Node::new);
        Node destinationNode = nodes.computeIfAbsent(destination, Node::new);
        sourceNode.addNeighbor(destinationNode);
    }

    public void printGraph() {
        for (Node node : nodes.values()) {
            System.out.print(node.getName() + " -> ");
            for (Node neighbor : node.getNeighbors()) {
                System.out.print(neighbor.getName() + ", ");
            }
            System.out.println();
        }
    }

    public List<String> getBridgeWords(String source, String destination) {
        List<String> bridgeWords = new ArrayList<>();
        Node sourceNode = nodes.get(source);
        Node destinationNode = nodes.get(destination);

        if (sourceNode != null && destinationNode != null) {
            List<Node> commonNeighbors = new ArrayList<>(sourceNode.getNeighbors());
            commonNeighbors.retainAll(destinationNode.getNeighbors());

            for (Node commonNeighbor : commonNeighbors) {
                bridgeWords.add(commonNeighbor.getName());
            }
        }

        return bridgeWords;
    }
    public String generateDOT() {
        StringBuilder dotBuilder = new StringBuilder();
        dotBuilder.append("digraph G {\n");
        for (Node node : nodes.values()) {
            for (Node neighbor : node.getNeighbors()) {
                dotBuilder.append("\t\"").append(node.getName()).append("\" -> \"").append(neighbor.getName()).append("\";\n");
            }
        }
        dotBuilder.append("}");
        return dotBuilder.toString();
    }
    public List<String> getAllNodes() {
        return new ArrayList<>(nodes.keySet());
    }
    public Node getNode(String name) {
        return nodes.get(name);
    }
}
