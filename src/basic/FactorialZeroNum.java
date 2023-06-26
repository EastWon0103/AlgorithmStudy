package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 플랫폼: 백준
 * 이름: 팩토리얼 0의 개수 (1676)
 * 분류: 수학
 */
public class FactorialZeroNum {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        while(n>=5) {
            result += n/5;
            n /= 5;
        }

        System.out.print(result);
        br.close();
    }
    public static void main(String[] args) throws Exception{
        new FactorialZeroNum().solution();
    }
}
