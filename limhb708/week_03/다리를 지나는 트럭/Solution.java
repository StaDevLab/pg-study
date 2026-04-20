import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        //  0은 트럭이 없는 상태
        Queue<Integer> bridge = new LinkedList<>();

        // 다리 길이만큼 0으로 채워 다리 상태 초기화
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        int time = 0; // 경과 시간
        int currentWeight = 0; // 현재 다리 위의 무게
        int index = 0; // 대기 중인 트럭

        // 대기 트럭이 남아있거나 다리 위에 트럭이 남아있을 때까지 반복
        while (index < truck_weights.length || currentWeight > 0) {
            time++; // 1초 경과

            // 다리 맨 앞의 값(나가는 트럭 또는 0)을 빼고 무게에서 차감
            currentWeight -= bridge.poll();

            // 더 들어올 트럭이 있는 경우
            if (index < truck_weights.length) {
                // 현재 다리 무게 + 다음 트럭 무게가 견딜 수 있는 무게 이하이면
                if (currentWeight + truck_weights[index] <= weight) {
                    bridge.offer(truck_weights[index]); // 트럭 진입
                    currentWeight += truck_weights[index]; // 무게 추가
                    index++; // 다음 트럭으로
                } else {
                    // 무게 제한 초과 시 0(빈 공간)을 넣어 다리 길이 유지
                    bridge.offer(0);
                }
            } else {
                // 대기 트럭이 없으면 0을 넣어 다리 위의 트럭을 계속 이동
                bridge.offer(0);
            }
        }

        return time; // 총 걸린 시간 반환
    }
}