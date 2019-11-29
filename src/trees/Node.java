package trees;

public class Node {
    Node left;
    Node right;
    Node parent;
    int val;
    boolean isBlack;

    private Node() {}

    Node(int val) {
        this();
        this.val = val;
    }
}
