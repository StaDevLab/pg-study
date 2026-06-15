from itertools import combinations
from bisect import bisect_left

def solution(info, query):
    answer = []
    
    # 조건 조합별 점수 목록을 저장할 딕셔너리
    infoDict = {}

    # 지원자 정보 처리
    for data in info:
        data = data.split()
        
        # 앞의 4개는 조건이고 마지막은 점수임
        conditions = data[:-1]
        score = int(data[-1])

        # 4개 조건 중 일부를 '-'로 바꾸는 모든 경우 생성
        for i in range(5):
            for comb in combinations(range(4), i):
                temp = conditions[:]

                # 선택된 위치를 '-'로 변경
                for idx in comb:
                    temp[idx] = '-'

                # 조건을 하나의 문자열 key 제작
                key = ''.join(temp)

                # 해당 조건 key에 점수 저장
                if key not in infoDict:
                    infoDict[key] = []

                infoDict[key].append(score)

    # 이분 탐색을 위해 리스트 정렬
    for key in infoDict:
        infoDict[key].sort()

    # query 처리
    for q in query:
        # and 지워버림
        q = q.replace(' and ', ' ')
        q = q.split()

        # 앞의 4개는 조건, 마지막은 기준 점수
        conditions = q[:-1]
        targetScore = int(q[-1])

        key = ''.join(conditions)

        # 해당 조건에 맞는 지원자가 있는 경우
        if key in infoDict:
            scores = infoDict[key]

            # targetScore 이상인 첫 위치 찾기
            idx = bisect_left(scores, targetScore)

            # 전체 개수 - idx = targetScore 이상인 사람 수
            answer.append(len(scores) - idx)

        # 해당 조건에 맞는 지원자가 없는 경우
        else:
            answer.append(0)

    return answer