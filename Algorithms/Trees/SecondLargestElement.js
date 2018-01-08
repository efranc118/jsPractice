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



function findSecondLargestElement(node) {
  if(node.left === null && node.right === null) return node;
  if(node.right === null) return findLargestElement(node.left);
  else return findSecondLargest(node);

}


function findSecondLargest(node) {
  if(node === null || node.right === null) return node;
  let curNode = node;
  let nextNode = node.right;


  while(nextNode.right !== null) {
    curNode = nextNode;
    nextNode = nextNode.right;
  }
  if(nextNode.left) return findLargestElement(nextNode.left);
  return curNode;
}


function findLargestElement(node) {
  if(node === null) return node;
  while(node.right !== null) {
    node = node.right;
  }
  return node;
}


let root = new BinaryTreeNode(15);
root.right = new BinaryTreeNode(20);
root.right.right = new BinaryTreeNode(25);
//root.left = new BinaryTreeNode(10);
root.right.left = new BinaryTreeNode(17);
root.right.left.right = new BinaryTreeNode(19);

console.log(findSecondLargestElement(root));