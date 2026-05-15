class Solution {
    public int solution(int a, int b, int n) {
        return getCoke(a, b, n);
    }
    
    private int getCoke(int a, int b, int empty) {
        
        if (empty < a) {
            return 0;
        }
        
        int receive = (empty / a) * b;
        int remain = empty % a;
        
        return receive + getCoke(a, b, remain + receive);
    }
}