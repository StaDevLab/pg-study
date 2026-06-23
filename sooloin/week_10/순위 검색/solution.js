function solution(info, query) {
  const map = new Map();

  function makeCombinations(arr, score, depth, key) {
    if (depth === 4) {
      if (!map.has(key)) {
        map.set(key, []);
      }

      map.get(key).push(score);
      return;
    }

    makeCombinations(arr, score, depth + 1, key + arr[depth]);
    makeCombinations(arr, score, depth + 1, key + "-");
  }

  for (const applicant of info) {
    const splitInfo = applicant.split(" ");
    const score = Number(splitInfo[4]);
    const conditions = splitInfo.slice(0, 4);

    makeCombinations(conditions, score, 0, "");
  }

  for (const scores of map.values()) {
    scores.sort((a, b) => a - b);
  }

  function lowerBound(arr, target) {
    let left = 0;
    let right = arr.length;

    while (left < right) {
      const mid = Math.floor((left + right) / 2);

      if (arr[mid] >= target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    return left;
  }

  const answer = [];

  for (const q of query) {
    const cleanedQuery = q.replaceAll(" and ", " ");
    const splitQuery = cleanedQuery.split(" ");

    const key = splitQuery.slice(0, 4).join("");
    const targetScore = Number(splitQuery[4]);

    const scores = map.get(key) || [];
    const index = lowerBound(scores, targetScore);

    answer.push(scores.length - index);
  }

  return answer;
}
