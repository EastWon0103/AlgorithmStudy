package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class DfsAndBfs {
    StringBuilder sb = new StringBuilder();

    public void dfs(List<List<Integer>> graph, int startNode) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.size()];
        stack.push(startNode);
        visited[startNode]=true;

        while(!stack.isEmpty()) {
            int tmp = stack.pop();

            sb.append(tmp).append(' ');
            for(int node: graph.get(tmp)) {
                if(!visited[node]){
                    stack.push(node);
                    visited[node] = true;
                }

            }
        }
    }

    public void bfs(List<List<Integer>> graph, int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];
        queue.offer(startNode);
        visited[startNode] = true;
        sb.append(startNode).append(' ');

        while(!queue.isEmpty()) {
            int indexNode = queue.poll();

            Collections.sort(graph.get(indexNode));
            for(int node: graph.get(indexNode)) {
                if(!visited[node]) {
                    queue.offer(node);
                    visited[node] = true;
                    sb.append(node).append(' ');
                }
            }
        }

    }
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeN = Integer.parseInt(st.nextToken());
        int edgeN = Integer.parseInt(st.nextToken());
        int firstNode = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=nodeN;i++)
            graph.add(new ArrayList<>());

        for(int i=0;i<edgeN;i++) {
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());

            graph.get(nodeA).add(nodeB);
            graph.get(nodeB).add(nodeA);
        }

//        for(List<Integer> e:graph)
//            sb.append(e).append('\n');

        dfs(graph,firstNode);
        sb.append('\n');
        bfs(graph,firstNode);
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new DfsAndBfs().solution();
    }
}
