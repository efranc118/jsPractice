
let memoizedFunction = function memoize() {
  let memoizeResult = {};

  let calc = function catalan(val) {
    if(memoizeResult[val] !== undefined) return memoizeResult[val];
    if(val <= 1) return 1;
    let result = 0;

    for(let i = 0; i < val; i++) {
      result += catalan(i) * catalan(val - i - 1);
    }
    memoizeResult[val] = result;
    return result;

  };

  return calc;


}();

function catalan(val) {
  if(val <= 1) return 1;
  let result = 0;

  for(let i = 0; i < val; i++) {
    result += catalan(i) * catalan(val - i - 1);
  }
  return result;

}




console.time('memoize');
console.log(memoizedFunction(20));
console.timeEnd('memoize');

console.time('catalan');
console.log(catalan(20));
console.timeEnd('catalan');
process.exit();