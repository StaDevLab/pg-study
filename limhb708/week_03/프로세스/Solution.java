import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {

        int answer = 0;

        // 실제 대기 큐: {우선순위, 초기위치} 형태로 저장
        Queue<int[]> queue = new LinkedList<>();

        // priorities 배열을 순회하며 큐에 (우선순위, 인덱스) 쌍으로 저장
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{priorities[i], i});
        }

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            // 큐의 맨 앞 요소를 꺼냄
            int[] current = queue.poll();
            boolean hasHigher = false; // 더 높은 우선순위 존재 여부 플래그

            // 현재 큐에 있는 나머지 요소들과 비교
            for (int[] q : queue) {
                // 현재 꺼낸 것보다 높은 우선순위가 있다면
                if (q[0] > current[0]) {
                    hasHigher = true;
                    break;
                }
            }

            // 더 높은 우선순위가 있다면
            if (hasHigher) {
                queue.offer(current); // 꺼낸 요소를 다시 큐의 뒤로 보냄
            } else {
                // 더 높은 게 없으면 실행
                answer++; // 실행 순서 증가

                // 실행한 프로세스가 우리가 찾는 프로세스면
                if (current[1] == location) {
                    return answer; // 현재까지의 순서 반환
                }
            }
        }

        return answer;
    }
}