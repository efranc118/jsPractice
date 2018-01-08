class BinaryTreeNode {
  constructor(value) {
    this.value = value;
    this.right = null;
    this.left = null;
  }

  insertLeft(value) {
    this.left = new BinaryTreeNode(value);
    return this.left;
  }

  insertRight(value) {
    this.right = new BinaryTreeNode(value);
    return this.right;
  }

}


function isBST(rootNode) {
  return checkBST(rootNode, Number.MIN_VALUE, Number.MAX_VALUE);
}

function checkBST(node, min, max) {
  if(node === null) return true;
  if(node.value <= min || node.value >= max) return false;
  return checkBST(node.left, min, node.value) && checkBST(node.right, node.value, max);
}



let node = new BinaryTreeNode(50);
let leftTemp = new BinaryTreeNode(30);
node.left = leftTemp;
let rightTemp = new BinaryTreeNode(80);
node.right = rightTemp;
leftTemp.right = new BinaryTreeNode(60);
leftTemp.left = new BinaryTreeNode(20);
rightTemp.right = new BinaryTreeNode(90);
rightTemp.left = new BinaryTreeNode(70);



console.log(isBST(node));
