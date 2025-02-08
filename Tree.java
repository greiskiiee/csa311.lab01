
import java.util.Scanner;

class Node {

    int data;
    Node left;
    Node right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Tree {

    private Node root;

    public Tree() {
        root = null;
    }

    //shine node tree-d hiine
    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    //inOrder daraallaar hewlene
    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(" " + root.data);
            inOrderRec(root.right);
        }
    }

    //preOrder daraallaar hewleh
    public void preOrder() {
        preOrderRec(root);
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(" " + root.data);
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    //key eer haij delete hiih
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {

        if (root == null) {
            return root;
        }

        if (key < root.data) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.data) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = minValue(root.right);

            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    //hamgiin baga utgiig oloh
    private int minValue(Node root) {
        int min = root.data;

        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }

        return min;
    }

    //hamgiin ih utga oloh
    private int maxValue(Node root) {
        int max = root.data;

        while (root.right != null) {
            max = root.right.data;
            root = root.right;
        }

        return max;
    }

    public boolean findVal(int key) {
        return findValRec(root, key);
    }

    private boolean findValRec(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        } else if (key < root.data) {
            return findValRec(root.left, key);
        } else {
            return findValRec(root.right, key);
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the size of the tree: ");
            int size = sc.nextInt();

            System.out.println("Enter node(s): ");

            int i;
            for (i = 0; i < size; i++) {
                int el = sc.nextInt();
                tree.insert(el);
            }

            boolean ch = true;

            while (ch) {
                System.out.println("\n1. Insert an element");
                System.out.println("2. Delete and element");
                System.out.println("3. Min value");
                System.out.println("4. Max value");
                System.out.println("5. Find an element");
                System.out.println("6. In-order traversal");
                System.out.println("7. Pre-order traversal");
                System.out.println("8. Exit");
                System.out.println("Your choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.println("Enter an element: ");
                        int add = sc.nextInt();
                        tree.insert(add);
                    }
                    case 2 -> {
                        System.out.println("Enter an element to delete: ");
                        int delete = sc.nextInt();
                        if (!tree.findVal(delete)) {
                            System.out.println("Element did not found in a treee!");
                        } else {
                            tree.delete(delete);
                            System.out.println("Element deleted. ");
                        }
                    }
                    case 3 ->
                        System.out.println("\nMin value: " + tree.minValue(tree.root));
                    case 4 ->
                        System.out.println("Max value: " + tree.maxValue(tree.root));
                    case 5 -> {
                        System.out.println("\nEnter an element to find: ");
                        int search = sc.nextInt();
                        System.out.println("Element found: " + tree.findVal(search));
                    }
                    case 6 -> {
                        System.out.println("In order printing: ");
                        tree.inOrder();
                    }
                    case 7 -> {
                        System.out.println("\nPre order printing: ");
                        tree.preOrder();
                    }
                    case 8 -> {
                        System.out.println("Programm ended.");
                        ch = false;
                    }
                    default ->
                        System.out.println("Invalid choice !");
                }
            }
        }

    }

}
