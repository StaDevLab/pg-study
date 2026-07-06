def solution(land):
    # dp[i][j] -> i행 j열을 밟았을 때 얻을 수 있는 최대 점수
    dp = [[0] * 4 for _ in range(len(land))]

    # 첫 번째 행은 이전 행이 없으므로 land 값 그대로 사용
    dp[0] = land[0]

    # 두 번째 행부터 마지막 행까지 확인
    for i in range(1, len(land)):
        # 현재 0열을 밟으려면 이전 행의 0열은 밟을 수 없음
        dp[i][0] = land[i][0] + max(dp[i - 1][1], dp[i - 1][2], dp[i - 1][3])

        # 현재 1열을 밟으려면 이전 행의 1열은 밟을 수 없음
        dp[i][1] = land[i][1] + max(dp[i - 1][0], dp[i - 1][2], dp[i - 1][3])

        # 현재 2열을 밟으려면 이전 행의 2열은 밟을 수 없음
        dp[i][2] = land[i][2] + max(dp[i - 1][0], dp[i - 1][1], dp[i - 1][3])

        # 현재 3열을 밟으려면 이전 행의 3열은 밟을 수 없음
        dp[i][3] = land[i][3] + max(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2])

    # 마지막 행까지 내려왔을 때 가능한 점수 중 최댓값 반환
    return max(dp[-1])