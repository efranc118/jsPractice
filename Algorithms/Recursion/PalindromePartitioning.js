function generatePartitions(input, count) {

  if(input.length === 1) {
    return [input];
  }

  let currentPartitions = generatePartitions(input.substring(1), count - 1);
  let partitions = currentPartitions.slice();
  for(let i = 0; i < count; i++) {
    let temp = input.substring(0, 1) + currentPartitions[i];
    partitions.unshift(temp);
  }
  partitions.unshift(input.substring(0,1));
  return partitions;
}



console.log(generatePartitions("abc", 2));

process.exit();

// function isPalindrome(input) {
//   return input === input.split('').reverse().join('');
// }


// function palindromePartitions(input) {
//   var result = [];
//   for(var i = 1; i < input.length; i++) {
//     palindromeParition(input, i, 0, result, []);
//   }
//   return result;
// }
//
// function generateAllSubStrings(input, length, result) {
//   if(length === input.length) return;
//   for(var i = 0; i < input - length; i++) {
//
//   }
// }



console.log(palindromePartitions("gacab"));


process.exit();