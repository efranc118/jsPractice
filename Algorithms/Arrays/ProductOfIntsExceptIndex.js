function getProductsOfAllIntsExceptAtIndex(array) {
  let maxLength = array.length - 1;
  let currentProduct = 1;
  let reverseProducts = [1];
  let result = [];
  for(let i = maxLength; i > 0; i--) {
    currentProduct *= array[i];
    reverseProducts.unshift(currentProduct);
  }
  currentProduct = 1;
  for(let i = 0; i < array.length; i++) {
    result.push(currentProduct * reverseProducts[i]);
    currentProduct *= array[i];
  }

  return result;

}



let testArray = [1, 7, 0, 4];

console.log(getProductsOfAllIntsExceptAtIndex(testArray));