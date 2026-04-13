//12981. 영어 끝말잇기

function solution(n, words) {
  let wordSet = new Set();
  wordSet.add(words[0]);

  for (let i = 1; i < words.length; i++) {
    let beforeWord = words[i - 1];

    // 1. 중복된 단어를 말한 경우
    if (wordSet.has(words[i])) {
      return [(i % n) + 1, Math.floor(i / n) + 1];
    }
    // 2. 잘못된 단어를 말한 경우
    else if (words[i].charAt(0) !== beforeWord.charAt(beforeWord.length - 1)) {
      return [(i % n) + 1, Math.floor(i / n) + 1];
    } else {
      wordSet.add(words[i]);
    }
  }

  return [0, 0];
}
