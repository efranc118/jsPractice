class TemperatureControl {
  min;
  max;
  mode;
  mean;
  array;
  occurrences;
  currentModeCount;

  constructor() {
    this.min = 0;
    this.max = 0;
    this.mode = 0;
    this.mean = 0;
    this.totalSum = 0;
    this.totalVals = 0;
    this.currentModeCount = 0;
    this.occurrences = new Array(111).fill(0);
  }

  insert(val) {
    if(val < this.min) {
      this.min = val;
    }
    if(val > this.max) {
      this.max = val;
    }
    this.totalVals++;
    this.totalSum += val;
    this.calculateMode(val);
    this.calculateMean(val);
    this.array.push(val);
  }

  calculateMode(val) {
    this.occurrences[val] += 1;

    if(this.occurrences[val] > this.currentModeCount) {
      this.mode = val;
      this.currentModeCount = this.occurrences[val];
    }
  }

  calculateMean(val) {
    return this.totalSum / this.totalVals;
  }

  getMax() {
    return this.max;
  }

  getMin() {
    return this.min;
  }

  getMean() {
    return this.mean;
  }

  getMode() {
    return this.mode;
  }


}