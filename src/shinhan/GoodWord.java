package shinhan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class GoodWord {
    public static boolean isGoodWord(String s) {
        Stack<Character> words = new Stack<>();

        for(Character c :s.toCharArray()) {
            if(!words.isEmpty() && words.peek().equals(c)) {
                words.pop();
                continue;
            }

            words.push(c);
        }

        return words.isEmpty();
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i=0;i<n;i++) {
            if(isGoodWord(br.readLine()))
                count++;
        }

        System.out.println(count);
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}
