package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/*
* 플랫폼: 백준
* 이름: 최소 스패닝 트리(1197)
* */
public class MSTWithPrim {
    private static int INF = 10000001;
    public static List<Map<Integer, Integer>> init(int v, int e, BufferedReader br) throws Exception{
        List<Map<Integer, Integer>> graph = new ArrayList<>(); // a, b, w

        for(int i=0;i<=v;i++) {
            graph.add(new HashMap<Integer,Integer>());
        }

        StringTokenizer st;
        for(int i=0;i<e;i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(a).put(b,w);
        }

        return graph;
    }
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        List<Map<Integer, Integer>> graph = init(v, e, br);
        int[] nearest = new int[v+1];
        int[] distance = new int[v+1];
        int sum =0;
        int index=0;

        for(int i=1;i<=v;i++) {
            nearest[i] = 1;
            distance[i] = graph.get(1).getOrDefault(i, INF);
        }
        distance[1] = 0;

        while(index++ < v-1) {
            int now = -1;
            int min = INF;
            for(int i=2;i<=v;i++) {
                if( 0<distance[i] && distance[i] < min) {
                    now = i;
                    min = distance[i];
                }
            }

            sum += min;
            distance[now] = -1;

            for(int i=2;i<=v;i++) {
                if(graph.get(now).getOrDefault(i, INF) < distance[i]) {
                    distance[i] = graph.get(now).get(i);
                    nearest[i] = now;
                }
            }
        }

        System.out.print(sum);
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}
