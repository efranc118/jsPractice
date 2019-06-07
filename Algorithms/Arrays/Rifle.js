function rifle(shuffledDeck, half1, half2) {

    let half1ptr = 0;
    let half2ptr = 0;
    for(let i = 0; i < shuffledDeck.length; i++) {
        if(shuffledDeck[i] === half1[half1ptr]) half1ptr++;
        else if(shuffledDeck[i] === half2[half2ptr]) half2ptr++;
        else return false;
    }
    return true;

}



console.log(rifle([1,24,26,7], [1, 26], [24, 7]));