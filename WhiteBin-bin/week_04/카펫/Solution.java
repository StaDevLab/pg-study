class Solution {
    public int[] solution(int brown, int yellow) {
        
        int[] arr = new int[2];
        
        for(int i = 3; i < brown + yellow; i++){
            int width = (brown + yellow) / i; 
            if (width >= i){
                if ((i - 2) * (width - 2) == yellow) {
                    arr[0] = width;
                    arr[1] = i;
                    break;
                }
            }
        }
        return arr;
    }
}