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
* 이름: 트리(1068)
* */
public class RemoveNode {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1; // Garbage
        for(int i=0;i<n;i++) {
            int parentNode = Integer.parseInt(st.nextToken());
            if (parentNode == -1) {
                root = i;
            } else  {
                graph.get(parentNode).add(i);
            }
        }

        int removeNode = Integer.parseInt(br.readLine());
        if(removeNode == root) {
            System.out.print(0);
            return;
        }

        for(int i=0;i<n;i++) {
            if(removeNode!=i && graph.get(i).contains(removeNode))
                graph.get(i).remove(graph.get(i).indexOf(removeNode));
        }

        Queue<Integer> que = new LinkedList<>();
        que.offer(root);
        int count = 0;// 삭제 된 노드가 사실 leaf node로 변경해준 것이기 때문에 삭제 된 node 개수만큼 삭제

        while(!que.isEmpty()) {
            int node = que.poll();

            List<Integer> children = graph.get(node);
            if(children.isEmpty()) {
                count++;
                continue;
            }

            for(int child: children)
                que.offer(child);
        }

        System.out.print(count);
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
