function solution(elements) {
    let set = new Set();
    let n = 1;
    let sum = 0;
    
    while(n<=elements.length){
        for (let i=0; i<elements.length; i++){
            sum=0;
            for (let j=0; j<n; j++){
                sum+= elements[(i+j)%elements.length];
            }
            set.add(sum);
        }
        n++;
    }
    return set.size;
}