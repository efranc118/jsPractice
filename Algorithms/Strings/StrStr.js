function strStr(A, B) {
  if(A.length < 1 || B.length < 1 || A.length < B.length) return -1;

  for(var j = 0; j < A.length; j++) {
    for (var i = 0; i < B.length; i++) {
      if (A.charAt(j + i) === B.charAt(i)) {
          if(i === B.length - 1) {
            return j;
          }
      } else break;
    }
  }
  return -1;
}

console.log(strStr("b", "b"));