import java.util.*;

public class SimpleSort{

    public static void main(String[] args){
        SimpleSort s = new SimpleSort();
        Scanner sc = new Scanner(System.in);

        int n = 50;
        
        // Get array size from user (or use random).
        while(true){
            System.out.println("");
            System.out.println("");
            System.out.print("Enter a number <= 100: ");
            String input = sc.nextLine();
            // Make sure they give an integer as input.
            try{
                n = Integer.parseInt(input);
                break;
            }
            // Catch format error
            catch(NumberFormatException e){
                System.out.println("");
                System.out.println("Error: Input was not a integer.");
                System.out.println("");
                // Ask if they just want to do a random length (between 0 and 100).
                System.out.print("Would you like to use a random array size? (y/n)  ");
                String res = sc.nextLine();
                // If they want random length:
                if(res.toLowerCase().charAt(0) == 'y'){
                    n = (int) (100 * Math.random());
                    break;
                }
            }
        }

        sc.close();

        System.out.println("");
        System.out.println("");
        System.out.println("Creating an array of size " + n + "...");
        // Create and populate an array with random numbers (<= desired size).
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = (int) (n * Math.random());
        }
        // Print array.
        System.out.println("");
        System.out.println("Array: " + Arrays.toString(arr));

        System.out.println("");
        System.out.println("Running Simple Sort Algorithm...");
        System.out.println("");
        // Run Simple Sort Algorithm on the array.
        s.simpleSort(arr);
        // Print the Simply Sorted Array.
        System.out.println("Simple Sorted Array: " + Arrays.toString(arr));
        System.out.println("");
    }

    /**
     * Simple Sort Algorithm
     * 
     * @param arr an int[]
     * @return an int[] of the ascending sorted int[] arr
     */
    public int[] simpleSort(int[] arr){
        if(arr.length <= 1) return arr;

        for(int i = 0; i < arr.length-1; i++){
            for(int j = i+1; j < arr.length; j++){
                // Sorting in ascending order.
                if(arr[j] < arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        return arr;
    }
}