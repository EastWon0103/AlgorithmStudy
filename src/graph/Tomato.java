package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * 플랫폼: 백준
 * 이름: 토마토 (7576)
 */
public class Tomato {
    public static int h;
    public static int w;
    public static int[][] warehouse;
    public static boolean[][] visited;
    public static class Point implements Comparable<Point>{
        int y;
        int x;
        int level;

        Point(int y, int x, int level) {
            this.y = y;
            this.x = x;
            this.level = level;
        }

        @Override
        public int compareTo(Point o) {
            return this.level-o.level;
        }
    }
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());


        PriorityQueue<Point> queue = new PriorityQueue<>();
        warehouse = new int[h][w];
        visited = new boolean[h][w];

        int notCount = 0;
        for(int i=0;i<h;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<w;j++) {
                int item = Integer.parseInt(st.nextToken());
                if(item == -1) {
                    notCount++;
                }
                if(item == 1) {
                    queue.offer(new Point(i,j,0));
                    visited[i][j] = true;
                }
                warehouse[i][j] = item;
            }
        }

        int date = 0;
        int[][] directions = {{-1,0}, {0,-1}, {1,0},{0,1}};
        int count=0;
        while(!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            count++;
            for(int[] direction:directions) {
                int nextY = currentPoint.y+ direction[0];
                int nextX = currentPoint.x + direction[1];

                if(nextY<0||nextY>=h||nextX<0||nextX>=w) {
                    continue;
                }

                if(visited[nextY][nextX] || warehouse[nextY][nextX] == -1) {
                    continue;
                }

                visited[nextY][nextX] = true;
                queue.offer(new Point(nextY, nextX, currentPoint.level+1));
            }

            if(queue.isEmpty()) {
                date = currentPoint.level;
            }
        }

        if(h*w-notCount != count) {
            System.out.println(-1);
            return;
        }

        System.out.println(date);
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}
