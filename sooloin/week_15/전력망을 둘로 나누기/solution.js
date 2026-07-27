function solution(n, wires) {
  let answer = Infinity;

  // 1. 그래프 만들기
  let graph = Array.from({ length: n + 1 }, () => []);

  for (let [a, b] of wires) {
    graph[a].push(b);
    graph[b].push(a);
  }

  // 2. 전선 하나씩 끊기
  for (let [cutA, cutB] of wires) {
    let visited = Array(n + 1).fill(false);

    // 3. DFS로 한쪽 네트워크 개수 세기
    function dfs(cur) {
      visited[cur] = true;
      let count = 1;

      for (let next of graph[cur]) {
        // 끊은 전선이면 지나가지 않기
        if (
          (cur === cutA && next === cutB) ||
          (cur === cutB && next === cutA)
        ) {
          continue;
        }

        if (!visited[next]) {
          count += dfs(next);
        }
      }

      return count;
    }

    let count = dfs(cutA);
    let other = n - count;

    answer = Math.min(answer, Math.abs(count - other));
  }

  return answer;
}
