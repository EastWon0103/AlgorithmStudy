package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 플랫폼: 백준
 * 이름: 균형잡힌 세상 (4949)
 * 분류: 문자열, 스택
 */
public class BalanceWorld {
    private boolean isBalanced(String context) {
        String[] arr = context.split("");

        Stack<String> stack = new Stack<String>();
        for(int i=0;i<arr.length;i++) {
            String data = arr[i];
            if(data.equals(".")) {
                break;
            }


            if(data.equals(")")) {
                if(stack.isEmpty()) {
                    return false;
                }
                if(!stack.pop().equals("(")) {
                    return false;
                }
            } else if(data.equals("]")) {
                if(stack.isEmpty()) {
                    return false;
                }
                if(!stack.pop().equals("[")) {
                    return false;
                }
            } else if(data.equals("(") || data.equals("[")){
                stack.push(data);
            }

        }

        if(!stack.isEmpty()) {
            return false;
        }

        return true;
    }
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String context = br.readLine();
            if(context.equals(".")) {
                break;
            }

            if(isBalanced(context)) {
                sb.append("yes").append('\n');
            } else {
                sb.append("no").append('\n');
            }

        }

        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new BalanceWorld().solution();
    }
}
