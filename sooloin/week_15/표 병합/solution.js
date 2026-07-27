function solution(commands) {
  const SIZE = 50;
  const CELL_COUNT = SIZE * SIZE;

  const parent = Array.from({ length: CELL_COUNT }, (_, index) => index);

  const value = Array(CELL_COUNT).fill(null);
  const answer = [];

  const getIndex = (r, c) => {
    return (r - 1) * SIZE + (c - 1);
  };

  const find = (x) => {
    if (parent[x] === x) {
      return x;
    }

    parent[x] = find(parent[x]);

    return parent[x];
  };

  const merge = (first, second) => {
    const firstRoot = find(first);
    const secondRoot = find(second);

    if (firstRoot === secondRoot) {
      return;
    }

    // 첫 번째 셀의 값을 우선함
    const mergedValue = value[firstRoot] ?? value[secondRoot];

    parent[secondRoot] = firstRoot;

    value[firstRoot] = mergedValue;
    value[secondRoot] = null;
  };

  const unmerge = (target) => {
    const root = find(target);
    const savedValue = value[root];

    const members = [];

    // 부모를 변경하기 전에 그룹원을 먼저 찾음
    for (let i = 0; i < CELL_COUNT; i++) {
      if (find(i) === root) {
        members.push(i);
      }
    }

    // 모든 셀을 독립된 상태로 되돌림
    for (const member of members) {
      parent[member] = member;
      value[member] = null;
    }

    // 선택한 위치에만 기존 값을 복구함
    value[target] = savedValue;
  };

  for (const command of commands) {
    const parts = command.split(" ");
    const type = parts[0];

    if (type === "UPDATE") {
      // UPDATE r c value
      if (parts.length === 4) {
        const r = Number(parts[1]);
        const c = Number(parts[2]);
        const newValue = parts[3];

        const index = getIndex(r, c);
        const root = find(index);

        value[root] = newValue;
      }

      // UPDATE value1 value2
      else {
        const oldValue = parts[1];
        const newValue = parts[2];

        for (let i = 0; i < CELL_COUNT; i++) {
          if (parent[i] === i && value[i] === oldValue) {
            value[i] = newValue;
          }
        }
      }
    }

    if (type === "MERGE") {
      const r1 = Number(parts[1]);
      const c1 = Number(parts[2]);
      const r2 = Number(parts[3]);
      const c2 = Number(parts[4]);

      const first = getIndex(r1, c1);
      const second = getIndex(r2, c2);

      merge(first, second);
    }

    if (type === "UNMERGE") {
      const r = Number(parts[1]);
      const c = Number(parts[2]);

      unmerge(getIndex(r, c));
    }

    if (type === "PRINT") {
      const r = Number(parts[1]);
      const c = Number(parts[2]);

      const root = find(getIndex(r, c));

      answer.push(value[root] ?? "EMPTY");
    }
  }

  return answer;
}
