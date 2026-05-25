var generateParenthesis = function(n) {
    let answer=[];

    function recursion(path, open, close){
        if(path.length===2*n){
            answer.push(path);
            return;
        }
        if(open<n){
            recursion(path+'(', open+1, close);
        }
        if (close<open){
            recursion(path+')', open, close+1);
        }
    }
    
    recursion("",0,0);

    return answer;
};