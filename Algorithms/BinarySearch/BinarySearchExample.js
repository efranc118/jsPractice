/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
  let min = 0;
  let max = nums.length;

  while(min < max) {
    let mid = Math.floor(min + ((max - min) / 2));
    if(nums[mid] < target) min = mid + 1;
    if(nums[mid] > target) max = mid - 1;
    else if(nums[mid] === target) return mid;
  }
  return -1;
};




search([-1,0,3,5,9,12]
,13);
