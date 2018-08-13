public class QS {

    public void qs(int[] in, int head, int tail) {
        if (head >= tail) return;

        int start = head, end = tail, pivot = tail;

        System.out.println("start/pivot/end:" + start + pivot + end);
        while(start < end) {
            for (; start < pivot; start++) {
                if (in[start] > in[pivot]) {
                    Utils.swap(in, start, pivot);
                    pivot = start;
                    break;
                }
            }
            for (; end > pivot; end--) {
                if (in[end] < in[pivot]) {
                    Utils.swap(in, end, pivot);
                    pivot = end;
                    break;
                }
            }

            System.out.println("start/pivot/end:" + start + pivot + end);
        }


        qs(in, head, pivot - 1);
        qs(in, pivot + 1, tail);
    }

}