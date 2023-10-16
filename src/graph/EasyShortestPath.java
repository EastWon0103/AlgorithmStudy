package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 플랫폼: 백준
 * 이름: 쉬운 최단거리 (14940)
 */
public class EasyShortestPath {
    public static int[][] board;
    public static int h;
    public static int w;
    public static int[][] answer;
    public static boolean[][] visited;
    public static class Point {
        int y;
        int x;
        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        board = new int[h][w];

        int startY = -1;
        int startX = -1;
        for(int i=0;i<h;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<w;j++) {
                int k = Integer.parseInt(st.nextToken());
                board[i][j] = k;
                if(k == 2) {
                    startY = i;
                    startX = j;
                }
            }
        }

        answer = new int[h][w];
        visited = new boolean[h][w];

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startY, startX));
        visited[startY][startX] = true;

        int weight = 0;
        int[][] direction = {{-1,0}, {0,-1}, {1,0}, {0,1}};

        while(!queue.isEmpty()) {
            Point p = queue.poll();

            for(int i=0;i<4;i++) {
                int nextY = p.y + direction[i][0];
                int nextX = p.x + direction[i][1];

                if(nextY < 0 || nextY >= h || nextX < 0 || nextX >= w) {
                    continue;
                }

                if(board[nextY][nextX] == 0) {
                    continue;
                }

                if(visited[nextY][nextX] == true) {
                    continue;
                }
                queue.offer(new Point(nextY, nextX));
                answer[nextY][nextX] = answer[p.y][p.x] + 1;
                visited[nextY][nextX] = true;
            }
        }


        StringBuilder sb = new StringBuilder();
        for(int i=0;i<h;i++) {
            for (int j=0;j<w;j++) {
                if(startY == i && startX == j) {
                    sb.append(answer[i][j]).append(" ");
                    continue;
                }

                if(board[i][j] != 0 && answer[i][j] == 0) {
                    sb.append(-1).append(" ");
                    continue;
                }
                sb.append(answer[i][j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new EasyShortestPath().solution();
    }
}
