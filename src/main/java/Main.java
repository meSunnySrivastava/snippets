public class Main {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }

    static class KthLargest {
        private int[] arr;
        private int size, maxSize; // we need size to keep track of current heap size. and max to initialize array.

        public KthLargest(int k, int[] nums) {
            maxSize = k;
            size = 0;
            arr = new int[k];

            for (int each : nums) {
                add(each);
            }
        }

        public int add(int element) {
            if ((size < maxSize - 1) || (arr[size] < element)) {
                int current = size;
                if (size <  maxSize - 1)
                    arr[size++] = element;
                else
                    arr[size] = element;

                while (arr[current] > arr[parent(current)]) {
                    swap(current, parent(current));
                    current = parent(current);
                }
            }
            return arr[maxSize - 1] > arr[maxSize - 2] ? arr[maxSize - 2] : arr[maxSize - 1];
        }

        private void swap(int from, int to){
            int tmp = arr[from];
            arr[from] = arr[to];
            arr[to] = tmp;
        }

        private int parent(int index) {
            return (index - 1) / 2;
        }
    }
/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

}
