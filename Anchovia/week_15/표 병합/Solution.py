def solution(commands):
    answer = []

    # 각 셀이 어느 그룹에 속해 있는지 저장
    group = [i for i in range(2500)]

    # 각 그룹이 가지고 있는 값
    values = [""] * 2500

    # 행과 열을 0부터 시작하는 번호 하나로 바꾸는 함수
    def getIndex(row, col):
        return (row - 1) * 50 + (col - 1)

    for command in commands:
        parts = command.split()

        # UPDATE 명령어
        if parts[0] == "UPDATE":
            # UPDATE r c value
            if len(parts) == 4:
                row = int(parts[1])
                col = int(parts[2])
                newValue = parts[3]

                index = getIndex(row, col)
                groupNumber = group[index]

                # 해당 셀이 속한 그룹의 값을 변경
                values[groupNumber] = newValue

            # UPDATE value1 value2
            else:
                oldValue = parts[1]
                newValue = parts[2]

                # 모든 그룹 값을 확인하면서 변경
                for i in range(2500):
                    if values[i] == oldValue:
                        values[i] = newValue

        # MERGE 명령어
        elif parts[0] == "MERGE":
            row1 = int(parts[1])
            col1 = int(parts[2])
            row2 = int(parts[3])
            col2 = int(parts[4])

            index1 = getIndex(row1, col1)
            index2 = getIndex(row2, col2)

            group1 = group[index1]
            group2 = group[index2]

            # 이미 같은 그룹이면 무시
            if group1 == group2:
                continue

            value1 = values[group1]
            value2 = values[group2]

            # 첫 번째 셀의 값이 있으면 우선 사용
            if value1 != "":
                mergedValue = value1
            else:
                mergedValue = value2

            # group2에 속한 셀들을 group1로 합치기
            for i in range(2500):
                if group[i] == group2:
                    group[i] = group1

            values[group1] = mergedValue
            values[group2] = ""

        # UNMERGE 명령어
        elif parts[0] == "UNMERGE":
            row = int(parts[1])
            col = int(parts[2])

            index = getIndex(row, col)
            groupNumber = group[index]
            savedValue = values[groupNumber]

            # 같은 그룹에 속한 모든 셀의 병합 해제
            for i in range(2500):
                if group[i] == groupNumber:
                    group[i] = i
                    values[i] = ""

            # 선택한 위치만 기존 값을 다시 가짐
            values[index] = savedValue

        # PRINT 명령어
        elif parts[0] == "PRINT":
            row = int(parts[1])
            col = int(parts[2])

            index = getIndex(row, col)
            groupNumber = group[index]
            result = values[groupNumber]

            if result == "":
                answer.append("EMPTY")
            else:
                answer.append(result)

    return answer