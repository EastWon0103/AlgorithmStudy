package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 플랫폼: 백준
 * 이름: 나이 순 정렬 (10814)
 * 분류: 정렬
 */
public class OrderAge {
    static class Member implements Comparable<Member>{
        int age;
        String name;

        private Member(int age,String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public static Member newInstance(int age, String name) {
            return new Member(age,name);
        }

        @Override
        public int compareTo(Member m) {
            return getAge()-m.getAge();
        }
    }
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        StringBuilder sb = new StringBuilder();

        List<Member> members = new ArrayList<>();

        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.valueOf(st.nextToken());
            String name = st.nextToken();

            members.add(Member.newInstance(age,name));
        }

        Collections.sort(members);
        for(Member member: members) {
            sb.append(member.getAge()).append(' ').append(member.getName()).append('\n');
        }
        System.out.print(sb);

    }
    public static void main(String[] args) throws Exception{
        new OrderAge().solution();
    }
}
