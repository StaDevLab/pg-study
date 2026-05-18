function solution(a, b, n) {
  return getCoke(a, b, n);
}

function getCoke(a, b, n) {
  if (n < a) {
    return 0;
  }

  let received = Math.floor(n / a) * b;
  let remainder = n % a;

  return received + getCoke(a, b, received + remainder);
}
