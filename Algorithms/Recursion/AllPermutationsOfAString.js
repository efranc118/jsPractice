function allPermutationsOfString(prefix, input, result) {
  if(input.length === 0) result.push(prefix);
  for(let i = 0; i < input.length; i++) {
    let currentString = prefix + input.charAt(i);
    allPermutationsOfString(currentString, input.substring(0, i) + input.substring(i + 1, input.length), result);
  }
  return result;
}



console.log(allPermutationsOfString("", "abc", []));


process.exit();