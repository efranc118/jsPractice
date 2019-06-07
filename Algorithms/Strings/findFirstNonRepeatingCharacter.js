var firstUniqChar = function(s) {
  let uniqueMap = {};
  for(let i =0; i < s.length; i++) {
    if(uniqueMap[s.charAt(i)] === undefined) uniqueMap[s.charAt(i)] = i;
    else {
      uniqueMap[s.charAt(i)] = -1;
    }
  }
  let minIndex = s.length;
  for(var prop in uniqueMap) {
    if(uniqueMap[prop] >= 0 && uniqueMap[prop] < minIndex) {
      minIndex = uniqueMap[prop];
    }
  }
  if(minIndex === s.length) return -1;
  return minIndex;

};







console.log(firstUniqChar("leetcode"));
console.log(firstUniqChar("loveleetcode"));


process.exit();
