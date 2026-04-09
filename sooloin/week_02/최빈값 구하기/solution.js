//120812. 최빈값 구하기

function solution(array) {
  let freqMap = new Map();
  var answer = 0;

  array.forEach((el) => {
    let cnt = 1;

    if (freqMap.has(el)) {
      freqMap.set(el, freqMap.get(el) + 1);
    } else {
      freqMap.set(el, cnt);
    }
  });

  let maxCnt = 0;
  let isDuplicate = false;

  for (let [key, cnt] of freqMap) {
    if (cnt > maxCnt) {
      maxCnt = cnt;
      answer = key;
      isDuplicate = false;
    } else if (cnt == maxCnt) {
      isDuplicate = true;
    }
  }

  return isDuplicate ? -1 : answer;
}
