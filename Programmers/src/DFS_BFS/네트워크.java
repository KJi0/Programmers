package DFS_BFS;

class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i, n, computers);
            }
        }
        
        return answer;
    }
    
    public void dfs(int i, int n, int[][] computers) {
        visited[i] = true;
        
        for (int j = 0; j < n; j++) {
            if (!visited[j] && computers[i][j] == 1)
                dfs(j, n, computers);
        }
    }
}