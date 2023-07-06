package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackSequence {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1;i<=n;i++) {
            queue.offer(i);
        }

        for(int i=0;i<n;i++) {
            int data = Integer.parseInt(br.readLine());

            while(!queue.isEmpty() && queue.peek()<=data) {
                stack.push(queue.poll());
                sb.append('+').append('\n');
            }

            if(stack.pop() != data) {
                System.out.print("NO");
                return;
            }
            sb.append('-').append('\n');
        }

        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new StackSequence().solution();
    }
}
