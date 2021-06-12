
import java.util.LinkedList;
import java.util.Queue;

public class Methods {

    public static Node pre = null, suc = null;

    //inorder & postorder & preorder -------------------------------------------
    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.getLeftChild());
            System.out.print(root.getData() + " ");
            inorder(root.getRightChild());
        }
    }

    public static void postorder_test(Node root) {
        if (root == null) {
            return;
        }

        postorder_test(root.getLeftChild());

        postorder_test(root.getRightChild());

        System.out.print(root.getData() + " ");
    }

    public static void preorder_test(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.getData() + " ");

        preorder_test(node.getLeftChild());

        preorder_test(node.getRightChild());
    }

    public static void preorder(Node root) {
        preorder_test(root);
    }

    public static void postorder(Node root) {
        postorder_test(root);
    }

    //print (Tree Size )--------------------------------------------------------
    public static int size(Node root) {
        return calcsize(root);
    }

    public static int calcsize(Node node) {
        if (node == null) {
            return 0;
        } else {
            return (size(node.getLeftChild()) + 1 + size(node.getRightChild()));
        }
    }

    //print (Tree height)-------------------------------------------------------
    public static int height(Node node) {
        if (node == null) {
            return 0;
        } else {

            int lDepth = height(node.getLeftChild());
            int rDepth = height(node.getRightChild());

            if (lDepth > rDepth) {
                return (lDepth + 1);
            } else {
                return (rDepth + 1);
            }
        }
    }

    //print (Tree using BFS Traversal)------------------------------------------
    public static void BFS(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root == null) {
            return;
        }
        q.add(root);
        while (!q.isEmpty()) {
            Node n = (Node) q.remove();
            System.out.print(" " + n.getData());
            if (n.getLeftChild() != null) {
                q.add(n.getLeftChild());
            }
            if (n.getRightChild() != null) {
                q.add(n.getRightChild());
            }
        }
    }

    //Search Test --------------------------------------------------------------
    public static Node testsearch(String x, Node n) {
        if (n == null || (n.getData() == null ? x == null : n.getData().equals(x))) {
            return n;
        } else if (n.getData().length() > x.length()) {
            return testsearch(x, n.getLeftChild());
        } else {
            return testsearch(x, n.getRightChild());
        }
    }

    public static boolean search_test(String x, Node n) {
        Node node = testsearch(x, n);

        return null == node;
    }

    public static Node printLastNode(String x, Node n) {

        if (n == null) {
            return n;
        } else if (n.getData().length() > x.length()) {
            if (n.getLeftChild() == null) {
                System.out.println("The word in the leaf node i reached :" + n.getData());
                return null;
            }
            return printLastNode(x, n.getLeftChild());
        } else {
            if (n.getRightChild() == null) {
                System.out.println("The word in the leaf node i reached is :" + n.getData());
                return null;
            }
            return printLastNode(x, n.getRightChild());
        }

    }

    public static void PreSuc(Node root, String key) {
        if (root == null) {
            return;
        }
        if (root.getData() == key) {

            if (root.getLeftChild() != null) {
                Node tmp = root.getLeftChild();
                while (tmp.getRightChild() != null) {
                    tmp = tmp.getRightChild();
                }
                pre = tmp;
            }

            if (root.getRightChild() != null) {
                Node tmp = root.getRightChild();
                while (tmp.getLeftChild() != null) {
                    tmp = tmp.getLeftChild();
                }
                suc = tmp;
            }
            return;

        }
        if (root.getData().length() > key.length()) {
            suc = root;
            PreSuc(root.getLeftChild(), key);
        } else {
            pre = root;
            PreSuc(root.getRightChild(), key);
        }

    }

    public static void printPreSuc(Node root, String word) {

        PreSuc(root, word);
        if (pre != null) {
            System.out.println("Predecessor is " + pre.getData());
        } else {
            System.out.println("No Predecessor");
        }

        if (suc != null) {

            System.out.println("Successor is " + suc.getData());
        } else {

            System.out.println("No Successor");
        }

        pre = null;
        suc = null;
    }

    //Insert Method -------------------------------------------------------------
    public static Node insert(Node root, String key) {

        if (root == null) {
            return new Node(key);
        } else if (key.length() > root.getData().length()) {
            root.setRightChild(insert(root.getRightChild(), key));
        } else {
            root.setLeftChild(insert(root.getLeftChild(), key));
        }
        return root;
    }
}
