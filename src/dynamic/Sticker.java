package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sticker {

    public static int solve(BufferedReader br) throws Exception {
        int n = Integer.parseInt(br.readLine());

        // init
        int[][] stickers = new int[3][n+1];

        StringTokenizer st;
        for(int i=1;i<=2;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++)
                stickers[i][j] = Integer.parseInt(st.nextToken());
        }


        int[][] dp = new int[3][n+1];

        dp[1][1] = stickers[1][1];
        dp[2][1] = stickers[2][1];

        for(int i=2;i<=n;i++) {
            dp[1][i] = Math.max(dp[2][i-2]+stickers[1][i], dp[2][i-1]+stickers[1][i]);
            dp[2][i] = Math.max(dp[1][i-2]+stickers[2][i], dp[1][i-1]+stickers[2][i]);
        }

        return Math.max(dp[1][n], dp[2][n]);
    }

    public static void execute() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfTestCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<numOfTestCase;i++) {
            sb.append(solve(br)).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        execute();
    }
}
