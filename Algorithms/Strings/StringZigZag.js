/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function(s, numRows) {
  let rowMap = [];
  let curRow = 0;
  let direction = "1";

  if(numRows === 1) return s;

  for(let i = 0; i < numRows; i++) {
    rowMap[i] = "";
  }

  for(let j = 0; j < s.length; j++) {
    rowMap[curRow] += s.charAt(j);
    if(curRow === numRows - 1) direction = -1;
    if(curRow === 0) direction = 1;
    curRow += direction;
  }
  let result = "";
  for(let i = 0 ; i < rowMap.length; i++) {
    result += rowMap[i];
  }

  return result;
};





console.log(convert("PAYPALISHIRING", 3));

