def solution(n, lost, reserve):
    # 도난당한 학생은 자기 체육복을 입어야 하니까 제외
    real_lost = sorted(set(lost) - set(reserve))
    real_reserve = set(reserve) - set(lost)

    # 체육복을 잃어버린 학생들을 번호 순서대로 확인
    for student in real_lost:
        # 앞 번호 학생이 빌려줄 수 있다면 먼저 빌림
        if student - 1 in real_reserve:
            real_reserve.remove(student - 1)
        # 앞 번호가 안 되면 뒷 번호 학생에게 빌림
        elif student + 1 in real_reserve:
            real_reserve.remove(student + 1)
        # 둘 다 불가능하면 체육 수업 못들음
        else:
            n -= 1

    return n