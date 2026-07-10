import java.util.*;

class Solution {

    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inTime = new HashMap<>();
        Map<String, Integer> totalTime = new TreeMap<>();

        for (String record : records) {
            String[] info = record.split(" ");

            int time = convertToMinute(info[0]);
            String carNumber = info[1];
            String type = info[2];

            if (type.equals("IN")) {
                inTime.put(carNumber, time);
                totalTime.putIfAbsent(carNumber, 0);
            } else {
                int enterTime = inTime.remove(carNumber);
                int parkingTime = time - enterTime;

                totalTime.put(
                    carNumber,
                    totalTime.get(carNumber) + parkingTime
                );
            }
        }

        int lastTime = convertToMinute("23:59");

        for (String carNumber : inTime.keySet()) {
            int enterTime = inTime.get(carNumber);
            int parkingTime = lastTime - enterTime;

            totalTime.put(
                carNumber,
                totalTime.get(carNumber) + parkingTime
            );
        }

        int[] answer = new int[totalTime.size()];
        int index = 0;

        for (int parkingTime : totalTime.values()) {
            answer[index++] = calculateFee(fees, parkingTime);
        }

        return answer;
    }

    private int convertToMinute(String time) {
        String[] split = time.split(":");

        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);

        return hour * 60 + minute;
    }

    private int calculateFee(int[] fees, int parkingTime) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        if (parkingTime <= baseTime) {
            return baseFee;
        }

        int overTime = parkingTime - baseTime;

        return baseFee
            + (int) Math.ceil((double) overTime / unitTime) * unitFee;
    }
}