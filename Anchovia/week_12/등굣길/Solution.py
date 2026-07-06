def solution(m, n, puddles):
    # dp[row][col] -> 집에서 해당 칸까지 오는 경로 수(dp[y][x]로 접근)
    dp = [[0] * (m + 1) for _ in range(n + 1)]

    # 물웅덩이 위치 표시
    for x, y in puddles:
        dp[y][x] = -1

    # 시작점
    dp[1][1] = 1

    for row in range(1, n + 1):
        for col in range(1, m + 1):
            # 시작점은 이미 1로 설정했으므로 건너뜀
            if row == 1 and col == 1:
                continue

            # 물웅덩이는 경로 수 0으로 처리
            if dp[row][col] == -1:
                dp[row][col] = 0
                continue

            # 현재 칸까지 오는 방법 -> 위쪽에서 오는 방법 + 왼쪽에서 오는 방법
            dp[row][col] = (dp[row - 1][col] + dp[row][col - 1]) % 1000000007

    return dp[n][m]