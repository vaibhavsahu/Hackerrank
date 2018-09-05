import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r, int m, int n) {
        
        int layers = Math.min(m, n)/2;
        
        int [][] array = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                array[i][j] = matrix.get(i).get(j);
            }
        }
        
        for(int layer = 0; layer < layers; ++layer){
            for(int x = 0; x < r % (2 * (m + n - 2 - 4 * layer )); x++){
                
                int i = layer;
                int j = layer;
                
                int temp = array[layer][layer];
                
                while(i < m -1-layer){
                    int temp2 = array[i+1][j];
                    array[i+1][j] = temp;
                    temp = temp2;
                    i++;
                }
                
                
                while(j < n -1-layer){
                    int temp2 = array[i][j+1];
                    array[i][j+1] = temp;
                    temp = temp2;
                    j++;
                }
                
                while(i > layer){
                    int temp2 = array[i-1][j];
                    array[i-1][j] = temp;
                    temp = temp2;
                    i--;
                }
                
                while(j > layer){
                    int temp2 = array[i][j-1];
                    array[i][j-1] = temp;
                    temp = temp2;
                    j--;
                }
            }
        }
        
               
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println("");
        }
         
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        matrixRotation(matrix, r, m, n);

        bufferedReader.close();
    }
}
