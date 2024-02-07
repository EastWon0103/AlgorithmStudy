package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
* 플랫폼: 백준
* 이름: 2*N 타일링 2(11727)
* */
public class TwoXNTile {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] result = new int[n+22];
        result[1] = 1;
        result[2] = 3;

        for(int i=3;i<=n;i++)
            result[i] = (result[i-2]*2+result[i-1]) % 10007;

        System.out.print(result[n]);
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}
