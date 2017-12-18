// function mergeRanges(meetings) {
//   let totalRanges = [meetings[0]];
//   for (i = 1; i < meetings.length; i++) {
//     for (j = 0; j < totalRanges.length; j++) {
//       if (meetings[i].startTime >= totalRanges[j].startTime &&
//         meetings[i].startTime <= totalRanges[j].endTime) {
//         totalRanges[j].endTime = Math.max(meetings[i].endTime, totalRanges[j].endTime);
//         break;
//       } else if (meetings[i].endTime >= totalRanges[j].startTime &&
//         meetings[i].endTime <= totalRanges[j].endTime) {
//         totalRanges[j].startTime = Math.min(meetings[i].startTime, totalRanges[j].startTime);
//         break;
//       } else if (j === totalRanges.length - 1) {
//         totalRanges.push(meetings[i]);
//         break;
//       }
//     }
//   }
//   return totalRanges;
//
// }


function mergeRanges(meetings) {
  meetings = meetings.sort(compare);
  let currentStart = meetings[0].startTime;
  let currentEnd = meetings[0].endTime;
  let ranges = [];

  for(i = 1; i < meetings.length; i++) {
    if(meetings[i].startTime <= currentEnd && meetings[i].endTime > currentEnd) {
      currentEnd = meetings[i].endTime;
    }
    if(meetings[i].startTime > currentEnd) {
      ranges.push({startTime: currentStart, endTime: currentEnd});
      currentStart = meetings[i].startTime;
      currentEnd = meetings[i].endTime;
    }
  }
  ranges.push({startTime: currentStart, endTime: currentEnd});
  return ranges;
}

function compare(a,b) {
  if(a.startTime < b.startTime) {
    return -1;
  }
  if(a.startTime > b.startTime) {
    return 1;
  }
  return 0;
}


let testArray = [{startTime: 0, endTime: 1},
  {startTime: 3, endTime: 5},
  {startTime: 4, endTime: 8},
  {startTime: 10, endTime: 12},
  {startTime: 9, endTime: 10},
];

let edgeCase = [{startTime: 1, endTime: 5}, {startTime: 2, endTime: 3}];

console.log(mergeRanges(edgeCase));