function findClosestSum(A, B) {
  var sorted = A.sort(function(a, b){return a-b});

  let currentDiff = 1000000000000;
  let currentResult = 0;
for(let i = 0; i < A.length - 2; i++) {
  let min = i + 1;
  let max = A.length - 1;
  while( min < max) {
    let curSum = A[i] + A[min] + A[max];
    if(curSum === B) return B;
    let curDiff = Math.abs(curSum - B);
    if(curDiff < currentDiff) {
      currentResult = curSum;
      currentDiff = curDiff;
    }
    if(curSum < B) min++;
    if(curSum > B) max--;
  }
}


  return currentResult;
}

var array = [ 7, -6, 2, 10 ];
var goal = 3;

console.log(findClosestSum(array, goal));
