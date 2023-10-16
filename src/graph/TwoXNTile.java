package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TwoXNTile {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] result = new int[1001];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;


        for(int i=3;i<=n;i++) {
            result[i] = (result[i-1] + result[i-2])%10007;
        }

        System.out.print(result[n]);
    }

    public static void main(String[] args) throws Exception {
        new TwoXNTile().solution();
    }
}
