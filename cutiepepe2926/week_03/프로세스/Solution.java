import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {

        int answer = 1;

        // 높은 순으로 우선순위를 정렬하는 큐
        PriorityQueue<Integer> priority = new PriorityQueue<>(Collections.reverseOrder());

        for (int pr : priorities) {
            priority.add(pr);
        }

        // 실제 대기 큐
        Deque<WQ> wQueue = new ArrayDeque<>();

        for (int i = 0; i < priorities.length; i++) {
            wQueue.add(new WQ(priorities[i], i));
        }

        // 프로세스 동작 시작
        while (true) {

            int pr = priority.peek();

            // 만약, 우선순위가 높은 프로세스가 맞다면,
            if (wQueue.peek().pr == pr) {

                // 우리가 찾는 프로세스인지 검증
                if (wQueue.peek().idx == location) {
                    break;
                }

                else { // 아니면 프로세스 종료
                    priority.poll();
                    wQueue.poll();
                    answer++;
                }

            }
            else { // 아닌 경우
                wQueue.add(wQueue.poll()); // 후순위로 밀려남
            }

        }

        return answer;

    }
}

// 위치 값과 우선도를 저장할 WQ 클래스
class WQ {
    int pr;
    int idx;

    WQ(int pr, int idx) {
        this.pr = pr;
        this.idx = idx;
    }
}