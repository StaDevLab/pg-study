def solution(brown, yellow):
    total = brown + yellow
    
    # 세로 길이를 3부터 늘려가며 모두 체크함
    # 가운데 노랑 1개가 있어도 최소 높이는 3부터 시작임 
    for h in range(3, total + 1):
        # 전체 면적이 h로 나누어 떨어져야 직사각형이 됨
        if total % h == 0:
            # w * h = size니까 w = size // h
            w = total // h
            
            # 가로는 세로보다 길거나 같아야 하므로, 해당 안되면 넘김
            if w < h:
                break
            
            # 마지막으로 노란색 갯수 맞는지 체크함
            # 가로 두줄 세로 두줄 둘러싸고 있으니까 그거 빼서 곱해줌
            if (w - 2) * (h - 2) == yellow:
                return [w, h]