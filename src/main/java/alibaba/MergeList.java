package alibaba;

class Node{

    public Node(int val, Node next){
        this.next = next;
        this.val = val;
    }
    public Node next;
    public int val;
}

public class MergeList {

    public static Node mergeList(Node rootA, Node rootB){

        if(rootA==null) return rootB;
        if(rootB==null) return rootA;

        // if a < b, output a
        if(rootA.val<rootB.val){
            rootA.next = mergeList(rootA.next, rootB);
            return rootA;
        }else{
            rootB.next = mergeList(rootA, rootB.next);
            return rootB;
        }
        // else, output b

    }

    public static void main(String[] args) {

        Node n11 = new Node(6, null);
        Node n12 = new Node(2, n11);
        Node n13 = new Node(1, n12);

        Node n21 = new Node(9, null);
        Node n22 = new Node(3, n21);
        Node n23 = new Node(2, n22);
        Node n24 = new Node(1, n23);
        Node n25 = new Node(0, n24);
        Node n26 = new Node(-1, n25);
        Node n27 = new Node(-3, n26);

        Node root = mergeList(n13, n27);
        while (root!=null){
            System.out.print(root.val+" ");
            root = root.next;
        }

    }

}
