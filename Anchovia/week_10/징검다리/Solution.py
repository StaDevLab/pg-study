def solution(distance, rocks, n):
    # 바위 위치 정렬
    rocks.sort()

    # 도착 지점도 마지막 바위처럼 추가
    rocks.append(distance)

    left = 1
    right = distance
    answer = 0

    while left <= right:
        mid = (left + right) // 2

        # 마지막으로 남긴 바위 위치
        prev = 0

        # 제거한 바위 개수
        removeCount = 0

        for rock in rocks:
            # 이전 위치와 현재 바위 사이 거리가 mid보다 작으면 최소 거리 mid를 만족하지 못하므로 현재 바위를 제거
            if rock - prev < mid:
                removeCount += 1

            # 거리가 mid 이상이면 현재 바위 남김
            else:
                prev = rock

        # 제거한 바위 개수가 n개 이하라면 가장 짧은 mid를 만들 수 있음
        if removeCount <= n:
            answer = mid
            left = mid + 1

        # 너무 많은 바위를 제거해야 한다면 mid가 너무 큰거니까 줄여야 함
        else:
            right = mid - 1

    return answer