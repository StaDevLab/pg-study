class Solution {
    public int solution(int n, long l, long r) {
        int count = 0;

        for (long i = l; i <= r; i++) {
            if (isOne(n, i)) {
                count++;
            }
        }

        return count;
    }

    private boolean isOne(int n, long idx) {
        
        if (n == 0) {
            return true;
        }

        long len = 1;
        for (int i = 0; i < n - 1; i++) {
            len *= 5;
        }

        long section = (idx - 1) / len;

        if (section == 2) {
            return false;
        }

        return isOne(n - 1, (idx - 1) % len + 1);
    }
}