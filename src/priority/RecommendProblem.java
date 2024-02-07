package priority;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class RecommendProblem {
    static class ProblemMap {
        private TreeMap<Integer, Integer> entireNumbers;// number, level;
        private TreeMap<Integer, TreeSet<Integer>> map; // level, (number1, number2)

        ProblemMap(Map<Integer, Integer> problems) {
            entireNumbers = new TreeMap<>();
            map = new TreeMap<>(Collections.reverseOrder());

            for(Map.Entry<Integer, Integer> problem: problems.entrySet())
                add(problem.getKey(), problem.getValue());
        }

        public int recommend(int type) {
            if(type == 1)
                return map.firstEntry().getValue().first();

            return map.lastEntry().getValue().last();
        }

        public void add(int number, int level) {
            entireNumbers.put(number, level);
            TreeSet<Integer> problemSet = map.getOrDefault(level, new TreeSet<>(Comparator.reverseOrder()));
            problemSet.add(number);
            map.put(level, problemSet);
        }

        public void remove(int number) {
            int level = entireNumbers.get(number);
            TreeSet<Integer> problems = map.get(level);

            problems.remove(number);
            entireNumbers.remove(number);
            if (problems.isEmpty())
                map.remove(level);
        }
    }
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) {
           StringTokenizer st = new StringTokenizer(br.readLine());

           int problemNum = Integer.parseInt(st.nextToken());
           int level = Integer.parseInt(st.nextToken());

           map.put(problemNum, level);
        }

        ProblemMap problemMap = new ProblemMap(map);

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String op = st.nextToken();
            if(op.equals("add")) {
                int num = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());

                problemMap.add(num, level);
            } else if(op.equals("solved")) {
                int num = Integer.parseInt(st.nextToken());
                problemMap.remove(num);
            } else if (op.equals("recommend")) {
                int type = Integer.parseInt(st.nextToken());
                sb.append(problemMap.recommend(type)).append('\n');
            }
        }

        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}
