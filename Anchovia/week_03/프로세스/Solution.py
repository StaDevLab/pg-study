from collections import deque

def solution(priorities, location):
    answer = 0

    # 파이썬에서 queue를 쓰려면 deque를 사용합니다.
    queue = deque()
    # (우선순위, idx)로 큐에 저장
    for idx, priority in enumerate(priorities):
        queue.append((priority, idx))
    
    # 큐가 빌때까지 진행
    while queue:
        # 맨 앞 요소 뺌
        now = queue.popleft()

        # 큐에 요소가 있고, 큐에 있는 프로세스들 중 가장 높은 우선순위보다 지금이 낮으면
        if queue and now[0] < max(queue)[0]:
            # 다시 집어넣음
            queue.append(now)
        else:
            # 가장 높은 우선순위면 answer 1 증가(프로세스 실행)
            answer += 1
            # 내가 찾던 process면 answer return
            if now[1] == location:
                return answer