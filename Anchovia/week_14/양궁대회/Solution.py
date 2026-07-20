def solution(n, info):
    maxDiff = 0
    answer = [-1]

    # 라이언이 각 점수에 쏜 화살 개수
    lion = [0] * 11

    def dfs(index, remainingArrow):
        nonlocal maxDiff, answer

        # 10점부터 1점까지 모두 확인한 경우
        if index == 10:
            # 남은 화살은 전부 0점에 사용
            lion[10] = remainingArrow

            apeachScore = 0
            lionScore = 0

            # 어피치와 라이언의 점수 계산
            for i in range(11):
                score = 10 - i

                # 둘 다 화살을 쏘지 않은 경우
                if info[i] == 0 and lion[i] == 0:
                    continue

                # 라이언이 더 많이 맞힌 경우
                if lion[i] > info[i]:
                    lionScore += score
                else:
                    apeachScore += score

            scoreDiff = lionScore - apeachScore

            # 라이언이 이긴 경우만 확인
            if scoreDiff > 0:
                # 기존 점수 차이보다 더 큰 경우
                if scoreDiff > maxDiff:
                    maxDiff = scoreDiff
                    answer = lion[:]

                # 점수 차이가 같은 경우
                elif scoreDiff == maxDiff:
                    # 낮은 점수를 더 많이 맞힌 경우 선택
                    for i in range(10, -1, -1):
                        if lion[i] > answer[i]:
                            answer = lion[:]
                            break
                        elif lion[i] < answer[i]:
                            break

            # 다음 탐색을 위해 0점 화살 초기화
            lion[10] = 0
            return

        # 현재 점수를 라이언이 가져가는 경우
        needArrow = info[index] + 1

        if remainingArrow >= needArrow:
            lion[index] = needArrow
            dfs(index + 1, remainingArrow - needArrow)
            lion[index] = 0

        # 현재 점수를 포기하는 경우
        dfs(index + 1, remainingArrow)

    dfs(0, n)

    return answer