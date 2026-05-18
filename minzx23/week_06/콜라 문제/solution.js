function solution(a, b, n) {
    let sum=0;
    
    function recursion(sum, n){
        if(n<a){
            return sum;
        }
        
        let cola=Math.floor(n/a)*b;
        let total=n%a;
        
        sum+=cola;
        
        return recursion(sum, cola+total)
    }
    
    return recursion(0, n);
}