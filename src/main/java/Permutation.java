import java.util.Arrays;

/**
 * @author Livhong
 * @version 2018-11-13
 */
public class Permutation {

    /*
    * 全排列
    * */
    public static void AllPerm(int[] array, int start, int end){

        if(start==end){
            System.out.println(Arrays.toString(array));
            return;
        }

        for(int i=start;i<=end;i++){
            int tmp = array[start];
            array[start] = array[i];
            array[i] = tmp;

            AllPerm(array, start+1, end);

            tmp = array[start];
            array[start] = array[i];
            array[i] = tmp;
        }
    }

    public static void Perm(int[] array, int pos, int k, int n){
        if(pos>k||pos==n){
            System.out.println(Arrays.toString(array));
            return;
        }

        for(int i=pos;i<=n;i++){
            int tmp = array[pos];
            array[pos] = array[i];
            array[i] = tmp;

            Perm(array, pos+1, k, n);

            tmp = array[pos];
            array[pos] = array[i];
            array[i] = tmp;
        }
    }

    public static void main(String[] args) {

        int[] array = new int[]{1,2,3,4};

//        AllPerm(array, 0, 3);

        Perm(array, 0, 1-1, 4-1);
    }

}
