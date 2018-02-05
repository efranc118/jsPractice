var cache = require('./LRUCache').LRUCache(3);


// let cache = new LRUCache(1);
cache.set(1, 1);
cache.set(2, 2);
cache.set(3, 3);
cache.set(4, 4);
// cache.set(5, 5);
// cache.set(6, 6);
// cache.set(7, 7);
// cache.set(8, 8);
// cache.set(9, 9);
// console.log(cache.get(9));
// console.log(cache.get(8));
// console.log(cache.get(7));
// console.log(cache.get(6));
// console.log(cache.get(5));
console.log(cache.get(4));
console.log(cache.get(3));
console.log(cache.get(2));
console.log(cache.get(1));

cache.get(4);
cache.set(1, 1);
console.log(cache.get(9));
console.log(cache.get(7));
console.log(cache.get(6));
console.log(cache.get(5));
console.log(cache.get(4));
console.log(cache.get(3));
console.log(cache.get(1));
console.log(cache.get(8));


process.exit();