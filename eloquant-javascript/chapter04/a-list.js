function listToArray(list) {
    if (list.length == 0) return [];
    let output = [];
    let curList = list;

    while (curList != null) {
        output.push(curList.value);
        curList = curList.rest;
    }
    return output;
}

function arrayToList(arr) {
    let list = null;
    let curChain = null;

    for (let i of arr) {
        let chain = {value: i, rest: null};
        if (list == null) {
            list = curChain = chain;
        }
        else {
            curChain.rest = chain;
            curChain = curChain.rest;
        }
    }
    return list;
}

let list = {
    value: 1,
    rest: {
        value: 2,
        rest: {
            value: 3,
            rest: null
        }
    }
};

let arr = [1, 2, 3];

console.log(listToArray(list));
console.log(arrayToList(arr));