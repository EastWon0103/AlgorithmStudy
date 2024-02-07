package basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 플랫폼: 프로그래머스
 * 이름: 롤케이크 자르기
 */
public class RoleCake {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> first = new HashSet<>();
        Map<Integer, Integer> second = new HashMap<>();

        first.add(topping[0]);
        for(int i=1;i<topping.length;i++) {
            second.put(topping[i], second.getOrDefault(topping[i], 0)+1);
        }

        for(int i=1;i<topping.length;i++) {
            first.add(topping[i]);
            second.put(topping[i], second.get(topping[i])-1);

            if(second.get(topping[i])==0) {
                second.remove(topping[i]);
            }

            if(first.size() == second.size()) {
                answer++;
            }
        }

        return answer;
    }
}
