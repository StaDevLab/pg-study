import java.util.*;

class Solution {

    public int[] solution(String today, String[] terms, String[] privacies) {

        // 핵심
        // 약관마다 유효기간 있고, 지나면 파기
        // 모든 달은 28일까지 존재
        // 수집 일 기준 보관은 유효기간-1일 즉, 수집일 + 유효기간 = 파기

        // 약관 저장용
        HashMap<Character, Integer> rule = new HashMap<>();

        // 약관 저장
        for (String t : terms) {
            String[] temp = t.split(" ");
            rule.put(temp[0].charAt(0), Integer.parseInt(temp[1]));
        }

        // 파기 인덱스 저장용
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) { // 순회 시작

            int t = rule.get(privacies[i].charAt(privacies[i].length() - 1)); // 개인정보 정책 추출

            if (calcDate(today, privacies[i].substring(0,10), t)) { // 파기 여부 결정
                temp.add(i+1);
            }

        }

        int[] answer = new int[temp.size()];
        int idx = 0;
        for (int t : temp) {
            answer[idx++] = t;
        }

        return answer;

    }

    // 날짜 추가 함수
    private boolean calcDate(String today, String target, int num) {

        int year = Integer.parseInt(target.substring(0,4));
        int month = Integer.parseInt(target.substring(5,7)) + num;
        int day = Integer.parseInt(target.substring(8,10));

        // 파기 날짜 계산
        int total = (year * 12 * 28) + (month * 28) + day;

        int tyear = Integer.parseInt(today.substring(0,4));
        int tmonth = Integer.parseInt(today.substring(5,7));
        int tday = Integer.parseInt(today.substring(8,10));

        // 현재 날짜 계산
        int ttotal = (tyear * 12 * 28) + (tmonth * 28) + tday;

        // 파기날짜보다 오늘이 크거나 같다 = 파기
        return (ttotal >= total)?true:false;

    }

}
