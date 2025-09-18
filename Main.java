import java.util.*;

// This algorithm approximates a solution to the Bin Packing Problem
// It is a way to pack 'n' items of different sizes in 3 bins with capacity 'B' each
// its goal is to minimize the amount of unused bin space.
// Takes an array s1,s2,... Sn
// Allocates them into 3 bins (N) 
// Allocates them based on bin capacity (B)

// Jakob Linscheid and Mahathir Mostafa 

// Optimal 1
// B=20 n=8 items[15 5 3 7 10 8 2 9]
// Output: Bin 1[15,5], Bin 2[10,9], Bin 3[8,7,3,2] 
// No unused items

// Optimal 2
// B=10 n=8 items[7 2 1 5 5 5 2 3]
// Output: Bin 1[7,3], Bin 2[5,5], Bin 3[5,2,2,1]
// No unused items

// Non-Optimal
// B=10 n=8 items[1 4 10 7 8 5 6 9]
// Output: Bin 1[10], Bin 2[9,1], Bin 3[8] 
// Unused items: 7,6,5,4


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Allows the program to use inputs from the console.

            System.out.println("Enter the number of items to be packed:");

        int n = input.nextInt(); //number of items

            System.out.println("Enter the capacity of each bin:");

        int B = input.nextInt(); //capacity of each bin

        Integer[] items = new Integer[n]; //array to hold the sizes of the items

            System.out.println("Enter the sizes of the items:");

        for (int i = 0; i < n; i++) 
            items[i] = input.nextInt();

        input.close();
    
        //sorts in decreasing, efficiency of O(n log n)
        Arrays.sort(items, Collections.reverseOrder());

        input.close();

       // First Fit (decreasing) Bin Packing for 3 bins, this has a time complexity of Θ(n),
       // where n is the number of items to be packed. O(n) since there is a fixed number of bins.
            int binCount = 3;
            int[] binSpace = new int[binCount];
            Arrays.fill(binSpace, B);
            List<List<Integer>> bins = new ArrayList<>();
            for (int i = 0; i < binCount; i++) {
                bins.add(new ArrayList<>());
            }

            for (int item : items) {
                boolean packed = false;
                for (int i = 0; i < binCount; i++) {
                    if (binSpace[i] >= item) {
                        bins.get(i).add(item);
                        binSpace[i] -= item;
                        packed = true;
                        break;
                    }
                }
                if (!packed) {
                    System.out.println("Item " + item + " could not be packed in any bin.");
                }
            }

            // Print bins and their remaining space
            System.out.println("Packing Result:"); 
            for (int i = 0; i < binCount; i++) {
                System.out.println("Bin " + (i+1) + ": " + bins.get(i) + " (used " + (B-binSpace[i]) + "/" + B + ")");
            }
            int unused = 0;
            for (int i = 0; i < binCount; i++) unused += binSpace[i];
            System.out.println("Total unused space: " + unused);
        }
}
