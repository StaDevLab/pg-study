function solution(maps) {
  const rowLength = maps.length;
  const colLength = maps[0].length;

  const visited = Array.from({ length: rowLength }, () =>
    Array(colLength).fill(false),
  );

  const answer = [];

  // 상, 하, 좌, 우 이동
  const dr = [-1, 1, 0, 0];
  const dc = [0, 0, -1, 1];

  function dfs(row, col) {
    visited[row][col] = true;

    // 현재 칸의 식량 숫자
    let sum = Number(maps[row][col]);

    // 상하좌우 탐색
    for (let i = 0; i < 4; i++) {
      const nextRow = row + dr[i];
      const nextCol = col + dc[i];

      // 1. 지도 범위를 벗어나면 안 됨
      if (
        nextRow < 0 ||
        nextRow >= rowLength ||
        nextCol < 0 ||
        nextCol >= colLength
      ) {
        continue;
      }

      // 2. 바다라면 이동 불가
      if (maps[nextRow][nextCol] === "X") {
        continue;
      }

      // 3. 이미 방문한 땅이면 다시 방문 X
      if (visited[nextRow][nextCol]) {
        continue;
      }

      // 갈 수 있는 땅이면 그 칸에서 다시 DFS
      sum += dfs(nextRow, nextCol);
    }

    return sum;
  }

  // 전체 지도 순회
  for (let row = 0; row < rowLength; row++) {
    for (let col = 0; col < colLength; col++) {
      // 숫자 칸이면서 아직 방문하지 않았다면 새로운 섬 발견
      if (maps[row][col] !== "X" && !visited[row][col]) {
        const islandFood = dfs(row, col);
        answer.push(islandFood);
      }
    }
  }

  // 무인도가 없다면 [-1]
  if (answer.length === 0) {
    return [-1];
  }

  // 오름차순 정렬
  return answer.sort((a, b) => a - b);
}
