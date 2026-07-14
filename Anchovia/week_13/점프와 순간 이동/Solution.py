def solution(n):
    answer = 0

    while n > 0:
        # 현재 거리가 홀수면 1칸 점프해야 함
        if n % 2 == 1:
            n -= 1
            answer += 1

        # 현재 거리가 짝수면 순간이동으로 온 것으로 볼 수 있음
        else:
            n //= 2

    return answer