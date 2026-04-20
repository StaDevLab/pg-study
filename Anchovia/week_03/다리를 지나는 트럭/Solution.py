def solution(bridge_length, weight, truck_weights):
    # 다리 길이만큼 리스트 깡으로 선언
    bridge = [0] * bridge_length
    # 다리 위 무게 총합
    total_weight = 0
    # 걸린 시간
    answer = 0

    # bridge 리스트가 안비어있을때(모든 트럭이 다리를 건널 때)까지 진행
    # truck_weights = [t1, t2] 라면
    # ([0, 0] -> [0, t1] -> [t1, t2] -> [t2] -> [])
    while bridge:
        answer += 1

        # 맨 앞 트럭이 지나감(나갔으니 그 트럭 무게만큼 빼야함)
        total_weight -= bridge.pop(0)

        # 들어올 트럭이 남아있는지 확인
        if truck_weights:
            # 들어갈 수 있으면, 다리 위에 올려도 되는지 확인(트럭 올라가면 다리 안뽀샤지는지 확인)
            if total_weight + truck_weights[0] <= weight:
                # 가능하면, truck_weights 맨 앞에 pop 하고
                truck = truck_weights.pop(0)
                # 다리 위에 올리고
                bridge.append(truck)
                # 그 무게만큼 더함
                total_weight += truck
            else:
                # 올렸다가 다리가 뽀샤질거같으면 시간만 보냄 
                bridge.append(0)

    return answer