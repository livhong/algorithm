/*
* Breadth first search
* */
import java.util.ArrayList;

import java.util.List;

public class BFS {

    static int NODE_NUM = 9;
    static int[][] edges = new int[NODE_NUM][NODE_NUM];
    static boolean[] visited = new boolean[NODE_NUM];

    static {
        edges[0][1] = 1;
        edges[1][2] = 1;
        edges[0][3] = 1;
        edges[0][4] = 1;
        edges[1][4] = 1;
        edges[2][5] = 1;
        edges[3][6] = 1;
        edges[4][6] = 1;
        edges[6][7] = 1;
        edges[7][8] = 1;
    }

    public static void main(String[] args) {

        List<Integer> queue = new ArrayList<>();

        for (int i=0;i<NODE_NUM;i++){

            if(!visited[i]){
                queue.add(i);
                while (!queue.isEmpty()){
                    int node = queue.remove(0);
                    if(!visited[node]){
                        {
                            System.out.println(node);
                            visited[node] = true;
                        }
                        for(int j=0;j<edges[node].length;j++){
                            if((edges[node][j]==1||edges[j][node]==1)&&!visited[j]){
                                queue.add(j);
                            }
                        }
                    }
                }
            }

        }

    }

}
