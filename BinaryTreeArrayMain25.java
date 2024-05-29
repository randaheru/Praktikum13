public class BinaryTreeArrayMain25 {
    public static void main(String[] args) {
        BinaryTreeArray25 bta = new BinaryTreeArray25();
        
        // Contoh data untuk pengujian
        int[] sampleData = {3, 5, 7, 9, 11, 13, 15};
        bta.populateData(sampleData, sampleData.length - 1);

        System.out.print("In-order traversal: ");
        bta.traverseInOrder(0);
        System.out.println();

        System.out.print("Pre-order traversal: ");
        bta.traversePreOrder(0);
        System.out.println();

        System.out.print("Post-order traversal: ");
        bta.traversePostOrder(0);
        System.out.println();

        // Menambahkan elemen baru
        bta.add(17);
        bta.add(19);

        System.out.print("In-order traversal after adding elements: ");
        bta.traverseInOrder(0);
        System.out.println();
    }
}
