package DP;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] = triangle[i - 1][0] + triangle[i][0];
            triangle[i][i] = triangle[i - 1][i - 1] + triangle[i][i];
            
            for (int j = 1; j < i; j++) {
                triangle[i][j] = Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]) + triangle[i][j];
                answer = Math.max(answer, triangle[i][j]);
            }
        }
        
        return answer;
    }
}