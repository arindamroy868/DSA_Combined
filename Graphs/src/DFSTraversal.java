import java.util.ArrayList;
import java.util.List;

public class DFSTraversal {
    public static void dfsTraversal(int node,boolean[] vis,List<List<Integer>> adj){
        System.out.print(node+", ");
        for(int it : adj.get(node)){
            if(!vis[it]){
                vis[it] = true;
                dfsTraversal(it,vis,adj);
            }
        }
    }
    public static void createEdge(int a,int b,List<List<Integer>> adj){
        adj.get(a).add(b);
        adj.get(b).add(a);
    }
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = 7;

        for(int i=0;i<=7;i++){
            adj.add(new ArrayList<>());
        }
        createEdge(1,4,adj);
        createEdge(4,2,adj);
        createEdge(4,5,adj);
        createEdge(2,3,adj);
        createEdge(2,7,adj);
        createEdge(3,6,adj);
        createEdge(6,7,adj);

        boolean vis[] = new boolean[n+1];

        for(int i=1;i<=n;i++){
            if(!vis[i]){
                vis[i] = true;
                dfsTraversal(i,vis,adj);
            }
        }

    }
}
