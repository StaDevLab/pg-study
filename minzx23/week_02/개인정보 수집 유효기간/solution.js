function solution(today, terms, privacies) {
    var answer = [];

    let termsMap= new Map();

    // 약관과 유효기간 매핑
    for(let i=0; i<terms.length; i++){
        let term=terms[i].split(' ');
        termsMap.set(term[0], Number(term[1]));
    }

    let privaciesMap= new Map();

    // 날짜와 약관 매핑
    for (let i=0; i<privacies.length; i++){
        let privacy=privacies[i].split(' ');
        privaciesMap.set(i+1, privacy);
    }


    for (let [key] of privaciesMap){
        let [y,m,d]=privaciesMap.get(key)[0].split('.').map(Number);
        let date=y*12*28+m*28+d;

        let month=termsMap.get(privaciesMap.get(key)[1]);
        let expDate=date+(month*28);

        let [ty,tm,td]=today.split('.').map(Number);
        let todayDate=ty*12*28+tm*28+td;

        if(todayDate >= expDate){
            answer.push(key);
        }
    }

    return answer;
}