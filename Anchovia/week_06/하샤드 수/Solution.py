def solution(x):
    sum = 0
    for i in list(str(x)): sum += int(i)
    return (x % sum) == 0