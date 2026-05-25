class Solution(object):
    def isPalindrome(self, s):
        i = 0
        j = len(s) - 1

        while i < j:
            # 영어/숫자가 나올 때까지 오른쪽, 왼쪽 이동
            while i < j and not s[i].isalnum():
                i += 1
            while i < j and not s[j].isalnum():
                j -= 1
            
            # 소문자 통일해 비교
            if s[i].lower() != s[j].lower():
                return False
            
            # 같으면 다음 문자로 이동
            i += 1
            j -= 1
            
        return True