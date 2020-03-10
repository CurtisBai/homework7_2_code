
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxHeapTest {
    // homework

    @Test
    public void totalTest() {
        // create a empty heap
        MaxHeap heap = new MaxHeap(1000);

        // test size
        int testSize = 600;
        Random rand = new Random(1);

        // create 600 random number
        ArrayList<Integer> lst = new ArrayList<>();
        for (int i = 0; i < testSize; i++) {
            int rd = rand.nextInt(100);

            // insert into list
            lst.add(rd);

            // Test 1: insert into heap
            heap.add(rd);
        }

        // sort the data in lst in reverse order
        Collections.sort(lst);
        Collections.reverse(lst);

        for (int i = 0; i < testSize; i++) {

            // Test 2: test for get method
            int data = heap.get();
            assertTrue(data == lst.get(i));

            // Test 3: test for pop method
            data = heap.pop();
            assertTrue(data == lst.get(i));
        }

        Integer[] arr;

        // Test 4: test for MaxHeapLogN
        // move the element from lst to array
        arr = lst.toArray(new Integer[lst.size()]);
        heap.MaxHeapLogN(arr);
        assertTrue(heapCheck(arr));

        // Test 5:  test for MaxHeapN
        arr = lst.toArray(new Integer[lst.size()]);
        heap.MaxHeapN(arr);
        assertTrue(heapCheck(arr));

    }

    /**
     * check whether a heap is valid
     *
     * @param arr
     * @return
     */
    private static boolean heapCheck(Integer[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (2 * i + 2 < arr.length) {
                if (arr[i] < arr[2 * i + 1] || arr[i] < arr[2 * i + 2]) {
                    return false;
                }
            }
        }
        return true;
    }

}
