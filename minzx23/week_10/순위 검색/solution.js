function solution(info, query) {
    let map = new Map();

    for (let item of info) {
        let parts = item.split(' ');
        let score = Number(parts[4]); //점수
        let apply = parts.slice(0, 4); //조건
        
        for (let i = 0; i < 16; i++) {
            let key = [];
            
            for (let j = 0; j < 4; j++) {
                key.push((i & (1 << j)) ? '-' : apply[j]);
            }
            
            let keyStr = key.join(' ');
            
            if (!map.has(keyStr)){
                map.set(keyStr, []);
            }
            
            map.get(keyStr).push(score);
        }
    }

    for (let arr of map.values()) {
        arr.sort((a, b) => a - b);
    }

    let answer = [];
    
    for (let q of query) {
        let tokens = q.split(' ');
        let key = [tokens[0], tokens[2], tokens[4], tokens[6]].join(' ');
        let X = Number(tokens[7]); //기준 점수

        let arr = map.get(key);
        
        if (!arr){
            answer.push(0);
            continue;
        }
        
        let lo = 0, hi = arr.length;
        
        while (lo < hi) {
            let mid = (lo + hi) >> 1;
            
            if (arr[mid] < X){
                lo = mid + 1;
            }
            else{
                hi = mid;
            }
        }
        
        answer.push(arr.length - lo);
    }

    return answer;
}