import java.util.*;
import java.util.Scanner;
import java.lang.*;
import java.util.Arrays;

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
        for (int i = 0; i < n; i++) {
            items[i] = input.nextInt();
        }
        Arrays.sort(items);
        System.out.println("Number of items: " + n);
        System.out.println("Bin capacity: " + B);
        System.out.println("Items to be packed: " + Arrays.toString(items));
        input.close();
    }
}