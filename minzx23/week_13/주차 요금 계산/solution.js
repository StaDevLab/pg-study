function solution(fees, records) {
    let answer=[];
    let feesMap=new Map;
    
    for (let record of records){
        let [time, number, log]=record.split(' ');
        let [hour, minute]=time.split(':').map(Number);
        let totalMin=hour*60+minute;
        
        if(!feesMap.has(number)){
            feesMap.set(number, [])
        }
        feesMap.get(number).push([totalMin, log])
    }
    
    // 차량별 주차 시간 계산
    for (let [car, inOut] of [...feesMap.entries()].sort((a,b)=>a[0]-b[0])){
        let totalTime=0;
        let inTime=null;
        
        for (let [time, isIn] of inOut){
            if(isIn==='IN'){
                inTime=time;
            }
            else{
                totalTime+=time-inTime;
                inTime=null;
            }
        }
        
        // 마지막까지 출차 기록이 없으면 23:59에 나간거로 처리
        if(inTime!=null){
            totalTime+=(23*60+59)-inTime;
        }
        
        let fee=0;

        if(totalTime-fees[0]<0){
            fee=fees[1];
        }
        else{
            fee=fees[1]+Math.ceil((totalTime-fees[0])/fees[2])*fees[3];
        }

        answer.push(fee);
    }
    
    return answer;
}