
function getNextServerNumber(currentValues) {
  if(currentValues.length === 0 ) {
    return 1;
  }

  //get the current max value
  let maxValue = Math.max.apply(null, currentValues);

  for(let i = 1; i < maxValue; i++) {
    if(!currentValues.includes(i)) return i;
  }
  return maxValue + 1;
}


console.log(getNextServerNumber([]) === 1);
console.log(getNextServerNumber([1]) === 2);
console.log(getNextServerNumber([1, 5]) === 2);
console.log(getNextServerNumber([1,2,3,4, 5]) === 6);
console.log(getNextServerNumber([1.5,2.5,3,4,5]) === 1);



class Tracker {
  constructor() {
    this.hostTypes = {}
  }

  allocate(hostType) {
    let hostNumber = 1;
    if(this.hostTypes[hostType] !== undefined) {
      let currentServerList = this.hostTypes[hostType];
      hostNumber = getNextServerNumber(currentServerList);
      currentServerList.push(hostNumber);
      this.hostTypes[hostType] = currentServerList
    }
    else {
      this.hostTypes[hostType] = [1]
    }
    return hostType + hostNumber;
  }

  deallocate(hostName) {
    let hostParts = hostName.match(/(\d+|[^\d]+)/g);
    let host = hostParts[0];
    let serverNumber  = parseInt(hostParts[1]);
    let allocationList = this.hostTypes[host];
    if(allocationList === undefined) throw "Attempting to deallocate non-registered server";
    let index = allocationList.indexOf(serverNumber);
    if(index > -1) {
      this.hostTypes[hostName] = removeServer(index, allocationList);
    }
    else {
      throw "Attempting to deallocate non-registered server";
    }

    function removeServer(index, allocationList) {
      allocationList.splice(index, 1);
      return allocationList;
    }


  }

}



let tracker = new Tracker();

console.log(tracker.allocate('apibox'));
console.log(tracker.allocate('apibox'));
console.log(tracker.allocate('sitebox'));

tracker.deallocate("apibox1");
console.log(tracker.allocate('apibox'));
console.log(tracker.allocate('apibox'));
