function solution(people, limit) {
  // 양방향 투포인터 사용하기!!
  var answer = 0;
  people.sort((a, b) => a - b);

  let start = 0;
  let end = people.length - 1;

  while (start <= end) {
    let sum = people[start] + people[end];

    if (sum <= limit) {
      // 가벼운 사람도 태우기
      start++;
    }

    end--; // 무거운 사람은 무조건 나감
    answer++;
  }
  return answer;
}
