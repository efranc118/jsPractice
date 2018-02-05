function findAllLetterPermutations(remainingNumbers, results, currentString) {
  var map = {'0': '0','1' : '1', '2' : 'abc', '3': 'def', '4': 'ghi', '5': 'jkl', '6': 'mno', '7' : 'pqrs', '8': 'tuv', '9': 'wxyz'};
  if(remainingNumbers.length === 0) {
    results.push(currentString);
    return;
  }

  let values = map[remainingNumbers.charAt(0)].split('');
  for(let i = 0; i < values.length;i++) {
    let tempString = currentString + values[i];
    findAllLetterPermutations(remainingNumbers.substring(1), results, tempString);
  }

}


let results = [];
findAllLetterPermutations("23", results, []);

console.log(results);


process.exit();