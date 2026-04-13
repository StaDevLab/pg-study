import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {

        Map<String, Integer> termMap = new HashMap<>();
        // 약관 종류와 유효기간을 저장할 HashMap 생성

        for (String term : terms) { // 약관 배열 순회
            String[] part = term.split(" "); // "약관종류 기간" 형태를 분리
            termMap.put(part[0], Integer.parseInt(part[1])); // 약관 종류와 기간 저장
        }

        int todayValue = convertDate(today); // 오늘 날짜를 숫자로 변환
        List<Integer> result = new ArrayList<>(); //만료된 개인정보 인덱스를 저장할 리스트

        for (int i = 0; i < privacies.length; i++) { // 개인정보 배열 순회
            String[] part = privacies[i].split(" "); // "날짜 약관종류" 형태 분리
            String date = part[0]; // 수집 날짜
            String type = part[1]; // 약관 종류

            int collectedDate = convertDate(date); // 수집 날짜를 숫자로 변환
            int expireDate = collectedDate + (termMap.get(type) * 28) - 1;
            // 만료 날짜 = 수집 날짜 + (약관 기간 * 28일) - 1

            if (expireDate < todayValue) { // 만료 날짜가 오늘보다 이전이면
                result.add(i + 1); // 해당 개인정보 번호를 결과에 추가
            }
        }

        int[] answer = new int[result.size()]; // 결과 리스트를 배열로 변환
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i); // 리스트 값 복사
        }

        return answer;
    }

    private int convertDate(String date) {
        // 날짜 문자열("YYYY.MM.DD")을 정수 값으로 변환하는 메서드
        String[] part = date.split("\\."); // '.' 기준으로 연, 월, 일 분리
        int year = Integer.parseInt(part[0]); // 연도
        int month = Integer.parseInt(part[1]); // 월
        int day = Integer.parseInt(part[2]); // 일

        return year * 12 * 28 + month * 28 + day;
        // 날짜를 "총 일수"로 변환 (1년=12개월, 1개월=28일 기준)
    }
}

