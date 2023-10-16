package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Cabbage {
    static int[][] field = new int[50][50];
    static int[][] direction = {{-1,0}, {0,-1}, {1,0}, {0,1}}; // 상하좌우, y,x

    public static boolean canGo(int goY, int goX, int w, int h) {
        if(goY < 0 || goY >= h) {
            return false;
        }

        if(goX < 0 || goX >= w) {
            return false;
        }

        if(field[goY][goX] == 0) {
            return false;
        }

        return true;
    }
    public static void marking(int y, int x, int w, int h) {
        field[y][x] = 0;
        for(int i=0;i< direction.length;i++) {
            int goY = y+direction[i][0];
            int goX = x+direction[i][1];
            if (canGo(goY,goX,w,h)) {
                field[goY][goX] = 1;
                marking(goY,goX, w,h);
            }
        }
    }

    public static int getResult(int w, int h) {
        int result = 0;
        for(int i=0;i<h;i++) {
            for(int j=0;j<w;j++) {
                if (field[i][j] == 1) {
                    marking(i,j,w,h);
                    result++;
                }
            }
        }

        return result;
    }

    public static void initField(int w, int h) {
        for(int i=0;i<h;i++) {
            for(int j=0;j<w;j++) {
                field[i][j] = 0;
            }
        }
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int numOfTestCase = Integer.parseInt(br.readLine());
        for(int i=0;i<numOfTestCase;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            initField(w,h);

            int numOfCabbage = Integer.parseInt(st.nextToken());
            for (int j=0;j<numOfCabbage;j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                field[y][x] = 1;
            }

            int result = getResult(w,h);
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Cabbage().solution();
    }
}
