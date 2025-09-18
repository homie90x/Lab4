
import java.util.*;

public class BinPacking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read input
        int B = sc.nextInt();      // bin capacity
        int n = sc.nextInt();      // number of items
        int[] items = new int[n];
        for (int i = 0; i < n; i++) items[i] = sc.nextInt();
        sc.close();

        // Sort items in decreasing order
        Arrays.sort(items);
        for (int i = 0; i < n / 2; i++) {
            int tmp = items[i];
            items[i] = items[n - 1 - i];
            items[n - 1 - i] = tmp;
        }

        // 3 bins
        ArrayList<Integer>[] bins = new ArrayList[3];
        int[] used = new int[3];
        for (int i = 0; i < 3; i++) bins[i] = new ArrayList<>();

        ArrayList<Integer> unpacked = new ArrayList<>();

        // First-Fit Decreasing
        for (int item : items) {
            boolean placed = false;
            for (int b = 0; b < 3; b++) {
                if (used[b] + item <= B) {
                    bins[b].add(item);
                    used[b] += item;
                    placed = true;
                    break;
                }
            }

            if (!placed) unpacked.add(item);
        }

        // Output
        System.out.println("=== Packing Result ===");
        for (int b = 0; b < 3; b++) {
            System.out.println("Bin " + (b+1) + ": " + bins[b] + 
                               " (used " + used[b] + "/" + B + ")");
        }
        System.out.println("Unpacked: " + unpacked);
        int unused = 3*B - (used[0] + used[1] + used[2]);
        System.out.println("Total unused space: " + unused);
    }
}
