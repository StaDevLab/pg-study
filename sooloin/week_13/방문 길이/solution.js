function solution(dirs) {
  const direction = {
    U: [0, 1],
    D: [0, -1],
    R: [1, 0],
    L: [-1, 0],
  };

  let x = 0;
  let y = 0;

  const visited = new Set();
  let answer = 0;

  for (const dir of dirs) {
    const [dx, dy] = direction[dir];

    const nextX = x + dx;
    const nextY = y + dy;

    // 좌표평면의 경계를 벗어나면 명령을 무시함.
    if (nextX < -5 || nextX > 5 || nextY < -5 || nextY > 5) {
      continue;
    }

    const path = `${x},${y}->${nextX},${nextY}`;
    const reversePath = `${nextX},${nextY}->${x},${y}`;

    // 정방향과 역방향 모두 지나간 적이 없는 길인 경우에만 증가함.
    if (!visited.has(path) && !visited.has(reversePath)) {
      answer++;
    }

    visited.add(path);
    visited.add(reversePath);

    x = nextX;
    y = nextY;
  }

  return answer;
}
