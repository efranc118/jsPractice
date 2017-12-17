let stockPrices = [ 15, 5, 6, 7, 11];


function getMaxProfit(stockPrices) {


  let minPrice = stockPrices[0];
  let maxProfit = stockPrices[1] - stockPrices[0];

  for(i = 1; i < stockPrices.length; i++) {
    let currentPrice = stockPrices[i];
    let currentProfit = currentPrice - minPrice;

    maxProfit = Math.max(maxProfit, currentProfit);
    minPrice = Math.min(minPrice, currentPrice);
  }


  return maxProfit;

}

console.log(getMaxProfit(stockPrices));