function solution(diffs, times, limit) {
    let left = 1;
    let right = 0;
    for (let i = 0; i < diffs.length; i++) {
        if (diffs[i] > right) right = diffs[i];
    }
    
    while (left <= right) {
        const level = Math.floor((left + right) / 2);
        let totalTime = BigInt(0);
        totalTime += BigInt(times[0]);
        for (let i = 1; i < diffs.length; i++) {
            if (diffs[i] > level) {
                totalTime += BigInt(diffs[i] - level) * BigInt(times[i - 1] + times[i]);
            }
            totalTime += BigInt(times[i]);
            if (totalTime > BigInt(limit)) {
                break;
            }
        }
        if (totalTime <= limit) {
            right = level - 1;
        } else {
            left = level + 1;
        }
    }
    return left;
}