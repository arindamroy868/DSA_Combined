import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    static class Node{
        int v;
        int wt;
        Node(){};
        Node(int v,int wt){
            this.v = v;
            this.wt = wt;
        }
    }
    public static void primsAlgorithm(List<List<Node>> mat,int n){
        int[] keys = new int[n];
        boolean[] mst = new boolean[n];
        int[] parent = new int[n];
        Arrays.fill(keys,Integer.MAX_VALUE);
        Arrays.fill(parent,-1);

        PriorityQueue<Node> pq = new PriorityQueue<>((node1,node2) -> node1.wt - node2.wt );

        keys[0] = 0;
        pq.offer(new Node(0,keys[0]));
        for(int i=0;i<n;i++){
            int u = pq.poll().v;

            mst[u] = true;
            for(Node node : mat.get(u)){
                if(mst[node.v] == false && node.wt <keys[node.v]){
                    keys[node.v] = node.wt;
                    parent[node.v] = u;
                    pq.add(new Node(node.v,keys[node.v]));
                }
            }
        }
        for(int i=1;i<n;i++){
            System.out.println(parent[i]+" ----> "+i);
        }
    }
    public static void addEdge(int u,int v,int wt,List<List<Node>> mat){
        mat.get(u).add(new Node(v,wt));
        mat.get(v).add(new Node(u,wt));
    }
    public static void main(String[] args) {
        List<List<Node>> mat = new ArrayList<>();
        int n = 6;
        for(int i=0;i<n;i++){
            mat.add(new ArrayList<>());
        }
        addEdge(0,1,3,mat);
        addEdge(0,3,6,mat);
        addEdge(1,2,3,mat);
        addEdge(1,3,8,mat);
        addEdge(1,4,5,mat);
        addEdge(2,4,7,mat);
        addEdge(2,5,5,mat);
        addEdge(4,5,9,mat);

        primsAlgorithm(mat,n);
    }
}
