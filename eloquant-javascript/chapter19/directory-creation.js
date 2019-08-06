function makeCollection(path) {
    const fs = require('fs');
    try {
        fs.mkdir(path, err => {
            if (err == null) {
                console.log('Success');
                return;
            }

            switch (err.code) {
                case 'ENOENT': {
                    fs.mkdir(path, { recursive: true }, err => {
                        if (err) throw 400;
                        else console.log('Success');
                    });
                    break;
                }

                case 'EEXIST': {
                    throw 204;
                }

                default: {
                    throw err;
                }
            }
        });
    }
    catch (err) {
        throw err;
    };
}

const path = 'C://mapleStory//windyLand';
makeCollection(path);