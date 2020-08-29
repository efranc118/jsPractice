const max_sub_array_of_size_k = function(k, arr) {
  if(arr.length < k) return -1;
  let curSubSum = 0;
  for(let i =0; i < k; i++) {
    curSubSum+= arr[i];
  }
  let curMaxSum = curSubSum;
  for(let i = k; i < arr.length; i++) {
    curSubSum -= arr[i - k];
    curSubSum += arr[i];
    if(curSubSum > curMaxSum) curMaxSum = curSubSum;
  }
  return curMaxSum;
};


// console.log(`Maximum sum of a subarray of size K: ${max_sub_array_of_size_k(3, [2, 1, 5, 1, 3, 2])}`);
// console.log(`Maximum sum of a subarray of size K: ${max_sub_array_of_size_k(2, [2, 3, 4, 1, 5])}`);

function assertEquals(spec, argList, expectedResult) {
  return spec(...argList) === expectedResult
}



console.log(assertEquals(max_sub_array_of_size_k, [3, [2, 1, 5, 1, 3, 2]], 9 ));
