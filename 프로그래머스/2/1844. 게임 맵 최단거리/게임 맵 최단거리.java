import java.io.*;
import java.util.*;

class Solution {
    public static int answer = -1;
    public static boolean[][] visited;
    // 상 하 좌 우 
    public static int[] dr= {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    
     class Node {
        int row;
        int col;
        int count;
        
        public Node(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
    
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        
        bfs(0, 0, maps);
        
        return answer;
    }
    
    public void bfs(int row, int col, int[][] maps) {
        Queue<Node> queue = new LinkedList<>();

        // 초기 출발 상태
        queue.add(new Node(0, 0, 1));
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            
            // 우측 하단인 (n, m) 위치에 도착
            if (cur.row == maps.length - 1 && cur.col == maps[0].length - 1) {
                answer = cur.count;
                return;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = cur.row + dr[i];
                int nc = cur.col + dc[i];
                
                if (canMove(nr, nc, maps)) {
                    visited[nr][nc] = true;
                    queue.add(new Node(nr, nc, cur.count + 1));
                }
            }
        }
    }
        
    public boolean canMove(int row, int col, int[][] maps) {
        return row >= 0 && row < visited.length && col >= 0 && col < visited[0].length
                    && !visited[row][col] && maps[row][col] != 0;
    }
}