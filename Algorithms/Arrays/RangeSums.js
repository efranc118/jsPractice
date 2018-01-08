function rangeSums(A, B, C) {
  var currentSum = 0;
  var count = 0;
  var i = 0;
  var j = 0;
  while(i < A.length) {
    currentSum = currentSum + A[j];
    if((currentSum >= B) && (currentSum <= C)) {
      j++;
      count++;
    }
    else if(currentSum < B) {
      j++;
    }
    else if(currentSum > C) {
      i++;
      j = i;
      currentSum = 0;
    }
    if(j === A.length ) {
      currentSum = 0;
      i++;
      j = i;
    }

  }


  return count;
}


console.log(rangeSums([10,5,1,0,2],6,8));