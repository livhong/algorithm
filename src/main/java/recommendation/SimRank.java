package recommendation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimRank {

    public static String[] nodeString = {
            "Univ", "ProfA", "ProfB", "StudentA", "StudentB"
    };
    public static int[][] graph = new int[nodeString.length][nodeString.length];

    public static double[][] sim = new double[nodeString.length][nodeString.length];

    static {
        graph[0][1] = 1;
        graph[0][2] = 1;
        graph[1][3] = 1;
        graph[3][0] = 1;
        graph[2][4] = 1;
        graph[4][2] = 1;

        for(int i=0;i<sim.length;i++){
            for(int j=0;j<sim.length;j++){
                if(i==j) sim[i][j] = 1;
            }
        }
    }

    public static List<Integer> getInNode(int index){
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            if(graph[i][index]==1){
                result.add(i);
            }
        }
        return result;
    }

    public static double updateSim(int i, int j, double C){
        // C/(|Ii|*|Ij|)*SUM(Sim(i, j))
//        if(i<j){
//            int tmp = i;
//            i = j;
//            j = tmp;
//        }
        if(i==j) return 1;
        List<Integer> list1 = getInNode(i);
        List<Integer> list2 = getInNode(j);
        if(list1.size()==0||list2.size()==0) return 0;
        double sum = 0;
        for(int index1: list1){
            for(int index2: list2){
//                if(index1<index2){
//                    int tmp = index1;
//                    index1 = index2;
//                    index2 = tmp;
//                }
                sum += sim[index1][index2];
            }
        }
        return C*sum/(list1.size()*list2.size());
    }

    public static void computeSim(int k, double C){
        for(int i=0;i<k;i++){
            double[][] newSim = new double[nodeString.length][nodeString.length];

            for(int index1 = 0;index1<newSim.length;index1++){
                for(int index2=0;index2<nodeString.length;index2++){
                    newSim[index1][index2] = updateSim(index1, index2, C);
                }
            }

            sim = newSim;
        }
    }

    public static void main(String[] args) {

        computeSim(20, 0.8);
        for(double[] s: sim){
            System.out.println(Arrays.toString(s));
        }

    }

}
