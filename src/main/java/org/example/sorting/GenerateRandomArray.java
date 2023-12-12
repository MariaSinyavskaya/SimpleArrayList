package org.example.sorting;
import java.util.Random;

public class GenerateRandomArray {
    public static Integer[] generateRandomArray() {
        Random random = new Random();
        Integer[] arr = new Integer[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10) + 100_000;
        }
        return arr;
    }
}
