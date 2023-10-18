package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 플랫폼: 백준
 * 이름: 미로 탐색 (2178)
 */
public class MazeSearch {
    static class Point {
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

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] maze = new int[h][w];

        // 0,0 에서 시작하여 h-1, w-1 까지 가는 수;

        for(int i=0;i<h;i++) {
            String[] s = br.readLine().split("");
            for (int j=0;j<w;j++) {
                maze[i][j] = Integer.parseInt(s[j]);
            }
        }



        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[h][w];
        int[][] answer = new int[h][w];
        answer[0][0] = 1;
        int[][] direction = {{1,0}, {0,1}, {-1,0}, {0,-1}}; // 하 우 상 좌
        queue.offer(new Point(0,0));

        while(!queue.isEmpty()) {
            Point currentPoint = queue.poll();

            for(int i=0;i<direction.length;i++) {
                int nextY = currentPoint.y + direction[i][0];
                int nextX = currentPoint.x + direction[i][1];

                if(nextY < 0 || nextY >= h || nextX < 0 || nextX >= w) {
                    continue;
                }
                if(maze[nextY][nextX] == 0) {
                    continue;
                }
                if(visited[nextY][nextX]) {
                    continue;
                }

                Point nextPoint = new Point(nextY, nextX);
                queue.offer(nextPoint);
                answer[nextY][nextX] = answer[currentPoint.y][currentPoint.x]+1;
                visited[nextY][nextX] = true;
            }
        }

        System.out.println(answer[h-1][w-1]);
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}
