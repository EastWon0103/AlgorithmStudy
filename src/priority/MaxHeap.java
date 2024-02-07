package priority;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/*
* 플랫폼: 백준
* 이름: 최대 힙(11279)
* */
public class MaxHeap {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            int num = Integer.parseInt(br.readLine());

            if(num == 0 && que.isEmpty())
                sb.append(0).append('\n');
            else if(num==0)
                sb.append(que.poll()).append('\n');
            else
                que.offer(num);
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
