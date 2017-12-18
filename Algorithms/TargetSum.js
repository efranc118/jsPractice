var twoSum = function(nums, target) {
  let map = {};
  for(i = 0; i < nums.length; i++) {
    let remainder = target - nums[i];
    if(map[nums[i]] !== undefined) {
      return [map[nums[i]], i];
    }
    map[remainder] = i;
  }
  return [];
};

console.log(twoSum([1,2,5,3], 4));