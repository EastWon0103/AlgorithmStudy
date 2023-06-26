package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
/**
 * 플랫폼: 백준
 * 이름: 스택 (10828)
 * 분류: 스택
 */
public class StackProblem {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Stack<String> stack = new Stack<String>();

        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();

            if(operation.equals("push")) {
                stack.push(st.nextToken());
            } else if(operation.equals("top")) {
                if(stack.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(stack.peek()).append('\n');
                }
            } else if(operation.equals("size")) {
                sb.append(stack.size()).append('\n');
            } else if(operation.equals("empty")) {
                if(stack.isEmpty()) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            } else if(operation.equals("pop")) {
                if(stack.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(stack.pop()).append('\n');
                }
            }
        }

        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new StackProblem().solution();
    }
}
