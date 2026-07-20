function solution(info, edges) {
  const children = Array.from({ length: info.length }, () => []);

  for (const [parent, child] of edges) {
    children[parent].push(child);
  }

  let answer = 1;

  function backtracking(sheep, wolf, candidates) {
    answer = Math.max(answer, sheep);

    for (let i = 0; i < candidates.length; i++) {
      const node = candidates[i];

      const nextSheep = sheep + (info[node] === 0 ? 1 : 0);

      const nextWolf = wolf + (info[node] === 1 ? 1 : 0);

      // 늑대가 양보다 많거나 같으면 탐색 중단
      if (nextWolf >= nextSheep) {
        continue;
      }

      // 1. 현재 노드 선택
      candidates.splice(i, 1);

      // 2. 현재 노드의 자식들을 방문 후보에 추가
      const addedChildrenCount = children[node].length;
      candidates.push(...children[node]);

      // 3. 다음 경우 탐색
      backtracking(nextSheep, nextWolf, candidates);

      // 4. 추가했던 자식 노드 제거
      candidates.splice(
        candidates.length - addedChildrenCount,
        addedChildrenCount,
      );

      // 5. 선택했던 현재 노드를 원래 위치에 복구
      candidates.splice(i, 0, node);
    }
  }

  backtracking(1, 0, [...children[0]]);

  return answer;
}
