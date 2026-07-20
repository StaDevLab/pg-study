def solution(tickets):
    # 전처리
    tickets.sort() # 알파벳 순으로 정렬
    visited = [False] * len(tickets) # 항공권 사용 여부

    answer = []

    def dfs(currentAirport, path):
        # 모든 항공권을 사용했다면 경로 저장
        if len(path) == len(tickets) + 1:
            answer.extend(path)
            return True

        # 현재 공항에서 갈 수 있는 항공권 찾기
        for i in range(len(tickets)):
            startAirport = tickets[i][0]
            endAirport = tickets[i][1]

            # 아직 사용하지 않았고 현재 공항에서 출발하는 항공권일때
            if not visited[i] and startAirport == currentAirport:
                visited[i] = True  # 항공권 사용

                # 다음 공항으로 이동
                if dfs(endAirport, path + [endAirport]):
                    return True

                # 경로가 막히면 다시 사용하지 않은 상태로 되돌리기
                visited[i] = False

        # 갈 수 있는 경로가 없으면 실패
        return False

    # 인천 공항에서 출발
    dfs("ICN", ["ICN"])

    return answer