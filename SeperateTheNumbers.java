import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the separateNumbers function below.
    
    static long seperateNumbersUtil(String s){
        if( s.charAt(0) == '0'){
            return -1;
        }
        
        for(int i = 1; i * 2 <= s.length(); i++){
            long firstNumber = Long.parseLong(s.substring(0, i));
            
            StringBuilder sequence = new StringBuilder();
            
            long number = firstNumber;
            
            while(sequence.length() < s.length()){
                sequence.append(number);
                number++;
            }
            
            if(sequence.toString().equals(s)){
                return firstNumber;
            }
        }
               return -1;
    }
    
    static void separateNumbers(String s) {
        long result = seperateNumbersUtil(s);
        
        System.out.println(result > 0 ? "YES" + " " + result : "NO");

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            separateNumbers(s);
        }

        scanner.close();
    }
}
