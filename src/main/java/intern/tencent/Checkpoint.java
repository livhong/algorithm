package intern.tencent;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Checkpoint {

    void solution(int[] points, int a){
        if(points==null) {System.out.println(0);return;}
        int num = points.length;
        if(num <= 1){
            System.out.println(0);
            return;
        }
        Arrays.sort(points);
        if (a <= points[0]){
            System.out.println(points[num-2] - a);
        }else if(a >= points[num - 1]){
            System.out.println(a - points[1]);
        }else{
            int min = 2*(a-points[1]>0?a-points[1]:0)+points[num-1]-a;
            int d2 = (a-points[1]>0?a-points[1]:0)+2*(points[num-1]-a);
            min = min<d2?min:d2;
            int d3 = 2*(a-points[0])+(points[num-2]-a>0?points[num-2]-a:0);
            min = min<d3?min:d3;
            int d4 = (a-points[0])+2*(points[num-2]-a>0?points[num-2]-a:0);
            min = min<d4?min:d4;
//            System.out.println(Math.min(a - 2*points[0] + points[num-2], 2*points[num-1] - a - points[1]));
            System.out.println(min);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        int[] points = new int[n];
        for(int i = 0;i < n;i++){
            points[i] = in.nextInt();
        }
        new Checkpoint().solution(points, a);
    }


}
