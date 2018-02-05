function longestPalindrome(string) {
  let start = 0;
  let end = 0;
  for(let i = 0; i < string.length; i++) {
     let len1 = expandFromCenter(string, i, i);
     let len2 = expandFromCenter(string, i, i + 1);
     let len = Math.max(len1, len2);
     if(len > end - start) {
       start = i - ((len - 1) / 2);
       end = i + (len / 2);
     }
  }


  return string.substring(start, end + 1);
}

function expandFromCenter(string, min, max) {
  while(min >= 0 && max < string.length && string.charAt(min) === string.charAt(max)) {
    min--;
    max++;
  }
  return max - min - 1;
}

console.log(longestPalindrome("aaaabaaa"));
console.log(longestPalindrome("racecar"));
console.log(longestPalindrome("bb"));

process.exit();