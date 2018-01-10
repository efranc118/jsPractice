function findRotationPoint(array) {
  let min = 0;
  let max = array.length - 1;
  while(min < max) {
    let mid = Math.floor((min + max) / 2);
    if(array[mid] < array[mid - 1] && array[mid] < array[mid + 1]) return mid;
    else if(array[min] > array[mid]) {
      max = mid;
    } else if(array[min] < array[mid] && array[mid] > array[max]) {
      min = mid;
    }
  }
  return 0;
}

var words = [
  'ptolemaic',
  'retrograde',
  'supplant',
  'undulate',
  'xenoepist',
  'zoologist',
  'asymptote',  // <-- rotates here!
  'babka',
  'banoffee',
  'engender',
  'karpatka',
  'othellolagkage',
];

console.log(findRotationPoint(words));


