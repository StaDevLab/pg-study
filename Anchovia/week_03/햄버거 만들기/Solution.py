def solution(ingredient):
    stk = []
    answer = 0

    for food in ingredient:
        stk.append(food)

        if len(stk) >= 4 and stk[-4:] == [1, 2, 3, 1]:
            answer += 1
            for _ in range(4):
                stk.pop()

    return answer