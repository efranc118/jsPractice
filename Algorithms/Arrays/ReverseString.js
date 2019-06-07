function reverseString(input) {
    let low = 0;
    let high = input.length - 1;
    while(low < high) {
        let character = input[high];
        input[high] = input[low];
        input[low] = character;
        high--;
        low++;
    }
    return input;
}




console.log(reverseString(['t', 'e', 's', 't']));

