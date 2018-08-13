public class MS {
    public void ms(int[] arr, int low, int high) {
        int[] arrT = Utils.copy(arr);
        ms(arrT, low, high, arr);
    }

    public void ms(int[] arrA, int low, int high, int[] arrB) {
        if (low < high) {
            int mid = (low + high) / 2;
            ms(arrB, low, mid, arrA);
            ms(arrB, mid+1, high, arrA);
            merge(arrA, low, mid, high, arrB);
        }
    }

    public void merge(int[] arrA, int low, int mid, int high, int[] arrB) {
        System.out.println("merge: low/mid/high=" + low + mid + high);
        System.out.print("before:");
        Utils.print(arrA, low, high);
        int i = low, j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (arrA[i] <= arrA[j]) {
                arrB[k] = arrA[i];
                i++;
            } else {
                arrB[k] = arrA[j];
                j++;
            }
            k++; 
        }
        while (i <= mid) {
            arrB[k++] = arrA[i++];
        }
        while (j <= high) {
            arrB[k++] = arrA[j++];
        }

        // for (int l = low; l <= high; l++) {
        //     arrA[l] = arrB[l];
        // }

        System.out.print("after:");
        Utils.print(arrB, low, high);
    }
}