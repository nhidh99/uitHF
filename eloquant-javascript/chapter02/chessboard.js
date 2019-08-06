const size = 8;

for (let i = 0; i < size; i++) {
    let line = '';
    if (i % 2 == 0) {
        for (let j = 0; j < size; j++) {
            if (j % 2 == 0) {
                line += ' ';
            } else line += '#';
        }
    }
    else {
        for (let j = 0; j < size; j++) {
            if (j % 2 == 0) {
                line += '#';
            } else line += ' ';
        }
    }
    console.log(line);
}