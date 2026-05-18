function solution(n) {
    let prev=0;
    let pres=1;
    
    for (let i=2; i<=n; i++){
        let mod=(prev+pres)%1234567;
        
        prev=pres;
        pres=mod;
    }
    
    return pres;
}