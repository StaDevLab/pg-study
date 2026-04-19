import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        /* 다리를 건너는 시간에 대해서 설명이 없어서 출처 자료를 참고해야함.*/
        /* 다리 길이는 bridge_length고, 트럭은 자기 weight 만큼 움직인다.*/

        Queue<Integer> bridge = new ArrayDeque<>();

        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        int time = 0; // 지난 시간
        int curW = 0; // 현재 무게
        int idx = 0;

        // 아직 대기 트럭이 남아있거나, 다리 위에 트럭이 남아있으면 계속 진행
        while (idx < truck_weights.length || curW > 0) {

            time++;

            // 1초가 지나면서 맨 앞 칸이 빠져나감
            curW -= bridge.poll();

            // 다음 트럭을 올릴 수 있으면 올림
            if (idx < truck_weights.length) {

                if (curW + truck_weights[idx] <= weight) {

                    // 트럭을 다리의 맨 뒤 칸에 올린다.
                    bridge.offer(truck_weights[idx]);

                    // 현재 다리 위 총무게에 새 트럭 무게를 반영
                    curW += truck_weights[idx];

                    // 다음 트럭으로 인덱스 이동
                    idx++;

                }

                else {
                    // 못 올리면 빈 칸
                    bridge.offer(0);
                }
            }

            else {
                // 남은 트럭이 없으면 계속 빈 칸만 이동
                bridge.offer(0);
            }
        }


        return time;
    }
}