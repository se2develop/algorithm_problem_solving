import java.util.*;

class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n]; // 방문 여부 저장
        
        // 방문하지 않은 컴퓨터인 경우 dfs 탐색 후 네트워크의 개수를 증가시킴
        for (int i=0; i<n; i++){
            if (!visited[i]){
                dfs(i, computers, visited);
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(int node, int[][] computers, boolean[] visited){
        visited[node] = true;
        
        for (int i=0; i<computers[node].length; i++){
            if (computers[node][i] == 1 && !visited[i]){
                // 현재 노드와 연결된 컴퓨터이면서 방문하지 않은 경우
                
                dfs(i, computers, visited); // 재귀적으로 dfs 탐색
            }
        }  
    }
}
