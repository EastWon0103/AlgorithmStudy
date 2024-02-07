package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// FIXME: 수정
public class Zproblem {
    public static int r;
    public static int c;
    public static int ans;

    public static int dfs(int size, int y, int x, int start) {
        if(size == 2) {
            int[][] directions = {{0,0}, {0,1},{1,0},{1,1}};
            for(int[] direction: directions) {
                int nextY = y+direction[0];
                int nextX = x+direction[1];
                if(nextY==r && nextX==c) {
                    ans = start;
                }
                start++;
            }

            return start;
        }

        size/=2;
        start = dfs(size, y,x, start);
        start = dfs(size, y,x+size,start);
        start = dfs(size, y+size,x,start);
        start = dfs(size, y+size,x+size,start);
        return start;
    }

    public static int getPow(int n) {
        int result = 2;
        for(int i=1;i<n;i++) {
            result *= 2;
        }

        return result;
    }
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()); // y
        c = Integer.parseInt(st.nextToken()); // x

        int pow = getPow(n);

        dfs(pow,0,0,0);
        System.out.println(ans);
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}
