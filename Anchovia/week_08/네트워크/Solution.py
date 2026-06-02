def solution(n, computers):
    visited = [False] * n # 방문 처리용 배열
    answer = 0

    # dfs 함수
    def dfs(v):
        visited[v] = True # 방문 완료하고

        # 현재 컴퓨터와 연결된 컴퓨터 탐색
        for i in range(n):
            # 연결돼있고, 미방문 노드면 더 깊이 탐색
            if computers[v][i] == 1 and not visited[i]:
                dfs(i)

    # 모든 컴퓨터 확인
    for i in range(n):
        # 방문하지 않은 컴퓨터면
        if not visited[i]:
            # 해당 네트워크 전체 방문하고 답 += 1
            dfs(i)
            answer += 1

    return answer