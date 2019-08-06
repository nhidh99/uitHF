function countChar(input, character) {
    let count = 0;
    for (let i = 0; i < input.length; i++) {
        if (input[i] == character) {
            count++;
        }        
    }
    return count;
}

function countBs(input) {
    return countChar(input, 'B');
}

console.log(countBs('Happy Birthday!'));
console.log(countChar('Happy Birthday Banana!', 'B'));
console.log(countBs('BBB'));
console.log(countChar('BBB','B'));