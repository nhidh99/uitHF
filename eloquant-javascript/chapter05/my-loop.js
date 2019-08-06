function myLoop(value, test, update, body) {
    while (test(value)) {
        body(value);
        value = update(value);
    }
}

const testFunc = i => i < 10;
const updateFunc = i => i + 1;
const bodyFunc = i => console.log(i);
const value = 1;

myLoop(value, testFunc, updateFunc, bodyFunc);