let memoize = {};
function recursiveMaxDuffelBagValue(cakeTypes, capacity, currentValue) {
  let max = 0;
  if(capacity < 0) return max;
  if(capacity === 0) return currentValue;
  for(let i = 0; i< cakeTypes.length; i++) {
    let currentCake = cakeTypes[i];
    let currentMax = recursiveMaxDuffelBagValue(cakeTypes, capacity - currentCake.weight, currentValue + currentCake.value );
    if(currentMax > max) {
      max = currentMax;
    }
  }
  return max;
}

function maxDuffelBagValue(cakeTypes, capacity) {
  let maxValuesAtCapacities = [];
  for(i = 0; i <= capacity; i++) {
    maxValuesAtCapacities[i] = 0;
  }

  for(i = 0; i <= capacity; i++) {
    let currentMax = 0;
    for(j = 0; j < cakeTypes.length; j++) {
      let currentCapacity = i;
      let currentCake = cakeTypes[j];
      if(currentCapacity >= currentCake.weight) {
        currentMax = currentCake.value + maxValuesAtCapacities[currentCapacity - currentCake.weight];
      }
      if(currentMax > maxValuesAtCapacities[currentCapacity]) {
        maxValuesAtCapacities[currentCapacity] = currentMax;
      }
    }
  }
  return maxValuesAtCapacities[capacity];

}


var cakeTypes = [
  {weight: 3, value: 40},
  {weight: 5, value: 70},
  // {weight: 2, value: 15},
  // {weight: 0, value: 0},
];

var capacity = 9;

console.log(maxDuffelBagValue(cakeTypes, capacity, 0));
console.log(recursiveMaxDuffelBagValue(cakeTypes, capacity, 0));


