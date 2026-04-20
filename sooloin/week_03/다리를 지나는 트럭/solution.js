//42583. 다리를 지나는 트럭

function solution(bridge_length, weight, truck_weights) {
  // 1. bridge_length만큼 Queue 생성
  let bridge = new Array(bridge_length).fill(0);

  // 2. time / bridge_weight 변수 생성
  let time = 0;
  let bridge_weight = 0;

  // 대기 트럭이 남았거나, 다리 위에서 아직 트럭이 남아있으면 반복
  while (truck_weights.length > 0 || bridge_weight > 0) {
    time++;

    // 1. 다리 맨 앞 트럭이 빠져 나감
    const passedTruck = bridge.shift();
    bridge_weight -= passedTruck;

    // 2. 다음 트럭이 올라갈 수 있으면 올림
    if (
      truck_weights.length > 0 &&
      bridge_weight + truck_weights[0] <= weight
    ) {
      const nextTruck = truck_weights.shift();
      bridge.push(nextTruck);
      bridge_weight += nextTruck;
    } else {
      bridge.push(0);
    }
  }

  return time;
}
