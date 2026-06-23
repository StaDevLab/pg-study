function solution(diffs, times, limit) {
  let left = 1;
  let right = 0;

  for (let i = 0; i < diffs.length; i++) {
    if (diffs[i] > right) {
      right = diffs[i];
    }
  }

  let answer = right;

  function canSolve(level) {
    let total = 0;

    for (let i = 0; i < diffs.length; i++) {
      const diff = diffs[i];
      const timeCur = times[i];
      const timePrev = i === 0 ? 0 : times[i - 1];

      if (diff <= level) {
        total += timeCur;
      } else {
        const failCount = diff - level;
        total += (timeCur + timePrev) * failCount + timeCur;
      }

      if (total > limit) {
        return false;
      }
    }

    return true;
  }

  while (left <= right) {
    const mid = Math.floor((left + right) / 2);

    if (canSolve(mid)) {
      answer = mid;
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }

  return answer;
}
