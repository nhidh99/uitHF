function reverseArray(arr = []) {
    let output = [];
    for (let i = arr.length - 1; i >= 0; i--) {
        output.push(arr[i]);
    }
    return output;
}

function reverseArrayInPlace(arr = []) {
    let n = arr.length / 2;
    for (let i = 0; i < n; i++) {
        let temp = arr[i];
        arr[i] = arr[arr.length - i - 1];
        arr[arr.length - i - 1] = temp;
    }
    return arr;
}

arr = [1, 2, 3, 4, 5]
console.log(reverseArray(arr));