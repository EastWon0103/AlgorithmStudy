import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    /**
     * 해당 입력값을 출력 하는 방식
     * 3
     * 1 5
     * 3 10 11 12
     * 5 1 2 3 4 5
     * */
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            for(int j=0;j<m;j++) {
                int data = Integer.parseInt(st.nextToken());
                bw.write(String.valueOf(data));
                bw.newLine();
                // 혹은 이렇게도 처리 가능하다
                // StringBuilder sb = new StringBuilder();
                // sb.append(data).append('\n');
            }
        }

        br.close();
        bw.close(); // 비우기만 할꺼면 flush
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}