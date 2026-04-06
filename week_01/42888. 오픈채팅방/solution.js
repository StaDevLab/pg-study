// 42888. 오픈채팅방

const nameMap = new Map();
const userLogs = [];

function solution(record) {
  record.forEach((el) => {
    const [action, uid, nickname] = el.split(" ");

    if (action === "Enter") {
      nameMap.set(uid, nickname);
      userLogs.push([action, uid]);
    } else if (action === "Leave") {
      userLogs.push([action, uid]);
    } else if (action === "Change") {
      nameMap.set(uid, nickname);
    }
  });

  const answer = [];
  userLogs.forEach((el) => {
    const action = el[0];
    const uid = el[1];
    const logName = nameMap.get(uid);

    if (action === "Enter") {
      answer.push(`${logName}님이 들어왔습니다.`);
    } else if (action === "Leave") {
      answer.push(`${logName}님이 나갔습니다.`);
    }
  });

  return answer;
}
