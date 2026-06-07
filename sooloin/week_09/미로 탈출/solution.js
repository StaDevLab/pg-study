function solution(maps) {
  const n = maps.length;
  const m = maps[0].length;

  let S, L, E;

  // S, L, E 위치 찾기
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      if (maps[i][j] === "S") S = [i, j];
      if (maps[i][j] === "L") L = [i, j];
      if (maps[i][j] === "E") E = [i, j];
    }
  }

  function bfs(start, end) {
    const visited = Array.from({ length: n }, () => Array(m).fill(false));
    const queue = [[start[0], start[1], 0]];

    visited[start[0]][start[1]] = true;

    const dx = [1, -1, 0, 0];
    const dy = [0, 0, 1, -1];

    while (queue.length) {
      const [x, y, count] = queue.shift();

      if (x === end[0] && y === end[1]) {
        return count;
      }

      for (let i = 0; i < 4; i++) {
        const nx = x + dx[i];
        const ny = y + dy[i];

        if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
        if (maps[nx][ny] === "X") continue;
        if (visited[nx][ny]) continue;

        visited[nx][ny] = true;
        queue.push([nx, ny, count + 1]);
      }
    }

    return -1;
  }

  const toLever = bfs(S, L);
  const toExit = bfs(L, E);

  if (toLever === -1 || toExit === -1) return -1;

  return toLever + toExit;
}
