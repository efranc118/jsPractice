


function repeatedNumber(A){
  let map = {};
  let dupe = 0;
  let totalSum = 0;
  for(i = 0; i < A.length; i++) {
    if(map[A[i]] === undefined) {
      map[A[i]] = 1;
    }
    else {
      dupe = A[i];
    }
    totalSum += A[i];
  }
  let correctSum = (1 + A.length) * (A.length / 2);
  let missingSum = totalSum - dupe;
  let missingNum = correctSum - missingSum;
  return [dupe, missingNum];
}


let testArray = [1,3,4,5];

console.log(repeatedNumber(testArray));