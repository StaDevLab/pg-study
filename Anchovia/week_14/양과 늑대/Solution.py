def solution(info, edges):
    answer = [0]

    # 각 노드의 자식 노드 저장
    childs = [[] for _ in range(len(info))]

    for parent, child in edges:
        childs[parent].append(child)

    def dfs(sheepCount, wolfCount, availableNodes):
        # 지금까지 모은 양의 최대값 갱신
        answer[0] = max(answer[0], sheepCount)

        # 현재 갈 수 있는 노드를 하나씩 선택
        for i in range(len(availableNodes)):
            next = availableNodes[i]

            nextSheepCount = sheepCount
            nextWolfCount = wolfCount

            # 다음 노드가 양인 경우
            if info[next] == 0:
                nextSheepCount += 1
            else:
                nextWolfCount += 1

            # 늑대가 양보다 많거나 같으면 이동 불가
            if nextWolfCount >= nextSheepCount:
                continue

            # 방문한 노드를 제외한 후보 노드
            nextAvailableNodes = availableNodes[:i] + availableNodes[i + 1:]

            # 자식 노드 추가
            nextAvailableNodes += childs[next]

            dfs(nextSheepCount, nextWolfCount, nextAvailableNodes)

    # 루트(0번)는 항상 양
    dfs(1, 0, childs[0])

    return answer[0]