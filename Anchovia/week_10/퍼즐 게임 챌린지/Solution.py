def solution(diffs, times, limit):
    left = 1
    right = max(diffs)

    answer = right

    while left <= right:
        mid = (left + right) // 2

        totalTime = 0

        for i in range(len(diffs)):
            diff = diffs[i]
            currentTime = times[i]

            # 숙련도가 난이도 이상이면 한 번에 해결
            if diff <= mid:
                totalTime += currentTime

            # 숙련도가 부족하면 틀리는 시간까지 계산함
            else:
                mistake = diff - mid
                prevTime = times[i - 1]

                totalTime += mistake * (currentTime + prevTime) + currentTime

            # 제한 시간을 넘으면 더 계산하지 않아도 됨
            if totalTime > limit:
                break

        # mid 숙련도로 제한 시간 안에 풀 수 있는 경우
        if totalTime <= limit:
            answer = mid
            right = mid - 1

        # 안되는 경우
        else:
            left = mid + 1

    return answer