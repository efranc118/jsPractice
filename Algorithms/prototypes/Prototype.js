'use strict';

module.exports.Cat = class Cat {
  constructor(name, color) {
    this.name = name;
    this.color = color;
}

static speak() {
    console.log("Meeoow")
}

};



