import java.util.*;

class Solution {

    public int[] solution(int[] fees, String[] records) {
        // 현재 주차 중인 차량의 입차 시간
        Map<String, Integer> inTimeMap = new HashMap<>();

        // 차량별 누적 주차 시간
        // 차량 번호 순서대로 결과를 만들기 위해 TreeMap 사용
        Map<String, Integer> totalTimeMap = new TreeMap<>();

        for (String record : records) {
            String[] info = record.split(" ");

            int time = convertToMinute(info[0]);
            String carNumber = info[1];
            String status = info[2];

            if (status.equals("IN")) {
                // 입차 시간 저장
                inTimeMap.put(carNumber, time);
            } else {
                // 출차 시간 - 입차 시간
                int inTime = inTimeMap.remove(carNumber);
                int parkingTime = time - inTime;

                // 차량의 누적 주차 시간에 더하기
                totalTimeMap.put(
                        carNumber,
                        totalTimeMap.getOrDefault(carNumber, 0) + parkingTime
                );
            }
        }

        // 출차 기록이 없는 차량은 23:59에 출차한 것으로 처리
        int lastTime = convertToMinute("23:59");

        for (String carNumber : inTimeMap.keySet()) {
            int inTime = inTimeMap.get(carNumber);
            int parkingTime = lastTime - inTime;

            totalTimeMap.put(
                    carNumber,
                    totalTimeMap.getOrDefault(carNumber, 0) + parkingTime
            );
        }

        int[] answer = new int[totalTimeMap.size()];
        int index = 0;

        // TreeMap이므로 차량 번호가 작은 순서대로 반복
        for (int totalTime : totalTimeMap.values()) {
            answer[index++] = calculateFee(fees, totalTime);
        }

        return answer;
    }

    // HH:MM 형식의 시간을 분으로 변환
    private int convertToMinute(String time) {
        String[] splitTime = time.split(":");

        int hour = Integer.parseInt(splitTime[0]);
        int minute = Integer.parseInt(splitTime[1]);

        return hour * 60 + minute;
    }

    // 누적 주차 시간을 기준으로 요금 계산
    private int calculateFee(int[] fees, int totalTime) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        // 기본 시간 이하라면 기본 요금만 청구
        if (totalTime <= basicTime) {
            return basicFee;
        }

        int overTime = totalTime - basicTime;

        // 초과 시간을 단위 시간으로 나눈 값을 올림
        int unitCount = (overTime + unitTime - 1) / unitTime;

        return basicFee + unitCount * unitFee;
    }
}