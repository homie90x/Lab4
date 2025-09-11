import java.util.*;
import java.util.Scanner;
import java.lang.*;

// This algorithm approximates a solution to the Bin Packing Problem
// It is a way to pack 'n' items of different sizes in 3 bins with capacity 'B' each
// its goal is to minimize the amount of unused bin space.
// Takes an array s1,s2,... Sn
// Allocates them into 3 bins (N) 
// Allocates them based on bin capacity (B)


public class Main {
    public static int Bin() {
        Scanner input = new Scanner(System.in);
        
        int B = input.nextInt();

        int n = input.nextInt();

        System.out.println(B);

        System.out.println(n);
        
        int items = new int[n];
        for (int i = 0; i < n; i++) {
        }
        input.close();  
        return B;
    }
}