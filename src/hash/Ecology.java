package hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * 플랫폼: 백준
 * 이름: 생태학(4358)
 */
public class Ecology {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new TreeMap<>();

        int count = 0;
        String line= br.readLine();
        while(count++ < 30 && line!=null) {

            line = br.readLine();
        }

        System.out.print(count);

    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}