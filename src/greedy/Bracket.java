package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
* 플랫폼: 백준
* 이름: 잃어버린 괄호(1541)
* */
public class Bracket {
    public static int parseInt(String s) {
        boolean isZeroNoCount = true;
        StringBuilder sb = new StringBuilder();
        for(Character c: s.toCharArray()) {
            if (c.equals('0') && isZeroNoCount)
                continue;

            sb.append(c);
            isZeroNoCount = false;
        }
        return Integer.parseInt(sb.toString());
    }

    private static int sum(String s) {
        int sum = 0;
        for(String num:s.split("\\+"))
            sum += parseInt(num);

        return sum;
    }
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();

        Queue<Integer> numbers = new LinkedList<>();
        for(String s:expression.split("-"))
            numbers.offer(sum(s));

        int answer = 0;
        if (expression.charAt(0) != '-')
            answer += numbers.poll();

        while (!numbers.isEmpty())
            answer -= numbers.poll();

        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
