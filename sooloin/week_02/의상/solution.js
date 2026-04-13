//42578. 의상

function solution(clothes) {
  let wardrobe = new Map();

  // 1. 종류별 옷 개수 세기
  for (let [clothing, type] of clothes) {
    if (wardrobe.has(type)) {
      wardrobe.set(type, wardrobe.get(type) + 1);
    } else {
      wardrobe.set(type, 1);
    }
  }

  // 2. 각 종류마다 (입는 경우 + 안 입는 경우) 계산
  let answer = 1;

  for (let count of wardrobe.values()) {
    answer *= count + 1;
  }

  // 3. 아무것도 안 입는 경우 제외
  return answer - 1;
}
