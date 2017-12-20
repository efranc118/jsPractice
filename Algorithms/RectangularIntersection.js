let myRectangle = {
  leftX: 1,
  bottomY: 1,
  width: 6,
  height: 4
};

let otherRectangle = {
  leftX: 7,
  bottomY: 2,
  width: 2,
  height: 2
};


function overlappingRectangle(rectangle1, rectangle2) {
  let rectangle1Right = rectangle1.leftX + rectangle1.width;
  let rectangle2Right= rectangle2.leftX + rectangle2.width;
  let rectangle1Top = rectangle1.bottomY + rectangle1.height;
  let rectangle2Top = rectangle2.bottomY + rectangle2.height;


  let leftX = Math.max(rectangle1.leftX, rectangle2.leftX);
  let rightX = Math.min(rectangle1Right, rectangle2Right);
  let bottomY = Math.max(rectangle1.bottomY, rectangle2.bottomY);
  let topY = Math.min(rectangle1Top, rectangle2Top);

  let width = rightX - leftX;
  let height = topY - bottomY;

  if(height <= 0 || width <= 0) return "No intersection";
  return {
    leftX: leftX,
    width: rightX - leftX,
    bottomY: bottomY,
    height: topY - bottomY
  }


}


console.log(overlappingRectangle(myRectangle, otherRectangle));