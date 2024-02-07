package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 플랫폼: 백준
* 이름: 경로 찾기(11403)
* */
public class FindPath {
    static int[][] matrix;
    static boolean[] visited;
    static int n;
    // TODO: 오늘 여기


    public static int canGo(int startNode, int endNode) {
        return 1;
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        matrix = new int[n][n];
        visited = new boolean[n];
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++)
                matrix[i][j] = Integer.parseInt(st.nextToken());
        }


        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++)
                sb.append(canGo(i,j)).append(' ');
            sb.append('\n');
        }

        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}
