/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mostfreqinteger;

/**
 *
 * @author harini-geek
 */
import java.io.*;

public class MostFreqInteger {

    public int mostFreqInteger(int intArray[], int size, int limit){
        
        int result = 0;
        for(int i=0;i<size;i++){
            intArray[intArray[i] % limit] += limit;
        }
        
        int max = intArray[0];
        for(int i=0;i<size;i++){
            if(intArray[i] > max){
                max = intArray[i];
                result = i;
            }
        }
        return result;
    }
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter size of array");
        int size = Integer.parseInt(br.readLine());
        int intArray[] = new int[size];
        
        System.out.println("Enter integer value limit <= "+size);
        int limit = Integer.parseInt(br.readLine());
        
        for(int i=0;i<size;i++){
            System.out.println("Enter integer");
            int n = Integer.parseInt(br.readLine());
            if(n < limit){
                intArray[i] = n;
            } else {
                System.out.println("Enter value < "+limit);
                intArray[i] = Integer.parseInt(br.readLine());
            }
        }
        
        MostFreqInteger mFI = new MostFreqInteger();
        int result = mFI.mostFreqInteger(intArray,size,limit);
        System.out.println("Most Frequent number is "+result);
    }
    
}
