var twoSum = function (numbers, target) {
  let left = 0;
  let right = numbers.length - 1;

  while (left < right) {
    let sum = numbers[left] + numbers[right];

    if (sum === target) {
      // 정답 반환하기
      return [left + 1, right + 1];
    } else if (sum < target) {
      // 합이 작을 때 포인터 이동
      left++;
    } else {
      // 합이 클 때 포인터 이동
      right--;
    }
  }
};
