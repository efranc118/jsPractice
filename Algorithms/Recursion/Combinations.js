// function 	combine : function(A, B){
//   return this.combinations(A, 1, B, [], []);
// },
//


function combinations(A, start, B, result, currentArray) {
  if(B === 0) {
    result.push(currentArray);
    return;
  }
  let len = currentArray.length;
  for(let i = start; i <= A; i++) {
    currentArray[len] = i;
    combinations(A, i + 1, B - 1, result, currentArray.slice());
  }
}
let result = [];
combinations(3, 1, 3, result, []);
console.log(result);

process.exit();