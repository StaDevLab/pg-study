function solution(bridge_length, weight, truck_weights) {
    var answer = 0;
    
    // 다리 배열
    let queue= Array(bridge_length).fill(0);
    let sum=0;
    
    // 다리에 트럭이 있거나 대기 트럭이 있으면 반복
    while (sum>0||truck_weights.length>0){
        answer++;
        sum-=queue.shift();
        
        // 다리에 다음 트럭 올림
        if (sum+truck_weights[0]<=weight){
            let w=truck_weights.shift();
            queue.push(w);
            sum+=w;
        }
        // 다음 트럭을 올릴 수 없으면 다리 빈칸 채우기
        else {
            queue.push(0);
        }
    }
    
    return answer;
}