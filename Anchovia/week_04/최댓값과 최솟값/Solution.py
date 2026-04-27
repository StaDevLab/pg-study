def solution(s):
    # 숫자 문자열을 nums 리스트로 변환
    nums = list(map(int, s.split(" ")))
    answer = f"{min(nums)} {max(nums)}"
    return answer