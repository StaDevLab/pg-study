# 순열 라이브러리 사용
from itertools import permutations

class Solution(object):
    def permute(self, nums):
        result = []
        
        # 길이 4의 순열 생성
        for per in permutations(nums, len(nums)):
            result.append(list(per))

        return result
    