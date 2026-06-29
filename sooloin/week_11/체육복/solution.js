function solution(n, lost, reserve) {
  const lostSet = new Set(lost);
  const reserveSet = new Set(reserve);

  for (const student of reserve) {
    if (lostSet.has(student)) {
      lostSet.delete(student);
      reserveSet.delete(student);
    }
  }

  const realLost = [...lostSet].sort((a, b) => a - b);
  let answer = n - realLost.length;

  for (const student of realLost) {
    if (reserveSet.has(student - 1)) {
      reserveSet.delete(student - 1);
      answer++;
    } else if (reserveSet.has(student + 1)) {
      reserveSet.delete(student + 1);
      answer++;
    }
  }

  return answer;
}
