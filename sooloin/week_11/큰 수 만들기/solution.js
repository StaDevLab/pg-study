function solution(number, k) {
  const stack = [];

  for (let i = 0; i < number.length; i++) {
    const current = number[i];

    while (k > 0 && stack.length > 0 && stack[stack.length - 1] < current) {
      stack.pop();
      k--;
    }

    stack.push(current);
  }

  // 아직 제거할 숫자가 남았다면 뒤에서 제거
  if (k > 0) {
    stack.splice(stack.length - k, k);
  }

  return stack.join("");
}
