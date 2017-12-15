function countInversions(arr) {
  let totalSwaps = 0;
  while(true) {
    let swaps = 0;
    for(let i = 0; i < arr.length - 1; i++) {
      if(arr[i] > arr[i + 1]) {
        let temp = arr[i];
        arr[i] = arr[i + 1];
        arr[i+1] = temp;
        swaps++;
        totalSwaps++;
        break;
      }
    }
    if(swaps === 0) break;
  }
  return totalSwaps;
}


console.log(countInversions("2 1 3 1 2".split(' ').map(Number)));