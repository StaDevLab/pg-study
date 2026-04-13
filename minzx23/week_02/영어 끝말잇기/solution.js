function solution(n, words) {
    var answer = [];

    let wordsMap = new Map();
    let round=0;

    for(let i=0; i<words.length; i++){
        if(i%n===0){
            round++;
        }
        if(wordsMap.has(words[i])){
            answer.push((i%n)+1);
            answer.push(round);
            break;
        }
        else{
            wordsMap.set(words[i], 1);
        }
        if((i>0 && words[i-1].slice(-1)!==words[i].slice(0,1))){
            answer.push((i%n)+1);
            answer.push(round);
            break;
        }
    }
    if(answer.length===0){
        answer.push(0, 0);
    }

    return answer;
}