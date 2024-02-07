package hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
* 플랫폼: 백준
* 이름: 듣보잡 (1764)
* */
public class UselessGuy {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> hear = new HashMap<>();
        for (int i=0;i<n;i++)
            hear.put(br.readLine(), 0);

        List<String> see = new ArrayList<>();
        for (int i=0;i<m;i++)
            see.add(br.readLine());


        PriorityQueue<String> answers = new PriorityQueue<>();

        for(String key: see) {
            if (hear.containsKey(key))
                answers.offer(key);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answers.size()).append('\n');
        while (!answers.isEmpty())
            sb.append(answers.poll()).append('\n');

        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}
