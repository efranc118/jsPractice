console.time("gridwalk");
let memoize = {};
function gridWalk(A, B) {
  if(memoize['' + A + B] !== undefined) {
    return memoize['' + A + B];
  }
  if(A < 1 || B < 1) return 0;
  if(A === 1 && B === 1) {
    return 1;
  }
  memoize['' + A + B] =  gridWalk(A - 1, B) + gridWalk(A, B - 1);

}


console.log(gridWalk(10, 10));
console.timeEnd("gridwalk");