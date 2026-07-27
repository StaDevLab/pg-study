def solution(edges):
    # 각 정점으로 들어오는 간선 수와 나가는 간선 수를 저장
    inCount = {}
    outCount = {}

    # 모든 간선을 확인하면서 진입 차수와 진출 차수 계산
    for start, end in edges:
        outCount[start] = outCount.get(start, 0) + 1
        inCount[end] = inCount.get(end, 0) + 1

        # 간선이 없는 방향도 0으로 저장
        if start not in inCount:
            inCount[start] = 0

        if end not in outCount:
            outCount[end] = 0

    createdNode = 0 # 새로 생성된 정점
    barCount = 0 # 막대 그래프 개수
    eightCount = 0 # 8자 그래프 개수

    # 각 정점의 들어오는 간선 수와 나가는 간선 수 확인
    for node in inCount:
        incoming = inCount[node]
        outgoing = outCount[node]

        # 들어오는 간선이 없고 나가는 간선이 2개 이상이면 생성 정점
        if incoming == 0 and outgoing >= 2:
            createdNode = node

        # 나가는 간선이 없는 정점은 막대 그래프의 끝
        elif outgoing == 0:
            barCount += 1

        # 들어오고 나가는 간선이 모두 2개 이상이면 8자 그래프의 중심
        elif incoming >= 2 and outgoing >= 2:
            eightCount += 1

    # 생성 정점의 나가는 간선 수는 전체 그래프 개수
    totalGraphCount = outCount[createdNode]

    # 전체 그래프에서 막대와 8자를 제외하면 도넛 그래프
    donutCount = totalGraphCount - barCount - eightCount

    return [createdNode, donutCount, barCount, eightCount]