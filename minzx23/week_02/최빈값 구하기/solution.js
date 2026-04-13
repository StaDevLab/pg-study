function solution(array) {
    var answer = 0;

    let map= new Map();
    let frequency=0;
    let num=[];

    for(let i=0; i<array.length; i++){
        if(map.has(array[i])){
            map.set(array[i], map.get(array[i])+1);
        }
        else{
            map.set(array[i], 1);
        }
    }

    for (let [key, value] of map){
        if(value>frequency){
            frequency= value;
            num=[key];
        }
        else if(value===frequency){
            num.push(key);
        }
    }

    return num.length>1?-1:num[0];
}