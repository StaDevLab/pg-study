from collections import deque

def solution(board):
    n = len(board)
    m = len(board[0])

    start = None
    goal = None

    for i in range(n):
        for j in range(m):
            if board[i][j] == 'R':
                start = (i, j)
            elif board[i][j] == 'G':
                goal = (i, j)

    # 상, 하, 좌, 우
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    # 방문 배열
    visited = [[False] * m for _ in range(n)]

    q = deque()
    q.append((start[0], start[1], 0))
    visited[start[0]][start[1]] = True

    while q:
        # x, y는 현재 위치
        # count는 지금까지 이동한 횟수
        x, y, count = q.popleft()

        # 목표 지점에 정확히 멈췄다면 이동 횟수 반환
        if (x, y) == goal:
            return count

        # 상하좌우 이동 시도
        for direction in range(4):
            nx = x
            ny = y

            # 현재 방향으로 쭉 감
            while True:
                nextX = nx + dx[direction]
                nextY = ny + dy[direction]

                # 다음 위치가 보드 밖이면 멈춤
                if not (0 <= nextX < n and 0 <= nextY < m):
                    break

                # 다음 위치가 장애물이면 멈춤
                if board[nextX][nextY] == 'D':
                    break

                # 이동 가능하면 한 칸 더 감
                nx = nextX
                ny = nextY

            # 쭉 가서 멈춘 위치를 아직 방문하지 않았다면 큐에 추가
            if not visited[nx][ny]:
                visited[nx][ny] = True
                q.append((nx, ny, count + 1))

    # BFS가 끝날 때까지 도착 못했으면 -1
    return -1