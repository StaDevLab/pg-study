def solution(board, moves):
    stack = []
    answer = 0

    # 뽑는 열 선택
    for now_move in moves:
        # 해당 열을 위에서 아래로 훑음
        for i in range(len(board)):
            # 인형이 있어야 뽑음(0은 해당 col에 인형이 없음)
            if board[i][now_move - 1] != 0:
                # 잡은 인형의 숫자를 catched에 저장
                catched = board[i][now_move - 1]
                # 잡은 인형이 있던 위치는 0(뺐음) 처리
                board[i][now_move - 1] = 0

                # stack의 top이 catched랑 같으면
                if stack and stack[-1] == catched:
                    # 스택 pop() 하고
                    stack.pop()
                    # 인형이 한 번에 2개씩 터지니까 2 증가
                    answer += 2
                else:
                    # 근데 top이랑 같지 않으면 그냥 위로 쌓음
                    stack.append(catched)

                break

    return answer