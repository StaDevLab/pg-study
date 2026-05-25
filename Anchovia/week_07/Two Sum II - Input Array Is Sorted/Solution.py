class Solution(object):
    def twoSum(self, numbers, target):
        # 양끌에서 좁히면서 탐색
        left = 0
        right = len(numbers) - 1
        
        while left < right:
            sum = numbers[left] + numbers[right]
            
            # 합이 맞으면 +1 해서 반환
            if sum == target:
                return [left + 1, right + 1]
            
            # 합이 작으면 값을 키워야 하므로 left를 오른쪽으로
            elif sum < target:
                left += 1
            
            # 합이 크면 값을 줄여야 하므로 right를 왼쪽으로
            else:
                right -= 1