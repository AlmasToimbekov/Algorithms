package trees;
//Not finished yet (not balanced)
class RedBlack {

    static final int COUNT = 10;

    public static void main(String[] args) {
        RedBlack test = new RedBlack();

        Tree tree = new Tree(5);
        tree.insert(4);
        tree.insert(3);
        print2D(tree.root, tree);
    }

    static void print2DUtil(Node root, int space, Tree tree) {
        // Base case
        if (root.val == 0)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        print2DUtil(root.right, space, tree);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        String red = "r";
        if (root.isBlack)  red = "b";
        System.out.print(red + "-" + root.val + "\n");

        // Process left child
        print2DUtil(root.left, space, tree);
    }

    // Wrapper over print2DUtil()

    static void print2D(Node root, Tree tree) {
        // Pass initial space count as 0
        print2DUtil(root, 0, tree);
    }
}