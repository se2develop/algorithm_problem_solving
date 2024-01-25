import java.util.*;

class Solution {
    static int plusUsers = 0, totalSales = 0;
    static int[] discount = {10, 20, 30, 40}; 
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        int[] answer = new int[2];
       
        int[] arr = new int[emoticons.length];
        comb(arr, users, emoticons, 0);
        
        answer[0] = plusUsers;
        answer[1] = totalSales;
        
        return answer;
    }
    
    public void comb(int[] arr, int[][] users, int[] emoticons, int idx) {
        if(idx == emoticons.length) {
            cal(emoticons, users, arr);
            return;
        }
        
        for(int dis : discount) {
            arr[idx] = dis;
            comb(arr, users, emoticons, idx + 1);
        }
    }
    
    public void cal(int[] emoticons, int[][] users, int[] arr) {
        // 이모티콘 플러스 가입자 수
        int emoticonPlus = 0;
        // 이모티콘 매출액
        int total = 0;
        
        for(int[] user : users) {
            // 이모티콘 구매 비용
            int cost = 0;
            // 기준 비율
            int rate = user[0];
            // 기준 가격
            int price = user[1];
            
            for(int i=0; i < arr.length; i++) {
                // 이모티콘 가격을 할인율에 맞게 계산
            
                if(arr[i] >= rate) {
                   cost += emoticons[i] * (100 - arr[i]) / 100;
                }
                // 이모티콘 구매 비용이 가격을 넘어가면
                if(cost >= price) {
                    // 이모티콘 플러스 가입, 구매 취소
                    emoticonPlus += 1;
                    cost = 0;
                    break;
                }
            }
            total += cost;
        }
        
        // 이모티콘 플러스 가입자 수가 많으면
        if(emoticonPlus > plusUsers) {
            // 둘 다 갱신
            plusUsers = emoticonPlus;
            totalSales = total;
        // 같으면
        } else if(emoticonPlus == plusUsers) {
            // 매출액 최대로 갱신
            totalSales = Math.max(totalSales, total);
        }
    }
}