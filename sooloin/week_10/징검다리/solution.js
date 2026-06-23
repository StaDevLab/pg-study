function solution(distance, rocks, n) {
  rocks.sort((a, b) => a - b);
  rocks.push(distance);

  let left = 1;
  let right = distance;
  let answer = 0;

  while (left <= right) {
    const mid = Math.floor((left + right) / 2);

    let removed = 0;
    let previous = 0;

    for (let i = 0; i < rocks.length; i++) {
      const gap = rocks[i] - previous;

      if (gap < mid) {
        removed++;
      } else {
        previous = rocks[i];
      }
    }

    if (removed <= n) {
      answer = mid;
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }

  return answer;
}
