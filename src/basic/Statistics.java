package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.PriorityQueue;
/**
 * 플랫폼: 백준
 * 이름: 통계학 (2108)
 * 분류: 수학, 구현, 정렬
 */
public class Statistics {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        for(int i=0;i<n;i++) {
            int data = Integer.parseInt(br.readLine());
            sum+=data;
            list.add(data);
            if(map.containsKey(data)) {
                map.put(data,map.get(data)+1);
            } else {
                map.put(data,1);
            }
        }

        Collections.sort(list);

        Comparator<Entry<Integer,Integer>> comparator = new Comparator<>() {
            @Override
            public int compare(Entry<Integer,Integer> o1, Entry<Integer,Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        };

        int max = Collections.max(map.entrySet(),comparator).getValue();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(Entry<Integer, Integer> entry:map.entrySet()) {
            if(entry.getValue().equals(max)) {
                queue.offer(entry.getKey());
            }
        }
        if(queue.size()>1) {
            queue.poll();
        }

        sb.append((int) Math.round((double) sum/list.size())).append('\n');
        sb.append(list.get(n/2)).append('\n');
        sb.append(queue.poll()).append('\n');
        sb.append(list.get(list.size()-1)-list.get(0)).append('\n');


        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Statistics().solution();
    }
}
