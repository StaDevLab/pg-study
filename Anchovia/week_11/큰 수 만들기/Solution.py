def solution(number, k):
    stack = []

    for currentNum in number:
        # 앞에있는 숫자가 current 숫자보다 작으면 제거
        while stack and k > 0 and stack[-1] < currentNum:
            stack.pop()
            k -= 1

        # 현재 숫자를 스택(answer)에 추가
        stack.append(currentNum)

    # 지워야할게 남으면 뒤에서부터 제거
    if k > 0:
        stack = stack[:-k]

    return ''.join(stack)