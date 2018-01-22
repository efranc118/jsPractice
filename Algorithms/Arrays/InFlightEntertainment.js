function findMovies(flightLength, movieLengths) {
  let remainingFlightTimes = [];

  for(let i = 0; i < movieLengths.length; i++) {
    let remainingFlightTime = flightLength - movieLengths[i];

    if(remainingFlightTimes.indexOf(movieLengths[i]) > -1) return true;

    remainingFlightTimes.push(remainingFlightTime);

  }
return false;

}



movies = [1,2,4,5,4,9];

console.log(findMovies(10, movies));