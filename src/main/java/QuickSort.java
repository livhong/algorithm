import java.util.Random;

/**
 * @author zyz
 * @version 2018-07-07
 */
public class QuickSort {
    private void sort(int[] a, int x, int y) {
        int i = x, j = y, k = a[(x + y) >> 1];
        while (i < j) {
            for (; a[i] < k; i++);
            for (; a[j] > k; j--);
            if (i <= j) {
                int t;
                t = a[i]; a[i] = a[j]; a[j] = t;
                i++; j--;
            }
        }
        if (x < j) sort(a, x, j);
        if (i < y) sort(a, i, y);
    }

    public QuickSort() {
        Random random = new Random();
        int[] a = new int[10000000];
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(Integer.MAX_VALUE);
        }
        sort(a, 0, a.length - 1);
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                System.out.println("error");
            }
        }
    }

    public static void main(String[] args) {
        new QuickSort();
    }
}
