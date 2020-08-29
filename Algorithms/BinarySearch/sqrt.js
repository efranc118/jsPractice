/**
 * @param {number} x
 * @return {number}
 */
var mySqrt = function(x) {
  let min = 0;
  let max = x / 2;

  while(min < max) {
    let mid = min + (max - min) / 2;
    let squared = Math.floor(mid * mid);
    if(squared === x) return Math.floor(mid);
    if(squared < x) min = mid;
    if(squared > x) max = mid;
  }

  return -1;
};




console.log(mySqrt(8));
