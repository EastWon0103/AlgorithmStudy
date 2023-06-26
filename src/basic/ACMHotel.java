package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 플랫폼: 백준
 * 이름: ACM 호텔 (10250)
 * 분류: 수학
 */
public class ACMHotel {
    int height;
    int width;
    int customerN;
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            height = Integer.parseInt(st.nextToken());
            width = Integer.parseInt(st.nextToken());
            customerN = Integer.parseInt(st.nextToken());

            int floor = customerN%height;
            if(floor == 0) {
                floor = height;
            }

            int roomNumber = customerN/height+1+100*floor;
            if(customerN%height == 0) {
                roomNumber -= 1;
            }

            sb.append(roomNumber).append('\n');
        }



        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new ACMHotel().solution();
    }
}
