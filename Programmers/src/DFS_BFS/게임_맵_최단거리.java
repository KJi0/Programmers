package DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int dx[] = {1, 0, -1, 0};
    int dy[] = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        int visited[][] = new int[maps.length][maps[0].length];
        
        bfs(maps, visited);
        answer = visited[maps.length - 1][maps[0].length - 1];
        
        if (answer == 0) answer = -1;
        
        return answer;
    }
    
    public void bfs(int[][] maps, int[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = 1;
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            
            for (int i = 0; i < 4; i++) {
                int nX = x + dx[i];
                int nY = y + dy[i];
                
                if (nX < 0 || nX > maps.length - 1 || nY < 0 || nY > maps[0].length - 1) continue;
                
                if (visited[nX][nY] == 0 && maps[nX][nY] == 1) {
                    visited[nX][nY] = visited[x][y] + 1;
                    q.add(new int[]{nX, nY});
                }
            }
        }
    }
}