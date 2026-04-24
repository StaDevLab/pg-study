class Solution {
    public int solution(int[][] sizes) {

        int maxGaro = 0;
        int maxSero = 0;

        for (int[] s : sizes) {
            int garo = Math.max(s[0], s[1]);
            int sero = Math.min(s[0], s[1]);

            maxGaro = Math.max(garo, maxGaro);
            maxSero = Math.max(sero, maxSero);
        }

        return maxGaro * maxSero;
    }
}