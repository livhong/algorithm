package alibaba;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int n = Integer.parseInt(line);
        int[][] area = new int[n][n];

        for (int i = 0; i < n; i++) {
            line = scanner.nextLine();
            String[] split = line.split(",");
            if (split.length != n) {
                throw new IllegalArgumentException("错误输入");
            }
            int j = 0;
            for (String num : split) {
                area[i][j++] = Integer.parseInt(num);
            }
        }

        int minimumTimeCost = getMinimumTimeCost(n,area);
        System.out.println(minimumTimeCost);
    }

    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    private static int getMinimumTimeCost(int n, int[][] area) {
        int[][] cost = new int[n + 1][n];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = 9999999;
            }
        }
        for (int i = 0; i < n; i++) {
            cost[0][i] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = Math.min(element(cost, i - 2, j) + element(area, i - 1, j),
                        element(cost, i, j - 2) + element(area, i, j - 1));
            }
        }
        int ans = 9999999;
        for (int i = n - 1; i < n + 1; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.min(cost[i][j], ans);
            }
        }
        return ans;
    }

    private static int element(int[][] array, int x, int y) {
        if (x < 0 || x >= array.length || y < 0 || y >= array[x].length) {
            return 99999999;
        }
        return array[x][y];
    }
}