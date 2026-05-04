function solution(sizes) {
  // 가로, 세로의 최댓값 저장
  let maxWidth = 0;
  let maxHeight = 0;

  for (let [w, h] of sizes) {
    // 긴 쪽 짧은 쪽 고르기
    const big = Math.max(w, h);
    const small = Math.min(w, h);

    maxWidth = Math.max(maxWidth, big);
    maxHeight = Math.max(maxHeight, small);
  }

  return maxWidth * maxHeight;
}
