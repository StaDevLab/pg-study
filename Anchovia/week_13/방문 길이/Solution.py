def solution(dirs):
    x = 0
    y = 0

    # 이미 지나간 길을 저장
    visited = set()

    for direction in dirs:
        nextX = x
        nextY = y

        # 명령어에 따라 다음 좌표 계산
        if direction == 'U':
            nextY += 1
        elif direction == 'D':
            nextY -= 1
        elif direction == 'R':
            nextX += 1
        elif direction == 'L':
            nextX -= 1

        # 좌표평면의 범위를 벗어나면 이동하지 않음
        if nextX < -5 or nextX > 5 or nextY < -5 or nextY > 5:
            continue

        # 현재 위치에서 다음 위치로 가는 길 저장
        visited.add((x, y, nextX, nextY))

        # 반대 방향으로 가는 길도 같은 길이므로 함께 저장
        visited.add((nextX, nextY, x, y))

        # 현재 위치 변경
        x = nextX
        y = nextY

    # 길 하나를 양방향으로 저장했으므로 2로 나눔
    return len(visited) // 2