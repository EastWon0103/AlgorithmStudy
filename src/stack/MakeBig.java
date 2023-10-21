package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 플랫폼: 백준
 * 이름: 크게 만들기 (2812)
 */
public class MakeBig {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        String seq = br.readLine();

        int index = 0;
        for(int i=0;i<n-k;i++) {
            int max = 0;
            for(int j=index;j<=i+k;j++) {
                if(max<seq.charAt(j)-'0') {
                    max = seq.charAt(j)-'0';
                    index = j+1;
                }
            }
            sb.append(max);
        }


        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}
