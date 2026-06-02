def solution(k, dungeons):
    visited = [False] * len(dungeons) # 방문 배열

    # 현재 피로도, 현재까지 탐험한 던전 수
    def dfs(fatigue, count):
        maxCount = count

        # 모든 던전 확인
        for i in range(len(dungeons)):
            need, cost = dungeons[i]

            # 방문하지 않았고 탐험 가능하면
            if not visited[i] and fatigue >= need:
                visited[i] = True # 방문 처리

                result = dfs(fatigue - cost, count + 1) # 다음 던전 탐험 결과 확인
                maxCount = max(maxCount, result )# 최댓값 갱신

                visited[i] = False # 다른 경우 탐색 위해 방문 해제 !!!!!!!!!!

        return maxCount

    return dfs(k, 0) # dfs 탐색 ㄱㄱ