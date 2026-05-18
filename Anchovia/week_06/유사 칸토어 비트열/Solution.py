def solution(n, l, r):
    # l과 r을 0번째부터 시작하도록 1 빼줬음
    l -= 1
    r -= 1
    
    # step: 현재 단계
    # start: 현재 블록 시작 칸
    # end: 현재 블록 끝 칸
    def search(step, start, end):
        # 구하고자 하는 범위 [l, r]와 현재 블록이 전혀 안 겹치면 무시함
        if end < l or r < start:
            return 0
        
        # 현재 블록이 구하고자 하는 범위 안에 통째로 쏙 들어간다면,
        # 더 깊이 안들어가고 이 블록이 가진 1의 개수를 통째로 리턴함
        if l <= start and end <= r:
            return 4 ** step
        
        # 애매하게 걸쳐있다면 5등분으로 쪼개서 자식 블록들을 봄
        childLen = 5 ** (step - 1) # 자식 블록 하나 길이
        total = 0
        
        for i in range(5):
            # 3번째 블록(idx = 2)은 무조건 0으로 차있으니 무시(1 1 0 1 1)
            if i == 2:
                continue
                
            # 각 자식 블록의 시작점과 끝점을 계산해서 시작
            child_start = start + i * childLen
            child_end = child_start + childLen - 1
            
            total += search(step - 1, child_start, child_end)
            
        return total

    # 0부터 n까지 진행
    return search(n, 0, 5**n - 1)