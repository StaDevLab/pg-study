from collections import deque

def solution(people, limit):
    answer = 0
    people.sort() # 몸무게 순으로 오름차순 정렬
    deq = deque(people)

    while deq:
        # 1명만 남은 경우 혼자 타고 감
        if len(deq) == 1:
            answer += 1
            break
            
        # 가장 가벼운 사람 + 가장 무거운 사람 <= limit
        if deq[0] + deq[-1] <= limit:
            deq.popleft() # 가벼운 사람
            deq.pop()     # 무거운 사람
        else:
            # 같이 못 타면 무거운 사람만
            deq.pop()     
            
        # 보트 출발
        answer += 1

    return answer