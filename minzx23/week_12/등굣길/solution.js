function solution(m, n, puddles) {
    let dp=Array.from({length: n+1}, ()=>Array(m+1).fill(0));
    dp[1][1]=1;
    let ispuddle=Array.from({length: n+1}, ()=>Array(m+1).fill(false));
    
    for (let [x,y] of puddles){
        ispuddle[y][x]=true;
    }
    
    for (let i=1; i<=n; i++){
        for (let j=1; j<=m; j++){
            if(i===1 && j===1){
                continue;
            }
            
            if(ispuddle[i][j]){
                dp[i][j]=0;
            }
            else{
                dp[i][j]=(dp[i-1][j]+dp[i][j-1])%1000000007
            }
        }
    }
    
    return dp[n][m];
}