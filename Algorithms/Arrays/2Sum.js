/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
  let sorted = nums.sort((a,b) => a - b);
  let result = [];
  for(let i = 0; i < sorted.length - 2; i++) {
    let min = i + 1;
    let max = sorted.length - 1;
    if (sorted[i] === sorted[i - 1])
      continue;
    while(min < max) {
      if(sorted[max] === sorted[max - 1]) max--;
      if(sorted[min] === sorted[min + 1]) min++;
      let curSum = sorted[i] + sorted[min] + sorted[max];
      if(curSum === 0) {
        result.push([sorted[i], sorted[min], sorted[max]]);
        min++;
        max--;
      }
      if(curSum > 0) max--;
      if(curSum < 0) min++;
    }

  }
  return result;

};


console.log(threeSum([-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]));
