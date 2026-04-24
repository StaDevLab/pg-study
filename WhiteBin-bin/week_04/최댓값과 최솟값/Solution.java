class Solution {
    public String solution(String s) {
        
        String[] sArr = s.split(" ");

        int max = Integer.parseInt(sArr[0]);
        int min = Integer.parseInt(sArr[0]);

        for (String str : sArr) {
            int temp = Integer.parseInt(str);

            if (min > temp) {
                min = temp;
            }

            if (max < temp) {
                max = temp;
            }
        }

        return min + " " + max;
    }
}