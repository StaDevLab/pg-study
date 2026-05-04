function solution(brown, yellow) {
  // 전체 카펫의 칸 수
  const total = brown + yellow;

  // 세로 길이 h를 3부터 확인하기 !!
  // => 노란 카펫이 존재하려면 최소 구조가 3x3임..
  for (let h = 3; h <= Math.sqrt(total); h++) {
    if (total % h === 0) {
      const w = total / h;

      if ((w - 2) * (h - 2) === yellow) {
        return [w, h];
      }
    }
  }
}
