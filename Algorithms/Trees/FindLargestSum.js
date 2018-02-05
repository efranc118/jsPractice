// function findLargestPath(element, value) {
//   if(element === null) return null;
//   let max = element.value;
//   let stack = [];
//   stack.push(element);
//   while(stack.length) {
//     let currentElement =
//   }
// }


function findLargestPath(element, value) {
  if(element === null) return value;
  let currentValue = element.value + value;
  return Math.max(findLargestPath(element.left, currentValue), findLargestPath(element.right, currentValue));
}

function findLargesttSum(element) {
  let stack = [];
  let rootNode = new NodeSum(element, 0);
  stack.push(rootNode);
  let max = 0;
  while(stack.length) {
    let curNode = stack.pop();
    let curVal = curNode.value + curNode.treeNode.value;
    if(curVal > max) max = curVal;
    if(curNode.treeNode.left) stack.push(new NodeSum(curNode.treeNode.left, curVal));
    if(curNode.treeNode.right) stack.push(new NodeSum(curNode.treeNode.right, curVal));
  }
  return max;
}


function NodeSum(treeNode, currentValue) {
  this.treeNode = treeNode;
  this.value = currentValue;
}

function BinaryTreeNode(value) {
  this.value = value;
  this.left  = null;
  this.right = null;
}

BinaryTreeNode.prototype.insertLeft = function(value) {
  this.left = new BinaryTreeNode(value);
  return this.left;
};

BinaryTreeNode.prototype.insertRight = function(value) {
  this.right = new BinaryTreeNode(value);
  return this.right;
};

let head = new BinaryTreeNode(5);
head.left = new BinaryTreeNode(10);
head.right = new BinaryTreeNode(4);
head.right.left = new BinaryTreeNode(7);
head.right.right = new BinaryTreeNode(8);

console.log(findLargestPath(head, 0));
console.log(findLargesttSum(head));
process.exit();