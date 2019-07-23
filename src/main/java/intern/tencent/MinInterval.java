package intern.tencent;

import java.util.Scanner;

public class MinInterval {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        if(n<=1){
            System.out.println(0+" "+0);
            return;
        }
        for (int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }

        for (int i=1;i<n;i++){
            int min=Integer.MAX_VALUE;
            int idx=-1;
            for (int j=0;j<i;j++){
                int tmp=Math.abs(a[j]-a[i]);
                if(tmp<min){
                    min = tmp;
                    idx = j;
                }
            }
            System.out.println(min+" "+(idx+1));
        }
    }
}
