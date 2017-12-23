function highestProduct(array) {
  let highestProduct = 0;
  let highestNum =  0;
  let secondHighestNum = 0;
  for(i = 0; i < array.length; i++) {
    let currentProduct = array[i] * secondHighestNum * highestNum;
    if( currentProduct > highestProduct) {
      highestProduct = currentProduct;
    }
    if(array[i] > secondHighestNum && array[i] > highestNum) {
      secondHighestNum = highestNum;
      highestNum = array[i];
    }
    else if(array[i] > secondHighestNum) {
      secondHighestNum = array[i];
    }
  }
  return highestProduct;
}




let testArray = [ 0, 3, 10, 6, 9];


console.log(highestProduct(testArray));

