import java.util.ArrayList;
import java.util.List;

class Node {
    String name;
    List<Node> neighbors;

    public Node(String name) {
        this.name = name;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(Node neighbor) {
        this.neighbors.add(neighbor);
    }

    public String getName() {
        return name;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }
}
