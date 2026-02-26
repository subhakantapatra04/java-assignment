import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
    }
}

class BST {
    Node root;

    Node insert(Node r, int d) {
        if (r == null)
            return new Node(d);
        if (d < r.data)
            r.left = insert(r.left, d);
        else
            r.right = insert(r.right, d);
        return r;
    }

    void insert(int d) {
        root = insert(root, d);
    }

    boolean search(Node r, int d) {
        if (r == null)
            return false;
        if (r.data == d)
            return true;
        if (d < r.data)
            return search(r.left, d);
        return search(r.right, d);
    }

    void inorder(Node r) {
        if (r != null) {
            inorder(r.left);
            System.out.print(r.data + " ");
            inorder(r.right);
        }
    }

    void preorder(Node r) {
        if (r != null) {
            System.out.print(r.data + " ");
            preorder(r.left);
            preorder(r.right);
        }
    }

    void postorder(Node r) {
        if (r != null) {
            postorder(r.left);
            postorder(r.right);
            System.out.print(r.data + " ");
        }
    }
}

public class BinarySearchTree {
    public static void main(String[] args) {

        BST b = new BST();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1 Insert");
            System.out.println("2 Search");
            System.out.println("3 Inorder");
            System.out.println("4 Preorder");
            System.out.println("5 Postorder");
            System.out.println("6 Exit");

            int ch = sc.nextInt();

            if (ch == 1) {
                System.out.print("Value: ");
                int v = sc.nextInt();
                b.insert(v);

            } else if (ch == 2) {
                System.out.print("Search: ");
                int v = sc.nextInt();
                System.out.println(b.search(b.root, v));

            } else if (ch == 3) {
                b.inorder(b.root);
                System.out.println();

            } else if (ch == 4) {
                b.preorder(b.root);
                System.out.println();

            } else if (ch == 5) {
                b.postorder(b.root);
                System.out.println();

            } else if (ch == 6) {
                break;
            }
        }
    }
}
