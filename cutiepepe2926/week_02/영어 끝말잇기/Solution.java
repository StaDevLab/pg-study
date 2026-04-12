import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {

        // 결과 값
        int[] answer = new int[2];

        // 통과 시
        boolean pass = true;

        // i 값 추출 용
        int turn = 0;

        // 중복체크용
        HashSet<String> check = new HashSet<>();

        for (int i = 0; i < words.length; i++) {

            if (i > 0) { // 앞 뒤 단어 간 연결 체크
                if (words[i-1].charAt(words[i-1].length() - 1) != words[i].charAt(0)) {
                    pass = false;
                    turn = i;
                    break;
                }
            }

            if (check.contains(words[i])) { // 단어 포함 시
                pass = false;
                turn  = i;
                break;
            }
            else { // 단어 미 포함 시
                check.add(words[i]);
            }

        }

        // 탈락자 없는 경우
        if (pass) {
            return answer;
        }
        else { // 탈락자 발생 시
            // n번 사람 변수 및 차례 값
            answer[0] = turn % n + 1;
            answer[1] = turn / n + 1;
            return answer;
        }

    }
}