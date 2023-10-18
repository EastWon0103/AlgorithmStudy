package implement;
/**
 * 플랫폼: 프로그래머스
 * 이름: 점프와 순간이동
 */
public class JumpAndTeleport {
    public int solution(int n) {
        int answer = 0;

        while(n>0) {
            if(n%2 == 1) {
                n--;
                answer++;
            }
            n/=2;
        }

        return answer;
    }
}
