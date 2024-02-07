package hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class InCompany {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeMap<String, Integer> companyLog = new TreeMap<>();

        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String worker = st.nextToken();
            String log = st.nextToken();

            if(log.equals("enter")) {
                companyLog.put(worker, 1);
            } else {
                companyLog.remove(worker);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String worker : companyLog.descendingKeySet())
            sb.append(worker).append('\n');

        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        solution();
    }
}
