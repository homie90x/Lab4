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

        int[] items = new int[n];

            System.out.println("Enter the sizes of the items:");

        for (int i = 0; i < n; i++) 
            items[i] = input.nextInt();

        input.close();
    
        //sorts in decreasing
        Arrays.sort(items);
            for (int i = 0; i < n/2; i++) {
                int tmp = items[i];
                items[i] = items[n - 1 - i];
                items[n - 1 - i] = tmp;

            }    
        
        System.out.println("Number of items: " + n);
        System.out.println("Bin capacity: " + B);
        System.out.println("Items to be packed: " + Arrays.toString(items));
        input.close();
    

    //3 bins

      ArrayList<Integer>[] bins = new ArrayList[3];
        int[] used = new int[3]; 
        for (int i = 0; i < 3; i++) bins[i] = new ArrayList<>();
    
    //list for items that cant be placed into any of the bins

    ArrayList<Integer> unpacked = new ArrayList<>();

    //Looping through each item 
    for( int item : items) {
        boolean placed = false; //item not placed into a bin yet
        for(int b = 0; b < 3; b++) {
            if (used[b] + item <= b) {   // if item fits into bin (1 through 3)
                bins[b].add(item); //then it adds the item into that bin (whichever one it fits into 1-3)
                used[b] += item;
                placed = true;
                break; //if placed then stops the loop
            }
        }
        if (!placed) unpacked.add(item); //this is to store the item if it doesnt fit into a bin

        
    }
}

}
