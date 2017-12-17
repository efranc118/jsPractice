

let memoize = {0:1};
console.time("combinations");
function getCombinations(stairsLeft) {
  if(memoize[stairsLeft] !== undefined) return memoize[stairsLeft];
  if (0 === stairsLeft) return 1;
  if (0 > stairsLeft) return 0;
  memoize[stairsLeft] = getCombinations(stairsLeft - 3) + getCombinations(stairsLeft - 2) + getCombinations(stairsLeft - 1);
  return memoize[stairsLeft];
  // return getCombinations(stairsLeft - 3) + getCombinations(stairsLeft - 2) + getCombinations(stairsLeft - 1);
}


console.log(getCombinations(30));
console.log(console.timeEnd("combinations"));