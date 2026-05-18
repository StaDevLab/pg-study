function solution(n, l, r) {
  let answer = 0;

  for (let i = l; i <= r; i++) {
    let pos = i - 1;

    if (getCantor(pos) === 1) {
      answer++;
    }
  }

  return answer;
}

function getCantor(pos) {
  // 1인가? 0인가? 판별하자
  while (pos > 0) {
    if (pos % 5 === 2) {
      return 0;
    }

    pos = Math.floor(pos / 5);
  }

  return 1;
}
