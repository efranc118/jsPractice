
let promise1 = new Promise(function(resolve, reject) {
  setTimeout(resolve, 100, 'someValue');
});
let promise2 =  new Promise(function(resolve, reject) {
    setTimeout(resolve, 10000, 'Another Value');
});

let promise = new Promise.race(
promise1, promise2
);


console.log(promise);

promise.then(
  value => console.log('fulfilled: ' + value),
  error => console.log('rejected: ' + error)
);

