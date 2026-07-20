function solution(n, info) {
  let maxDiff = 0;
  let answer = null;

  const ryan = Array(11).fill(0);

  // 점수 차이가 같을 때 낮은 점수를 더 많이 맞힌 배열인지 확인함.
  function isBetter(candidate, current) {
    if (current === null) return true;

    // 0점부터 10점 방향으로 비교함.
    for (let i = 10; i >= 0; i--) {
      if (candidate[i] !== current[i]) {
        return candidate[i] > current[i];
      }
    }

    return false;
  }

  function dfs(index, remain, ryanScore, apeachScore) {
    // 0점 과녁까지 도착하면 남은 화살을 모두 0점에 사용함.
    if (index === 10) {
      ryan[10] = remain;

      const diff = ryanScore - apeachScore;

      if (
        diff > 0 &&
        (diff > maxDiff || (diff === maxDiff && isBetter(ryan, answer)))
      ) {
        maxDiff = diff;
        answer = [...ryan];
      }

      ryan[10] = 0;
      return;
    }

    const score = 10 - index;
    const arrowsToWin = info[index] + 1;

    // 현재 점수를 가져가는 경우
    if (arrowsToWin <= remain) {
      ryan[index] = arrowsToWin;

      dfs(index + 1, remain - arrowsToWin, ryanScore + score, apeachScore);

      ryan[index] = 0;
    }

    // 현재 점수를 포기하는 경우
    const nextApeachScore = info[index] > 0 ? apeachScore + score : apeachScore;

    dfs(index + 1, remain, ryanScore, nextApeachScore);
  }

  dfs(0, n, 0, 0);

  return answer ?? [-1];
}
