package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 플랫폼: 백준
 * 이름: 요세푸스 문제 0 (11866)
 * 분류: 구현, 자료구조, 큐
 */
public class Josephus {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append('<');

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken()) - 1;

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<n;i++) {
            queue.offer(i+1);
        }

        while(!queue.isEmpty()) {
            int index = k%queue.size();
            for(int i=0;i<index;i++) {
                queue.offer(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }
        sb.replace(sb.length()-2,sb.length(),">");

        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new Josephus().solution();
    }
}
