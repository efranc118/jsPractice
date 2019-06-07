var lengthOfLongestSubstring = function(s) {
  let result = 0;
  for(let i = 0; i < s.length; i++) {
    let subString = getLongestNonRepeatSubString(s, i);
    if(subString > result) result = subString;
  }
  return result;
};



function getLongestNonRepeatSubString(s, i) {
  let count = 0;
  let map = {};
  while(map[s[i + count]] === undefined && i + count < s.length) {
    map[s[i + count]] = 1;
    count++;
  }
  return count;
}


console.log(lengthOfLongestSubstring("abcabcbb"));
console.log(lengthOfLongestSubstring("pwwkew"));
console.log(lengthOfLongestSubstring("bbbb"));
