package hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


/*
 * 플랫폼: 백준
 * 이름: 비밀번호 찾기 (17219)
 * */
public class FindPassword {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        Map<String, String> passwordStore = new HashMap<>(n);
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            passwordStore.put(st.nextToken(), st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++)
            sb.append(passwordStore.get(br.readLine())).append('\n');

        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}
