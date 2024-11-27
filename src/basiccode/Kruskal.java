package basiccode;

import java.util.Arrays;
import java.util.Comparator;

public class Kruskal {

    static int[][] graph;
    static int[] parent;

    public static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if(parentA <= parentB) parent[parentB] = parentA;
        else parent[parentA] = parentB;
    }

    public static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) {
        graph = new int[][]{{1, 2, 6}, {1, 3, 3}, {1, 4, 1}, {2, 5, 4}, {3, 4, 2}, {3, 5, 5}, {4, 5, 7}};
        parent = new int[6];
        int total = 0;

        for(int i=1; i<6; i++) {
            parent[i] = i;
        }

        Arrays.sort(graph, Comparator.comparing(o-> o[2]));

        for(int i=0; i<graph.length; i++) {
            if(find(graph[i][0]) != find(graph[i][1])) {
                total += graph[i][2];
                union(graph[i][0], graph[i][1]);
            }
        }
        System.out.println(Arrays.toString(parent));
        System.out.println(total);
    }

}
