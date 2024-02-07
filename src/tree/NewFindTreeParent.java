package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 플랫폼: 백준
 * 이름: 트리의 부모 찾기(11725)
 * */
public class NewFindTreeParent {

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> targets = new LinkedList<>();
        List<List<Integer>> graph  = new ArrayList<>();
        int[] parent = new int[n+1];

        for(int i=0;i<n+1;i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<n-1;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) {
                parent[b] = 1;
                targets.offer(b);
            } else if (b == 1) {
                parent[a] = 1;
                targets.offer(a);
            } else {
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
        }

        while(!targets.isEmpty()) {
            int target = targets.poll();

            for(Integer child:graph.get(target)) {
                if(parent[child] == 0) {
                    parent[child] = target;
                    targets.add(child);
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for(int i=2;i<=n;i++)
            sb.append(parent[i]).append('\n');
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}
