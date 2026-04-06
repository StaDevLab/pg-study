// 87390. n^2 배열 자르기

function solution(n, left, right) {
  const answer = []; // 정답 배열 준비

  // 전체 배열 다 안 돌고 문제에서 요구한 구간만 돌기
  for (let i = left; i <= right; i++) {
    // 1차원 인덱스 행/열로 바꾸기
    const row = Math.floor(i / n);
    const col = i % n;
    // 필요한 값만 담기
    answer.push(Math.max(row, col) + 1);
  }

  return answer;
}
