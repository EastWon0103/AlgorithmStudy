package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 플랫폼: 백준
 * 이름: 마인크래프트 (18111)
 * 분류: 구현, 브루트포스
 */
public class Minecraft {
    final int MAX_BLOCKS = 256;

    public int[][] deepCopy(int[][] arr) {
        int[][] newArr = new int[arr.length][arr[0].length];
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[0].length;j++) {
                newArr[i][j] = arr[i][j];
            }
        }

        return newArr;
    }
    public int getWorkTime(int[][] arr, int level, int inventory) {
        int[][] earth = deepCopy(arr);
        int n = earth.length;
        int m = earth[0].length;
        int time = 0;

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                int height = earth[i][j];

                if(level < height) {
                    time += (height-level)*2;
                    inventory += (height-level);
                } else if (level > height) {
                    time += level-height;
                    inventory -= (level-height);
                }

                earth[i][j] = level;
            }
        }

        if(inventory<0) {
            return Integer.MAX_VALUE;
        }

        return time;
    }
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] earth = new int[n][m];

        int MAX_HEIGHT = -1;
        int MIN_HEIGHT = Integer.MAX_VALUE;

        for(int i=0;i<n;i++) {
            StringTokenizer blockTokens = new StringTokenizer(br.readLine());
            for (int j=0;j<m;j++) {
                int data = Integer.parseInt(blockTokens.nextToken());
                if(data > MAX_HEIGHT && MAX_BLOCKS >= data) {
                    MAX_HEIGHT = data;
                }

                if(data < MIN_HEIGHT) {
                    MIN_HEIGHT = data;
                }

                earth[i][j] = data;
            }
        }

        int MIN_TIME = Integer.MAX_VALUE;
        int earth_height = 0;

        for(int level=MIN_HEIGHT;level<=MAX_HEIGHT;level++) {
            int time = getWorkTime(earth, level, b);
            if(time < MIN_TIME) {
                MIN_TIME = time;
                earth_height = level;
            } else if(time == MIN_TIME && earth_height<level) {
                earth_height = level;
            }
        }

        sb.append(MIN_TIME).append(' ').append(earth_height);

        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new Minecraft().solution();
    }
}
