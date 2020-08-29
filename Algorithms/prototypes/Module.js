'use strict';

function Animal(voice) {
  this.voice = voice || 'grunt'
}


Animal.prototype.speak = function() {
  console.log(this.voice);
};



function Cat(name, color) {
  Animal.call(this, 'Meow');

  this.name = name;
  this.color = color;
}

Cat.prototype = Animal.prototype;


let fluffy = new Cat('Fluffy', 'White');

delete Animal.prototype.speak;

fluffy.speak();
console.log(fluffy);

