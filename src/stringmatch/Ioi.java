package stringmatch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 플랫폼: 백준
 * 문제: IOI(5525)
 */
public class Ioi {
    public static String getP(int num) {
        StringBuilder p = new StringBuilder("IOI");
        for(int i=1;i<num;i++) {
            p.append("OI");
        }

        return p.toString();
    }
    public static boolean isMatched(char[] s, char[] p, int i, int j) {
        while(i<s.length && s[i++] == p[j++]) {
            if(p.length == j)
                return true;
        }

        return false;
    }

    public static void solution() throws Exception {
        // FIXME: 여기 고치기(배점 50점만 맞음)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] s  = br.readLine().toCharArray();
        char[] p = getP(n).toCharArray();

        int count = 0;

        int i=0;
        int j=0;
        boolean isMatched = false;
        while(i<=m-p.length) {
            if(s[i]==p[j]) {
                j++;
                if(p.length == j) {
                    count++;
                    j-=2;
                }
            }
            i++;
        }

        System.out.print(count);
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
