package implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 플랫폼: 백준
 * 이름: AC (5430)
 */

// 아직 안품
public class ACLanguage {
    private static void deleteOperation(Deque<Integer> deque, boolean isReverse) {
        if(!isReverse) {
            deque.pollFirst();
            return;
        }

        deque.pollLast();
    }
    private static String convertDequeToString(Deque<Integer> deque, boolean isReverse) {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        if(!isReverse) {
            while (!deque.isEmpty()) {
                sb.append(deque.pollFirst()).append(",");
            }
        } else {
            while (!deque.isEmpty()) {
                sb.append(deque.pollLast()).append(",");
            }
        }

        sb.delete(sb.length()-1, sb.length());
        sb.append("]");

        return sb.toString();
    }
    private static String getResult(String[] operations, Deque<Integer> deque) {
        boolean isReverse = false;
        for(String operation: operations) {
            if(operation.equals("R")) {
                isReverse = !isReverse;
            } else if(operation.equals("D")) {
                // Delete
                if(deque.isEmpty()) {
                    return "error";
                }

                deleteOperation(deque,isReverse);
            }
        }

        return convertDequeToString(deque,isReverse);
    }
    public static Deque<Integer> makeDeque(String s) {
        s = s.substring(1,s.length()-1);

        String[] elements = s.split(",");
        Deque<Integer> deque = new ArrayDeque<>();

        for(String e : elements) {
            if(e.equals(""))
                break;
            deque.addLast(Integer.parseInt(e));
        }

        return deque;
    }
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            String[] operations = br.readLine().split("");
            int size = Integer.parseInt(br.readLine());
            Deque<Integer> deque = makeDeque(br.readLine());
            sb.append(getResult(operations, deque)).append('\n');
        }

        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}
