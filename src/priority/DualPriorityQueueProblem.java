package priority;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class DualPriorityQueueProblem {
    static class DualPriorityQueue {
        private static TreeMap<Integer, Integer> map;
        DualPriorityQueue() {
            map = new TreeMap<>();
        }
        void operation(String s) {
            StringTokenizer st = new StringTokenizer(s);
            String op = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if(op.equals("I")) {
                input(num);
                return;
            }

            if(map.isEmpty())
                return;

            if(num == -1)
                deleteMin();
            else if (num == 1)
                deleteMax();
        }

        public int getMax() {
            return map.lastKey();
        }

        public int getMin() {
            return map.firstKey();
        }

        private static void input(int i) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        private static void deleteMax() {
            if(map.get(map.lastKey()) > 1)
                map.put(map.lastKey(), map.get(map.lastKey())-1);
            else
                map.remove(map.lastKey());
        }

        private static void deleteMin() {
            if(map.get(map.firstKey()) > 1)
                map.put(map.firstKey(), map.get(map.firstKey())-1);
            else
                map.remove(map.firstKey());
        }

        public boolean isEmpty() {
            return map.isEmpty();
        }
    }

    public static StringBuilder operationPriorityQueue(BufferedReader br) throws Exception {
        int n = Integer.parseInt(br.readLine());
        DualPriorityQueue que = new DualPriorityQueue();

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            que.operation(br.readLine());
        }

        if(que.isEmpty())
            return sb.append("EMPTY\n");

        return sb.append(que.getMax()).append(' ').append(que.getMin()).append('\n');
    }
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<n;i++) {
            sb.append(operationPriorityQueue(br));
        }

        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}
