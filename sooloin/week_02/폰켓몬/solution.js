//1845. 폰켓몬

function solution(nums) {
  const kindPon = new Set(nums).size;
  const canTake = nums.length / 2;

  // Math.min[가져갈 수 있는 개수, 폰켓몬 종류 개수]
  let answer = Math.min(kindPon, canTake);
  return answer;
}
