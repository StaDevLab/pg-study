//42587. 프로세스

function solution(priorities, location) {
  // 1. 큐 만들기 [우선순위, 원래 위치]
  let queue = priorities.map((priority, index) => [priority, index]);
  // 2. 실행순서 카운트
  let cnt = 0;

  // 3. 큐가 비워질 때까지 반복하기
  while (queue.length > 0) {
    // 맨 앞 요소 꺼내기
    let front = queue.shift();

    // 남은 큐에 더 큰 우선순위가 있으면 뒤로 보내기
    if (queue.some((process) => process[0] > front[0])) {
      queue.push(front);
    } else {
      cnt++;

      //실행한 프로세스의 원래 위치가 location이면 count 반환
      if (front[1] === location) {
        return cnt;
      }
    }
  }
}
