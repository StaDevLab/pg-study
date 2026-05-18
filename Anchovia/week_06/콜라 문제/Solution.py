def solution(a, b, n):
    answer = 0

    while(n // a > 0):
        answer += (n // a) * b
        temp = 0
        temp += n % a
        n =  (n // a) * b
        n += temp

    return answer
