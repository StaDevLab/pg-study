function solution(name) {
  let answer = 0;
  const len = name.length;

  let move = len - 1;

  for (let i = 0; i < len; i++) {
    const alphabetMove = name.charCodeAt(i) - "A".charCodeAt(0);

    answer += Math.min(alphabetMove, 26 - alphabetMove);

    let next = i + 1;

    while (next < len && name[next] === "A") {
      next++;
    }

    move = Math.min(move, i * 2 + len - next);
    move = Math.min(move, (len - next) * 2 + i);
  }

  return answer + move;
}
