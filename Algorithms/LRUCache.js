module.exports = {
  LRUCache: function(capacity){
    var head = null;
    var tail = null;
    var keyLookup = {};
    var currentCapacity = 0;
    return {
      // get function returns an integer
      get: function(key){
        if(keyLookup[key] !== undefined) {
          this.moveNodeToFront(key);
          return keyLookup[key].value;
        }
        return -1;
      },
      // set returns nothing
      set: function(key, value){
        if(keyLookup[key] !== undefined) {
          keyLookup[key].value = value;
          this.moveNodeToFront(key);
          return;
        }
        if(currentCapacity === capacity) {
          this.removeOldestEntry();
        }
        keyLookup[key] = {key:key ,value: value, prev: null, next: null};
        this.setHead(keyLookup[key]);
        currentCapacity++;
      },

      removeOldestEntry: function() {
        delete keyLookup[tail.key];
        tail = tail.prev;
        if(tail) tail.next = null;
        currentCapacity -= 1;
      },

      setHead: function(chronologicalValue) {
        if(head) {
          head.prev = chronologicalValue;
          chronologicalValue.next = head;
        }
        head = chronologicalValue;
        if(tail === null) tail = chronologicalValue;
      },

      moveNodeToFront: function(key) {
        if(keyLookup[key] !== head) {
          if(tail === keyLookup[key] && tail !== head) tail = keyLookup[key].prev;
          if(keyLookup[key].next) keyLookup[key].next.prev = keyLookup[key].prev;
          if(keyLookup[key].prev) keyLookup[key].prev.next = keyLookup[key].next;

          keyLookup[key].next = head;
          head.prev = keyLookup[key];
          head = keyLookup[key];
        }
      }
    }
  }
};