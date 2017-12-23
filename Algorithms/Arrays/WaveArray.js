function waveArray(A) {
    let resultArray = [];
    A = A.sort(sortNumber);
    for(i = 1;i<A.length; i += 2)
    {
      resultArray.push(A[i]);
      resultArray.push(A[i - 1]);
    }
    if(resultArray.length < A.length) {
      resultArray.push(A[A.length - 1]);
    }
    return resultArray;
}

function sortNumber(a,b) {
  return a - b;
}


let testArray = [ 6, 17, 15, 13 ];

console.log(waveArray(testArray));
console.log(Math.ceil(5/5));