from collections import deque

def solution(n, wires):
    answer = n  # 송전탑 개수 차이의 최솟값

    # 전선을 하나씩 끊어본다
    for cutA, cutB in wires:
        # 그래프 만들기
        graph = [[] for _ in range(n + 1)]

        for a, b in wires:
            # 현재 끊을 전선은 그래프에 안넣음
            if (a == cutA and b == cutB) or (a == cutB and b == cutA):
                continue

            graph[a].append(b)
            graph[b].append(a)

        # BFS로 한쪽 전력망의 송전탑 개수 세기
        visited = [False] * (n + 1)
        q = deque([1])
        visited[1] = True
        count = 1

        while q:
            now = q.popleft()

            for next_node in graph[now]:
                if not visited[next_node]:
                    visited[next_node] = True
                    q.append(next_node)
                    count += 1

        # 한쪽 전력망 송전탑 개수 count
        # 다른 쪽 전력망 송전탑 개수 n - count
        diff = abs(count - (n - count))

        # 최솟값 갱신
        answer = min(answer, diff)

    return answer