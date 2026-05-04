function solution(elements) {
  const n = elements.length;
  let set = new Set();

  // 길이 1, 2, ... 증가
  for (let start = 0; start < n; start++) {
    let sum = 0;

    for (let len = 0; len < n; len++) {
      sum += elements[(start + len) % n];
      set.add(sum);
    }
  }
  return set.size;
}
