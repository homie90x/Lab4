import java.util.*;

// This algorithm approximates a solution to the Bin Packing Problem
// It is a way to pack 'n' items of different sizes in 3 bins with capacity 'B' each
// its goal is to minimize the amount of unused bin space.
// Takes an array s1,s2,... Sn
// Allocates them into 3 bins (N) 
// Allocates them based on bin capacity (B)


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

            System.out.println("Enter the number of items to be packed:");

        int n = input.nextInt();

            System.out.println("Enter the capacity of each bin:");

        int B = input.nextInt();

        Integer[] items = new Integer[n];

            System.out.println("Enter the sizes of the items:");

        for (int i = 0; i < n; i++) 
            items[i] = input.nextInt();

        input.close();
    
        //sorts in decreasing
        Arrays.sort(items, Collections.reverseOrder());

        input.close();

       // First Fit (decreasing) Bin Packing for 3 bins
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