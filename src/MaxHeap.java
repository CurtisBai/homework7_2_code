
public class MaxHeap implements Heap {

    int capacity;
    int size;
    Integer[] data;

    public MaxHeap(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        data = new Integer[capacity];
    }

    /**
     * adjust the data down
     *
     * @param data
     * @param i
     * @param n index of last element
     */
    static void HeapAdjustDown(Integer[] data, int i, int n) {

        int num = data[i];
        int son = i * 2 + 1;
        while (son <= n) {
            if (son + 1 <= n && data[son + 1] > data[son]) {
                son++;
            }
            if (num > data[son]) {
                break;
            }
            data[i] = data[son];
            i = son;
            son = i * 2 + 1;
        }
        data[i] = num;
    }

    /**
     * adjust the data up
     *
     * @param data
     * @param n index of last element
     */
    public static void HeapAdjustUp(Integer[] data, int n) {

        int num = data[n];
        int father = (n - 1) / 2;

        while (data[father] < num && n != 0) {
            data[n] = data[father];
            n = father;
            father = (n - 1) / 2;
        }
        data[n] = num;

    }

    // build a heap based on data
    // to be implemented in O(nlogn)
    public void MaxHeapLogN(Integer[] data) {
        // homework
        MaxHeap heap = new MaxHeap(data.length + 1);
        for (Integer i : data) {
            heap.add(i);
        }
        for (int i = 0; i < data.length; i++) {
            data[i] = heap.data[i];
        }
    }

    // build a heap based on data
    // to be implemented in O(n)
    public void MaxHeapN(Integer[] data) {
        int n = data.length - 1;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            HeapAdjustDown(data, i, n);
        }
    }

    // add an item to the heap
    public boolean add(Integer item) {
        // homework
        if(size>=capacity){
            return false;
        }
        this.data[size++] = item;
        HeapAdjustUp(data, size - 1);
        return true;
    }

    // return the max item in the heap
    public Integer get() {
        // homework
        Integer i = null;
        if (size > 0) {
            i = data[0];
        }

        return i;
    }

    // remove the root item
    public Integer pop() {
        // homework
        Integer i = null;
        if (size > 0) {
            i = data[0];

            data[0] = data[size - 1];
            HeapAdjustDown(data, 0, size - 2);
            size--;
        }

        return i;
    }

}
