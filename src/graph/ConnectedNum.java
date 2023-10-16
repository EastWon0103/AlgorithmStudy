package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ConnectedNum {
    static class UnionFind {
        int[] set;

        UnionFind(int n) {
            this.set = new int[n+1];
            for(int i=1;i<=n;i++) {
                set[i] = i;
            }

        }

        public int find(int p) {
            while(set[p] != p)
                p = set[p];
            return p;
        }

        public void union(int p1, int p2) {
            int i = find(p1);
            int j = find(p2);
            if(i!=j) {
                set[i] = j;
            }
        }

        boolean isSameSet(int p1, int p2) {
            return find(p1) == find(p2);
        }

        public int getRootNum() {
            int count = 0;
            for(int i=1;i<set.length;i++) {
                if(i == set[i]) {
                    count ++;
                }
            }

            return count;
        }
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeN = Integer.parseInt(st.nextToken());
        int edgeN = Integer.parseInt(st.nextToken());
        UnionFind unionFindSet = new UnionFind(nodeN);

        for(int i=0;i<edgeN;i++) {
            st = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());

            unionFindSet.union(e1, e2);
        }

        System.out.print(unionFindSet.getRootNum());
    }
    public static void main(String[] args) throws Exception {
        new ConnectedNum().solution();
    }
}
