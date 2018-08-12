public class HeapSort {

    public void heapSort(int[] arr) {
        buildHeap(arr);
        Utils.print(arr, "after build heap: ");
        int end = arr.length - 1;
        while (0 < end) {
            Utils.swap(arr, 0, end);
            end--;
            siftDown(arr, 0, end);
            Utils.print(arr, "after each run: " + end);
        }
    }

    public void buildHeap(int[] arr) {
        int end = arr.length - 1;
        int p = (end - 1) / 2;
        while (p >= 0) {
            System.out.println("buildHeap, iterate: " + p);
            siftDown(arr, p, end);
            p--;
        }
    }

    public void siftDown(int[] arr, int start, int end) {
        int p = start;
        while (true) {
            System.out.println("siftDown, iterate: " + p);
            int c1 = p * 2 + 1;
            int c2 = p * 2 + 2;
            if (c1 > end) {
                break;
            }
            if (c2 <= end) {
                if (arr[c2] > arr[c1] && arr[c2] > arr[p]) {
                    Utils.swap(arr, c2, p);
                    p = c2;
                    continue;
                }
            }
            if (arr[c1] > arr[p]) {
                Utils.swap(arr, c1, p);
                p = c1;
                continue;
            }
            break;
        }
    }

}