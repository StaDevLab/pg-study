function solution(x, y, n) {
  const visited = Array(y + 1).fill(-1);
  const queue = [x];

  visited[x] = 0;

  let head = 0;

  while (head < queue.length) {
    const current = queue[head++];

    if (current === y) {
      return visited[current];
    }

    const nextNumbers = [current + n, current * 2, current * 3];

    for (const next of nextNumbers) {
      if (next <= y && visited[next] === -1) {
        visited[next] = visited[current] + 1;
        queue.push(next);
      }
    }
  }

  return -1;
}
