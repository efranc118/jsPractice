module.exports = {
  //param A : array of integers
  //param B : integer
  //return a array of array of integers
  combinationSum : function(A, B){
    var results = [];
    function sortNumber(a,b) {
      return a - b;
    }
    A = A.sort(sortNumber).filter(function(item, pos, ary) {
      return !pos || item != ary[pos - 1];
    });
    this.checkSum(A, B, 0, 0, [], results);
    return results;
  },
  checkSum : function(array, sum, start, currentSum, currentArray, result) {
    if(currentSum === sum) {
      result.push(currentArray);
      return;
    }
    if(currentSum > sum) {
      return;
    }

    for(var i = start; i < array.length; i++) {
      var nextSum = currentSum + array[i];
      var nextArray = currentArray.slice()
      nextArray.push(array[i]);
      this.checkSum(array, sum, i, nextSum, nextArray, result);
    }
  }
};