process.stdin.resume();
process.stdin.setEncoding('ascii');

var input_stdin = "";
var input_stdin_array = "";
var input_currentline = 0;

process.stdin.on('data', function (data) {
	input_stdin += data;
    });

process.stdin.on('end', function () {
	input_stdin_array = input_stdin.split("\n");
	main();    
    });

function readLine() {
    return input_stdin_array[input_currentline++];
}

/////////////// ignore above this line ////////////////////
main();

function main() {

    let n = 10;
    let coins = [1,2,3];
    let result = getCombinations(coins, n);
    console.log(result);
}


function getCombinations(coins, number ) {
  let memoizationTable = new Array(coins.length + 1);
  for(let i = 0; i <= coins.length; i++) {
      memoizationTable[i] = new Array(number + 1);
  }
  memoizationTable[0][0] = 1;
  for(let i = 1; i <= number; i++) {
    memoizationTable[0][i] = 0;
  }
  for(let j = 1; j <= coins.length; j++) {
    memoizationTable[j][0] = 1;
  }


  for(let i = 1; i <= coins.length; i++) {
    for(let j = 1; j <= number; j++) {
      if(coins[i - 1] <= j) {
        memoizationTable[i][j] = memoizationTable[i - 1][j] + memoizationTable[i][j - coins[i - 1]];
        }
      else {
        memoizationTable[i][j] = memoizationTable[i - 1][j];
      }
    }
  }

  console.log(memoizationTable);
  console.log(memoizationTable[coins.length][number]);

}