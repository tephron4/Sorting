import java.util.*;

public class BubbleSort {
    
    public static void main(String[] args){
        BubbleSort b = new BubbleSort();
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
        System.out.println("Running Bubble Sort Algorithm...");
        System.out.println("");
        // Run Simple Sort Algorithm on the array.
        b.bubbleSort(arr);
        // Print the Simply Sorted Array.
        System.out.println("Bubble Sorted Array: " + Arrays.toString(arr));
        System.out.println("");
    }

    /**
     * Bubble Sort Algorithm
     * 
     * @param arr an int[]
     * @return the input int[] sorted in ascending order.
     */
    public int[] bubbleSort(int[] arr){
        int n = arr.length;

        for(int i = 0; i < n-1; i++){
            bubble(arr);
        }

        return arr;
    }

    public int[] bubble(int[] arr){
        int n = arr.length;

        for(int i = n-1; i > 0; i--){
            if(arr[i] < arr[i-1]){
                swap(arr, i, i-1);
            }
        }

        return arr;
    }

    /**
     * Function that swaps the values of given array at the given indeces.
     * 
     * @param a an int[]
     * @param x an index
     * @param y an index
     * @return the given int[] with the values at x and y swapped.
     */
    public int[] swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;

        return arr;
    }
}
