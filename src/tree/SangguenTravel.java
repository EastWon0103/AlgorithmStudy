package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 플랫폼: 백준
* 이름: 상근이의 여행(9372)
* */
public class SangguenTravel {

    /*
    * 문제의 가장 큰 키포인트: 가장 적은 종류의 비행기 -> 비행기를 몇 번 타도 종류가 같으면 상관없음
    * 결국 구하고자 하는 것은 MST(최소신장트리)
    * 하지만 가중치가 존재하지 않기 때문에 MST의 edge개수가 답임 (N-1)
    * */
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfTestCase = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<numOfTestCase;i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            for(int j=0;j<m;j++)
                br.readLine();

            sb.append(n-1).append('\n');
        }

        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}
