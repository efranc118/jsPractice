function lcs(string1, string2) {
  let commonArray = [];
  for(let i = 0; i < string1.length; i++) {
    commonArray[i] = new Array(string2.length);
  }

  let currentMax = 0;
  let longestCommonSubString = '';
  for(let i = 0; i < string1.length; i++) {
    for(let j = 0; j < string2.length; j++) {
      if(string1.charAt(i) === string2.charAt(j)) {
        if(i === 0 || j === 0) {
          commonArray[i][j] = 1;
        }
        else {
          let value = commonArray[i - 1][j - 1] + 1;
          if(value > currentMax) {
            currentMax = value;
            let startChar = i + 1 - value;
            longestCommonSubString = '';
            while(startChar <= i) {
              longestCommonSubString += string1.charAt(startChar);
              startChar++;
            }
          }
          commonArray[i][j] = commonArray[i - 1][j - 1] + 1;
        }
      } else {
        commonArray[i][j] = 0;
      }
    }
  }
  console.log(longestCommonSubString);
  return currentMax;
}



let s1 = 'reddit rocks my socks';
let s2 = 'the fox ran across my rock';

console.log(lcs(s1, s2));