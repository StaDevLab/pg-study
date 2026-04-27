def solution(sizes):
    widths = []
    heights = []
    
    # [큰 값, 작은 값] 순서로 정렬함
    for width, height in sizes:
        # 더 큰 값을 width로
        if width < height:
            width, height = height, width
        
        # 리스트에 추가
        widths.append(width)
        heights.append(height)
    
    # (가로 중 최대) * (세로 중 최대)
    return max(widths) * max(heights)