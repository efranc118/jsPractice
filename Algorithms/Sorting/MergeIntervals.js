/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
  intervals.sort(compare);
  let curMin = intervals[0][0];
  let curMax = intervals[0][1];
  let result = [];

  for(let i = 1; i < intervals.length; i++) {
    if(curMax < intervals[i][0]) {
      result.push([curMin, curMax]);
      curMin = intervals[i][0];
      curMax = intervals[i][1];
    }
    else if (curMax < intervals[i][1]) curMax = intervals[i][1];
  }

  result.push([curMin, curMax]);
  return result;
};


let testArray = [[1,3],[2,6],[8,10],[15,18]];

let testArray2 = [[1,4], [2,3]];

// let result = merge(testArray);
let result2 = merge(testArray2);

console.log(result);

function compare(a,b) {
  if(a[0] < b[0]) {
    return -1;
  }
  if(a[0] > b[0]) {
    return 1;
  }
  return 0;
}
