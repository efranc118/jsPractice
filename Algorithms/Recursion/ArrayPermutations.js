 function permute (A){
  var result = [];
  for(var i = 0; i < A.length; i++) {
    var integerArray = [];
    integerArray.push(A[i]);
    var remainingValues = A.slice();
    remainingValues.splice(i, 1);
    calculatePermutations(integerArray.slice(), result, remainingValues);
  }
  return result;
}


function calculatePermutations(currentArray, result, itemsLeft) {
  if(itemsLeft.length === 0) {
    result.push(currentArray);
    return;
  }
  for(var i = 0; i < itemsLeft.length; i++) {
    var nextArray = currentArray.slice();
    nextArray.push(itemsLeft[i]);
    var remainingValues = itemsLeft.slice();
    remainingValues.splice(i, 1);
    calculatePermutations(nextArray, result, remainingValues);
  }
}


console.log(permute([1,2,3]));
 process.exit();