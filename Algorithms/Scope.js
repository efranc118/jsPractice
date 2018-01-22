{
  var text = 'outside';

  function logIt() {
    console.log(text);
    var text = 'inside';
  }
}
logIt();


var prizes = ['A Unicorn!', 'A Hug!', 'Fresh Laundry!'];
for (var btnNum = 0; btnNum < prizes.length; btnNum++) {
  // for each of our buttons, when the user clicks it...
  document.getElementById('btn-' + btnNum).onclick = function(frozenBtnNum){
    return function() {
      // tell her what she's won!
      alert(prizes[frozenBtnNum]);
    };
  }(btnNum);
}