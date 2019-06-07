function findLongestCommonSubString(string) {
  let result = "";
  for(let i = 0; i < string.length; i++) {
    let temporaryResult1 = getlongestPalindrome(string, i, i);
    let temporaryResult2 = getlongestPalindrome(string, i, i + 1);
    if(temporaryResult1.length > temporaryResult2.length && temporaryResult1.length > result.length) result = temporaryResult1;
    if(temporaryResult1.length < temporaryResult2.length && temporaryResult2.length > result.length) result = temporaryResult2;
  }
  return result;
}




function getlongestPalindrome(string, min, max) {
  let curPalindrome = "";
  while(string[min] === string[max] && min >= 0 && max < string.length) {
    curPalindrome = string.substring(min,max + 1);
    min--;
    max++;
  }
  return curPalindrome
}



console.log(findLongestCommonSubString("babad"));
