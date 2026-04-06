// 12910. 나누어 떨어지는 숫자 배열
function solution(arr, divisor) {
  var answer = [];
  arr.forEach((el, i) => {
    //순회하며 조건에 맞는 요소 찾기
    if (el % divisor === 0) {
      answer.push(el);
    }
  });
  answer.sort((a, b) => a - b); // 오름차순 정렬
  return answer.length ? answer : [-1];
}
