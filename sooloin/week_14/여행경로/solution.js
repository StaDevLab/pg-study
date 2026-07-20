function solution(tickets) {
  const graph = {};

  // 출발 공항별 도착 공항 저장
  for (const [from, to] of tickets) {
    if (!graph[from]) {
      graph[from] = [];
    }

    graph[from].push(to);
  }

  // pop()으로 알파벳 순서가 빠른 공항을 꺼내기 위해 역순 정렬
  for (const airport in graph) {
    graph[airport].sort().reverse();
  }

  const route = [];

  function dfs(airport) {
    while (graph[airport] && graph[airport].length > 0) {
      const nextAirport = graph[airport].pop();
      dfs(nextAirport);
    }

    route.push(airport);
  }

  dfs("ICN");

  return route.reverse();
}
