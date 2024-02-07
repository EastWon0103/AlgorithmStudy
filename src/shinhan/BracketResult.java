package shinhan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BracketResult {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] brackets = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        int total = 0;

        int[] levelSum = new int[brackets.length];
        int level = 0;
        for(char bracket: brackets) {
            if(bracket == '(' || bracket == '[') {
                stack.push(bracket);
                level++;
                continue;
            }

            if(stack.isEmpty()) {
                System.out.print(0);
                return;
            }

            char target = stack.pop();
            if(target=='(' && bracket == ')') {
                if (levelSum[level] == 0 ) {
                    levelSum[--level] += 2;
                } else {
                    levelSum[level-1] += 2*levelSum[level];
                    levelSum[level--] = 0;
                }
            } else if (target=='[' && bracket == ']') {
                if (levelSum[level] == 0 ) {
                    levelSum[--level] += 3;
                } else {
                    levelSum[level-1] += 3*levelSum[level];
                    levelSum[level--] = 0;
                }
            } else {
                System.out.print(0);
                return;
            }
        }

        System.out.print(levelSum[0]);
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}
