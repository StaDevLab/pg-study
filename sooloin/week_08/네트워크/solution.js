function solution(n, computers) {
  let answer = 0;
  let visited = Array(n).fill(false);

  // 연결된 애들 전부 방문 처리 하는 함수
  function dfs(cur) {
    // 1. 현재 컴퓨터 방문 처리
    visited[cur] = true;

    // 2. 모든 컴퓨터를 돌면서
    for (let next = 0; next < n; next++) {
      // 3. 현재 컴퓨터와 연결되어 있고
      // 4. 아직 방문하지 않은 컴퓨터라면 dfs 호출
      if (computers[cur][next] === 1 && !visited[next]) {
        dfs(next);
      }
    }
  }

  for (let i = 0; i < n; i++) {
    // 아직 방문하지 않았다면
    if (!visited[i])
      // answer 증가
      answer++;
    dfs(i);
  }

  return answer;
}
