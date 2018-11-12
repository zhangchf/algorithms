

public class Test {
    public static void main(String[] args) {
        int[] in = new int[] {8, 10, 7, 6, 9, 3, 2};
        System.out.println("before sort: ");
        Utils.print(in);  

        new HeapSort().heapSort(in);

        System.out.println("after sort: ");
        Utils.print(in);
    }
}