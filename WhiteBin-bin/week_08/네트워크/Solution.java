class Solution {
    
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n];
        
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, n, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(int current, int n, int[][] computers) {
        visited[current] = true;
        
        for (int next = 0; next < n; next++) {
            
            if (current == next) {
                continue;
            }
            
            if (computers[current][next] == 1 && !visited[next]) {
                dfs(next, n, computers);
            }
        }
    }
}