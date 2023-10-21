package dynamic;

/**
 * 플랫폼: 프로그래머스
 * 이름: 피보나치수
 */
public class ForFibo {
    public int solution(int n) {

        int[] ans = new int[n+1];
        ans[0] = 0;
        ans[1] = 1;

        for(int i=2;i<=n;i++) {
            ans[i] = (ans[i-1]+ans[i-2])%1234567;
        }


        return ans[n];
    }
}
