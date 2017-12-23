function getTotalCombinations(coins, num) {

  let coinTable = new Array(coins.length);
  for(i = 0; i <= coins.length; i++) {
    coinTable[i] = new Array(num);
  }

  for(i = 0; i <= coins.length; i++) {
    coinTable[i][0] = 1;
  }

  for(i = 1; i <= num; i++) {
    coinTable[0][i] = 0;
  }

  for(i = 1; i <= coins.length; i++) {
    for(j = 1; j <= num; j++) {
      if(coins[i - 1] <= j) {
        coinTable[i][j] = coinTable[i -1][j] + coinTable[i][j - coins[i - 1]];
      }
      else {
        coinTable[i][j] = coinTable[i -1][j];
      }
    }
  }

  return coinTable[coins[coins.length - 1]][num];

}


console.log(getTotalCombinations([1,2,3,4], 4));