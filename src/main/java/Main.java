import java.util.Scanner;

public class Main {



    public static int getNumber(String s, int index) {
        int number = 0;
        int length = s.length();
        int lindex = index - 1;
        int rindex = index + 1;
        while (lindex >= 0 && s.charAt(lindex) == 'g') {
            lindex--;
            number++;
        }
        while (rindex < length && s.charAt(rindex) == 'g') {
            rindex++;
            number++;
        }
        return number;
    }

    public static void main(String[] args) {
        String users;
        int k;
        Scanner input = new Scanner(System.in);
        String tempS = input.nextLine();
        k = input.nextInt();
        users = tempS + tempS;
        int length = users.length();
        int max = 0;
        int maxi = -1;
        for (int i = 0; i < length; i++) {
            if (users.charAt(i) == 'b') {
                int temp = getNumber(users, i);
                if (temp > max) {
                    max = temp;
                    maxi = i;
                }
            }
        }
        System.out.print(maxi + " ");

        int[][] f = new int[length][k + 1];
        if (users.charAt(0) == 'b') f[0][0] = 1;
        for (int i = 1; i < length; i++) {
            if (users.charAt(i) == 'b') {
                for (int j = 0; j <= k; j++) {
                    f[i][j] = f[i - 1][j] + 1;
                }
            } else if (users.charAt(i) == 'g') {
                f[i][0] = 0;
                for (int j = 1; j <= k; j++) {
                    f[i][j] = f[i - 1][j - 1];
                }
            }
        }

        int maxB = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= k; j++) {
                if (f[i][j] > maxB) {
                    maxB = f[i][j];
                }
            }
        }
        System.out.println(maxB);
    }

}