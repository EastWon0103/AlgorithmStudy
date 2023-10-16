package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Fibo {
    static int[] zero = new int[41];
    static int[] one = new int[41];
    static int[] fiboResult = new int[41];
    public static int fibo(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if(fiboResult[n] != 0) {
            return fiboResult[n];
        }

        fiboResult[n] = fibo(n-1) + fibo(n-2);
        zero[n] = zero[n-1] + zero[n-2];
        one[n] = one[n-1] + one[n-2];
        return fiboResult[n];
    }


    public static void solution() throws Exception {
        fiboResult[0] = 0;
        fiboResult[1] = 1;
        zero[0] = 1;
        zero[1] = 0;
        one[0] = 0;
        one[1] = 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) {
            int k = Integer.parseInt(br.readLine());
            if(fiboResult[k] != 0) {
                sb.append(zero[k]).append(" ").append(one[k]).append("\n");
            } else {
                fibo(k);
                sb.append(zero[k]).append(" ").append(one[k]).append("\n");
            }
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Fibo().solution();
    }
}
