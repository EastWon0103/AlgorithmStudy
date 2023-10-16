package graph;
public class DFSExample {

    public static void recursionDFS(int[][] matrix, boolean[] visited, int nodeIndex) {
        System.out.print(nodeIndex + " ");
        visited[nodeIndex] = true;
        for(int i=1;i<matrix.length;i++) {
            if(!visited[i] && matrix[nodeIndex][i]==1) {
                recursionDFS(matrix, visited, i);
            }
        }
    }
    public void stackDFS() {

    }
    public static void main(String[] args) {
        int[][] edgeArr = {
                {1,2},
                {1,3},
                {1,4},
                {2,5},
                {3,5},
                {5,7},
                {3,6}
        };
        int numberOfNode = 7;
        int[][] matrix = new int[numberOfNode+1][numberOfNode+1];
        for(int i=0;i<edgeArr.length;i++) {
            int nodeA = edgeArr[i][0];
            int nodeB = edgeArr[i][1];

            matrix[nodeA][nodeB] = 1;
            matrix[nodeB][nodeA] = 1; // 양방향 그래프
        }

        for(int i=1;i<=numberOfNode;i++) {
            for(int j=1;j<=numberOfNode;j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        


        recursionDFS(matrix, new boolean[numberOfNode+1], 1);
    }
}