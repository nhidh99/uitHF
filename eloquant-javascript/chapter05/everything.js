function some(arr, condition) {
    for (let element of arr) {
        if (condition(element)) {
            return true;
        }
    }
    return false;
}

function every(arr, condition) {
    for (let element of arr) {
        if (!condition(element)) {
            return false;
        }
    }
    return true;
}

const arr = [2, 3, 6];
console.log(some(arr, i => i % 2 == 0));
console.log(every(arr, i => i % 2 == 0));