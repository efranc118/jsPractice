function generateSubSets(set, length) {
  if(length < 0) return [];

  let subSet = "";
  for(let i = 0; i < set.length; i++) {

    let item = set[i];
    if(isSet(length, i)) {
      subSet = subSet.concat(item);
    }

  }
  let subSets = generateSubSets(set, length - 1);
  subSets = subSets.concat(subSet);
  return subSets;
}

function isSet(active, bit) {
  return (( 1 << bit) & active) != 0;
}

let testSet = ['a','b','c'];
console.log(generateSubSets(testSet, 7));