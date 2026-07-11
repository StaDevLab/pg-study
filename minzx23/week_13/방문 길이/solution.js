function solution(dirs) {
    let x=0;
    let y=0;
    let visited=new Set();
    
    let dx=[0, 0, -1, 1];
    let dy=[1, -1, 0, 0];
    let move={'U':0, 'D':1, 'L':2, 'R':3};
    
    for (let dir of dirs){
        let d=move[dir];
        let nx=x+dx[d];
        let ny=y+dy[d];
        
        if(nx<-5 || nx>5 || ny<-5 || ny>5){
            continue;
        }
        
        visited.add(`${x},${y}-${nx},${ny}`);
        visited.add(`${nx},${ny}-${x},${y}`);
        
        x=nx;
        y=ny;
    }
      
    return visited.size/2;
}