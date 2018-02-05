function generateArrayPermuations(maxValue, columnCount, start, result, currentArray) {

  if(columnCount === 0) {
    result.push(currentArray);
    return;
  }

  for(let i = start; i <= maxValue; i++) {
    currentArray.push(i);
    generateArrayPermuations(maxValue, columnCount - 1, i + 1, result, currentArray.slice());
    currentArray.pop();
  }

}


let result = [];
generateArrayPermuations(4, 2, 1, result, []);


console.log(result);

process.exit();