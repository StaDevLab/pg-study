def solution(sequence, k):
    answer = []
    
    start = 0
    end = 0
    sum = sequence[0]
    minLen = 10000001
    
    while start <= end and end < len(sequence):
        # k와 같은 경우
        if sum == k:
            # 현재 찾은 수열의 길이가 기존에 찾은 길이보다 짧다면 바꿈(minLen)
            if end - start < minLen:
                minLen = end - start
                answer = [start, end]
            
            # 다음 경우의 수를 찾기 위해 start를 한 칸 이동
            sum -= sequence[start]
            start += 1
            
        # 합이 k보다 작은 경우 end를 오른쪽으로 이동(값을 늘려야함)
        elif sum < k:
            end += 1
            if end < len(sequence):
                sum += sequence[end]
                
        # 합이 k보다 큰 경우 start를 오른쪽으로 이동(값을 줄여야함)
        else:
            sum -= sequence[start]
            start += 1
            
    return answer