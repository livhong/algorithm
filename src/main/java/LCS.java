/*
* Longest common string
* Dynamic programming
* */
public class LCS {

    static char[] S1 = "INTHEBEGINING".toCharArray();
    static char[] S2 = "ALLTHINGSARELOST".toCharArray();

    public static void main(String[] args) {
        String[][] paths = new String[S1.length][S2.length];
        for(int i=0;i<S1.length;i++){
            for(int j=0;j<S2.length;j++){
                paths[i][j] = "";
            }
        }
        int[][] c = new int[S1.length][S2.length];

        for(int i=0;i<S1.length;i++){
            if(S1[i]==S2[0]) {
                c[i][0] = 1;
                paths[i][0]+=S2[0];
            }
            else
                c[i][0] = 0;
        }

        for(int j=0;j<S2.length;j++){
            if(S1[0]==S2[j]) {
                c[0][j] = 1;
                paths[0][j]+=S1[0];
            }
            else
                c[0][j] = 0;
        }

        for(int i=1;i<S1.length;i++){
            for(int j = 1;j<S2.length;j++){
                if(S1[i]==S2[j]){
                        c[i][j] = c[i-1][j-1]+1;
                        paths[i][j]+=paths[i-1][j-1]+S1[i];
                }else{
                    if(c[i-1][j]>c[i][j-1]){
                        c[i][j] = c[i-1][j];
                        paths[i][j] = paths[i-1][j];
                    }else{
                        c[i][j] = c[i][j-1];
                        paths[i][j] = paths[i][j-1];
                    }
//                    c[i][j] = c[i-1][j]>c[i][j-1]?c[i-1][j]:c[i][j-1];

                }
            }
        }

        System.out.println(c[S1.length-1][S2.length-1]);
        System.out.println(paths[S1.length-1][S2.length-1]);

    }

}
