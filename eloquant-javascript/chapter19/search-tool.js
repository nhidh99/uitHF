const regex = RegExp(process.argv[2]);
let output = [];
for (let i = 3; i < process.argv.length; i++) {
    const fileName = process.argv[i];
    if (regex.test(fileName)) {
        output.push(fileName);
    }
}
console.log(output);

