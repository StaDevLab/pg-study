def solution(n):
    if(n == 1): return 1
    elif(2 <= n < 6): return 2
    elif(6 <= n < 24): return 3
    elif(24 <= n < 120): return 4
    elif(120 <= n < 720): return 5
    elif(720 <= n < 5040): return 6
    elif(5040 <= n < 40320): return 7
    elif(40320 <= n < 362880): return 8
    elif(362880 <= n < 3628800): return 9
    else: return 10