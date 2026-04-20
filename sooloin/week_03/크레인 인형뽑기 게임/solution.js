//64061. 크레인 인형뽑기 게임

function solution(board, moves) {
  let answer = 0;
  let basket = [];

  for (let move of moves) {
    let col = move - 1; // moves는 1부터 시작, 배열 인덱스는 0부터 시작

    for (let row = 0; row < board.length; row++) {
      // 인형이 있는 칸을 찾으면
      if (board[row][col] !== 0) {
        let doll = board[row][col]; // 인형 뽑기
        board[row][col] = 0; // 뽑은 자리는 빈칸으로 만들기

        // 바구니 맨 위 인형과 비교
        if (basket[basket.length - 1] === doll) {
          basket.pop(); // 같은 인형이면 제거
          answer += 2; // 두 개 터졌으니 2개 추가
        } else {
          basket.push(doll); // 다르면 바구니에 넣기
        }

        break; // 한 번 집었으면 그 move는 끝
      }
    }
  }

  return answer;
}
