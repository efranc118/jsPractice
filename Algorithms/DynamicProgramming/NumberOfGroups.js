/**
 Given an array of numbers find how many sets of numbers add up to a given sum
 **/




function numberOfGroups(inputArray, sum) {
  const mem = {};
return helperFunc(0, inputArray, sum, mem);
}



function helperFunc(curSum, remainingValues, sum, mem) {
  if(mem[curSum + ":" + remainingValues.length]) return mem[curSum + ":" + remainingValues.length];
  let result = 0;
  for(let i = 0; i < remainingValues.length; i++) {
    let addend = remainingValues[i];
    if(curSum + addend === sum) result++;
    if(curSum + addend < sum) result += helperFunc(curSum + addend, remainingValues.slice(i + 1), sum, mem);
  }
  mem[curSum + ":" + remainingValues.length] = result;
  return result;
}



console.log(numberOfGroups([2,4,6,10], 16));
