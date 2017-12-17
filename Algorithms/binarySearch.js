

(function main() {
  // var t = parseInt(readLine());
  // for(var a0 = 0; a0 < t; a0++){
  //   var m = parseInt(readLine());
  //   var n = parseInt(readLine());
  //   a = readLine().split(' ');
  //   a = a.map(Number);
    a  = "2 1 9 4 4 56 90 3".split(' ').map(Number);
    m = 8;
    let sortedArray = [];
    for(i = 0; i < a.length; i++) {
      sortedArray.push(new Node(i + 1, a[i]));
    }
    sortedArray.sort(compare);
    findPair(sortedArray, m);
  //}

})();

function Node(position, value) {
  this.position = position;
  this.value = value;
}

function compare(a,b) {
  if(a.value > b.value) return 1;
  if(a.value < b.value) return -1;
  return 0;
}


function findPair(array, total) {

  for(let i = 0; i < array.length; i ++) {
    if(array[i].value < total) {
      let temp = array[i];
      let target = total - temp.value;
      let addends =  binarySearch(array, target, i);
      if(addends !== -1) {
        if(array[i].position < array[addends].position) {
          console.log((array[i].position) + " " + (array[addends].position));
          break;
        }
        else {
          console.log((array[addends].position) + " " + (array[i].position));
          break;
        }
      }
    }
  }

}



function binarySearch(array, target, invalidPosition) {
  let minPosition = 0;
  let maxPosition = array.length - 1;
  while(minPosition <= maxPosition) {
    let midPosition = Math.floor(minPosition + ((maxPosition - minPosition) / 2));
    if(array[midPosition].value === target && midPosition ) {
      if(midPosition === invalidPosition) {
        if(array[midPosition + 1].value === target) return midPosition + 1;
        if(array[midPosition - 1].value === target) return midPosition - 1;
      }
      else {
        return midPosition;
      }
    }
    if (array[midPosition].value < target) {
      minPosition = midPosition + 1;
    }
    else {
      maxPosition = midPosition - 1;
    }
  }
  return -1;
}
