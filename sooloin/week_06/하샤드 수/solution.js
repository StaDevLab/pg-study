function solution(x) {
  let arr = x.toString().split("");
  let sum = 0;

  arr.forEach((num) => {
    sum += Number(num);
  });

  return x % sum === 0 ? true : false;
}
