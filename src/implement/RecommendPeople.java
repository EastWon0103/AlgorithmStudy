package implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class RecommendPeople {

    static class Vote implements Comparable<Vote>{
        int numOfVote = 1;
        int latestVote;
        public Vote(int voteTime) {
            this.latestVote = voteTime;
        }

        public void goVote(int voteTime) {
            this.numOfVote++;
            this.latestVote = voteTime;
        }

        @Override
        public int compareTo(Vote v) {
            if(this.numOfVote == v.numOfVote) {
                return v.latestVote-this.latestVote;
            }

            return v.numOfVote - this.numOfVote;
        }
    }

    public static void removeVote(Map<Integer, Vote> frame) {
        boolean firstFlag = true;
        Map.Entry<Integer, Vote> target = null;
        for(Map.Entry<Integer, Vote> entry :frame.entrySet()) {
            if(firstFlag) {
                target = entry;
                firstFlag = false;
                continue;
            }

            if(target.getValue().compareTo(entry.getValue()) <= 0) {
               target = entry;
            }
        }

        frame.remove(target.getKey());
    }
    public static void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int totalRecommend = Integer.parseInt(br.readLine());


        Map<Integer, Vote> frame = new HashMap<>(n);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<totalRecommend;i++) {
            int pickNumber = Integer.parseInt(st.nextToken());

            if(frame.containsKey(pickNumber)) {
                frame.get(pickNumber).goVote(i);
                continue;
            }

            if(frame.size() != n) {
                frame.put(pickNumber, new Vote(i));
                continue;
            }

            removeVote(frame);
            frame.put(pickNumber, new Vote(i));
        }

        List<Integer> keys = new ArrayList<>(frame.keySet());

        keys.sort((o1, o2) -> frame.get(o1).compareTo(frame.get(o2)));

        StringBuilder sb = new StringBuilder();
        for(Integer pickNumber:keys) {
            sb.append(pickNumber).append(" ");
        }

        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new RecommendPeople().solution();
    }
}
