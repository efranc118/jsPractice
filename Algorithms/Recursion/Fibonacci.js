
let memoize = {};
function fib(n) {
  if(n < 2) return n;
  let prev = 0;
  let cur = 1;
  for(let i = 1; i < n; i++) {
    let next = cur + prev;
    prev = cur;
    cur = next;
  }
  return cur;
}

function fibRecursive(n) {
  if(n < 2) return n;
  if(memoize[n]) return memoize[n];
  memoize[n] = fibRecursive(n - 1) + fibRecursive(n - 2);
  return memoize[n];
}



console.log(fib(0));
console.log(fib(1));
console.log(fib(2));
console.log(fib(3));
console.log(fib(4));
console.log(fib(5));
console.log(fib(30));

console.log(fibRecursive(30));