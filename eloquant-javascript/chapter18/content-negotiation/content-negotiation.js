const url = 'https://eloquentjavascript.net/author';
const types = [
    'text/plain',
    'text/html',
    'application/json',
    'application/bunny+rainbow'
];

async function getResponseForMediaType(url, type) {
    try {
        let r = await fetch(url, { headers: { 'accept': type } });
        r = await r.text();
        console.log(`type: ${type}\n`, r);
    }
    catch (e) {
        console.log(e);
    }
}

for (const type of types) {
    getResponseForMediaType(url, type);
}