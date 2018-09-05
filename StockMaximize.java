import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    
    public static int maxInArray(int [] arr, int index){
        
        int max = 0;
        if(index+1 != arr.length){
            //System.out.println(index);
            for(int i = index+1; i < arr.length; i++){
            if(max <= arr[i]){
                max = arr[i];
            }
        }
            return max;
        }
        
     return max; 
    }
    
    // Complete the stockmax function below.
    static int stockmax(int[] prices) {
    int gain = 0;
        for(int i = 0; i < prices.length; i++){
            int current = prices[i];
            
            int maxRight = maxInArray(prices, i);
            
            if(current < maxRight){
                gain += maxRight - current;
            }
        }
        return gain;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] prices = new int[n];

            String[] pricesItems = scanner.nextLine().split(" ");
            int len = pricesItems.length;
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < len; i++) {
                int pricesItem = Integer.parseInt(pricesItems[i]);
                prices[i] = pricesItem;
            }

            int result = stockmax(prices);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
