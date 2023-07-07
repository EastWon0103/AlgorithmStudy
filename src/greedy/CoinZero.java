package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 플랫폼: 백준
 * 이름: 동전 0 (11047)
 * 분류: 그리디
 */
public class CoinZero {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> coinList = new ArrayList<>();
        int result = 0;

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++) {
            coinList.add(Integer.parseInt(br.readLine()));
        }

        for(int i=n-1;i>=0;i--) {
            int coin = coinList.get(i);
            if(coin <= k) {
                result += k/coin;
                k = k%coin;
            }
        }

        System.out.print(result);

    }
    public static void main(String[] args) throws Exception{
        new CoinZero().solution();
    }
}
