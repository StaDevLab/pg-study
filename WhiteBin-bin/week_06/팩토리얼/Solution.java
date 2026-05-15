class Solution {
    public int solution(int n) {
        
        int answer = 0;
        int num = 1;
        int k = 1;
        
        while (true) {
            num *= k;
            if (num > n) {
                answer = k;
                break;
            }
            k++;
        }
        return answer - 1;
    }
}