def solution(numlist, n):
    answer = []
    gap = 0 # n과의 거리 저장할 변수

    # numlist 빌때까지 반복
    while numlist:
        # 정렬을 위해 temp 리스트 선언
        temp = []
        
        # numlist 하나씩 빼가며 순회
        for num in numlist:
            # n과의 거리가 gap과 같으면
            if abs(num - n) == gap:
                # temp(정렬 전 리스트)에 num 추가
                temp.append(num)
        
        # 찾은 숫자가 있다면(len(temp) != 0)
        if temp:
            # 오름차순 정렬하고 pop()으로 상단부터 뺌, numlist도 같이 remove함
            temp.sort()
            while temp:
                target = temp.pop()
                answer.append(target)
                numlist.remove(target)
            
        # gap을 1씩 증가
        gap += 1

    return answer