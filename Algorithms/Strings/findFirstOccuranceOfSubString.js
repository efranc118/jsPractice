function findFirstSubstring(string1, string2) {

  let secondIndex = 0;
  for(let i = 0; i < string1.length; i++) {
    if(string1[i] === string2[secondIndex]) {
      secondIndex++
    }
    else {
      secondIndex = 0;
    }
    if(secondIndex === string2.length) return i - (secondIndex - 1);
  }
 return -1;

}


console.log(findFirstSubstring("this is a test", "this"));
console.log(findFirstSubstring("this is a test", "is"));
console.log(findFirstSubstring("this is a test", "a"));
console.log(findFirstSubstring("this is a test", "test"));
console.log(findFirstSubstring("this is a test", "st"));
