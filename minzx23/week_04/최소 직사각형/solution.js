function solution(sizes) {
    w=[];
    h=[];
    
    for (let i=0; i<sizes.length; i++){
        if (sizes[i][0]>sizes[i][1]){
            w.push(sizes[i][0]);
            h.push(sizes[i][1]);
        }
        else{
            w.push(sizes[i][1]);
            h.push(sizes[i][0]);
        }
    }
    
    w.sort((a,b)=>(b-a));
    h.sort((a,b)=>(b-a));
    
    return w[0]*h[0];
}