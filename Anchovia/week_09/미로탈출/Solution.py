from collections import deque

def solution(maps):
    n = len(maps)
    m = len(maps[0])

    # 출발, 레버, 출구 변수 선언
    start = lever = exit = None

    # 미로 전체를 돌면서 S, L, E 위치 찾기
    for i in range(n):
        for j in range(m):
            if maps[i][j] == 'S':
                start = (i, j)
            elif maps[i][j] == 'L':
                lever = (i, j)
            elif maps[i][j] == 'E':
                exit = (i, j)

    # src에서 dst까지의 최단 거리를 구하는 BFS 함수
    def bfs(src, dst):
        # 방문 여부 저장 배열
        visited = [[False] * m for _ in range(n)]

        q = deque()

        # 시작 위치와 이동 거리 0을 큐에 넣음
        sx, sy = src
        q.append((sx, sy, 0))
        visited[sx][sy] = True # 방문처리

        # 상, 하, 좌, 우
        dx = [-1, 1, 0, 0]
        dy = [0, 0, -1, 1]

        while q:
            # 현재 위치와 현재까지 이동한 거리
            x, y, dist = q.popleft()

            # 목적지에 도착하면 현재 거리가 최단 거리
            if (x, y) == dst:
                return dist

            # 네 방향 시도
            for k in range(4):
                nx = x + dx[k]
                ny = y + dy[k]

                # 미로 범위 안에 있는지 ?
                if 0 <= nx < n and 0 <= ny < m:
                    # 아직 방문하지 않았고, X가 아니면 이동 가능
                    if not visited[nx][ny] and maps[nx][ny] != 'X':
                        visited[nx][ny] = True
                        q.append((nx, ny, dist + 1))

        # 큐가 빌 때까지 도착하지 못하면 이동 불가
        return -1

    # dist1 - 시작 -> 레버까지 최단 거리
    dist1 = bfs(start, lever)

    # 레버까지 못 가면 탈출x
    if dist1 == -1:
        return -1

    # dist2 - 레버 -> 출구까지 최단 거리
    dist2 = bfs(lever, exit)

    # 출구까지 못 가면 탈출x
    if dist2 == -1:
        return -1

    # 시작점 → 레버 거리 + 레버 → 출구 거리
    return dist1 + dist2