function findMaxReturn(array) {
  if(array.length === 1) return 0;
  let min = array[0];
  let curMax = Number.MIN_SAFE_INTEGER;

  for(let i = 1; i < array.length; i++) {
    if(array[i] - min > curMax) curMax = array[i] - min;
    if(array[i] < min) min = array[i];
  }
  return curMax;

}



let testArray = [10, 7, 5, 8, 11, 9];
let testArray2 = [10, 5, 3, 1, -10];

console.log(findMaxReturn(testArray));
console.log(findMaxReturn(testArray2));
