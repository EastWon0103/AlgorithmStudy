package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 플랫폼: 백준
 * 이름: 단지번호붙이기 (2667)
 */
public class HouseNumber {
    private static int n;
    private static int[][] field;
    private static boolean[][] visited;

    public static int dfs(int y, int x) {
        visited[y][x] = true;

        int[][] direction = {{1,0}, {0,-1}, {-1,0}, {0,1}};
        int result = 0;
        for(int i=0;i<direction.length;i++) {
            int nextY = y+direction[i][0];
            int nextX = x+direction[i][1];

            if(nextY<0 || nextY>=n || nextX<0 || nextX>=n) {
                continue;
            }

            if(visited[nextY][nextX] || field[nextY][nextX]!=1) {
                continue;
            }

            result += dfs(nextY,nextX);
        }
        return result+1;
    }
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        field = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0;i<n;i++) {
            String[] s = br.readLine().split("");
            for(int j=0;j<n;j++) {
                field[i][j] = Integer.parseInt(s[j]);
            }
        }


        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(!visited[i][j] && field[i][j] == 1) {
                    int result = dfs(i,j);
                    queue.offer(result);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(queue.size()).append('\n');
        while(!queue.isEmpty()) {
            sb.append(queue.poll()).append('\n');
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}
