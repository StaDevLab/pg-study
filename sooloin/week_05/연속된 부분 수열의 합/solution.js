function solution(sequence, k) {
  let start = 0;
  let end = 0;
  let sum = sequence[0];

  let answer = [0, sequence.length - 1];

  while (start < sequence.length && end < sequence.length) {
    if (sum === k) {
      // 원하는 합 찾음
      if (end - start < answer[1] - answer[0]) {
        answer = [start, end];
      }

      sum -= sequence[start];
      start++;
    } else if (sum < k) {
      // 합이 원하는 목표보다 작으므로 더 넣기
      end++;

      if (end < sequence.length) {
        sum += sequence[end];
      }
    } else {
      // 합이 원하는 목표보다 크므로 앞 숫자 빼기
      sum -= sequence[start];
      start++;
    }
  }

  return answer;
}
