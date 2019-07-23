import java.util.Arrays;

/**
 * @author Livhong
 * @version 2018-11-13
 */
public class Combination {

    public static void Comb1(int[] status, int pos, int k, int n, int count){

        if(count==k){
            System.out.println(Arrays.toString(status));
            return;
        }

        if(pos==n||count+n-pos<k){
            return;
        }

        status[pos] = 0;
        Comb1(status, pos+1, k, n, count);
        status[pos] = 0;

        status[pos] = 1;
        Comb1(status, pos+1, k, n, count+1);
        status[pos] = 0;
    }

    public static void main(String[] args) {
        Comb1(new int[4], 0, 2, 4, 0);
    }

}
