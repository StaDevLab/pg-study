def solution(clothes):
    answer = 1
    wear_dict = {}

    for wear in clothes:
        wear_dict[wear[1]] = []
    
    for wear in clothes:
        wear_dict[wear[1]].append(wear[0])

    for value in wear_dict.values():
        answer *= len(value) + 1

    return answer - 1