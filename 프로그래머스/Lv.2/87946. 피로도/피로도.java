import java.util.*;

class Solution {
    // 탐험할 수 있는 최대 던전 수
    public int ans = -1;
    
    public int solution(int k, int[][] dungeons) {
        
        // 방문 정보 저장
        boolean[] visited = new boolean[dungeons.length];
        // 현재 남은 피로도
        int current = k;
        
        // 각 탐험에 방문하는 던전 수
        int tmp = 0;
        
        find(dungeons, visited, current, tmp);
        
        return ans;
    }
    
    public void find(int[][] dungeons, boolean[] visited, int current, int tmp) {
        // 다음 던전 탐험 가능 여부
        boolean flag = false;
        
        // 완전탐색, 던전 개수만큼
        for(int i = 0; i < dungeons.length; i++) {
            // 아직 방문안했고, 최소 필요 피로도 <= 현재 남은 피로도
            if(!visited[i] && dungeons[i][0] <= current) {
                // 방문 처리
                visited[i] = true;
                // 현재 남은 피로도 - 소모 피로도, 방문한 던전 개수 + 1
                find(dungeons, visited, current-dungeons[i][1], tmp + 1);
                visited[i] = false;
                flag = true;
            }
            if(!flag && tmp > ans)
                ans = tmp;
        } // 완탐 for문
    } // find
} // Solution