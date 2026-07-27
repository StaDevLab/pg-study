function solution(edges) {
  const MAX_NODE = 1_000_000;

  const inDegree = new Int32Array(MAX_NODE + 1);
  const outDegree = new Int32Array(MAX_NODE + 1);

  let maxNode = 0;

  // 각 정점의 진입 차수와 진출 차수를 계산함.
  for (let i = 0; i < edges.length; i++) {
    const from = edges[i][0];
    const to = edges[i][1];

    outDegree[from]++;
    inDegree[to]++;

    maxNode = Math.max(maxNode, from, to);
  }

  let createdNode = 0;
  let stickCount = 0;
  let eightCount = 0;

  // 정점의 차수 특징을 이용하여 그래프 종류를 판별함.
  for (let node = 1; node <= maxNode; node++) {
    if (inDegree[node] === 0 && outDegree[node] >= 2) {
      createdNode = node;
    } else if (inDegree[node] >= 1 && outDegree[node] === 0) {
      stickCount++;
    } else if (inDegree[node] >= 2 && outDegree[node] === 2) {
      eightCount++;
    }
  }

  const totalCount = outDegree[createdNode];
  const donutCount = totalCount - stickCount - eightCount;

  return [createdNode, donutCount, stickCount, eightCount];
}
