// 12932. 자연수 뒤집어 배열로 만들기

function solution(n) {
  var answer = String(n).split("").reverse();
  answer = answer.map((el) => Number(el));
  return answer;
}
