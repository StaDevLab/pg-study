import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {

        int[] answer = new int[2];

        for (int i = 1; i <= yellow; i++) {

            if (yellow % i == 0) {
                int x = i;
                int y = yellow / i;

                if (2 * (x + y) + 4 == brown) {
                    if (x >= y) {
                        answer[0] = x + 2;
                        answer[1] = y + 2;
                    }
                }
            }
        }

        return answer;

    }
}

// 8, 1 // 10, 2 // 12, 3 // 14, 4 // 16, 5 // 18, 6 // 20, 7 // 22, 8 // 24, 9 // 26, 10
// 3, 3 // 4, 3 // 5, 3 //  6, 3 // 7, 3  // 8, 3   //  9, 3 // 10, 3 // 11, 3 //  12, 3

// (y1 + 2) * 2 + (y2) * 2 = brwon -> 2 * (y1 + y2) + 4
// (1,2) (2,1) -> (6+4 = 10) (8 + 8 = 16)


// yellow의 크기에 따라서 brown의 배치가 달라진다
// yellow를 조져서 brown에 해당하는 값을 찾아야한다.
// yellow = 24
// 1, 24 // 2, 12 // 3, 8 // 4, 6

// yellow 쪼갠 값 y1, y2에 대해서 2 * (y1 + y2) + 4 = brown 를 만족하는 값을 찾아야 한다.
// 그리고 나온 값에 대해서 (y1 >= y2) 여야하고 최종값인 [ y1 + 2, y2 + 2 ]가 곧 정답