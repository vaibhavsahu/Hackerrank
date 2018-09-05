import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the insertionSort1 function below.
    static void insertionSort1(int n, int[] arr) {
        int sort = arr[arr.length - 1];
        
        int i = 0;
        
        for(i = arr.length - 2; (i >= 0) && (arr[i]) > sort; i--){
            arr[i+1] = arr[i];
            printArray(arr);
        }
        
        arr[i+1] = sort;
        printArray(arr);

    }
    
    static void printArray(int [] arr){
        for(int a: arr){
            System.out.print(a + " ");
        }
        System.out.println("");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        insertionSort1(n, arr);

        scanner.close();
    }
}
