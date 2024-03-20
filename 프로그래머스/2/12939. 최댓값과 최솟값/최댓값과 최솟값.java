class Solution {
    public String solution(String s) {
        String answer = "";
        
        // 문자열 공백으로 잘라서 배열로 저장
        String[] numList = s.split(" ");
        // min, max 초기값 지정
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i < numList.length; i++) {
            int number = Integer.parseInt(numList[i]);
            
            min = Math.min(min, number);
            max = Math.max(max, number);
        }
        
        answer = min + " " + max;
        
        return answer;
    }
}