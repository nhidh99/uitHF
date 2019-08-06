function primitiveMultiply(a, b) {
    const chance = Math.round(Math.random() * 100);
    if (chance <= 20) {
        return a * b;
    }
    else throw new Error("MultiplicatorUnitFailure");
}

console.log(primitiveMultiply(2,3));