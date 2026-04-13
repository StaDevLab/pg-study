function solution(clothes) {
    var answer = 0;

    let clothesMap = new Map();

    for (let i=0; i<clothes.length; i++) {
        if(clothesMap.has(clothes[i][1])){
            clothesMap.set(clothes[i][1], clothesMap.get(clothes[i][1])+1);
        }
        else{
            clothesMap.set(clothes[i][1], 1);
        }
    }

    let result=1;

    for (let value of clothesMap.values()){
        result *= (value + 1);
    }

    return result-1;
}
