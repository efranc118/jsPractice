/**
 * @param {number} num
 * @return {string}
 */
var intToRoman = function(num) {
  let map = {1 : "I", 5: "V", 10: "X",
    50: "L", 100: "C", 500: "D", 1000: "M"};


  let place = Math.pow(10, 0);
  let result = "";
  while(Math.floor(num / place) > 0) {
    let curNum = Math.floor(num / place);
    let digit = curNum % 10;
    if(map[digit * place]) result = map[place * digit] + result;
    else if(digit <= 3) {
      let character = map[place];
      for(let i = 1 ; i <= digit; i++ ) {
        result = character + result;
      }
    }
    else if( digit === 4 || digit === 9) {
      let characters = map[place] + map[(digit + 1) * place];
      result = characters + result
    }
    else if( digit > 5 && digit <= 8) {
      let remain = digit - 5;
      for(let i = 1 ; i <= remain; i++) {
        result = map[place] + result;
      }
      result = map[5 * place] + result;
    }
    place *= 10;
  }
  return result;
};



console.log(intToRoman(4));
console.log(intToRoman(58));
console.log(intToRoman(61));
console.log(intToRoman(90));
// console.log(intToRoman(100));
 console.log(intToRoman(1994));
