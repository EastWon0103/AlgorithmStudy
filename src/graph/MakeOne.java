package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 플랫폼: 백준
 * 이름: 1로 만들기 (1463)
 */
public class MakeOne {
    public static int getResult(int n) {
        int[] arr = new int[n+1];
        arr[1] = 0;

        for(int i=1;i<n;i++) {
            if(i*3 <= n) {
                if(arr[i*3] != 0) {
                    arr[i*3] = Math.min(arr[i * 3], arr[i] + 1);
                } else {
                    arr[i * 3] = arr[i] + 1;
                }
            }

            if(i*2 <= n) {
                if(arr[i*2] != 0) {
                    arr[i*2] = Math.min(arr[i*2], arr[i]+1);
                } else {
                    arr[i*2] = arr[i]+1;
                }
            }

            if(i+1 <= n) {
                if(arr[i+1] != 0) {
                    arr[i+1] = Math.min(arr[i+1], arr[i]+1);
                } else {
                    arr[i+1] = arr[i]+1;
                }
            }
        }

        return arr[n];
    }
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(getResult(n));
    }
    public static void main(String[] args) throws Exception {
        new MakeOne().solution();
    }
}
