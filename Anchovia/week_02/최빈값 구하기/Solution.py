from collections import Counter

def solution(array):
    answer = 0
    num_counter = Counter(array)

    max = 0
    key = 0
    judg = False
    for k in num_counter.keys():
        if num_counter[k] > max:
            max = num_counter[k]
            key = k
            judg = False
        elif num_counter[k] == max and not judg:
            judg = True
    
    if judg:
        answer = -1
    else:
        answer = key

    return answer