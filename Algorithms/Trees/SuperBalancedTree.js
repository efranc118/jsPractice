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

class Node {
  constructor(node, depth) {
    this.binaryTreeNode = node;
    this.depth = depth;
  }
}


function isSuperBalanced(root) {
  if(!root) return true;

  let stack = [];
  let depths = [];
  stack.push(new Node(root, 0));
  while(stack.length) {

    let temp = stack.pop();
    let binaryTreeNode = temp.binaryTreeNode;
    let depth = temp.depth;
    if(!binaryTreeNode.left && !binaryTreeNode.right) {
      if(depths.find(x => x.depth === depth) === undefined) {
        depths.push(depth);
      }
      if(depths.size > 2 || (depths.length === 2 && Math.abs(depths[0] - depths[1]) > 1)) return false;

    }
    else {
      if(binaryTreeNode.left) {
        stack.push(new Node(binaryTreeNode.left, depth + 1));
      }
      if(binaryTreeNode.right) {
        stack.push(new Node(binaryTreeNode.right,depth + 1));
      }
    }

  }


  return true;

}

let root = new BinaryTreeNode(15);
root.left = new BinaryTreeNode(10);
root.left.right = new BinaryTreeNode(13);
root.left.right.left = new BinaryTreeNode(12);
root.right = new BinaryTreeNode(30);

console.log(isSuperBalanced(root));
