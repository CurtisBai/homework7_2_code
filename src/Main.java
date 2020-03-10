
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        // left empty

        MaxHeap heap = new MaxHeap(10);

        long start, end;
        Random rand = new Random(1);

        int step = 1000000;
        for (int testSize = step; testSize < step * 11; testSize += step) {
            // create test data
            ArrayList<Integer> lst = new ArrayList<>();
            for (int i = 0; i < testSize; i++) {
                int rd = rand.nextInt(testSize);
                lst.add(rd);
            }
            Integer[] arr;

            // (1) test 1st method
            arr = lst.toArray(new Integer[lst.size()]);
            start = System.currentTimeMillis();
            heap.MaxHeapLogN(arr);
            end = System.currentTimeMillis();
            // calculate time and display
            System.out.print(end - start);
            System.out.print(" ");
            
            // (2) test 2nd method
            arr = lst.toArray(new Integer[lst.size()]);
            start = System.currentTimeMillis();
            heap.MaxHeapN(arr);
            end = System.currentTimeMillis();            
            // calculate time and display
            System.out.print(end - start);
            System.out.println("");
        }

    }

}
