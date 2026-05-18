class Solution {
    public boolean solution(int x) {

        String sx = String.valueOf(x);

        int div = 0;

        for (int i = 0; i < sx.length(); i++) {
            div = div + (sx.charAt(i) - '0');
        }

        return (x % div == 0) ? true : false;

    }
}