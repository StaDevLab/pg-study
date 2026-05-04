function solution(numlist, n) {
  return numlist.sort((a, b) => {
    // 절댓값 통해 거리 측정하기
    let A = Math.abs(a - n);
    let B = Math.abs(b - n);

    if (A === B) {
      return b - a; // 크기 기준 내림차순 정렬
    } else {
      return A - B; // 거리 기준 오름차순 정렬
    }
  });
}
