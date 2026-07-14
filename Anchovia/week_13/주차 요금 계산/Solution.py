import math

def solution(fees, records):
    basicTime, basicFee, unitTime, unitFee = fees

    # 차량별 입출차 시간을 저장
    carRecords = {}

    for record in records:
        time, carNumber, status = record.split()

        hour, minute = map(int, time.split(':'))
        currentTime = hour * 60 + minute

        if carNumber not in carRecords:
            carRecords[carNumber] = []

        carRecords[carNumber].append(currentTime)

    answer = []

    # 차량 번호가 작은 순서대로 확인
    for carNumber in sorted(carRecords):
        times = carRecords[carNumber]

        # 출차 기록이 없으면 23:59에 출차한 것으로 처리
        if len(times) % 2 == 1:
            times.append(23 * 60 + 59)

        totalTime = 0

        # 입차 시간과 출차 시간을 두 개씩 묶어서 계산
        for i in range(0, len(times), 2):
            totalTime += times[i + 1] - times[i]

        # 요금 계산
        if totalTime <= basicTime:
            fee = basicFee
        else:
            extraTime = totalTime - basicTime
            fee = basicFee + math.ceil(extraTime / unitTime) * unitFee

        answer.append(fee)

    return answer