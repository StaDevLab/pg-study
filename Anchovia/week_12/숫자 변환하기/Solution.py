from collections import deque

def solution(x, y, n):
    # visited[i] -> x에서 i까지 가는 최소 연산 횟수
    visited = [-1] * (y + 1) # -1은 아직 방문하지 않았다는 뜻임
    queue = deque()

    # 시작 숫자 x는 연산 0번으로 도달 가능
    visited[x] = 0
    queue.append(x)

    while queue:
        now = queue.popleft()

        # 목표 숫자에 도달하면 최소 연산 횟수 반환
        if now == y:
            return visited[now]

        # 현재 숫자에서 한 번의 연산으로 갈 수 있는 숫자들 정의
        nextNums = [
            now + n,
            now * 2,
            now * 3
        ]

        for nextNum in nextNums:
            # y보다 크면 제외, 이미 방문한 숫자도 제외
            if nextNum <= y and visited[nextNum] == -1:
                visited[nextNum] = visited[now] + 1
                queue.append(nextNum)

    # y를 만들 수 없는 경우 -1 반환
    return -1