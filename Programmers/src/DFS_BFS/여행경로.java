package DFS_BFS;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    boolean[] visited;
    ArrayList<String> list;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        list = new ArrayList<>();
        
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(list);
        answer = list.get(0).split(" ");
        
        return answer;
    }
    
    public void dfs(int depth, String start, String path, String[][] tickets) {
        if (depth == tickets.length) {
            list.add(path);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && start.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(depth + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}