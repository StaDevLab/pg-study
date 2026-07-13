import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Solution {

    public int[] solution(int[] fees, String[] records) {

        // 현재 주차 중인 차량의 입차 시각을 저장할 Map
        // 차량 번호 → 입차 시각
        Map<String, Integer> inTimes = new HashMap<>();

        // 차량별 누적 주차 시간을 저장할 TreeMap
        // TreeMap은 차량 번호를 자동으로 오름차순 정렬한다.
        Map<String, Integer> totalTimes = new TreeMap<>();

        // 모든 입출차 기록을 순회
        for (String record : records) {

            // 공백을 기준으로 기록을 분리
            String[] parts = record.split(" ");

            // 시각을 분 단위로 변환
            int time = toMinutes(parts[0]);

            // 차량 번호 저장
            String carNumber = parts[1];

            // 입차 또는 출차 상태 저장
            String state = parts[2];

            // 처음 등장한 차량이면 누적 시간을 0으로 초기화
            totalTimes.putIfAbsent(carNumber, 0);

            // 입차 기록이라면
            if (state.equals("IN")) {

                // 해당 차량의 입차 시각 저장
                inTimes.put(carNumber, time);

            } else {

                // 해당 차량의 입차 시각을 가져오고 Map에서 제거
                int inTime = inTimes.remove(carNumber);

                // 출차 시각에서 입차 시각을 빼서 주차 시간 계산
                int parkingTime = time - inTime;

                // 기존 누적 시간에 현재 주차 시간을 더해서 저장
                totalTimes.put(
                        carNumber,
                        totalTimes.get(carNumber) + parkingTime
                );
            }
        }

        // 하루의 마지막 시각인 23:59를 분으로 변환
        int endTime = toMinutes("23:59");

        // 출차하지 않고 남아 있는 차량을 순회
        for (Map.Entry<String, Integer> entry : inTimes.entrySet()) {

            // 차량 번호 가져오기
            String carNumber = entry.getKey();

            // 해당 차량의 입차 시각 가져오기
            int inTime = entry.getValue();

            // 23:59까지의 주차 시간을 누적 시간에 더하기
            totalTimes.put(
                    carNumber,
                    totalTimes.get(carNumber) + endTime - inTime
            );
        }

        // 차량 수만큼 정답 배열 생성
        int[] answer = new int[totalTimes.size()];

        // 정답 배열의 인덱스
        int index = 0;

        // 차량 번호가 작은 순서대로 누적 주차 시간을 순회
        for (int totalTime : totalTimes.values()) {

            // 누적 주차 시간에 따른 요금을 계산하여 배열에 저장
            answer[index++] = calculateFee(totalTime, fees);
        }

        // 계산된 차량별 요금 배열 반환
        return answer;
    }

    private int toMinutes(String time) {

        // 시각 문자열에서 시간 부분 추출
        int hour = Integer.parseInt(time.substring(0, 2));

        // 시각 문자열에서 분 부분 추출
        int minute = Integer.parseInt(time.substring(3, 5));

        // 전체 시각을 분으로 변환하여 반환
        return hour * 60 + minute;
    }

    private int calculateFee(int totalTime, int[] fees) {

        // 기본 시간 저장
        int baseTime = fees[0];

        // 기본 요금 저장
        int baseFee = fees[1];

        // 단위 시간 저장
        int unitTime = fees[2];

        // 단위 요금 저장
        int unitFee = fees[3];

        // 누적 주차 시간이 기본 시간 이하라면
        if (totalTime <= baseTime) {

            // 기본 요금만 반환
            return baseFee;
        }

        // 기본 시간을 초과한 시간 계산
        int extraTime = totalTime - baseTime;

        // 초과 시간을 단위 시간으로 나눈 값을 올림 계산
        int unitCount = (extraTime + unitTime - 1) / unitTime;

        // 기본 요금과 초과 요금을 더해서 반환
        return baseFee + unitCount * unitFee;
    }
}