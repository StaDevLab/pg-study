function solution(n, info) {
    var answer = [-1];
    let maxDiff=0;
    let lion=Array(11).fill(0);
    
    function dfs(score, arrow, lion){
        if(score===11){
            let AScore=0;
            let LScore=0;
            if(arrow>0){
                // 이기는 점수가 되었는데 화살이 남은 경우는 0점에 몰아주기
                lion[10]+=arrow;
            }
            
            for (let i=0; i<=10; i++){
                if(info[i]===0 && lion[i]===0){
                    continue;
                }
                // 해당 점수 칸에 어피치 화살이 많으면 어피치 점수, 라이언 화살이 많으면 라이언 점수에 추가
                if(info[i]>=lion[i]){
                    AScore+=(10-i);
                }
                else{
                    LScore+=(10-i);
                }
            }
            
            let diff=LScore-AScore;
            
            //라이언 점수가 더 높은 경우
            if(diff>0){
                // 점수 차가 maxDiff보다 크면 갱신
                if(diff>maxDiff){
                    maxDiff=diff;
                    answer=[...lion];
                }
                // 점수 차가 maxDiff와 같으면 낮은 점수가 더 많은 경우 선택
                else if(diff===maxDiff){
                    // 0점부터 점수 비교 후 갱신 또는 유지
                    for (let i=10; i>=0; i--){
                        if(lion[i]>answer[i]){
                            answer=[...lion];
                            break;
                        }
                        else if(lion[i]<answer[i]){
                            break;
                        }
                    }
                }
            }
            
            return;
        }
        
        if(arrow>info[score]){
            let next=[...lion];
            next[score]=info[score]+1;
                
            dfs(score+1, arrow-(info[score]+1), next);
        }
        
        // 화살을 많이 써야 하거나 질 것 같으면 해당 점수에 안쏨
        dfs(score+1, arrow, [...lion]);
    }
    
    dfs(0, n, lion);
    
    return answer;
}