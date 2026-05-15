class Solution {
    
    int[] data = new int[100001];

    public int solution(int n) {
        return fibo(n);
    }

    private int fibo(int n) {
        
        if (n <= 1) {
            return n;
        }

        if (data[n] != 0) {
            return data[n] % 1234567;
        }

        return data[n] = (fibo(n - 2) + fibo(n - 1)) % 1234567;
    }
}