function findBodiesOfWater(map) {

  let visitedMap = [];
  for(i = 0; i < map.length; i++) {
    visitedMap[i] = new Array(map.length).fill(0);
  }

  let result = [];
  for(i = 0; i < visitedMap.length; i++) {
    for(j = 0; j < visitedMap[i].length; j++) {
      if(!visitedMap[i][j]) {
        let count = dfs(map, visitedMap, i, j);
        if( count > 0) result.push(count);
      }
    }
  }
  result.sort();
  return result;

}

class Node {
  constructor(i, j) {
    this.i = i;
    this.j = j;
  }
}

function dfs(map, visitedMap, i, j) {
  let stack = [];
  stack.push(new Node(i, j));
  let count = 0;
  while(stack.length > 0) {
    let temp = stack.pop();
    if(visitedMap[temp.i][temp.j] === 0) {
      visitedMap[temp.i][temp.j] = 1;
      if(map[temp.i][temp.j] === 0) {
        count++;
        for(k = -1; k < 2; k++) {
          if(temp.j + k >= 0 && temp.j + k < map.length) {
            for (l = -1; l < 2; l++) {
              if (temp.i + l >= 0 && temp.i + l < map.length && !visitedMap[temp.i + l][temp.j + k]) stack.push(new Node(temp.i + l, temp.j + k));
            }
          }
        }
      }
    }
  }
  return count;
}



let testArray = [];
for(i = 0; i< 6; i++) {
  for(j = 0; j < 5; j++) {
    testArray[i] = new Array(6);
  }
}

testArray[0] = [1,2,1,1,0,1];
testArray[1] = [0,1,1,0,1,2];
testArray[2] = [0,0,1,0,1,0];
testArray[3] = [1,1,0,1,1,1];
testArray[4] = [0,1,1,1,0,0];
testArray[5] = [1,1,1,1,1,1];


console.log(findBodiesOfWater(testArray));