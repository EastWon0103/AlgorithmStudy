package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 플랫폼: 백준
 * 이름: 회의실 배정 (1931)
 */
public class AssignMeetingRoom {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Integer[][] meetingRooms = new Integer[n][2];
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetingRooms[i][0] = Integer.parseInt(st.nextToken());
            meetingRooms[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meetingRooms, (o1, o2) -> {
            if(o2[1] == o1[1]) {
                return o1[0] - o2[0];
            }
            return o1[1]-o2[1];
        });

        int lastIndex = -1;
        int count = 0;
        for(Integer[] meetingRoom : meetingRooms) {
            if(meetingRoom[0] >= lastIndex) {
                lastIndex = meetingRoom[1];
                count++;
            }
        }

        System.out.println(count);
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}
