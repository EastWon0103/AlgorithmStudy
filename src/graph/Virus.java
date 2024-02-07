package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 플랫폼: 백준
* 이름: 바이러스 (2606)
* */
public class Virus {
    public static void virusDfs(boolean[] visited, int[][] matrix, int start) {
        for (int i=1;i<=visited.length-1;i++) {
            if (!visited[i] && matrix[start][i] == 1) {
                visited[i] = true;
                virusDfs(visited,matrix,i);
            }
        }
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[n+1];
        visited[1] = true;

        int[][] matrix = new int[n+1][n+1];

        for(int i=0;i<m;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            matrix[a][b] = 1;
            matrix[b][a] = 1;
        }

        int count = 0;
        virusDfs(visited, matrix, 1);
        for(boolean visit: visited) {
            if (visit)
                count++;
        }

        System.out.println(--count);
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}