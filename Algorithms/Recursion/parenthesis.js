
console.log(generateParens(3, [""]));

function generateParens(n, list) {

  if(n === 0) return list;

  let parenList = list.slice(0);
    for(j = 0; j < list.length; j++) {
      for(k = 0; k <= list[j].length; k++) {
        let newString = list[j].substring(0, k) + "()" + list[j].substring(k);
        if(!listContains(newString, parenList)) {
          parenList.push(list[j].substring(0, k) + "()" + list[j].substring(k));
        }
      }
    }


  return generateParens(n - 1, parenList);


  function listContains(string, list) {
    for(i = 0; i < list.length; i++) {
      if(string === list[i]) return true;
    }
    return false;
  }

}

process.exit();



