package trees;

public class Tree {
    Node root;
    private final Node nil;

    private Tree() {
        nil = new Node(0);
        nil.isBlack = true;
    }

    Tree(int val) {
        this();
        root = new Node(val);
        root.left = nil;
        root.right = nil;
        root.parent = nil;
        root.isBlack = true;
    }

    void insert(int val) {
        insert(new Node(val));
    }

    void insert(Node node) {
        Node temp = root;
        Node parent = root;
        while (temp != nil) {
            parent = temp;
            if (node.val < temp.val) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        if (node.val < parent.val) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        node.parent = parent;
        node.left = nil;
        node.right = nil;
        insertFixup(node);
    }

    void insertFixup(Node fix) {
        while (!fix.parent.isBlack) {
            if (fix.parent.parent.left == fix.parent) {
                Node uncle = fix.parent.parent.right;
                if (!uncle.isBlack) {
                    fix.parent.isBlack = true;
                    uncle.isBlack = true;
                    fix.parent.parent.isBlack = false;
                    fix = fix.parent.parent;
                } else {
                    if (fix == fix.parent.right) {
                        fix = fix.parent;
                        rotateLeft(fix);
                    }
                    fix.parent.isBlack = true;
                    fix.parent.parent.isBlack = false;
                    rotateRight(fix.parent.parent);
                }
            } else {
                Node uncle = fix.parent.parent.left;
                if (!uncle.isBlack) {
                    fix.parent.isBlack = true;
                    uncle.isBlack = true;
                    fix.parent.parent.isBlack = false;
                    fix = fix.parent.parent;
                } else {
                    if (fix == fix.parent.left) {
                        fix = fix.parent;
                        rotateRight(fix);
                    }
                    fix.parent.isBlack = true;
                    fix.parent.parent.isBlack = false;
                    rotateLeft(fix.parent.parent);
                }
            }
//            test.print2D(root, this);
        }
        root.isBlack = true;
    }

    void rotateLeft(Node fix) {
        Node right = fix.right;
        fix.right = right.left;
        if (right.left != nil)
            right.left.parent = fix;

        right.parent = fix.parent;
        if (fix.parent == nil) {
            root = right;
        } else if (fix.parent.left == fix) {
            fix.parent.left = right;
        } else {
            fix.parent.right = right;
        }
        right.left = fix;
        fix.parent = right;
    }

    void rotateRight(Node fix) {
        Node left = fix.left;
        fix.left = left.right;
        if (left.right != nil)
            left.right.parent = fix;

        left.parent = fix.parent;
        if (fix.parent == nil) {
            root = left;
        } else if (fix.parent.left == fix) {
            fix.parent.left = left;
        } else {
            fix.parent.right = left;
        }
        left.right = fix;
        fix.parent = left;
    }
}
