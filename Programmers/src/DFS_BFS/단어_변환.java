package DFS_BFS;

class Solution {
    int answer = 0;
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }
    
    public void dfs(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) {
            answer = cnt;
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (visited[i]) { continue; }
            
            int num = 0;
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    num++;
                }
            }
            
            if (num == begin.length() - 1) {
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }
    }
}