function romanToInteger(A) {
  let map = {"I": 1, "V": 5, "X":10, "L": 50, "C": 100, "D": 500, "M": 1000};

  let currentChar = A.charAt(0);
  let currentValue = map[currentChar];
  let currentSum = 0;
  for(let i = 1; i < A.length; i++) {
    let nextChar = A.charAt(i);
    let nextValue = map[nextChar];
    if(nextValue > currentValue) {
      currentSum += nextValue - currentValue;
      i++;
      nextChar = A.charAt(i);
      nextValue = map[nextChar];
    }
    else {
      currentSum += currentValue;
    }
    if(i >= A.length - 1) {
      if(nextValue <= currentValue) {
        currentSum += nextValue;
      }
    }
    currentChar = nextChar;
    currentValue = nextValue;
  }
  if(A.length === 1) return currentValue;

  return currentSum;


}





console.log(romanToInteger("MDCCLXXVI"));
console.log(romanToInteger("MCMLIV"));
console.log(romanToInteger("MCMXC"));
console.log(romanToInteger("V"));


process.exit();