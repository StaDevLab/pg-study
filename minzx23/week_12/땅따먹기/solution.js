function solution(land) {
    let dp=Array.from({length: land.length}, ()=>Array(4).fill(0));
    
    for (let i=0; i<4; i++){
        dp[0][i]=land[0][i];
    }
    
    for (let i=1; i<land.length; i++){
        for (let j=0; j<4; j++){
            let maxScore=0;
            
            for (let k=0; k<4; k++){
                if(j!==k){
                    maxScore=Math.max(maxScore, dp[i-1][k]);
                }
            }
            
            dp[i][j]=maxScore+land[i][j];
        }
    }
    
    return Math.max(...dp[land.length-1]);
}