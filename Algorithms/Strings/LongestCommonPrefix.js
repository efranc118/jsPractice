function longestCommonPrefix(A){
  var prefix = A[0];
  for(let i = 1; i < A.length; i++) {
    prefix = getCommonPrefix(prefix, A[i]);
  }
  return prefix;
}

function getCommonPrefix(string1, string2) {
  if(string1.length === 0 || string2.length === 0) return '';
  var length = Math.min(string1.length, string2.length);
  var prefix = '';
  for(let i = 0; i < length; i++) {
    if(string1.charAt(i) === string2.charAt(i)) {
      prefix += string1.charAt(i);
    }
  }
  return prefix;
}


let testArray = [ 'abcd', 'abcd', 'efgh' ];
longestCommonPrefix(testArray);