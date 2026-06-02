def solution(maps):
    n = len(maps)
    m = len(maps[0])

    visited = [[False] * m for _ in range(n)] # 방문 여부 지정
    answer = []

    # 상, 하, 좌, 우 이동 방향
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    # 모든 칸 탐색
    for i in range(n):
        for j in range(m):

            # 방문하지 않은 땅 발견 -> 새로운 섬 시작
            if not visited[i][j] and maps[i][j] != 'X':
                stack = [(i, j)] # 스택 생성
                visited[i][j] = True # 방문 처리
                total = 0 # 현재 섬의 식량 합

                # 스택 DFS로 현재 섬 전체 탐색
                while stack:
                    x, y = stack.pop()

                    total += int(maps[x][y])  # 현재 칸의 식량 추가

                    # 상하좌우 탐색
                    for k in range(4):
                        nx = x + dx[k]
                        ny = y + dy[k]

                        # 지도 범위 안인지 확인
                        if 0 <= nx < n and 0 <= ny < m:

                            # 방문하지 않은 땅이면 같은 섬이므로 계속 탐색
                            if not visited[nx][ny] and maps[nx][ny] != 'X':
                                visited[nx][ny] = True
                                stack.append((nx, ny))

                # 현재 섬 탐색 완료
                answer.append(total)
                
    # 섬이 없으면 [-1] 반환
    return sorted(answer) if answer else [-1]