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

class DepthNode {
  constructor(node, depth) {
    this.node = node;
    this.depth = depth;
  }
}


function isTreeSuperBalanced(rootNode) {
  if(rootNode === null) return true;
  let stack = [];
  stack.push(new DepthNode(rootNode, 0));
  let depthStack = [];
  while(stack.length) {
    let currentDepthNode = stack.pop();
    let currentNode = currentDepthNode.node;
    let currentDepth = currentDepthNode.depth;

    if(!currentNode.left && !currentNode.right) {
      if(!depthStack.find((element) => { return currentDepth === element})) {
        depthStack.push(currentDepth);
        if(depthStack.length > 2 || (depthStack.length === 2 && Math.abs(depthStack[0] - depthStack[1] > 1))) return false;
      }
    }

    if(currentNode.left) {
      stack.push(new DepthNode(currentNode.left, currentDepth + 1));
    }

    if(currentNode.right) {
      stack.push(new DepthNode(currentNode.right, currentDepth + 1));
    }

  }

  return true;
}



let root = new BinaryTreeNode(10);
root.right = new BinaryTreeNode(20);
root.right.left = new BinaryTreeNode(15);
root.right.left.right = new BinaryTreeNode(16);
root.left = new BinaryTreeNode(5);

console.log(isTreeSuperBalanced(root));