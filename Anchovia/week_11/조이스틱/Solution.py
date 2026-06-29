def solution(name):
    answer = 0
    n = len(name)

    # 일단 오른쪽으로만 쭉 가는 경우
    move = n - 1

    for i in range(n):
        # 현재 알파벳을 A에서 바꾸는 최소 횟수
        up = ord(name[i]) - ord('A')
        down = ord('Z') - ord(name[i]) + 1
        answer += min(up, down)

        # 현재 위치 다음부터 연속된 A 찾기
        nextIndex = i + 1

        while nextIndex < n and name[nextIndex] == 'A':
            nextIndex += 1

        # 오른쪽으로 갔다가 다시 왼쪽으로 돌아가는 경우
        move = min(move, i * 2 + n - nextIndex)

        # 왼쪽으로 먼저 갔다가 오른쪽으로 돌아오는 경우
        move = min(move, (n - nextIndex) * 2 + i)

    answer += move

    return answer