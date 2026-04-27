def solution(numbers):
    # 중복 제거를 위해 answer를 집합 자료형으로 선언
    answer = set()

    # 더할 수 있는 모든 경우를 순회해 계산함
    # a, b, c, d, e
    # a + a는 하면 안되므로, i + 1부터 시작함(b부터 더하게)
    for i in range(len(numbers)):
        for j in range(i + 1, len(numbers)):
            answer.add(numbers[i] + numbers[j])
    
    # list로 바꾸고 오름차순 정렬함
    answer = list(answer)
    answer.sort()

    return answer