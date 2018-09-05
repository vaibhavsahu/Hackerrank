import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the missingNumbers function below.
    static int[] missingNumbers(int[] arr, int[] brr) {
        Map<Integer, Integer> mapArr = new HashMap<>();
        Map<Integer, Integer> mapBrr = new HashMap<>();
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++){
            if(mapArr.containsKey(arr[i])){
                mapArr.put(arr[i], mapArr.get(arr[i])+1);
            }else{
                mapArr.put(arr[i], 1);
            }
        }
        
        for(int i = 0; i < brr.length; i++){
            if(mapBrr.containsKey(brr[i])){
                mapBrr.put(brr[i], mapBrr.get(brr[i])+1);
            }else{
                mapBrr.put(brr[i], 1);
            }
        }
        
        for(Map.Entry<Integer, Integer> entry: mapBrr.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if(!mapArr.containsKey(key) || mapArr.get(key) != value){
                list.add(key);
            }

        }
        
        int [] array = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            array[i] = list.get(i);
        }
        
        return array;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] brr = new int[m];

        String[] brrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrItems[i]);
            brr[i] = brrItem;
        }

        int[] result = missingNumbers(arr, brr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
