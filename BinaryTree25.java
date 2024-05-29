class Node25 {
    int data;
    Node25 left, right;

    public Node25(int item) {
        data = item;
        left = right = null;
    }
}

public class BinaryTree25 {
    Node25 root;

    public BinaryTree25() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void add(int data) {
        if (isEmpty()) { // tree is empty
            root = new Node25(data);
        } else {
            Node25 current = root;
            while (true) {
                if (data < current.data) {
                    if (current.left == null) {
                        current.left = new Node25(data);
                        break;
                    } else {
                        current = current.left;
                    }
                } else if (data > current.data) {
                    if (current.right == null) {
                        current.right = new Node25(data);
                        break;
                    } else {
                        current = current.right;
                    }
                } else { // data already exists
                    break;
                }
            }
        }
    }

    public boolean find(int data) {
        boolean result = false;
        Node25 current = root;
        while (current != null) {
            if (current.data == data) {
                result = true;
                break;
            } else if (data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return result;
    }

    public void traversePreOrder(Node25 node) {
        if (node != null) {
            System.out.print(" " + node.data);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traversePostOrder(Node25 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.data);
        }
    }

    public void traverseInOrder(Node25 node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.data);
            traverseInOrder(node.right);
        }
    }

    public Node25 getSuccessor(Node25 del) {
        Node25 successor = del.right;
        Node25 successorParent = del;
        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }
        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }

    public void delete(int data) {
        if (isEmpty()) {
            System.out.println("Tree is empty!");
            return;
        }

        Node25 parent = root;
        Node25 current = root;
        boolean isLeftChild = false;
        while (current != null) {
            if (current.data == data) {
                break;
            } else if (data < current.data) {
                parent = current;
                current = current.left;
                isLeftChild = true;
            } else {
                parent = current;
                current = current.right;
                isLeftChild = false;
            }
        }

        if (current == null) {
            System.out.println("Couldn't find data!");
            return;
        }

        // Case 1: No children
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        // Case 2: One child (left)
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        }
        // Case 2: One child (right)
        else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        }
        // Case 3: Two children
        else {
            Node25 successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
    }

    // Method untuk menambahkan node secara rekursif
    private Node25 addRecursive(Node25 current, int data) {
        if (current == null) {
            return new Node25(data);
        }

        if (data < current.data) {
            current.left = addRecursive(current.left, data);
        } else if (data > current.data) {
            current.right = addRecursive(current.right, data);
        }

        return current;
    }

    public void addRecursive(int data) {
        root = addRecursive(root, data);
    }

    // Method untuk menampilkan nilai paling kecil dalam tree
    public int findMin() {
        if (isEmpty()) {
            System.out.println("Tree is empty!");
            return Integer.MIN_VALUE; // Return the smallest integer value if the tree is empty
        }

        Node25 current = root;
        while (current.left != null) {
            current = current.left;
        }

        return current.data;
    }

    // Method untuk menampilkan nilai paling besar dalam tree
    public int findMax() {
        if (isEmpty()) {
            System.out.println("Tree is empty!");
            return Integer.MAX_VALUE; // Return the largest integer value if the tree is empty
        }

        Node25 current = root;
        while (current.right != null) {
            current = current.right;
        }

        return current.data;
    }

    // Method untuk menampilkan data yang ada di leaf
    public void displayLeafNodes(Node25 node) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            System.out.print(node.data + " ");
        }

        displayLeafNodes(node.left);
        displayLeafNodes(node.right);
    }

    // Method untuk menghitung jumlah leaf yang ada di dalam tree
    public int countLeafNodes(Node25 node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        return countLeafNodes(node.left) + countLeafNodes(node.right);
    }

}