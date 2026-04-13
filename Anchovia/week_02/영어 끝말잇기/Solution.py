def solution(n, words):
    answer = []
    
    word_set = set()
    word_len = 0
    loop = 1
    prev = ""
    for idx, word in enumerate(words):
        word_set.add(word)

        if word_len == len(word_set):
            answer = [((idx) % n) + 1, loop]
            return answer
        elif prev and prev[len(prev) - 1] != word[0]:
            answer = [((idx) % n) + 1, loop]
            return answer

        if (idx + 1) % n == 0:
            loop += 1

        word_len = len(word_set)
        prev = word
    
    answer = [0, 0]
    return answer