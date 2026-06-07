function solution(board) {
  const rowLen = board.length;
  const colLen = board[0].length;

  let startX = 0;
  let startY = 0;

  // 1. 시작 위치 R 찾기
  for (let i = 0; i < rowLen; i++) {
    for (let j = 0; j < colLen; j++) {
      if (board[i][j] === "R") {
        startX = i;
        startY = j;
      }
    }
  }

  // 상, 하, 좌, 우
  const dx = [-1, 1, 0, 0];
  const dy = [0, 0, -1, 1];

  // 방문 배열
  const visited = Array.from({ length: rowLen }, () =>
    Array(colLen).fill(false),
  );

  // queue에는 [x좌표, y좌표, 이동횟수] 저장
  const queue = [[startX, startY, 0]];
  visited[startX][startY] = true;

  let index = 0;

  // 2. BFS 시작
  while (index < queue.length) {
    const [x, y, count] = queue[index++];

    // 현재 위치가 목표 지점이면 이동 횟수 반환
    if (board[x][y] === "G") {
      return count;
    }

    // 3. 네 방향으로 미끄러지기
    for (let dir = 0; dir < 4; dir++) {
      let nx = x;
      let ny = y;

      // 다음 칸이 범위 안이고, 장애물이 아닐 때까지 계속 이동
      while (
        nx + dx[dir] >= 0 &&
        nx + dx[dir] < rowLen &&
        ny + dy[dir] >= 0 &&
        ny + dy[dir] < colLen &&
        board[nx + dx[dir]][ny + dy[dir]] !== "D"
      ) {
        nx += dx[dir];
        ny += dy[dir];
      }

      // 멈춘 위치를 아직 방문하지 않았다면 큐에 추가
      if (!visited[nx][ny]) {
        visited[nx][ny] = true;
        queue.push([nx, ny, count + 1]);
      }
    }
  }

  // 끝까지 탐색했는데 G에 도달하지 못하면 -1
  return -1;
}
