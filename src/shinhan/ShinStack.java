package shinhan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class ShinStack {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String method = st.nextToken();

            if(method.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if(method.equals("size")) {
                sb.append(stack.size()).append('\n');
            } else if(method.equals("top")) {
                if(stack.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(stack.peek()).append('\n');
                }
            } else if(method.equals("empty")) {
                if(stack.isEmpty()) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            } else if(method.equals("pop")) {
                if(stack.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(stack.pop()).append('\n');
                }
            }
        }

        System.out.print(sb);

    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}
