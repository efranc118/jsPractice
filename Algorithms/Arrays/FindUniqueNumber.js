function findUnique(array) {
  if(array.length < 1) return null;
  if(array.length === 1) return array[0];
  let unique = array[0];
  for(i = 1;i < array.length; i++) {
    unique ^= array[i];
  }
  return unique;
}




let testArray = [ 1, 2, 3, 4, 5, 1, 2, 3, 5];


console.log(findUnique(testArray));