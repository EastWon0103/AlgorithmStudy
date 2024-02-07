package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 플랫폼: 백준
* 이름: 카드 구매하기 (11052)
* */
public class PurchaseCard {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cardpacks = new int[n+1];
        for(int i=1;i<=n;i++)
            cardpacks[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[n+1];
        dp[1] = cardpacks[1];

        for(int i=2;i<=n;i++) {
            int max = -1;
            for(int j=1;j<=i;j++)
                max = Math.max(max, dp[i-j]+cardpacks[j]);

            dp[i] = max;
        }

        System.out.println(dp[n]);
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
