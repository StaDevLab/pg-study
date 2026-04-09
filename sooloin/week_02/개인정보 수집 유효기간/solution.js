//150370. 개인정보 수집 유효기간

function totalDay(beforeDay) {
  let [year, month, day] = beforeDay.split(".").map(Number);
  const totalDay = year * 12 * 28 + month * 28 + day;
  return totalDay;
}

function solution(today, terms, privacies) {
  let termsMap = new Map();
  let answer = [];

  // 1. 약관 정보 저장
  for (const term of terms) {
    const [type, months] = term.split(" ");
    termsMap.set(type, Number(months));
  }

  // 2. 오늘 날짜 숫자로 변환
  let numToday = totalDay(today);

  // 3. 개인정보 하나씩 확인
  for (let i = 0; i < privacies.length; i++) {
    const [accessDay, type] = privacies[i].split(" ");
    const totalAccessDay = totalDay(accessDay);

    if (totalAccessDay + termsMap.get(type) * 28 <= numToday) {
      // 4. 파기 대상이면 answer.push(i + 1)
      answer.push(i + 1);
    }
  }

  return answer;
}
