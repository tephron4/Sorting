import java.util.*;

public class SelectionSort {
    
    public static void main(String[] args){
        SelectionSort s = new SelectionSort();
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
        System.out.println("Running Selection Sort Algorithm...");
        System.out.println("");
        // Run Simple Sort Algorithm on the array.
        s.selectionSort(arr);
        // Print the Simply Sorted Array.
        System.out.println("Selection Sorted Array: " + Arrays.toString(arr));
        System.out.println("");
    }

    /**
     * Selection Sort Algorithm
     * 
     * @param arr an int[]
     * @return the given int[] sorted in ascending order.
     */
    public int[] selectionSort(int[] arr){
        int n = arr.length;

        int i = 0;
        while(i < n-1){
            int j = findSmallest(arr, i, n);
            arr = swap(arr, i, j);
            i++;
        }

        return arr;
    }

    /**
     * Function for finding the index of the smallest int in an int[].
     * 
     * @param a an int[]
     * @param s starting index for the search
     * @param e end value (non-inclusive) for the search
     * @return the index of the smallest value in the given int[].
     */
    public int findSmallest(int[] arr, int s, int e){
        int ind = -1;
        int small = Integer.MAX_VALUE;

        for(int i = s; i < e; i++){
            if(arr[i] < small){
                small = arr[i];
                ind = i;
            }
        }

        return ind;
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
