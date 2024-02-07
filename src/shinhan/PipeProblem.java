package shinhan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class PipeProblem {
    static class Pipe {
        int start;
        int end;

        Pipe(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int splitPipe(Pipe pipe, List<Integer> lasers) {
        int count = 1;
        for(Integer laser: lasers) {
            if(pipe.start < laser && laser < pipe.end)
                count++;
        }

        return count;
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] brackets = br.readLine().toCharArray();

        Stack<Integer> stack = new Stack<>();

        List<Integer> lasers = new ArrayList<>();
        Queue<Pipe> pipes = new LinkedList<>();

        int i=0;
        while(i<brackets.length) {
            if(brackets[i] == '(') {
                if(i+1<brackets.length && brackets[i+1] == ')') {
                    lasers.add(i);
                    i+=2;
                } else {
                    stack.push(i);
                    i+=1;
                }
                continue;
            }

            int start = stack.pop();
            pipes.offer(new Pipe(start, i++));
        }

        int splitPipes = 0;
        while(!pipes.isEmpty())
            splitPipes += splitPipe(pipes.poll(), lasers);

        System.out.print(splitPipes);
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}
