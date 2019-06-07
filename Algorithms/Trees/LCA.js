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

let head = new BinaryTreeNode(3);
head.left = new BinaryTreeNode(5);
head.right = new BinaryTreeNode(1);
head.right.left = new BinaryTreeNode(0);
head.right.right = new BinaryTreeNode(8);
head.left.left = new BinaryTreeNode(6);
head.left.right = new BinaryTreeNode(2);
head.left.right.left = new BinaryTreeNode(7);
head.left.right.right = new BinaryTreeNode(4);




function findLowestCommonAncestor(node, p, q) {
  if(node.value === p && findNode(node, q)) return node.value;
  if(node.value === q && findNode(node, p)) return node.value;
  if(findNode(node.right, p) && findNode(node.left, q)) return node.value;
  if(findNode(node.left, p) && findNode(node.right, q)) return node.value;
  if(findNode(node.left, p) && findNode(node.left, q)) return findLowestCommonAncestor(node.left, p, q);
  if(findNode(node.right, p) && findNode(node.right, q)) return findLowestCommonAncestor(node.right, p, q);
  return -1;
}

function findNode(node, val) {
    if(node === null) return false;
    if(node.value === val) return true;
    return findNode(node.left, val) || findNode(node.right, val);
}


console.log(findLowestCommonAncestor(head, 5, 4));
console.log(findLowestCommonAncestor(head, 5, 1));
console.log(findLowestCommonAncestor(head, 5, 10));
console.log(findLowestCommonAncestor(head, 8, 7));
