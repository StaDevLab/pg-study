function solution(numbers) {
  let answer = [];

  // 두 수의 합을 구하기 위해 이중 for문 사용
  for (let i = 0; i < numbers.length; i++) {
    for (let j = i + 1; j < numbers.length; j++) {
      let sum = numbers[i] + numbers[j];

      // 중복된 합 방지를 위해 answer 배열에 sum이 이미 존재하는지 확인
      if (!answer.includes(sum)) {
        answer.push(sum);
      }
    }
  }

  // answer 배열을 오름차순으로 정렬
  answer.sort((a, b) => a - b);
  // Set을 사용하여 중복된 합 제거
  let set = new Set(answer);
  answer = [...set];
  return answer;
}
