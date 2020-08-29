'use strict';

/* What value should you replace the '?' with to make the output read 10? */
// var x = 6;
// var y = 4;
// var a = function(b) { return function(c) { return y + b + c; } };
// x = 2;
// y = 5;
// var fn = a(x);
// x = 1;
// y = 3;
// var unknown = 5;
// console.log(fn(unknown));
//
// console.log(scaleImage(2, 5, 10));
//

function scaleImage(width, height, maxdim) {
var scale = maxdim / Math.max(width, height);
return [scale * width, scale * height];
}


console.log(scaleImage(2, 5, 10));


let x = 2;
let y = 8;
const a = function(b) { return function(c) { return x + y + Math.abs(b) + c; } };

y = 4;

const fn = a(x);
x = 4;
console.log(fn(Math.random() * 10));



