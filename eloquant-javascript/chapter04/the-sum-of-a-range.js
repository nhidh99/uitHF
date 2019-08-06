function range(begin, end, step = 1) {
    let sum = 0;
    if (step >= 0) {
        for (let i = begin; i <= end; i += step) {
            sum += i;
        }
    }
    else {
        for (let i = begin; i >= end; i += step) {
            sum += i;
        }
    }
    return sum;
}

function sum(arr) {
    let sum = 0;
    for (let i of arr) {
        sum += i;
    }
    return sum;
}

console.log(range(1, 10));      // 55
console.log(range(1, 10, 2));   // 25
console.log(range(5, 2, -1));   // 14
console.log(sum([1,2,3,4,5]));  // 15