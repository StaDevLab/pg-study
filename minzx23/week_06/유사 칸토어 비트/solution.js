function solution(n, l, r) {
    if (n===0){
        return 1;
    }
    
    let cnt=0;
    let len=Math.pow(5,n-1);
    
    for (let i=0; i<5; i++){
        let s=(i*len)+1;
        let e=(i+1)*len;
        
        if(i===2){
            continue;
        }
        
        let lidx=Math.max(l, s);
        let ridx=Math.min(r, e);
        
        if(lidx<=ridx){
            cnt+=solution(n-1, lidx-s+1, ridx-s+1);
        }
    }
    
    return cnt;
}