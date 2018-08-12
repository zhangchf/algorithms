

public class Utils {
    public static void print(int[] arr, int low, int high) {
        StringBuilder sb = new StringBuilder();
        for (int i = low; i <= high; i++) {
            sb.append(" " + arr[i]);
        }
        System.out.println(sb.toString());
    }

    public static void print(int[] arr) {
        print(arr, 0, arr.length - 1);
    }

    public static void print(int[] arr, String msg) {
        System.out.println(msg);
        print(arr);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}