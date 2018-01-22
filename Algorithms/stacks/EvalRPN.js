var stack = [];
for(var i = 0; i < A.length; i++) {
  var currentValue = A[i];
  if(currentValue === '+') {
    var operand = stack.pop();
    var secondOperand = stack.pop();
    var result = Math.floor(secondOperand + operand);
    stack.push(result);
  } else if(currentValue === '-') {
    var operand = stack.pop();
    var secondOperand = stack.pop();
    var result = Math.floor(secondOperand - operand);
    stack.push(result);
  } else if(currentValue === '/') {
    var operand = stack.pop();
    var secondOperand = stack.pop();
    var result = Math.floor(secondOperand / operand);
    stack.push(result);
  } else if(currentValue === '*') {
    var operand = stack.pop();
    var secondOperand = stack.pop();
    var result = Math.floor(secondOperand * operand);
    stack.push(result);
  }
  else {
    stack.push(Math.floor(Number(currentValue)));
  }
}
return stack.pop();