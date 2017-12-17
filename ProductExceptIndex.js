

function productOfAllIntegersExceptIndex(array) {
  var productsAfterIndex = [];
  var productSoFar = 1;
  let result = [];
  if(array.length < 2) return [];

  for(i = array.length - 1; i >= 0; i--) {
    productsAfterIndex.unshift(productSoFar);
    productSoFar *= array[i];
  }

  productSoFar = 1;
  for(i = 0; i < array.length; i++) {
    result[i] = productSoFar * productsAfterIndex[i];
    productSoFar *= array[i];
  }

  return result;

}



var example = [10];

console.log(productOfAllIntegersExceptIndex(example));