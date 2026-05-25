from itertools import combinations

class Solution(object):
    # 모든 괄호 경우를 만들고 그 중에 검증된걸 빼냄
    def generateParenthesis(self, n):
        result = []
        
        # 0부터 2n-1까지의 인덱스 중 '('가 들어갈 인덱스 n개를 뽑음
        for open in combinations(range(2 * n), n):
            # 일단 전부 ')'로 채운 리스트를 만듬
            raw = [")"] * (2 * n)
            # 뽑은 인덱스 자리에만 '('를 덮어씌움
            for i in open:
                raw[i] = "("
            # 결론적으로 모든 괄호의 경우를 만들어봄
            openStr = "".join(raw)
            
            # 만들어진게 올바른 괄호 형태인지 검증
            check = 0
            judg = True
            for char in openStr:
                if char == "(":
                    check += 1
                else:
                    check -= 1
                # 평형이 깨지면(괄호 갯수가 다르면) 올바른 괄호가 아님 !!!
                if check < 0:
                    judg = False
                    break
            
            # 검증을 통과한 친구만 결과에 추가
            if judg and check == 0:
                result.append(openStr)
                
        return result