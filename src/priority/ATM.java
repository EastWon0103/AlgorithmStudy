package priority;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * 플랫폼: 백준
 * 이름: ATM (11399)
 */
public class ATM {
    public static void solution() throws Exception {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        int sum = 0;
        int answer = 0;
        while(!queue.isEmpty()) {
            sum += queue.poll();
            answer += sum;
        }

        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}
