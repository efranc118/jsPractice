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




function levelOrderPrint(root) {
  let queue = [];
  queue.push(root);

  while(queue.length > 0) {
    let node = queue.shift();
    console.log(node.value);
    if(node.left !== null) queue.push(node.left);
    if(node.right !== null) queue.push(node.right);
  }

}




let root = new BinaryTreeNode(15);
root.left = new BinaryTreeNode(10);
root.right = new BinaryTreeNode(20);
root.left.left = new BinaryTreeNode(5);
root.left.right = new BinaryTreeNode(13);
root.right.left = new BinaryTreeNode(17);
root.right.right = new BinaryTreeNode(25);
root.right.left.right = new BinaryTreeNode(19);

console.log(levelOrderPrint(root));
