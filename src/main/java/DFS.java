/*
* Depth first search
* */
public class DFS {

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

    static void traverse(int nodeIndex){
        {
            System.out.println(nodeIndex);
            visited[nodeIndex] = true;
        }
        for(int i=0;i<edges[nodeIndex].length;i++){
            if (edges[nodeIndex][i]==1&&!visited[i]){
                traverse(i);
            }
        }
    }

    public static void main(String[] args){

        for(int i=0;i<NODE_NUM;i++){
            if(!visited[i]){
                traverse(i);
        }
    }

    }

}
