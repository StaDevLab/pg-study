function solution(k, dungeons) {
  let visited = Array(dungeons.length).fill(false);
  var answer = 0;

  function dfs(curEnergy, clearCnt) {
    // 1. answer 갱신
    answer = Math.max(answer, clearCnt);

    // 2. 모든 던전 순회
    for (let i = 0; i < dungeons.length; i++) {
      // 3. 아직 안 감 + 갈 수 있는 던전이면
      if (!visited[i] && curEnergy >= dungeons[i][0]) {
        // 방문 처리
        visited[i] = true;

        // dfs 호출
        dfs(curEnergy - dungeons[i][1], clearCnt + 1);

        // 방문 해제
        visited[i] = false;
      }
    }
  }

  dfs(k, 0);

  return answer;
}
