public class BinaryTreeArray25 {
    int[] data;
    int idxLast;

    public BinaryTreeArray25(){
        data = new int[10];
        idxLast = -1;
    }

    public void populateData(int[] data, int idxLast){
        this.data = data;
        this.idxLast = idxLast;
    }

    public void traverseInOrder(int idxStart){
        if (idxStart <= idxLast) {
            traverseInOrder(2 * idxStart + 1);
            System.out.print(data[idxStart] + " ");
            traverseInOrder(2 * idxStart + 2);
        }
    }

    // Method untuk menambahkan data ke dalam tree
    public void add(int value) {
        if (idxLast >= data.length - 1) {
            System.out.println("Tree is full, can't add more elements.");
            return;
        }
        idxLast++;
        data[idxLast] = value;
    }

    // Method untuk pre-order traversal
    public void traversePreOrder(int idxStart) {
        if (idxStart <= idxLast) {
            System.out.print(data[idxStart] + " ");
            traversePreOrder(2 * idxStart + 1);
            traversePreOrder(2 * idxStart + 2);
        }
    }

    // Method untuk post-order traversal
    public void traversePostOrder(int idxStart) {
        if (idxStart <= idxLast) {
            traversePostOrder(2 * idxStart + 1);
            traversePostOrder(2 * idxStart + 2);
            System.out.print(data[idxStart] + " ");
        }
    }
}
