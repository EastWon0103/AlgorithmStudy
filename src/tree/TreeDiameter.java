package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
* 플랫폼: 백준
* 이름: 트리의 지름(1967)
* */
public class TreeDiameter {
    static class Node {
        int num;
        int weight;

        Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }
    private static int n;
    private static List<List<Node>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static int[] diameter;

    public static int updateDiameterWithDfs(int node) {
        visited[node] = true;

        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        for(Node child:graph.get(node)) {
            if (!visited[child.num])
                que.offer(child.weight + updateDiameterWithDfs(child.num));
        }

        int max = que.isEmpty()?0:que.poll();
        int secondMax = que.isEmpty()?0:que.poll();
        diameter[node] = max+secondMax;

        return max;
    }
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i=0;i<=n;i++)
            graph.add(new ArrayList<>());

        visited = new boolean[n+1];
        diameter = new int[n+1];

        StringTokenizer st;
        for(int i=0;i<n-1;i++) {
            st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // 무방향 이므로
            graph.get(parent).add(new Node(child, weight));
            graph.get(child).add(new Node(parent, weight));
        }

        updateDiameterWithDfs(1);

        int max = -1;
        for(int i=1;i<=n;i++)
            max = Math.max(max, diameter[i]);
        System.out.print(max);
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
