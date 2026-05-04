def solution(elements):
    answerSet = set()
    elemExtend = elements + elements
    
    # idx는 부분 수열의 시작점 (0부터 원래 배열의 끝까지)
    for idx in range(len(elements)):
        # selectLen은 부분 수열의 길이 (1부터 원래 배열의 길이까지)
        for selectLen in range(1, len(elements) + 1):
            # 슬라이싱을 이용해 i부터 i+selectLen까지 자르고 합을 구함
            sub_sum = sum(elemExtend[idx : idx + selectLen])
            answerSet.add(sub_sum)
            
    return len(answerSet)