package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
* 플랫폼: 백준
* 이름: 퇴사(14501)
* */
public class Retire {
    static class Counseling {
        int days;
        int price;

        Counseling(String s) {
            StringTokenizer st = new StringTokenizer(s);
            this.days = Integer.parseInt(st.nextToken());
            this.price = Integer.parseInt(st.nextToken());
        }
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Counseling> consultations = new ArrayList<>(n+1);
        consultations.add(null);

        for(int i=1;i<=n;i++)
            consultations.add(new Counseling(br.readLine()));

        int[] price = new int[n+1];

        for(int i=1;i<=n;i++) {
            for(int j=i;j>=1;j--) {
                Counseling counseling = consultations.get(j);
                if(counseling.days+j-1 <= i)
                    price[i] = Math.max(price[i], counseling.price+price[j-1]);
            }
        }

        System.out.println(price[n]);
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}
