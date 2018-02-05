function isPermutationPalindrome(string) {
  let palindromeMap = {};
  for(let i = 0; i < string.length; i++) {
    palindromeMap[string.charAt(i)] = palindromeMap[string.charAt(i)] === undefined ? 1 : palindromeMap[string.charAt(i)] + 1;
  }
  let oddChracterCount = 0;
  for(let key in palindromeMap) {
    if(palindromeMap[key] % 2) oddChracterCount++;
    if(oddChracterCount > 1) return false;
  }
  return true;
}





console.log(isPermutationPalindrome("racecar"));
console.log(isPermutationPalindrome("aaabb"));
console.log(isPermutationPalindrome("a"));
console.log(isPermutationPalindrome("bb"));
console.log(isPermutationPalindrome("bbccde"));
console.log(isPermutationPalindrome("bbccdee"));


process.exit();