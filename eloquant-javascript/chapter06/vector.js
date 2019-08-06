class Vector {
    constructor(x, y) {
        this.x = x;
        this.y = y;
    }

    plus(v) {
        return new Vector(this.x + v.x, this.y + v.y);
    }

    minus(v) {
        return new Vector(this.x - v.x, this.y - v.y);
    }

    get length() {
        return Math.sqrt(this.x* this.x + this.y* this.y);
    }
}

let vec = new Vector(3, 4);
let total = vec.plus(new Vector(1, 2));
let diff = vec.minus(new Vector(1, 2));
let length = vec.length;

console.log(vec);
console.log(total);
console.log(diff);
console.log(length);