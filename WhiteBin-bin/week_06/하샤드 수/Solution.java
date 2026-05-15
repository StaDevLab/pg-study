class Solution {
    public boolean solution(int x) {
        int sum = digitSum(x);
        return x % sum == 0;
    }

    private int digitSum(int n) {
        if (n == 0) {
            return 0;
        }

        return n % 10 + digitSum(n / 10);
    }
}